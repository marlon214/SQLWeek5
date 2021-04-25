package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String connectionString = "jdbc:mysql://localhost:3306/Restaurant";
	private static DBConnection instance;
	private static Connection connection;

	private DBConnection(Connection connection) {
		this.connection = connection;
	}

	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(connectionString, "root", "Black426!");
				instance = new DBConnection(connection);
				System.out.println("Success!");
			} catch (SQLException e) {
				System.out.println("Error!");
				e.printStackTrace();
			}
		}

		return DBConnection.connection;
	}
}

