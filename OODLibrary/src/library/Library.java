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
		return null;
	}
	
	public void payBill(Member member, Bill bill) {
		
	}
	
	public Bill bringBackArticle(Article article) {
		return null;
	}
	
	public void bringBackAllArticles(Member member) {
		
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
