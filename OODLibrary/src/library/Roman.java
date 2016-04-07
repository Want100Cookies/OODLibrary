package library;

import library.Bill.TypeCost;

public class Roman extends Book {

	public Roman(Title title) {
		super(title);
	}
	
	public Bill getBill() {
		if(getLoanPeriod() > 21){
			int days = getLoanPeriod() - 21;
			double amount = days * 0.25;
			return new Bill(amount, TypeCost.fine);
		}
		return null;
	}

}
