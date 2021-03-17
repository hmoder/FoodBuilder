
public class FoodItem {
	// Properties
	
	// The name of the food item
	private String name;
	
	// The cost of the food item
	private double cost;
	
	// The category of the food item
	private String category;
	
	// Constructors
	public FoodItem(String _name, double _cost, String _category) {
		name = _name;
		cost = _cost;
		category = _category;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double value) {
		cost = value;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String value) {
		category = value;
	}
}
