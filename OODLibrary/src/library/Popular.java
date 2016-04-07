package library;

public class Popular extends CD {

	public Popular(Title title, String UID) {
		super(title, UID);
		
		this.startAmount = 1.00;
		this.weeklyAmount = 2.00;
	}
}
