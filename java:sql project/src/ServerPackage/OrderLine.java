package ServerPackage;

/**
 * OrderLine class records the relevant order information for an item.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class OrderLine {

	/**
	 * variable to describe the item in the order
	 */
	private String description;

	/**
	 * variable to store the quantity of items in an order
	 */
	private int orderQuantity;

	/**
	 * variable to store the supplier name
	 */
	private String SupplierName;
	private int supplierId;

	/**
	 * Constructor to initialize order description and information about the order
	 * 
	 * @param item in the order
	 */
	public OrderLine(Item item) {
		setDescription(item.getItemName());
		setOrderQuantity(40 - item.getItemQuantity()); // the amount to order
		// setSupplierName(item.getSupplier().getSupplierName());
		// setSupplierId(item.getSupplier().getSupplierId());

	}

	/**
	 * getDescription() method gets the description of the order
	 * 
	 * @return description of the order
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setDescription() method sets the description of the order
	 * 
	 * @param description of the order
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getOrderQuantity() gets the quantity of the order
	 * 
	 * @return orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * setOrderQuantity() sets the quantity of the order
	 * 
	 * @param orderedQ
	 */
	public void setOrderQuantity(int orderedQ) {
		this.orderQuantity = orderedQ;
	}

	/**
	 * getSupplierName() gets the supplier name related to the order
	 * 
	 * @return SupplierName related to order
	 */
	public String getSupplierName() {
		return SupplierName;
	}

	/**
	 * setSupplierName() sets supplier name related to the order
	 * 
	 * @param supplierName related to the order
	 */
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int i) {
		this.supplierId = i;
	}
}
