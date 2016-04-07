package library;

public abstract class Book extends Article {

	public Book(Title title, String UID) {
		super(title, UID);
	}

	abstract Bill getBill();
}
