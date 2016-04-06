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
	
	public void pay() {
		
	}
	
	public boolean isPaid() {
		return this.paid;
	}
	
	public void giveWarning() {
		
	}
	
	public boolean hasWarning1() {
		return warning1 != null;
	}
	
	public Date getWarning2() {
		return this.warning2;
	}
	
	public double getAmount() {
		return this.amount;
	}

}
