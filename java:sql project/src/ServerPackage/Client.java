package ServerPackage;

/**
 * 
 * Client model class. 
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class Client {

	private int clientId;
	private String fname;
	private String lname;
	private String clientType;
	private String phoneNumber;
	private String address;
	private String postalCode;

	/**
	 * constructor initializing private variables.
	 * 
	 * @param clientId
	 * @param lname
	 * @param fname
	 * @param clientType
	 * @param phoneNumber
	 * @param address
	 * @param postalCode
	 */
	public Client(int clientId, String lname, String fname, String clientType, String phoneNumber, String address,
			String postalCode) {
		this.clientId = clientId;
		this.fname = fname;
		this.lname = lname;
		this.clientType = clientType;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
	}

	/**
	 * toString method for the class
	 */
	public String toString() {

		return (clientId + " " + lname + " " + fname + " " + clientType + " " + phoneNumber + " " + address + " "
				+ postalCode);

	}

	/**
	 * getting for client id
	 * @return clientID
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * sertting for client id
	 * @param clientId
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * getting for client first name
	 * @return fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * setter for client first name
	 * @param fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * getting for client last name
	 * @return lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * setting for client last name
	 * @param lname
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * getting for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setter for address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter for postal code
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * setting for postal code
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * getter for phone number
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setter for phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getting for client type
	 * @return clientType
	 */
	public String getClientType() {
		return clientType;
	}

	/**
	 * setter for client type 
	 * @param clientType
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

}
