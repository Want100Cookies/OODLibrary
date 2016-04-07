 package library;

public abstract class DVD extends Article {

	/**
	 * 
	 * @param title the title of the DVD
	 * @param UID unique identifier
	 */
	public DVD(Title title, String UID) {
		super(title, UID);
	}

	/**
	 * abstract method getBill
	 */
	abstract Bill getBill();
}
