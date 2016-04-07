package library;

import library.Bill.TypeCost;

public class Roman extends Book {

	public Roman(Title title, String UID) {
		super(title, UID);
	}
	
	public Bill getBill() {
		int days = getLoanPeriod();
		System.out.println("De loan period is: " + days);
		if(days > 21){
			days -= 21;
			double amount = days * 0.25;
			return new Bill(amount, TypeCost.fine);
		}
		return null;
	}

}
