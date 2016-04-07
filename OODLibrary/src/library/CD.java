package library;

import library.Bill.TypeCost;

public abstract class CD extends Article {
	protected double startAmount;
	protected double weeklyAmount;
	
	public CD(Title title, String UID){
		super(title, UID);
	}

	/**
	 * returnt de rekening voor de gehuurde CD.
	 * startAmount en weeklyAmount wordt ingevuld door een Classical object of een Popular object.
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
