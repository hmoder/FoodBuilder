import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JList;

public class GroceryListWindow {

	// The window's frame
	private JFrame frame;
	
	// The list of all food items
	private List<FoodItem> allFoodItems;
	
	// The list of selected main courses
	private List<String> mainCourseList;
	
	// The list of selected side dishes
	private List<String> sideDishList;
	
	// The list of all possible main courses
	private List<MainCourse> allMainCourses;
	
	// The list of all possible side dishes
	private List<SideDish> allSideDishes;
	
	// The DefaultListModels for each category
	private DefaultListModel cannedListModel;
	private DefaultListModel condimentListModel;
	private DefaultListModel breadListModel;
	private DefaultListModel dairyListModel;
	private DefaultListModel frozenListModel;
	private DefaultListModel meatListModel;
	private DefaultListModel pantryListModel;
	private DefaultListModel produceListModel;
	private DefaultListModel otherListModel;

	// Create the application and initialize values
	public GroceryListWindow(List<String> mcList,
								List<String> sdList,
								List<MainCourse> _allMainCourses,
								List<SideDish> _allSideDishes) {
		
		allFoodItems = new ArrayList<FoodItem>();
		mainCourseList = mcList;
		sideDishList = sdList;
		allMainCourses = _allMainCourses;
		allSideDishes = _allSideDishes;
		breadListModel = new DefaultListModel();
		cannedListModel = new DefaultListModel();
		condimentListModel = new DefaultListModel();
		dairyListModel = new DefaultListModel();
		frozenListModel = new DefaultListModel();
		meatListModel = new DefaultListModel();
		pantryListModel = new DefaultListModel();
		produceListModel = new DefaultListModel();
		otherListModel = new DefaultListModel();
		
		// Create a list of the foods in each recipe
		List<FoodItem> newList = getFoodList();
		
		// Organize the list by category and add to DefaultListModels
		sortFoodsByCategory(newList);
		
		// Build the window
		initialize();
		
		// Calculate cost
		getTotalCost(newList);
		frame.setVisible(true);
	}

	// Initialize the contents of the frame
	private void initialize() {
		
		// Set properties of the frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		// Create and set properties of the title label
		JLabel lblList = new JLabel("List");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.DARK_GRAY);
		lblList.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblList.setBounds(335, 11, 88, 54);
		frame.getContentPane().add(lblList);
		
		// Create and set properties of the title label
		JLabel lblGrocery = new JLabel("Grocery");
		lblGrocery.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrocery.setForeground(Color.ORANGE);
		lblGrocery.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblGrocery.setBounds(172, 11, 178, 54);
		frame.getContentPane().add(lblGrocery);
		
		// Create and set properties of the panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 111, 622, 675);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{45, 155, 35, 155, 35, 155, 45, 0};
		gbl_panel.rowHeights = new int[]{30, 190, 30, 190, 30, 190, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		// Create and set properties of the bread label
		JLabel breadLbl = new JLabel("Breads/Grains/Pasta");
		breadLbl.setForeground(Color.BLACK);
		breadLbl.setBackground(Color.WHITE);
		breadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		breadLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		GridBagConstraints gbc_breadLbl = new GridBagConstraints();
		gbc_breadLbl.insets = new Insets(0, 0, 5, 5);
		gbc_breadLbl.gridx = 1;
		gbc_breadLbl.gridy = 0;
		panel.add(breadLbl, gbc_breadLbl);
		
		// Create and set properties of the canned goods label
		JLabel cannedLbl = new JLabel("Canned Goods");
		cannedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cannedLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		GridBagConstraints gbc_cannedLbl = new GridBagConstraints();
		gbc_cannedLbl.insets = new Insets(0, 0, 5, 5);
		gbc_cannedLbl.gridx = 3;
		gbc_cannedLbl.gridy = 0;
		panel.add(cannedLbl, gbc_cannedLbl);
		
		// Create and set properties of the condiments label
		JLabel condimentsLbl = new JLabel("Condiments/Sauces");
		condimentsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		condimentsLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		GridBagConstraints gbc_condimentsLbl = new GridBagConstraints();
		gbc_condimentsLbl.insets = new Insets(0, 0, 5, 5);
		gbc_condimentsLbl.gridx = 5;
		gbc_condimentsLbl.gridy = 0;
		panel.add(condimentsLbl, gbc_condimentsLbl);
		
		// Create and set properties of the bread list
		JList breadList = new JList(breadListModel);
		breadList.setBorder(null);
		breadList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_breadList = new GridBagConstraints();
		gbc_breadList.insets = new Insets(0, 0, 5, 5);
		gbc_breadList.fill = GridBagConstraints.BOTH;
		gbc_breadList.gridx = 1;
		gbc_breadList.gridy = 1;
		panel.add(breadList, gbc_breadList);
		
		// Create and set properties of the canned food list
		JList cannedList = new JList(cannedListModel);
		cannedList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_cannedList = new GridBagConstraints();
		gbc_cannedList.insets = new Insets(0, 0, 5, 5);
		gbc_cannedList.fill = GridBagConstraints.BOTH;
		gbc_cannedList.gridx = 3;
		gbc_cannedList.gridy = 1;
		panel.add(cannedList, gbc_cannedList);
		
		// Create and set properties of the condiments list
		JList condimentsList = new JList(condimentListModel);
		condimentsList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_condimentsList = new GridBagConstraints();
		gbc_condimentsList.insets = new Insets(0, 0, 5, 5);
		gbc_condimentsList.fill = GridBagConstraints.BOTH;
		gbc_condimentsList.gridx = 5;
		gbc_condimentsList.gridy = 1;
		panel.add(condimentsList, gbc_condimentsList);
		
		// Create and set properties of the dairy label
		JLabel dairyLbl = new JLabel("Dairy");
		dairyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dairyLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_dairyLbl = new GridBagConstraints();
		gbc_dairyLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dairyLbl.gridx = 1;
		gbc_dairyLbl.gridy = 2;
		panel.add(dairyLbl, gbc_dairyLbl);
		
		// Create and set properties of the frozen label
		JLabel frozenLbl = new JLabel("Frozen");
		frozenLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frozenLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_frozenLbl = new GridBagConstraints();
		gbc_frozenLbl.insets = new Insets(0, 0, 5, 5);
		gbc_frozenLbl.gridx = 3;
		gbc_frozenLbl.gridy = 2;
		panel.add(frozenLbl, gbc_frozenLbl);
		
		// Create and set properties of the meat label
		JLabel meatLbl = new JLabel("Meat");
		meatLbl.setHorizontalAlignment(SwingConstants.CENTER);
		meatLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_meatLbl = new GridBagConstraints();
		gbc_meatLbl.insets = new Insets(0, 0, 5, 5);
		gbc_meatLbl.gridx = 5;
		gbc_meatLbl.gridy = 2;
		panel.add(meatLbl, gbc_meatLbl);
		
		// Create and set properties of the dairy list
		JList dairyList = new JList(dairyListModel);
		dairyList.setBorder(null);
		dairyList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_dairyList = new GridBagConstraints();
		gbc_dairyList.insets = new Insets(0, 0, 5, 5);
		gbc_dairyList.fill = GridBagConstraints.BOTH;
		gbc_dairyList.gridx = 1;
		gbc_dairyList.gridy = 3;
		panel.add(dairyList, gbc_dairyList);
		
		// Create and set properties of the frozen list
		JList frozenList = new JList(frozenListModel);
		frozenList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_frozenList = new GridBagConstraints();
		gbc_frozenList.insets = new Insets(0, 0, 5, 5);
		gbc_frozenList.fill = GridBagConstraints.BOTH;
		gbc_frozenList.gridx = 3;
		gbc_frozenList.gridy = 3;
		panel.add(frozenList, gbc_frozenList);
		
		// Create and set properties of the meat list
		JList meatList = new JList(meatListModel);
		meatList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_meatList = new GridBagConstraints();
		gbc_meatList.insets = new Insets(0, 0, 5, 5);
		gbc_meatList.fill = GridBagConstraints.BOTH;
		gbc_meatList.gridx = 5;
		gbc_meatList.gridy = 3;
		panel.add(meatList, gbc_meatList);
		
		// Create and set properties of the pantry label
		JLabel pantryLbl = new JLabel("Pantry");
		pantryLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pantryLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_pantryLbl = new GridBagConstraints();
		gbc_pantryLbl.insets = new Insets(0, 0, 5, 5);
		gbc_pantryLbl.gridx = 1;
		gbc_pantryLbl.gridy = 4;
		panel.add(pantryLbl, gbc_pantryLbl);
		
		// Create and set properties of the produce label
		JLabel produceLbl = new JLabel("Produce");
		produceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		produceLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_produceLbl = new GridBagConstraints();
		gbc_produceLbl.insets = new Insets(0, 0, 5, 5);
		gbc_produceLbl.gridx = 3;
		gbc_produceLbl.gridy = 4;
		panel.add(produceLbl, gbc_produceLbl);
		
		// Create and set properties of the other label
		JLabel otherLbl = new JLabel("Other");
		otherLbl.setHorizontalAlignment(SwingConstants.CENTER);
		otherLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		GridBagConstraints gbc_otherLbl = new GridBagConstraints();
		gbc_otherLbl.insets = new Insets(0, 0, 5, 5);
		gbc_otherLbl.gridx = 5;
		gbc_otherLbl.gridy = 4;
		panel.add(otherLbl, gbc_otherLbl);
		
		// Create and set properties of the pantry list
		JList pantryList = new JList(pantryListModel);
		pantryList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_pantryList = new GridBagConstraints();
		gbc_pantryList.insets = new Insets(0, 0, 0, 5);
		gbc_pantryList.fill = GridBagConstraints.BOTH;
		gbc_pantryList.gridx = 1;
		gbc_pantryList.gridy = 5;
		panel.add(pantryList, gbc_pantryList);
		
		// Create and set properties of the produce list
		JList produceList = new JList(produceListModel);
		produceList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_produceList = new GridBagConstraints();
		gbc_produceList.insets = new Insets(0, 0, 0, 5);
		gbc_produceList.fill = GridBagConstraints.BOTH;
		gbc_produceList.gridx = 3;
		gbc_produceList.gridy = 5;
		panel.add(produceList, gbc_produceList);
		
		// Create and set properties of the other list
		JList otherList = new JList(otherListModel);
		otherList.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_otherList = new GridBagConstraints();
		gbc_otherList.insets = new Insets(0, 0, 0, 5);
		gbc_otherList.fill = GridBagConstraints.BOTH;
		gbc_otherList.gridx = 5;
		gbc_otherList.gridy = 5;
		panel.add(otherList, gbc_otherList);
		
		// Set additional properties of the frame
		frame.setBounds(100, 100, 638, 825);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	// Method to get food items from recipes
	private List<FoodItem> getFoodList() {
		
		
		MainCourse current;			// The current Main Course
		SideDish currentSide;		// The current Side Dish
		List<FoodItem> currentList;	// The current ingredient list
		
		// Master list of all Food Items from dishes
		List<FoodItem> allFoods = new ArrayList<FoodItem>();
		
		// Loop through the main course list
		for (int s = 0; s < mainCourseList.size(); s++) {
			
			// Loop through all Main Courses
			for (int mc =  0; mc < allMainCourses.size(); mc++) {
				
				// Find matching String to Main Course
				if (mainCourseList.get(s) == allMainCourses.get(mc).getName()) {
					
					// Set current Main Course
					current = allMainCourses.get(mc);
					
					// Add all ingredients to allFoodItems list
					allFoodItems.addAll(current.getIngredients());
					
				}
			}
		}
		
		// Loop through the side dish list
		for (int s = 0; s < sideDishList.size(); s++) {
			
			// Loop through all Side Dishes
			for (int sd =  0; sd < allSideDishes.size(); sd++) {
				
				// Find matching String to Side Dish
				if (sideDishList.get(s) == allSideDishes.get(sd).getName()) {
					
					// Set current Main Course
					currentSide = allSideDishes.get(sd);
					
					// Add all ingredients to allFoodItems list
					allFoodItems.addAll(currentSide.getIngredients());
	
				}
			}
		}
		
		// Return the master food list
		return allFoodItems;
	}
	
	// Method to get total cost and add label to window
	private void getTotalCost(List<FoodItem> foodList) {
		
		// Variable to hold total cost
		double total = 0;
		
		// Loop through food items and add cost to total
		for (int i = 0; i < foodList.size(); i++) {
			
			total = total + foodList.get(i).getCost();
		}
		
		// Build label
		JLabel totalCostLabel = new JLabel("Total Cost: $" + total);
		totalCostLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		totalCostLabel.setBounds(260, 76, 150, 14);
		frame.getContentPane().add(totalCostLabel);
	}
	
	// Method to sort foods into proper category lists
	private void sortFoodsByCategory(List<FoodItem> foodList) {
		
		// Variable for current category
		String current;
		
		// Lists to hold string names for each category
		List<String> breadList = new ArrayList<String>();
		List<String> cannedList = new ArrayList<String>();
		List<String> condimentList = new ArrayList<String>();
		List<String> dairyList = new ArrayList<String>();
		List<String> frozenList = new ArrayList<String>();
		List<String> meatList = new ArrayList<String>();
		List<String> pantryList = new ArrayList<String>();
		List<String> produceList = new ArrayList<String>();
		List<String> otherList = new ArrayList<String>();
		
		// Loop through food items and add to category ListModels
		for (int i = 0; i < foodList.size(); i++ ) {
			
			// Set current variable
			current = foodList.get(i).getCategory();
			
			// Compare categories and add to proper ListModel
			if (current == "Breads/Grains/Pasta") {
				
				// Call CheckDuplicates method
				CheckDuplicates(breadList, foodList.get(i).getName());
				
			} else {
				
				if (current == "Canned Goods") {
					
					// Call CheckDuplicates method
					CheckDuplicates(cannedList, foodList.get(i).getName());
					
				} else {
					
					if (current == "Condiments/Sauces") {
						
						// Call CheckDuplicates method
						CheckDuplicates(condimentList, foodList.get(i).getName());
						
					} else {
						
						if (current == "Dairy") {
							
							// Call CheckDuplicates method
							CheckDuplicates(dairyList, foodList.get(i).getName());
							
						} else {
							
							if (current == "Frozen") {
								
								// Call CheckDuplicates method
								CheckDuplicates(frozenList, foodList.get(i).getName());
								
							} else {
								
								if (current == "Meat") {
									
									// Call CheckDuplicates method
									CheckDuplicates(meatList, foodList.get(i).getName());
									
								} else {
									
									if (current == "Pantry") {
										
										// Call CheckDuplicates method
										CheckDuplicates(pantryList, foodList.get(i).getName());
										
									} else {
										
										if (current == "Produce") {
											
											// Call CheckDuplicates method
											CheckDuplicates(produceList, foodList.get(i).getName());
											
										} else {
											
											// Call CheckDuplicates method
											CheckDuplicates(otherList, foodList.get(i).getName());
										}
									}
								}
							}
						}
					}
				}
			}
			
		}
		
		// Add all lists to listModels
		breadListModel.addAll(breadList);
		cannedListModel.addAll(cannedList);
		condimentListModel.addAll(condimentList);
		dairyListModel.addAll(dairyList);
		frozenListModel.addAll(frozenList);
		meatListModel.addAll(meatList);
		pantryListModel.addAll(pantryList);
		produceListModel.addAll(produceList);
		otherListModel.addAll(otherList);
		
	}
	
	// Method to check and remove duplicates
	private void CheckDuplicates(List<String> list, String newFood) {
		
		// If the list doesn't contain the item
		if (list.contains(newFood) == false) {
			
			// Add food to list
			list.add(newFood);
			
			// Sort the list
			Collections.sort(list);
		} 
	}
}
