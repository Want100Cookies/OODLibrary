package library;

public abstract class CD extends Article {

	public CD(Title title) {
		super(title);
	}

	abstract Bill getBill();
}
