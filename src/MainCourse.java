import java.util.*;

public class MainCourse {
	
	// Properties
	// The main course's name
	private String name;
	
	// The main course's list of ingredients
	private List<FoodItem> ingredients;
	
	// The main course's notes
	private String notes;
	
	// Constructors
	public MainCourse() {
		name = "";
		ingredients = null;
	}
	
	public MainCourse(String value) {
		name = value;
		ingredients = new ArrayList<FoodItem>();
	}
	
	public MainCourse(String value, List<FoodItem> foodList) {
		name = value;
		ingredients = foodList;
		notes = "";
	}
	
	public MainCourse(String value, List<FoodItem> foodList, String str) {
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
	
	public void setNotes(String _notes) {
		
		notes = _notes;
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
