package library;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class Article {
	private Title title;
	private String UID;
	private Member borrower;
	private DateTime loanStart;
	private DateTime loanEnd;
	
	public Article(Title title, String UID) {
		this.title = title;
		this.UID = UID;
	}
	
	public String toString(){
		return UID;
	}
	
	public Member getBorrower() {
		return this.borrower;
	}
	
	public void setBorrower(Member member) {
		this.borrower = member;
	}
	
	public int getLoanPeriod() {		
		//Days days = Days.daysBetween(loanStart, loanEnd);
		int days = Days.daysBetween(new DateTime(loanStart), new DateTime(loanEnd)).getDays();
		return days;
	}
	
	public void startLoanPeriod() {
		loanStart = new DateTime();
	}
	
	public void endLoanPeriod() {
		if(loanEnd == null){
			loanEnd = new DateTime();
			System.out.println("loanEnd was null");
		}
		setBorrower(null);
	}
	
	/**
	 * for testing purposes.
	 * @param d
	 */
	public void setEndDate(DateTime d){
		loanEnd = d;
	}
	
	abstract Bill getBill();
}
