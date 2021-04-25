package Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FoodDao {
	private Connection connection;
	private final String DISPLAY_Food_QUERY = "SELECT * FROM Food";
	private final String CREATE_NEW_Food_QUERY ="INSERT INTO Food(dishName,Price) VALUES(?,?)";
	private final String DELETE_Food_BY_ID = "DELETE FROM Food WHERE ID = ?";
	
		public FoodDao() {
			connection = DBConnection.getConnection();
		}

		public List<FoodEntity> getFood() throws SQLException {
			ResultSet rs = connection.prepareStatement(DISPLAY_Food_QUERY).executeQuery();
			List<FoodEntity> Food = new ArrayList<FoodEntity>();
			
			while(rs.next()) {
				Food.add(populateFood(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return Food;
			
			
	}
		private FoodEntity populateFood(int id, String name, double price) {
				return new FoodEntity(id, name, price);
			}
		
		public void createFood(String Name, double Price) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(CREATE_NEW_Food_QUERY);
			ps.setString(1, Name);
			ps.setDouble(2, Price);
			ps.executeUpdate();
			
		}
		public void deleteFood (int id) throws SQLException {
			PreparedStatement ps  = connection.prepareStatement(DELETE_Food_BY_ID);
			ps.setInt(1, id);
			ps.executeUpdate();
		
		}
	
}

