package library;

import library.Bill.TypeCost;

public class Roman extends Book {

	public Roman(Title title, String UID) {
		super(title, UID);
	}
	
	/**
	 * Calculate the bill on the Roman book.
	 * If the book is loaned for more then 21 days pay 25 cent for each extra day.
	 * @return Bill
	 */
	public Bill getBill() {
		int days = getLoanPeriod();
		if(days > 21){
			days -= 21;
			double amount = days * 0.25;
			return new Bill(amount, TypeCost.fine);
		}
		return null;
	}

}
