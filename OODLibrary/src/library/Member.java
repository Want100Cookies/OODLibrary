package library;

import java.util.ArrayList;
import java.util.Date;

public class Member {
	private String firstName;	// The first name of the member
	private String lastName;	// The last name of the member
	private String address;		// The address of the member
	private String email;		// The email address of the member
	private Date birthDay;		// The birthday of the member
	private ArrayList<Bill> bills; // The list of bills for this user
	
	public Member(String firstName, String lastName, String address, String email, Date birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.birthDay = birthDay;
		bills = new ArrayList<Bill>();
	}
	
	/**
	 * Getter for the name
	 * @return String
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Setter for the name
	 * @param firstName
	 * @param lastName
	 */
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Getter for the address
	 * @return String
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Setter for the address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Getter for the email
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Setter for the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter for the birthday
	 * @return Date
	 */
	public Date getBirthDay() {
		return this.birthDay;
	}
	
	/**
	 * Setter for the birthday
	 * @param date
	 */
	public void setBirthDay(Date date) {
		this.birthDay = date;
	}
	
	/**
	 * Getter for all the bills
	 * @return ArrayList<Bill>
	 */
	public ArrayList<Bill> getBills() {
		return this.bills;
	}
	
	/**
	 * Add a bill to this specific user
	 * @param bill
	 */
	public void addBill(Bill bill) {
		bills.add(bill);
	}
}
