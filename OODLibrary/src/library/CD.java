package library;

import library.Bill.TypeCost;

public abstract class CD extends Article {
	protected double startAmount;
	protected double weeklyAmount;
	
	public CD(Title title, String UID){
		super(title, UID);
	}

	/**
	 * Get the calculated bill for this CD
	 * The only difference between the the child types are the start amount and the weekly amount.
	 * Therefore they have been added as protected fields and is the getBill method implemented in this class.
	 * @return Bill
	 */
	public Bill getBill() {
		int days = this.getLoanPeriod();
		double amount = startAmount;
		
		if (days > 10) {
			days = days - 10;
			
			int weeks = days / 7;
			
			amount += weeks * weeklyAmount;
		}
		
		return new Bill(amount, TypeCost.fee);
	}
}
