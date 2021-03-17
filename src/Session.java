import java.util.*;

public class Session {
	
	// The list of main course options
	private static List<MainCourse> mainCourses;
	
	// The list of side dish options
	private static List<SideDish> sideDishes;
	
	// The list of all food items
	private static List<FoodItem> allFoodItems;
	
	// The session's main menu window
	private static MainMenu mainMenu;
	
	// The session's meal plan builder window
	private static MealPlanBuilder mpb;
	
	// The session's recipe builder window
	private static RecipeBuilder rb;
	
	// The session's grocery list window
	private static GroceryListWindow glw;
	
	// The session's add food window
	private static AddFoodWindow afw;
	
	// Instantiate a new Session
	public Session() throws InterruptedException {
		
		// Initialize values
		mainCourses = new ArrayList<MainCourse>();
		sideDishes = new ArrayList<SideDish>();
		allFoodItems = new ArrayList<FoodItem>();
		mpb = null;
		rb = null;
		glw = null;
		afw = null;
		
		// Add default food library
		AddDefaults();
		
		// Instantiate main menu
		mainMenu = new MainMenu(allFoodItems);
	}

	public static void main(String[] args) throws InterruptedException {
		
		// Instantiate a new Session
		Session mySession = new Session();
		
		// Call the StartOver method
		StartOver();

	}
	
	// Method to build default food library
	private static void AddDefaults() {
		
		// Add default food items
		FoodItem groundBeef = new FoodItem("Ground Beef", 4.00, "Meat");
		allFoodItems.add(groundBeef);
		FoodItem spaghettiSauce = new FoodItem("Spaghetti Sauce", 2.00, "Condiments/Sauces");
		allFoodItems.add(spaghettiSauce);
		FoodItem lasagnaNoodles = new FoodItem("Lasagna Noodles", 1.50, "Breads/Grains/Pasta");
		allFoodItems.add(lasagnaNoodles);
		FoodItem ricotta = new FoodItem("Ricotta", 3.00, "Dairy");
		allFoodItems.add(ricotta);
		FoodItem mozz = new FoodItem("Mozzarella", 2.50, "Dairy");
		allFoodItems.add(mozz);
		FoodItem egg = new FoodItem("Egg", 1.00, "Dairy");
		allFoodItems.add(egg);
		FoodItem hamBuns = new FoodItem("Hamburger Buns", 2.00, "Breads/Grains/Pasta");
		allFoodItems.add(hamBuns);
		FoodItem garlicBread = new FoodItem("Garlic Bread", 2.00, "Frozen");
		allFoodItems.add(garlicBread);
		FoodItem broccoli = new FoodItem("Broccoli", 3.00, "Produce");
		allFoodItems.add(broccoli);
		FoodItem fries = new FoodItem("French Fries", 2.50, "Frozen");
		allFoodItems.add(fries);
		FoodItem spagNoodles = new FoodItem("Spaghetti Noodles", 1.50, "Breads/Grains/Pasta");
		allFoodItems.add(spagNoodles);
		FoodItem mixedVegs = new FoodItem("Mixed Vegetables", 1.50, "Frozen");
		allFoodItems.add(mixedVegs);
		FoodItem hotdogs = new FoodItem("Hotdogs", 5.00, "Meat");
		allFoodItems.add(hotdogs);
		FoodItem hotBuns = new FoodItem("Hotdog Buns", 2.00, "Breads/Grains/Pasta");
		allFoodItems.add(hotBuns);
		FoodItem tortillas = new FoodItem("Tortillas", 2.50, "Breads/Grains/Pasta");
		allFoodItems.add(tortillas);
		FoodItem tacoSeasoning = new FoodItem("Taco Seasoning", 1.00, "Pantry");
		allFoodItems.add(tacoSeasoning);
		FoodItem chicken = new FoodItem("Chicken Breasts", 5.00, "Meat");
		allFoodItems.add(chicken);
		FoodItem stirFryVegs = new FoodItem("Stir Fry Vegetables", 2.00, "Frozen");
		allFoodItems.add(stirFryVegs);
		FoodItem stirFrySauce = new FoodItem("Stir Fry Sauce", 2.00, "Condiments/Sauces");
		allFoodItems.add(stirFrySauce);
		FoodItem rice = new FoodItem("Rice", 2.00, "Breads/Grains/Pasta");
		allFoodItems.add(rice);
		FoodItem mac = new FoodItem("Mac n' Cheese", 2.50, "Other");
		allFoodItems.add(mac);
		FoodItem milk = new FoodItem("Milk", 1.50, "Dairy");
		allFoodItems.add(milk);
		FoodItem lettuce = new FoodItem("Lettuce", 1.50, "Produce");
		allFoodItems.add(lettuce);
		FoodItem sweetPotato = new FoodItem("Sweet Potato", 2.50, "Produce");
		allFoodItems.add(sweetPotato);
		FoodItem onion = new FoodItem("Onion", 1.00, "Produce");
		allFoodItems.add(onion);
		FoodItem cheddar = new FoodItem("Cheddar Cheese", 2.50, "Dairy");
		allFoodItems.add(cheddar);
		FoodItem corn = new FoodItem("Corn", 1.00, "Frozen");
		allFoodItems.add(corn);
		FoodItem breadcrumbs = new FoodItem("Breadcrumbs", 2.00, "Pantry");
		allFoodItems.add(breadcrumbs);
		FoodItem beefStock = new FoodItem("Beef Stock", 1.50, "Canned Goods");
		allFoodItems.add(beefStock);
		FoodItem potato = new FoodItem("Potato", 2.00, "Produce");
		allFoodItems.add(potato);
		FoodItem rolls = new FoodItem("Dinner Roll", 3.00, "Frozen");
		allFoodItems.add(rolls);
		FoodItem meatballs = new FoodItem("Meatballs", 5.00, "Frozen");
		allFoodItems.add(meatballs);
		FoodItem butter = new FoodItem("Butter", 2.00, "Dairy");
		allFoodItems.add(butter);
		
		// Add default side dishes
		SideDish side = new SideDish("Mashed Potatoes");
		side.addIngredient(potato);
		side.addIngredient(butter);
		side.addIngredient(milk);
		sideDishes.add(side);
		
		side = new SideDish("Rice");
		side.addIngredient(rice);
		side.addIngredient(butter);
		sideDishes.add(side);
		
		side = new SideDish("Roasted Broccoli");
		side.addIngredient(broccoli);
		side.addIngredient(butter);
		sideDishes.add(side);
		
		side = new SideDish("French Fries");
		side.addIngredient(fries);
		sideDishes.add(side);
		
		side = new SideDish("Roasted Sweet Potato");
		side.addIngredient(sweetPotato);
		side.addIngredient(butter);
		sideDishes.add(side);
		
		side = new SideDish("Dinner Rolls");
		side.addIngredient(rolls);
		side.addIngredient(butter);
		sideDishes.add(side);
		
		side = new SideDish("Mixed Vegetables");
		side.addIngredient(mixedVegs);
		side.addIngredient(butter);
		sideDishes.add(side);
		
		side = new SideDish("Garlic Bread");
		side.addIngredient(garlicBread);
		sideDishes.add(side);
		
		side = new SideDish("Mac n' Cheese");
		side.addIngredient(mac);
		side.addIngredient(butter);
		side.addIngredient(milk);
		sideDishes.add(side);
		
		// Add default main courses
		MainCourse main = new MainCourse("Cheeseburgers");
		main.addIngredient(groundBeef);
		main.addIngredient(egg);
		main.addIngredient(breadcrumbs);
		main.addIngredient(cheddar);
		main.addIngredient(hamBuns);
		mainCourses.add(main);
		
		main = new MainCourse("Hotdogs");
		main.addIngredient(hotdogs);
		main.addIngredient(hotBuns);
		mainCourses.add(main);
		
		main = new MainCourse("Lasagna");
		main.addIngredient(lasagnaNoodles);
		main.addIngredient(spaghettiSauce);
		main.addIngredient(ricotta);
		main.addIngredient(mozz);
		mainCourses.add(main);
		
		main = new MainCourse("Tacos");
		main.addIngredient(groundBeef);
		main.addIngredient(tacoSeasoning);
		main.addIngredient(cheddar);
		main.addIngredient(lettuce);
		main.addIngredient(tortillas);
		mainCourses.add(main);
		
		main = new MainCourse("Spaghetti");
		main.addIngredient(spagNoodles);
		main.addIngredient(spaghettiSauce);
		main.addIngredient(meatballs);
		main.addIngredient(mozz);
		mainCourses.add(main);
		
		main = new MainCourse("Stir Fry");
		main.addIngredient(chicken);
		main.addIngredient(stirFryVegs);
		main.addIngredient(stirFrySauce);
		mainCourses.add(main);
		
		main = new MainCourse("Meatloaf");
		main.addIngredient(groundBeef);
		main.addIngredient(breadcrumbs);
		main.addIngredient(egg);
		main.addIngredient(onion);
		mainCourses.add(main);
		
		main = new MainCourse("Meatballs & Gravy");
		main.addIngredient(meatballs);
		main.addIngredient(beefStock);
		mainCourses.add(main);
	}
	
	// Method to update the dish lists
	public static void UpdateDishList() {
		
		// Check to see if new main dishes have been built
		if (rb.GetNewMainCourses().size() > 0) {
			
			// Add to master list
			for (int i = 0; i < rb.GetNewMainCourses().size(); i++) {
				mainCourses.add(rb.GetNewMainCourses().get(i));
			}
		}
		
		// Check to see if new side dishes have been built
		if (rb.GetNewSideDishes().size() > 0) {
			
			// Add to master list
			for (int i = 0; i < rb.GetNewSideDishes().size(); i++) {
				sideDishes.add(rb.GetNewSideDishes().get(i));
			}
		}
		
		// Clear new dish lists
		rb.ClearNewDishes();
		
		// Add to meal plan builder lists
		if (mpb != null) {
			
			mpb.GetSDListModel().clear();
			mpb.GetMCListModel().clear();
		}

	}
	
	// Method to update the food list
	public static void UpdateFoodList() {
		
		// Check to see if new food has been built
		if (afw.GetNewFoodItem() != null)
		{
			// Add to main food list
			allFoodItems.add(afw.GetNewFoodItem());
		}
	}
	
	// Method to check for input and restart
	public static void StartOver() throws InterruptedException {
		
		// Clear the user's selection
		mainMenu.ClearSelection();
		
		// Wait for user input on main menu
		while(mainMenu.GetSelection() == 0)
		{
			Thread.sleep(100);
		}
		
		// If the user selected the first button
		if (mainMenu.GetSelection() == 1) {
			
			// Build new lists
			List<String> mcNames = new ArrayList<String>();
			List<String> sdNames = new ArrayList<String>();
			
			// Check to see if dish list need to be updated
			if (rb != null) {
				
				UpdateDishList();
			}
			
			// Loop through maincourses and sidedishes and add names to lists
			for (int i = 0; i < mainCourses.size(); i++ ) {
				
				mcNames.add(mainCourses.get(i).getName());
			}
			
			for (int i = 0; i < sideDishes.size(); i++ ) {
				
				sdNames.add(sideDishes.get(i).getName());
			}
			
			// Instantiate new MealPlanBuilder window
			mpb = new MealPlanBuilder(mcNames, sdNames);
		}
		else {
			
			// If the user selected the second button
			if (mainMenu.GetSelection() == 2) {
				
				// Check to see if AddFoodWindow has been built
				if (afw != null) {
					
					// Update food list
					UpdateFoodList();
				}
				
				// Check to see if meal plan has been built
				if (mpb != null) {
					
					// Open grocery list window
					glw = new GroceryListWindow(mpb.GetAllMainCourses(), mpb.GetAllSideDishes(), mainCourses, sideDishes);
				}
			}
			else {
				
				// If the user selected the third button
				if (mainMenu.GetSelection() == 3) {
					
					// Check to see if dishes need to be updated
					if (rb != null) {
						
						UpdateDishList();
					}
					
					// Check to see if AddFoodWindow has been built
					if (afw != null) {
						
						// Update food list
						UpdateFoodList();
					}
					
					// Instantiate new RecipeBuilder window
					rb = new RecipeBuilder(allFoodItems);
				}
				else {
					
					// If the user selected the fourth button
					if (mainMenu.GetSelection() == 4) {
						
						// Check to see if AddFoodWindow has been built
						if (afw != null) {
							
							// Update food list
							UpdateFoodList();
						}
						
						// Instantiate new AddFood window
						afw = new AddFoodWindow(allFoodItems);
					}
				}
			}
		}
		
		// Start from the beginning
		StartOver();
	}

}
