package library;

import java.util.Date;

public class Bill {
	private double amount;
	private boolean paid;
	private Date warning1;
	private Date warning2;
	private TypeCost type;
	
	public enum TypeCost {
		fine, fee
	}
	
	public Bill(double amount, TypeCost type) {
		this.amount = amount;
		this.type = type;
	}
	
	/**
	 * de bill wordt betaald:
	 */
	public void pay() {
		this.paid = true;
	}
	
	/**
	 * Is de bill al betaald?
	 * @return true als de bill is betaald.
	 */
	public boolean isPaid() {
		return this.paid;
	}
	
	/**
	 * Returnt het type, fine of fee.
	 * @return fine of fee.
	 */
	public TypeCost getType() {
		return this.type;
	}

	public void giveWarning() {
		if (!hasWarning1()) {
			warning1 = new Date();
			
		} else if (warning2 == null) {
			warning2 = new Date();
		}
	}
	
	public boolean hasWarning1() {
		return warning1 != null;
	}
	
	public Date getWarning2() {
		return this.warning2;
	}
	
	/**
	 * returnt het bedrag van de rekening.
	 * @return double het bedrag van de rekening.
	 */
	public double getAmount() {
		return this.amount;
	}
}
