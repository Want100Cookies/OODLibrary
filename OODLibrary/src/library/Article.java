package library;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class Article {

	private Title title; 	// Title of the article
	private String UID;		// Unique ID of the article
	private Member borrower;// The borrower of this article (can be null)
	private DateTime loanStart;	// The start of the loan
	private DateTime loanEnd;	// The end of the loan
	
	public Article(Title title, String UID) {
		this.title = title; // Set the title
		this.UID = UID; // set the UID
	}
	
	/**
	 * Simply get the borrower
	 * @return Borrower
	 */
	public Member getBorrower() {
		return this.borrower;
	}
	
	/**
	 * Simply set the borrower (null if not borrowed anymore)
	 * @param member
	 */
	public void setBorrower(Member member) {
		this.borrower = member;
	}
	
	/**
	 * Calculate the days between the start and end of the loan using YodaTime
	 * @return int days
	 */
	public int getLoanPeriod() {		
		int days = Days.daysBetween(new DateTime(loanStart), new DateTime(loanEnd)).getDays();
		return days;
	}
	
	/**
	 * Start the loan period (using the current DateTime)
	 */
	public void startLoanPeriod() {
		loanStart = new DateTime();
	}
	
	/**
	 * End the loan period and set the borrower to null
	 */
	public void endLoanPeriod() {
		if(loanEnd == null){
			loanEnd = new DateTime();
		}
		
		setBorrower(null);
	}
	
	/**
	 * Childs need to calculate the bill on their own
	 * @return
	 */
	abstract Bill getBill();
}
