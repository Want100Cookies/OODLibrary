package library;

import java.util.ArrayList;
import java.util.Date;

public class Member {
	private int memberID;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private Date birthDay;
	private ArrayList<Bill> bills;
	
	public Member(String firstName, String lastName, String address, String email, Date birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.birthDay = birthDay;
		bills = new ArrayList<Bill>();
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public ArrayList<Bill> getBills() {
		return this.bills;
	}
	
	public void addBill(Bill bill) {
		bills.add(bill);
	}
	
	public void getBills() {
		
	}
}
