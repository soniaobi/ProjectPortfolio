package ServerPackage;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Random;
import java.util.Date;

/**
 * Order class stores and manages all the relevant information related to an
 * order of a certain day.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class Order {
	
	DBController connection = new DBController();
	
	public Statement statement;
	public String tableName = "TOOLORDER";


	/**
	 * array list variable to sore all the orderLines
	 */
	private ArrayList<OrderLine> orderOfDay;

	/**
	 * variable to store order id
	 */
	private int id;

	/**
	 * variable to store order date
	 */
	private String date;

	/**
	 * Constructor to create order instance with randomized order id and the current
	 * date
	 */
	
	
	public Order() {
		
		orderOfDay = new ArrayList<OrderLine>();
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		String sql = "INSERT INTO " + tableName +
				" (OrderDate) VALUES ( '"+  date  + "');";
		
		try{
			statement = connection.jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		

	/**
	 * addOrderLine() method to add an order line
	 * 
	 * @param orderInfo
	 */
	public void addOrderLine(OrderLine orderInfo) {
		orderOfDay.add(orderInfo);
	}

	/**
	 * getId() method gets order id
	 * 
	 * @return id of order
	 */
	public int getId() {
		
		String sql = "SELECT OrderID FROM " + tableName + " WHERE OrderID = (SELECT MAX(orderid) FROM " +  tableName + ")";
		
		ResultSet tool;
		id = 0;
		
		try {
			statement = connection.jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);

			while (tool.next()) {
				id = tool.getInt("OrderID");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	/**
	 * setId() method sets order id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getDate() method gets the date of the order
	 * 
	 * @return date of order
	 */
	public String getDate() {
		return date;
	}

	/**
	 * setDate() method sets the date of the order
	 * 
	 * @param date of order
	 */
	public void setDate(String date) {
		this.date = date;
	}


}
