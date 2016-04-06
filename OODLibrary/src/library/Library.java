package library;

import java.util.ArrayList;

public class Library {
	private ArrayList<Title> titles;
	private ArrayList<Member> members;
	
	public Library() {
		titles = new ArrayList<Title>();
		members = new ArrayList<Member>();
	}
	
	public Article loan(Member member, Title title) {
		return title.loan(member);
	}
	
	public void payBill(Bill bill) {
		bill.pay();
	}
	
	public void bringBackArticle(Member member, Article article) {
		article.endLoanPeriod();
		member.addBill(article.getBill());
	}
	
	public void bringBackAllArticles(Member member) {
		for (Title title : titles){
			for (Article article : title.getArticles()) {
				if (article.getBorrower() == member) {
					article.endLoanPeriod();
					member.addBill(article.getBill());
				}
			}
		}
	}
	
	public ArrayList<Bill> getFines() {
		return null;
	}
	
	public void sendWarningLetters(ArrayList<Bill> bills) {
		
	}
	
	public void sendMemberToBailiff(Member member) {
		
	}
	
	public void getTotalIncome(int year) { // Todo: add parameter `Bill.typeCost type`
		
	}
	
	public static void main(String[] args) {
		System.out.println("Library started");
	}
}
