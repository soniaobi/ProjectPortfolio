package ServerPackage;

/**
 * 
 * International Supplier class, suclass of the Supplier class.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class InternationalSupplier extends Supplier {

	private double importTax;
	Item tool;

	/**
	 * constructor.
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param salesRep
	 */
	public InternationalSupplier(int id, String name, String address, String salesRep) {

		super(id, name, address, salesRep);

	}

	/**
	 * 
	 * method to calculate import tax
	 * 
	 * @return importtTax
	 */
	public double importTax() {

		importTax = 0.05 * tool.getItemPrice();

		return importTax;

	}
}
