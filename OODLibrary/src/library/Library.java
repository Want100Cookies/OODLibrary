package library;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.joda.time.DateTime;
import org.joda.time.Days;

import library.Bill.TypeCost;
public class Library {
	//all titles in the library.
    private ArrayList<Title> titles;
    
    //all members of this library.
    private ArrayList<Member> members;

    public Library() {
        titles = new ArrayList<Title>();
        members = new ArrayList<Member>();
    }

    /**
     * Called when a member wants to loan a title. Then article  
     * @param member the member that is going to loan
     * @param title The title that is (if available) going to be borrowed.
     * @return
     */
    public Article loan(Member member, Title title) {
        return title.loan(member);
    }

    /**
     * Pay a bill.
     * @param bill
     */
    public void payBill(Bill bill) {
        bill.pay();
    }

    /**
     * Let a member bring back an article.
     * @param member the member in case.
     * @param article the article he has and wants to bring back.
     */
    public void bringBackArticle(Member member, Article article) {
        article.endLoanPeriod();
        Bill bill = article.getBill();
               
        if (bill != null) {
            System.out.println("Het bedrag van de berekende bill is: " + bill.getAmount());

        	member.addBill(article.getBill());        	
        }        
    }

    /**
     * Let the member bring all articles back.
     * @param member the member in case.
     */
    public void bringBackAllArticles(Member member) {
        for (Title title : titles){
            for (Article article : (ArrayList<Article>) title.getArticles()) {
                if (article.getBorrower() == member) {
                    bringBackArticle(article.getBorrower(), article);
                }
            }
        }
    }

    /**
     * Returns every fines that a member has, paid or unpaid.
     * @return
     */
    public ArrayList<Bill> getFines() {
    	Iterator<Member> it = members.iterator();
    	ArrayList<Bill> returnList = new ArrayList<>();
    	while(it.hasNext()){
            Member m = it.next();
            Iterator<Bill> bills = m.getBills().iterator();
            
            while(bills.hasNext()){
                Bill bill = bills.next();
                
                if(bill.getType() == TypeCost.fine){
                	returnList.add(bill);
                }
            }
        }
        return returnList;
    }

    /**
     * Send everyone with a fine on an article higher than €10,- a warning letter.
     * If the total of all the fines of a member is higher than €100,- a second letter is sent.
     * If there isn't a return of the books within two weeks, a bailiff is sent. 
     */
    public void sendWarningLetters() {
    	
    	for(Member member : members){
    	
    		for (Bill bill : member.getBills()) {
    			if (bill.getType() == TypeCost.fine) {
    				 if(bill.getAmount() >= 10.00 && !bill.hasWarning1()) {
    					 bill.giveWarning();
    					 System.out.println("**Official Stenden Library Warning**");
    					 System.out.println("You '" + member.getName() + "' hereby recieve your first warning.");
    					 System.out.println("This means you have a bill of â‚¬10,- or more, please pay your bill on time.");
    					 System.out.println("-Stenden Library");
    				 }
    				 if(bill.getAmount() >= 100.00 && bill.hasWarning1() && bill.getWarning2() == null ) {
    					 bill.giveWarning();
    					 System.out.println("**Official Stenden Library Warning**");
    					 System.out.println("You '" + member.getName() + "' hereby recieve your second warning.");
    					 System.out.println("This means you have a bill of â‚¬100,- or more, please pay your bill on time.");
    					 System.out.println("Secondly, you now have 2 weeks to pay your bill, otherwise it will be sent to the bailiff.");
    					 System.out.println("-Stenden Library"); 
    				 }
    				 //amount of days >= 14:
    				 if(bill.getAmount() >= 100.00 && Days.daysBetween(bill.getWarning2(), new DateTime()).getDays() >= 14 ) {
    					 sendMemberToBailiff(member);	 
    				 }
    			}
    		}
    	}
    }

    public void sendMemberToBailiff(Member member) {
    	System.out.println("The following member informations is send to the bailiff:");
    	System.out.println("\tName:\t" + member.getName());
    	
    	double total = 0;
    	
    	for (Bill bill : member.getBills()) {
    		if (bill.getType() == TypeCost.fine) {
    			total += bill.getAmount();
    		}
    	}
    	
    	System.out.println("\tFine amount:\t" + total);
    }

    public double getTotalIncome() {
    	double total = 0;
    	System.out.println("Started iteration:");
    	for (Member member : members) {
    		for (Bill bill : member.getBills()) {
    			if(bill.isPaid()){
    				total += bill.getAmount();
    				//System.out.println(total);
    			}
    		}
    	}
    	
    	return total;
    }

    public static void main(String[] args) {
        System.out.println("Library started");
             
    }
    
    public boolean removeMember(Member member) {
    	return members.remove(member);
    }

    /**
     * Add een title toe aan Titles.
     * @param T
     */
    public void addTitle(Title t){
    	titles.add(t);
    }
    
    /**
     * Add een title toe aan Titles.
     * @param T
     */
    public void addMember(Member m){
    	members.add(m);
    }
}
