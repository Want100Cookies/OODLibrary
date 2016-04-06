package library;

public abstract class Book extends Article {

	public Book(Title title) {
		super(title);
	}

	abstract Bill getBill();
}
