 package library;

public abstract class DVD extends Article {

	public DVD(Title title) {
		super(title);
	}

	abstract Bill getBill();
}
