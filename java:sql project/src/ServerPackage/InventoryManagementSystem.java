package ServerPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * Inventory Management class to manage all the funcionalities associated with the inventory and the Item class.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */

public class InventoryManagementSystem {

	DBController connection = new DBController();
	public Statement statement;
	public String tableName = "Tool";
	private static final int MINQUANTITY = 40;

	public InventoryManagementSystem() {
	}

	// Add a tool to the database table
	public void addItem(Item tool) {
		String sql = "INSERT INTO " + tableName + " VALUES ( " + tool.getItemId() + ", '" + tool.getItemName() + "', "
				+ tool.getItemQuantity() + ", " + tool.getItemPrice() + ", " + tool.getSupplierID() + ");";
		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// This method should search the database table for a tool matching the toolID
	// parameter and return that tool.
	public ArrayList<Item> searchToolByID(int toolID) {

		ArrayList<Item> itemList = new ArrayList<Item>();

		String sql = "SELECT * FROM " + tableName + " WHERE ToolID LIKE" + "'%" + toolID + "%'";
		ResultSet tool;

		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if (tool.next()) {
				itemList.add(new Item(tool.getInt("ToolID"), tool.getString("TName"), tool.getInt("Quantity"),
						tool.getDouble("Price"), tool.getInt("SupplierID")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;
	}

	/**
	 * method to search tool by name.
	 * 
	 * @param toolName
	 * @return
	 */
	public ArrayList<Item> searchToolByName(String toolName) {

		ArrayList<Item> itemList = new ArrayList<Item>();

		String sql = "SELECT * FROM " + tableName + " WHERE TName = '" + toolName + "'";
		ResultSet tool;

		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);

			if (tool.next()) {

				itemList.add(new Item(tool.getInt("ToolID"), tool.getString("TName"), tool.getInt("Quantity"),
						tool.getDouble("Price"), tool.getInt("SupplierID")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	/**
	 * method to list items
	 * @return
	 */
	public ArrayList<String> listItems() {

		ArrayList<String> itemList = new ArrayList<String>();

		String sql = "SELECT ToolID, TName FROM TOOL";
		ResultSet tool;

		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);

			while (tool.next()) {
				int ToolID = tool.getInt("ToolID");
				String ToolName = tool.getString("TName");
				String output = ToolID + " " + ToolName;
				itemList.add(output);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;
	}

	/**
	 * method to check item quantity
	 * 
	 * @param toolID
	 * @return
	 */
	public int checkItemQuantity(int toolID) {

		String sql = "SELECT Quantity FROM " + tableName + " WHERE ToolID = '" + toolID + "'";

		ResultSet tool;
		int ToolQuantity = 0;

		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);

			while (tool.next()) {
				ToolQuantity = tool.getInt("Quantity");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ToolQuantity;

	}

	/**
	 * method to search for item
	 * 
	 * @param toolID
	 * @return
	 */
	public Item searchForItem(int toolID) {

		String sql = "SELECT * FROM " + tableName + " WHERE ToolID LIKE" + "'%" + toolID + "%'";

		ResultSet tool;
		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if (tool.next()) {
				return new Item(tool.getInt("ToolID"), tool.getString("TName"), tool.getInt("Quantity"),
						tool.getDouble("Price"), tool.getInt("SupplierID"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * method to decrease item quantity 
	 * @param toolID
	 */
	public void decreaseItemQuantity(int toolID) {

		Order ord = new Order(); // generating a new order

		Item tool = searchForItem(toolID);

		int orderLineQuantity = 40 - (tool.getItemQuantity() - 1);

		String sql = "UPDATE " + tableName + " SET Quantity = '" + (tool.getItemQuantity() - 1) + "' "
				+ " WHERE ToolID = '" + tool.getItemId() + "'";

		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (tool.getItemQuantity() <= MINQUANTITY) {

			ord.addOrderLine(tool.generateOrderLine());

			sql = "INSERT INTO ORDERLINE" + " VALUES ( '" + ord.getId() + "', '" + toolID + "', '"
					+ tool.getSupplierID() + "', '" + orderLineQuantity + "');";

			try {
				statement = connection.jdbc_connection.createStatement();
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			tool.setItemQuantity(40);
		}
	}
}