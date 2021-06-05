package ServerPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ClientManager class to handle all the functionalities associated with the Client.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class ClientManager {

	DBController connection = new DBController();

	public Statement statement;
	public String tableName = "CLIENT";
	static int id;

	public ClientManager() {
	}

	// Add a tool to the database table
	public void addClient(Client client) {
		int id;
		String sql = "SELECT ClientID FROM " + tableName + " WHERE ClientID = (SELECT MAX(Clientid) FROM " + tableName
				+ ")";

		ResultSet clients;
		id = 0;

		try {
			statement = connection.jdbc_connection.createStatement();
			clients = statement.executeQuery(sql);

			while (clients.next()) {
				id = clients.getInt("ClientID");
				id += 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "INSERT INTO " + tableName + " VALUES ( '" + id + "', '" + client.getLname() + "', '" + client.getFname()
				+ "', '" + client.getClientType() + "', '" + client.getPhoneNumber() + "', '" + client.getAddress()
				+ "', '" + client.getPostalCode() + "');";
		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param clientID
	 * @return
	 */
	public ArrayList<Client> searchClientByID(String clientID) {

		ArrayList<Client> clientList = new ArrayList<Client>();

		String sql = "SELECT * FROM " + tableName + " WHERE ClientID = " + clientID;

		ResultSet client;
		try {
			statement = connection.jdbc_connection.createStatement();
			client = statement.executeQuery(sql);
			if (client.next()) {
				clientList.add(new Client(client.getInt("ClientID"), client.getString("LName"),
						client.getString("FName"), client.getString("CType"), client.getString("PhoneNum"),
						client.getString("Address"), client.getString("PostalCode")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientList;
	}

	/**
	 * 
	 * @param lname
	 * @return
	 */
	public ArrayList<Client> searchClientByName(String lname) {

		ArrayList<Client> clientList = new ArrayList<Client>();

		String sql = "SELECT * FROM " + tableName + " WHERE LName = '" + lname + "'";
		;
		ResultSet client;
		try {
			statement = connection.jdbc_connection.createStatement();
			client = statement.executeQuery(sql);

			while (client.next()) {
				clientList.add((new Client(client.getInt("ClientID"), client.getString("LName"),
						client.getString("FName"), client.getString("CType"), client.getString("PhoneNum"),
						client.getString("Address"), client.getString("PostalCode"))));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return clientList;
	}

	/**
	 * 
	 * @param clientType
	 * @return
	 */
	public ArrayList<Client> searchClientByType(String clientType) {

		ArrayList<Client> clientList = new ArrayList<Client>();

		String sql = "SELECT * FROM " + tableName + " WHERE CType = '" + clientType + "'";

		ResultSet client;

		try {
			statement = connection.jdbc_connection.createStatement();
			client = statement.executeQuery(sql);

			while (client.next()) {
				clientList.add(((new Client(client.getInt("ClientID"), client.getString("LName"),
						client.getString("FName"), client.getString("CType"), client.getString("PhoneNum"),
						client.getString("Address"), client.getString("PostalCode")))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientList;
	}

	/**
	 * 
	 * @param clientId
	 * @param fname
	 * @param lname
	 * @param clientType
	 * @param phoneNumber
	 * @param address
	 * @param postalCode
	 */
	public void modifyClient(int clientId, String fname, String lname, String clientType, String phoneNumber,
			String address, String postalCode) {

		String sql = "UPDATE " + tableName + " SET ClientID = '" + clientId + "', " + " LName = '" + lname + "', "
				+ " FName = '" + fname + "', " + " CType = '" + clientType + "', " + " PhoneNum = '" + phoneNumber
				+ "', " + " Address = '" + address + "', " + " PostalCode = '" + postalCode + "'"
				+ " WHERE ClientID = '" + clientId + "'";

		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param clientID
	 */
	public void removeClient(int clientID) {

		String sql = "DELETE FROM " + tableName + " WHERE ClientID = '" + clientID + "'";

		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
