package ServerPackage;

import java.util.ArrayList;

/**
 * SupplierList class stores the list of all the available suppliers.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class SupplierList {

	/**
	 * array list variable to store list of suppliers
	 */
	private ArrayList<Supplier> suppliers;

	/**
	 * Constructor to initialize supplier list
	 * 
	 * @param supplierList
	 */
	public SupplierList(ArrayList<Supplier> supplierList) {
		suppliers = supplierList;
	}

	/**
	 * listSuppliers() method list all the suppliers available
	 * 
	 * @return supList list of suppliers
	 */
	public String listSuppliers() {

		String supList = "";

		for (Supplier supp : suppliers) {
			supList += supp.getSupplierName() + "\n";
		}

		return supList;
	}

}
