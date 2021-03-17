import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JList;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class RecipeBuilder {

	// The window's frame
	private JFrame frame;
	
	// The recipe name textfield
	private JTextField nameTextField;
	
	// The created recipe JList
	private JList recipeList;
	
	// The JList of optional ingredients
	private JList ingredientsList;
	
	// The list of chosen ingredients in the recipe
	private DefaultListModel recipeListModel;
	
	// The list of optional ingredients
	private DefaultListModel ingredientsListModel;
	
	// The list of all food items
	private List<FoodItem> allFoodItems;
	
	// Determines whether recipe is a main course
	private boolean isMainCourse;
	
	// The label to show successful save
	private JLabel recipeSavedLabel;
	
	// The session's new side dishes
	private List<SideDish> newSideDishes;
	
	// The session's new main dishes
	private List<MainCourse> newMainCourses;
	
	// The session's notes area
	private TextArea notesTextArea;
	
	// Getters
	public List<MainCourse> GetNewMainCourses() {
		
		return newMainCourses;
	}
	
	public List<SideDish> GetNewSideDishes() {
		
		return newSideDishes;
	}
	
	// Create the application and initialize values
	public RecipeBuilder(List<FoodItem> _allFoodItems) {
		recipeListModel = new DefaultListModel();
		ingredientsListModel = new DefaultListModel();
		allFoodItems = _allFoodItems;
		newMainCourses = new ArrayList<MainCourse>();
		newSideDishes = new ArrayList<SideDish>();
		isMainCourse = false;
		recipeSavedLabel = null;
		initialize();
		frame.setVisible(true);

	}

	// Initialize the contents of the frame
	private void initialize() {
		
		// Set properties for the frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		// Create and set properties for the title label
		JLabel lblBuilder = new JLabel("Builder");
		lblBuilder.setBounds(347, 30, 164, 54);
		lblBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuilder.setForeground(Color.DARK_GRAY);
		lblBuilder.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		frame.getContentPane().add(lblBuilder);
		
		// Create and set properties for the title label
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setBounds(213, 30, 148, 54);
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setForeground(Color.ORANGE);
		lblRecipe.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		frame.getContentPane().add(lblRecipe);
		
		// Create and set properties for the main course radio button
		JRadioButton mainDishRadio = new JRadioButton("Main Course");
		mainDishRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set boolean on click
				isMainCourse = true;
			}
		});
		mainDishRadio.setBounds(267, 170, 94, 23);
		mainDishRadio.setBackground(SystemColor.window);
		mainDishRadio.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		frame.getContentPane().add(mainDishRadio);
		
		// Create and set properties for the side dish radio button
		JRadioButton sideDishRadio = new JRadioButton("Side Dish");
		sideDishRadio.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		sideDishRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set boolean on click
				isMainCourse = false;
			}
		});
		sideDishRadio.setBounds(399, 170, 83, 23);
		sideDishRadio.setBackground(SystemColor.window);
		mainDishRadio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(sideDishRadio);
		
		// Group to hold radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(mainDishRadio);
		group.add(sideDishRadio);
		
		// Create and set properties for the recipe name text field
		nameTextField = new JTextField();
		nameTextField.setBounds(237, 131, 261, 29);
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		// Create and set properties for the recipe name label
		JLabel nameLbl = new JLabel("Name your dish:");
		nameLbl.setBounds(315, 106, 107, 22);
		nameLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		frame.getContentPane().add(nameLbl);
		
		// Create and set properties for the select ingredient label
		JLabel lblSelectAnIngredient = new JLabel("Use the dropdown on the left to select a category and ingredients.");
		lblSelectAnIngredient.setBounds(96, 218, 557, 22);
		lblSelectAnIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAnIngredient.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		frame.getContentPane().add(lblSelectAnIngredient);
		
		// Create and set properties for the add ingredient button
		JButton addIngredientButton = new JButton("Add");
		addIngredientButton.setBounds(315, 331, 89, 46);
		addIngredientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Remove the recipe list, update, and re-add to frame
				frame.remove(recipeList);
				updateRecipeList(ingredientsList.getSelectedValue());
				frame.getContentPane().add(recipeList);
				frame.repaint();
			}
		});
		addIngredientButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		addIngredientButton.setBackground(SystemColor.control);
		frame.getContentPane().add(addIngredientButton);
		
		// JList containing the created recipe
		recipeList = new JList(recipeListModel);
		recipeList.setBounds(477, 306, 176, 192);
		recipeList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		recipeList.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		frame.getContentPane().add(recipeList);
		
		// TextArea for recipe's notes
		notesTextArea = new TextArea();
		notesTextArea.setBounds(86, 514, 579, 95);
		notesTextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				// Clear on focus
				notesTextArea.setText("");
			}
		});
		notesTextArea.setText("Add notes (optional)");
		frame.getContentPane().add(notesTextArea);
		
		// ComboBox with all Categories
		List<String> categoryList = Arrays.asList("Categories", "Breads/Grains/Pasta", "Canned Goods", "Condiments/Sauces", "Dairy", "Frozen","Meat", "Pantry", "Produce", "Other");
		JComboBox categoryComboBox = new JComboBox(categoryList.toArray());
		categoryComboBox.setBounds(96, 271, 158, 29);
		categoryComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Update ingredient list based on selection
				frame.remove(ingredientsList);
				updateIngredientList(categoryComboBox.getSelectedItem());
				frame.getContentPane().add(ingredientsList);
				frame.repaint();
			}
		});
		categoryComboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		categoryComboBox.setBackground(Color.WHITE);
		frame.getContentPane().add(categoryComboBox);
		
		// Button to save recipe
		JButton saveRecipeButton = new JButton("Save Recipe");
		saveRecipeButton.setBounds(267, 647, 215, 29);
		saveRecipeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewRecipe();
			}
		});
		saveRecipeButton.setForeground(SystemColor.desktop);
		saveRecipeButton.setBackground(SystemColor.control);
		saveRecipeButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		frame.getContentPane().add(saveRecipeButton);
		
		// List of optional ingredients
		ingredientsList = new JList(ingredientsListModel);
		ingredientsList.setBounds(86, 306, 176, 192);
		ingredientsList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsList.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		frame.getContentPane().add(ingredientsList);
		
		// Label for instructions
		JLabel lblThenHitadd = new JLabel("Then hit \"Add\" to add it to the recipe.");
		lblThenHitadd.setBounds(96, 238, 557, 22);
		lblThenHitadd.setHorizontalAlignment(SwingConstants.CENTER);
		lblThenHitadd.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		frame.getContentPane().add(lblThenHitadd);
		
		// Label for Your Recipe
		JLabel lblYourRecipe = new JLabel("Your Recipe");
		lblYourRecipe.setBounds(477, 279, 176, 22);
		lblYourRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourRecipe.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		frame.getContentPane().add(lblYourRecipe);
		
		// The Main Menu button
		JButton mainButton = new JButton("Main Menu");
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Dispose frame
				frame.dispose();
			}
		});
		mainButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		mainButton.setBackground(SystemColor.menu);
		mainButton.setBounds(310, 725, 125, 29);
		frame.getContentPane().add(mainButton);
		
		// Additional properties for the frame
		frame.setBounds(100, 100, 757, 852);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	// Method to create a new recipe
	private void createNewRecipe() {
		
		String name = nameTextField.getText();				// The name of the recipe
		List<FoodItem> recipe = new ArrayList<FoodItem>();	// The list of food items in recipe
		String notes = notesTextArea.getText();				// The recipe's notes
		String line = "";									// The name of the food item
		
		// Loop through all lines in recipeList
		for (int i = 0; i < recipeList.getModel().getSize(); i++) {
			
			// Cast the line as a string
			line = ((String) recipeList.getModel().getElementAt(i));
			
			// Loop through all food items
			for (int j = 0; j < allFoodItems.size(); j++ ) {
				
				// If the names match...
				if (line == allFoodItems.get(j).getName()) {
					
					// Add it to the recipe list
					recipe.add(allFoodItems.get(j));
				}
			}
		}
		
		// If the Main Course radio button is selected
		if (isMainCourse) {
			
			// Create a new MainCourse
			newMainCourses.add(new MainCourse(name, recipe, notes));
		}
		else {
			
			// Create a new SideDish
			newSideDishes.add(new SideDish(name, recipe, notes));
		}
		
		// Show Saved Recipe label
		recipeSavedLabel = new JLabel("Recipe Saved!");
		recipeSavedLabel.setForeground(Color.RED);
		recipeSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recipeSavedLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		recipeSavedLabel.setBounds(267, 687, 215, 22);
		frame.getContentPane().add(recipeSavedLabel);
		frame.repaint();
	}
	
	private void updateIngredientList(Object cat) {
		
		ingredientsListModel.clear();		// Clear current list model
		String uCat = cat.toString();		// Variable to hold user's selection
		
		// Loop through all food items and add items of the selected category to model
		for (int i = 0; i < allFoodItems.size(); i++) {
			
			if (uCat == allFoodItems.get(i).getCategory()) {
				
				ingredientsListModel.addElement(allFoodItems.get(i).getName());
			}
		}
		
	}
	
	// Method to update the recipe list
	private void updateRecipeList(Object ing) {
		
		// The ingedient being added
		String uIng = ing.toString();
		
		recipeListModel.addElement(uIng);
	}
	
	// Method to clear new dish lists
	public void ClearNewDishes() {
		
		newMainCourses.clear();
		newSideDishes.clear();
	}
}
