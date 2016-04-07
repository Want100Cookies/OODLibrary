package library;

import library.Bill.TypeCost;

public abstract class CD extends Article {
	protected double startAmount;
	protected double weeklyAmount;
	
	public CD(Title title){
		super(title, "wat is deasu");
	}

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
