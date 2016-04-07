package library;

import java.util.Date;

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
		return (int) Math.round((loanEnd.getTime() - loanStart.getTime()) / (double)86400000);
	}
	
	public void startLoanPeriod() {
		loanStart = new Date();
	}
	
	public void endLoanPeriod() {
		if(loanEnd == null){
		loanEnd = new Date();
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
