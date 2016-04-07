package library;

import library.Bill.TypeCost;

public class B_Film extends DVD {
	
	public B_Film(Title title, String UID) {
		super(title, UID);
	}

	/**
	 * Calculate the bill for the B_Film
	 * First three days is 1.00
	 * Every day after is days times 2.00
	 * @return Bill (fee)
	 */
	public Bill getBill() {
		int days = this.getLoanPeriod();
		double total = 1.00;
		
		if(days > 3) {
			days = days - 3;
			total += 3 * 1.00;
			total += days * 2.00;
		}
		else {
			total += days * 1.00;
		}
		
		return new Bill( total, TypeCost.fee);
	}
}
