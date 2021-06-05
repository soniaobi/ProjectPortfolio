package ServerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database Controller class to control the database end of the project and
 * handle the connection between java and sql.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class DBController {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "InventoryDB";

	public String connectionInfo = "jdbc:mysql://localhost:3306/InventoryDB", login = "root", password = "Fatsam123";

	/**
	 * connection to sql
	 */
	public DBController() {
		try {
			// If this throws an error, make sure you have added the mySQL connector JAR to
			// the project
			Class.forName("com.mysql.jdbc.Driver");

			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			// System.out.println("Connected to: " + connectionInfo + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
