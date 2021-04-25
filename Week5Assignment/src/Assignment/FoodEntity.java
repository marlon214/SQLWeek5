package Assignment;

public class FoodEntity {
	private int Id;
	private String Name;
	private double Price;

	public FoodEntity(int Id, String Name, double Price) {
		this.setId(Id);
		this.setName(Name);
		this.setPrice(Price);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
}
