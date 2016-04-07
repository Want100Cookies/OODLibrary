package library;

public abstract class Book extends Article {

	public Book(Title title, String UID) {
		super(title, UID);
	}

	/**
	 * Abstract method for the bill
	 */
	abstract Bill getBill();
}
