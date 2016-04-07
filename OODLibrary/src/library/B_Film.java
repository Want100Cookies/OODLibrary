package library;

public class B_Film extends DVD {
	protected double startAmount;
	protected double afterThreeDays;
	protected double total;
	
	public B_Film(Title title, String UID) {
		super(title, UID);
		
		this.startAmount = 1.00;
		this.afterThreeDays = 2.00;
	}

	public Bill getBill() {
		int days = this.getLoanPeriod();
		double amount = startAmount;
		
		if(days > 3) {
			days = days - 3;
			total += 3 * this.startAmount;
			total += days * this.afterThreeDays;
		}
		else {
			total += days * this.startAmount;
		}
		return total;
	}
}
