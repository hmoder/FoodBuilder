import javax.swing.JFrame;
import java.awt.SystemColor;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddFoodWindow {

	// The window's frame
	private JFrame frame;
	
	// The food name text field
	private JTextField nameTextField;
	
	// The food cost text field
	private JTextField costTextField;
	
	// The category combobox
	private JComboBox catComboBox;
	
	// The list containing all food items
	private List<FoodItem> allFoodItems;
	
	// The new FoodItem being created
	private FoodItem newFoodItem;
	
	// The label showing that the food has been saved
	private JLabel foodSavedLabel;

	// Create the application and initialize values
	public AddFoodWindow(List<FoodItem> _allFoodItems) {
		allFoodItems = _allFoodItems;
		foodSavedLabel = null;
		initialize();
		frame.setVisible(true);
	}
																																																																			
	// Get newFoodItem
	public FoodItem GetNewFoodItem() {
		
		return newFoodItem;
	}

	// Initialize the contents of the frame.
	private void initialize() {
		
		// Set frame properties
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		frame.getContentPane().setBackground(SystemColor.window);
		frame.getContentPane().setLayout(null);
		
		// Create and set properties for the title label
		JLabel foodLbl = new JLabel("Food");
		foodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		foodLbl.setForeground(Color.ORANGE);
		foodLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		foodLbl.setBounds(211, 38, 112, 54);
		frame.getContentPane().add(foodLbl);
		
		// Create and set properties for the title label
		JLabel addLbl = new JLabel("Add");
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setForeground(Color.DARK_GRAY);
		addLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		addLbl.setBounds(109, 38, 118, 54);
		frame.getContentPane().add(addLbl);
		
		// Create and set properties for the food name label
		JLabel foodNameLabel = new JLabel("Name:");
		foodNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		foodNameLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		foodNameLabel.setBounds(129, 181, 48, 22);
		frame.getContentPane().add(foodNameLabel);
		
		// Create and set properties for the instructions label
		JLabel foodInstructionLbl = new JLabel("Complete the form and hit \"Save Food\" to add the food to the database");
		foodInstructionLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		foodInstructionLbl.setBounds(43, 115, 465, 22);
		frame.getContentPane().add(foodInstructionLbl);
		
		// Create and set properties for the Item label
		JLabel lblItem = new JLabel("Item");
		lblItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblItem.setForeground(Color.DARK_GRAY);
		lblItem.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblItem.setBounds(309, 38, 118, 54);
		frame.getContentPane().add(lblItem);
		
		// Set properties for the food name JTextField
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		nameTextField.setColumns(10);
		nameTextField.setBounds(187, 174, 196, 29);
		frame.getContentPane().add(nameTextField);
		
		// Create and set properties for the food cost label
		JLabel foodCostLabel = new JLabel("Cost:");
		foodCostLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		foodCostLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		foodCostLabel.setBounds(128, 234, 48, 22);
		frame.getContentPane().add(foodCostLabel);
		
		// The text field to enter cost
		costTextField = new JTextField();
		costTextField.setText("$");
		costTextField.setHorizontalAlignment(SwingConstants.LEFT);
		costTextField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		costTextField.setColumns(10);
		costTextField.setBounds(187, 227, 196, 29);
		frame.getContentPane().add(costTextField);
		
		// The category dropdown label
		JLabel foodCategoryLbl = new JLabel("Select a Category:");
		foodCategoryLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		foodCategoryLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		foodCategoryLbl.setBounds(211, 287, 127, 22);
		frame.getContentPane().add(foodCategoryLbl);
		
		// The dropdown of categories
		List<String> categoryList = Arrays.asList("Breads/Grains/Pasta", "Canned Goods", "Condiments/Sauces", "Dairy", "Frozen","Meat", "Pantry", "Produce", "Other");
		catComboBox = new JComboBox(categoryList.toArray());
		catComboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		catComboBox.setBackground(SystemColor.menu);
		catComboBox.setBounds(199, 314, 158, 29);
		frame.getContentPane().add(catComboBox);
		
		// The button to save the food
		JButton addFoodButton = new JButton("Add Food");
		addFoodButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the BuildNewFoodItem method
				BuildNewFoodItem();
			}
		});
		addFoodButton.setForeground(Color.BLACK);
		addFoodButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		addFoodButton.setBackground(SystemColor.menu);
		addFoodButton.setBounds(172, 398, 215, 29);
		frame.getContentPane().add(addFoodButton);
		
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
		mainButton.setBounds(211, 511, 125, 29);
		frame.getContentPane().add(mainButton);
		
		// Set additional properties of the frame
		frame.setBounds(100, 100, 561, 610);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	// Method to build a new food item
	private void BuildNewFoodItem() {
		
		String name = nameTextField.getText();						// The name of the food item
		double cost;												// The cost of the food item
		String sCost;												// The cost of a food item as a string
		char[] charCost = costTextField.getText().toCharArray();	// Char array of cost string
		StringBuilder sb = new StringBuilder();						// StringBuilder of cost
		int i = 0;													// Initial value
		String cat = catComboBox.getSelectedItem().toString();		// The selected category
		
		// Check to see if user left the dollar sign
		if (charCost[0] == '$') {
			
			// Set counter to 1 to skip
			i = 1;
		}
		
		// Add chars to StringBuilder
		for (int j = i; j < charCost.length; j++) {
			
			sb.append(charCost[j]);
		}
		
		// Set sCost
		sCost = sb.toString();
		
		// Try parsing to double
		cost = Double.parseDouble(sCost);
		
		// Build new FoodItem
		newFoodItem = new FoodItem(name, cost, cat);
		
		// Add Food Saved label to frame
		foodSavedLabel = new JLabel("New Food Saved!");
		foodSavedLabel.setForeground(Color.RED);
		foodSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		foodSavedLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		foodSavedLabel.setBounds(170, 445, 215, 22);
		frame.getContentPane().add(foodSavedLabel);
		frame.repaint();
	}

}
