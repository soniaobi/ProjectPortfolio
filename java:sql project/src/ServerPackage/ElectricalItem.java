package ServerPackage;

/**
 * 
 * ElectricalItem Class - subclass of Item class.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class ElectricalItem extends Item {

	private String powerType;

	/**
	 * 
	 * constructor.
	 * 
	 * @param itemId
	 * @param itemName
	 * @param itemQuantity
	 * @param itemPrice
	 * @param supplierid
	 */
	public ElectricalItem(int itemId, String itemName, int itemQuantity, double itemPrice, int supplierid) {

		super(itemId, itemName, itemQuantity, itemPrice, supplierid);
	}

	/**
	 * 
	 * @return powerType
	 */
	public String getPowerType() {
		return powerType;
	}

	/**
	 * 
	 * @param powerType
	 */
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

}
