package library;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Article {
	private Title title;
	private String UID;
	private Member borrower;
	private Date loanStart;
	private Date loanEnd;
	
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
		long diff = loanEnd.getTime() - loanStart.getTime();//in Milli seconds
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		Days days = Days.daysBetween(start, end);
	}
	
	public void startLoanPeriod() {
		loanStart = new Date();
	}
	
	public void endLoanPeriod() {
		if(loanEnd == null){
			loanEnd = new Date();
			System.out.println("loanEnd was null");
		}
		setBorrower(null);
	}
	
	/**
	 * for testing purposes.
	 * @param d
	 */
	public void setEndDate(Date d){
		loanEnd = d;
	}
	
	abstract Bill getBill();
}
