 package library;

public abstract class DVD extends Article {

	/**
	 * 
	 * @param title de Title van de dvd
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
