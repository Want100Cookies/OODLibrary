package library;

public class Classical extends CD {

	/**
	 * Set the start and weekly amount
	 * @param title
	 * @param UID
	 */
	public Classical(Title title, String UID) {
		super(title, UID);
		
		this.startAmount = 2.00;
		this.weeklyAmount = 1.50;
	}
}
