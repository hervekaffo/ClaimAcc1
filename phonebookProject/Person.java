package phonebookProject;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	
	
	
	
	public Person() {}
	
	public Person(String firstName, String lastName, String phoneNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	
	public Person(String firstName, String middleName, String lastName, String phoneNumber, Address address) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public static String formatPhoneNumber(String p) {
		return "("+p.charAt(0)+p.charAt(1)+p.charAt(2)+")-"+p.charAt(3)+
				p.charAt(4)+p.charAt(5)+"-"+p.charAt(6)+p.charAt(7)+p.charAt(8)
				+p.charAt(9);	
	}
	
	@Override
	public String toString() {
		return firstName+" "+middleName+" "+ lastName +", " + address.toString()
				+ ", "+formatPhoneNumber(phoneNumber);
	}
	
	

}
