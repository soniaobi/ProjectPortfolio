package ServerPackage;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Item class stores and manages all the relevant information about an item
 * such as the id, name, price, quantity and supplier.
 * 
 * @author Sonia Obi & Ikenna Onyegbutulem
 *
 */
public class Item {
	
	DBController connection = new DBController();
	
	public Statement statement;
	public String tableName = "Tool";
	

	/**
	 * id variable to store ID of the item
	 */
	private int itemId;

	/**
	 * name variable to store name of the item
	 */
	private String itemName;

	/**
	 * price variable to store price of the item
	 */
	private double itemPrice;

	/**
	 * quantity variable to store quantity of the item
	 */
	private int itemQuantity;

	/**
	 * supplier variable to store supplier of the item
	 */
	private Supplier supplier;

	/**
	 * variable to store minimum quantity of item to see if an order has to be
	 * placed
	 */
	private static final int MINQUANTITY = 40;
	
	private int supplierid;

	/**
	 * Constructor to initialize id, name, quantity, price and supplier of item.
	 * 
	 * @param itemId
	 * @param itemName
	 * @param itemQuantity
	 * @param itemPrice
	 * @param supplier
	 */
	
	public Item(int itemId, String itemName, int itemQuantity, double itemPrice, int supplierid) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.supplierid = supplierid;

	}


	/**
	 * generateOrderLine() method generates an order line that records information
	 * about the item and the supplier.
	 * 
	 * @return orderInfo orderLine if order is places, otherwise returns null.
	 */
	public OrderLine generateOrderLine() {
		OrderLine orderInfo;

		if (getItemQuantity() < MINQUANTITY) {

			orderInfo = new OrderLine(this);
			
			return orderInfo;
		}
		return null;
		
	}
	
	
	public String toString() {

		return (itemId + " " + itemName + " " + itemQuantity + " " + itemPrice + " " + supplierid);
		
	}

	/**
	 * getItemId() method gets the item id
	 * 
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * getItemName() methods get the item name
	 * 
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * getItemQuantity() method gets the item quantity
	 * 
	 * @return itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * getItemPrice() method gets the item price
	 * 
	 * @return itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * getSupplier() method gets the item supplier
	 * 
	 * @return supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * setItemName() method sets the item name
	 * 
	 * @param name
	 */
	public void setItemName(String name) {
		itemName = name;
	}

	/**
	 * setItemId() method sets the item id
	 * 
	 * @param Id
	 */
	public void setItemId(int Id) {
		itemId = Id;
	}


	public int getSupplierID() {
		return supplierid;
	}
	
	public void setSupplierID(int id) {
		supplierid = id;
	}
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
		
		String sql = "UPDATE " + tableName + 
				" SET Quantity = '" + itemQuantity + "' " + 
				" WHERE ToolID = '" + itemId + "'";
		
		try {
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
