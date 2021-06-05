package ServerPackage;

import java.util.ArrayList;

/**
 * Supplier class stores relevant information about the supplier and the items
 * related to the supplier.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class Supplier {

	/**
	 * array list variable to store list of items related to a supplier
	 */
	private ArrayList<Item> supplierItems;

	/**
	 * variable to store supplier id
	 */
	private int id;

	/**
	 * variable to store supplier name
	 */
	private String name;

	/**
	 * variable to store supplier address
	 */
	private String address;

	/**
	 * variable to store sales rep/contact associated with the supplier
	 */
	private String salesRep;

	/**
	 * Constructor to initialize id, name, address, and sales rep information
	 * 
	 * @param id       of supplier
	 * @param name     of supplier
	 * @param address  of supplier
	 * @param salesRep associated with supplier
	 */
	public Supplier(int id, String name, String address, String salesRep) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.salesRep = salesRep;

		supplierItems = new ArrayList<Item>();
	}

	/**
	 * setSupplierId() sets the supplier id
	 * 
	 * @return id of supplier
	 */
	public int getSupplierId() {
		return id;
	}

	/**
	 * setSupplierId() sets the id of the supper
	 * 
	 * @param id of supplier
	 */
	public void setSupplierId(int id) {
		this.id = id;
	}

	/**
	 * getSupplierName() gets the name of the supplier
	 * 
	 * @return name of supplier
	 */
	public String getSupplierName() {
		return name;
	}

	/**
	 * getSupplierName() gets the supplier name
	 * 
	 * @param name of supplier
	 */
	public void setSupplierName(String name) {
		this.name = name;
	}

	/**
	 * getSupplierAddress() gets the address of the supplier
	 * 
	 * @return address of supplier
	 */
	public String getSupplierAddress() {
		return address;
	}

	/**
	 * setSupplierAddress() sets the suppler address
	 * 
	 * @param address of supplier
	 */
	public void setSupplierAddress(String address) {
		this.address = address;
	}

	/**
	 * getSalesRep() gets the sales representative/contact associated with the
	 * supplier
	 * 
	 * @return salesRep
	 */
	public String getSalesRep() {
		return salesRep;
	}

	/**
	 * setSalesRep() sets sales rep associated with supplier
	 * 
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	/**
	 * getItemList() gets the list of items associated with a supplier
	 * 
	 * @return supplierItems list
	 */
	public ArrayList<Item> getItemList() {
		return supplierItems;
	}

	/**
	 * addSupplierItem() adds an item to the list of items associated with the
	 * supplier
	 * 
	 * @param item
	 */
	public void addSupplierItem(Item item) {
		supplierItems.add(item);
	}

}
