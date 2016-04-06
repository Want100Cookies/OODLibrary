package library;

import java.util.Date;

public abstract class Article {
	private Title title;
	private Member borrower;
	private Date loanStart;
	private Date loanEnd;
	
	public Article(Title title) {
		this.title = title;
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
		loanEnd = new Date();
	}
	
	abstract Bill getBill();
}
