 package library;

public abstract class DVD extends Article {

	public DVD(Title title, String UID) {
		super(title, UID);
	}

	abstract Bill getBill();
}
