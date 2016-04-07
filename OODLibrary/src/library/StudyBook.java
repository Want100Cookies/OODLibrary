package library;

import library.Bill.TypeCost;

public class StudyBook extends Book{

	public StudyBook(Title title, String UID) {
		super(title, UID);
	}
	
	/**
	 * Calculate the bill for this StudyBook
	 * If the book is loaned longer than 30 days, make a fine for 1.00 per extra week
	 * 
	 * @return Bill
	 */
	public Bill getBill() {
		if(getLoanPeriod() > 30){
			int totalWeeks = (getLoanPeriod() - 30) / 7;
			return new Bill((double) totalWeeks, TypeCost.fine);
		}
		return null;
	}
}
