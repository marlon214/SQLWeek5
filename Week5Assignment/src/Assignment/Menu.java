package Assignment;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private FoodDao foodDao = new FoodDao();
	
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Food", "Create Food", "Delete Food");

	public void start() {
		// TODO Auto-generated method stub
		String select = "";
		do {
			printMenu();
			select = scanner.nextLine();
			try {
				if (select.equals("1")) {
					displayFood();
				} else if (select.equals("2")) {
					createFood();
				} else if (select.equals("3")) {
					deleteFood();
		
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			

		} while (!select.equals("-1"));

}

	private void deleteFood() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Food id to delete: ");
		int id =Integer.parseInt(scanner.nextLine());
		foodDao.deleteFood(id);
	}

	private void createFood() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter New Food name:");
		String foodName = scanner.nextLine();
		System.out.println("Enter it's price: $");
		double foodPrice= scanner.nextDouble();
		foodDao.createFood(foodName, foodPrice);
	}

	private void displayFood() throws SQLException {
		// TODO Auto-generated method stub
		List<FoodEntity> Food = foodDao.getFood();
		for (FoodEntity food : Food) {
			System.out.println(food.getId() + ": " + food.getName() + 
					": " + food.getPrice());
		}
		

	}

	private void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Please Select an Options:");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ". " + options.get(i));
		}
	}

}