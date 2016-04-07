package library;

import library.Bill.TypeCost;

public class A_Film extends DVD {

	public A_Film(Title title, String UID) {
		super(title, UID);
	}
	
	/**
	 * Calculates the bill (fee)
	 * Which is days * €2.00
	 */
	public Bill getBill() {
		int days = getLoanPeriod();
	    double amount = days * 2;
		return new Bill(amount, TypeCost.fee);
	}
}
