package library;

public class Popular extends CD {

	/**
	 * Set the start and weekly amount
	 * @param title
	 * @param UID
	 */
	public Popular(Title title, String UID) {
		super(title, UID);
		
		this.startAmount = 1.00;
		this.weeklyAmount = 2.00;
	}
}
