package library;

import java.util.Date;

public class Bill {
	private double amount;	// Amount of the bill
	private boolean paid;	// Has the bill been paid
	private Date warning1;	// Date of the first warning
	private Date warning2;	// Date of the second warning
	private TypeCost type;	// The type of this cost
	
	// Enum of containing fine or fee
	public enum TypeCost {
		fine, fee
	}
	
	public Bill(double amount, TypeCost type) {
		this.amount = amount;
		this.type = type;
	}
	
	/**
	 * Pay the bill (set paid on true)
	 */
	public void pay() {
		this.paid = true;
	}
	
	/**
	 * Has the bill been paid
	 * @return boolean
	 */
	public boolean isPaid() {
		return this.paid;
	}
	
	/**
	 * Get the type of the bill (fine/fee)
	 * @return TypeCost
	 */
	public TypeCost getType() {
		return this.type;
	}

	/**
	 * Give the first or second warning
	 */
	public void giveWarning() {
		if (!hasWarning1()) {
			warning1 = new Date();
			
		} else if (warning2 == null) {
			warning2 = new Date();
		}
	}
	
	/**
	 * Check if the bill has been given the first warning
	 * @return boolean
	 */
	public boolean hasWarning1() {
		return warning1 != null;
	}
	
	/**
	 * Get the date of the second warning
	 * @return Date
	 */
	public Date getWarning2() {
		return this.warning2;
	}
	
	/**
	 * Get the amount of this bull
	 * @return Double
	 */
	public double getAmount() {
		return this.amount;
	}
}
