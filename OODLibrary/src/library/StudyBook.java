package library;

import library.Bill.TypeCost;

public class StudyBook extends Book{

	public StudyBook(Title title, String UID) {
		super(title, UID);
	}
	
	public Bill getBill() {
		if(getLoanPeriod() > 30){
			int totalWeeks = (getLoanPeriod() - 30) / 7;
			return new Bill((double) totalWeeks, TypeCost.fine);
		}
		return null;
	}
}
