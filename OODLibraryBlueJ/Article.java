 

import java.util.Date;

public abstract class Article {
	private Title title;
	private String UID;
	//note to Pascal: wat is deze hierboven?
	private Member borrower;
	private Date loanStart;
	private Date loanEnd;
	
	public Article(Title title, String UID) {
		this.title = title;
		this.UID = UID;
	}
	
		public Article(Title title) {
		this.title = title;
		UID = "wat is deze?";
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
		setBorrower(null);
	}
	
	abstract Bill getBill();
}