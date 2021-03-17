import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainMenu {

	// The window's frame
	private JFrame Frame;
	
	// The list of all food items
	private List<FoodItem> allFoodItems;
	
	// The user's selection
	private int selection;

	// Create the application and initialize values
	public MainMenu(List<FoodItem> _allFoodItems) {
		allFoodItems = _allFoodItems;
		initialize();
		Frame.setVisible(true);
		
		selection = 0;
	}
	
	// Getters and setters
	public int GetSelection() {
		
		return selection;
	}
	
	// Clear the user's selection
	public void ClearSelection() {
		
		selection = 0;
	}

	// Initialize the contents of the frame
	private void initialize() {
		
		// Initialize and set properties of the frame
		Frame = new JFrame();
		Frame.getContentPane().setBackground(Color.WHITE);
		Frame.setBounds(100, 100, 494, 600);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		
		// Create and set properties for the title label
		JLabel headerLabel = new JLabel("Food");
		headerLabel.setForeground(Color.ORANGE);
		headerLabel.setBounds(112, 69, 112, 54);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		Frame.getContentPane().add(headerLabel);
		
		// Create and set properties for the title label
		JLabel headerLabel2 = new JLabel("Builder");
		headerLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel2.setForeground(Color.DARK_GRAY);
		headerLabel2.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		headerLabel2.setBounds(213, 69, 159, 54);
		Frame.getContentPane().add(headerLabel2);
		
		// Create and set properties for the MealPlanBuilder button
		JButton mealPlanBuilderButton = new JButton("Meal Plan Builder");
		mealPlanBuilderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set selection on click
				selection = 1;
			}
		});
		mealPlanBuilderButton.setForeground(Color.DARK_GRAY);
		mealPlanBuilderButton.setBackground(SystemColor.control);
		mealPlanBuilderButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mealPlanBuilderButton.setBounds(117, 170, 245, 39);
		Frame.getContentPane().add(mealPlanBuilderButton);
		
		// Create and set properties for the MealPlanBuilder button
		JButton groceryListButton = new JButton("See My Grocery List");
		groceryListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set selection on click
				selection = 2;
			}
		});
		groceryListButton.setBackground(SystemColor.control);
		groceryListButton.setForeground(Color.DARK_GRAY);
		groceryListButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		groceryListButton.setBounds(117, 235, 245, 39);
		Frame.getContentPane().add(groceryListButton);
		
		// Create and set properties for the RecipeBuilder button
		JButton recipeButton = new JButton("Create Recipe");
		recipeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set selection on click
				selection = 3;
			}
		});
		recipeButton.setForeground(Color.DARK_GRAY);
		recipeButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		recipeButton.setBackground(SystemColor.menu);
		recipeButton.setBounds(117, 300, 245, 39);
		Frame.getContentPane().add(recipeButton);
		
		// Create and set properties for the AddFood button
		JButton addFoodButton = new JButton("Add Food to Database");
		addFoodButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Set selection on click
				selection = 4;
			}
		});
		addFoodButton.setForeground(Color.DARK_GRAY);
		addFoodButton.setBackground(SystemColor.control);
		addFoodButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		addFoodButton.setBounds(117, 365, 245, 39);
		Frame.getContentPane().add(addFoodButton);
	}
}
