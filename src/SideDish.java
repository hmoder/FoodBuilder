import java.util.*;

public class SideDish {
	// Properties
	
	// The side dish's name
	private String name;
	
	// The side dish's list of ingredients
	private List<FoodItem> ingredients;
	
	// The side dish's notes
	private String notes;
	
	// Constructors
	public SideDish(String value) {
		name = value;
		ingredients = new ArrayList<FoodItem>();
	}
	
	public SideDish(String value, List<FoodItem> foodList) {
		name = value;
		ingredients = foodList;
	}
	
	public SideDish(String value, List<FoodItem> foodList, String str) {
		name = value;
		ingredients = foodList;
		notes = str;
	}
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	
	public List<FoodItem> getIngredients() {
		return ingredients;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String value) {
		notes = value;
	}
	
	// Method to calculate cost
	public double calculateCost() {
		
		// Initialize cost at 0
		double cost = 0;
		
		// Loop through list of ingredients and add cost to total
		for (int i = 0; i < ingredients.size(); i++) {
			cost = cost + ingredients.get(i).getCost();
		}
		
		// Return the total cost
		return cost;
	}
	
	// Method to add ingredients
	public void addIngredient(FoodItem food) {
		ingredients.add(food);
	}

}
