package library;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

import library.Bill.TypeCost;
public class Library {
    private ArrayList<Title> titles;
    private ArrayList<Member> members;

    public Library() {
        titles = new ArrayList<Title>();
        members = new ArrayList<Member>();
        addDummyData();
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

    /**
     * Returnt alle fines die elke member heeft, betaald of onbetaald.
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

    public void sendWarningLetters() {
    	
    for(Member member : members){
    	
    		for (Bill bill : member.getBills()) {
    			if (bill.getType() == TypeCost.fine) {
    				 if(bill.getAmount() >= 10.00 && !bill.hasWarning1()) {
    					 bill.giveWarning();
    					 System.out.println("**Official Stenden Library Warning**");
    					 System.out.println("You '" + member.getName() + "' hereby recieve your first warning.");
    					 System.out.println("This means you have a bill of €10,- or more, please pay your bill on time.");
    					 System.out.println("-Stenden Library");
    				 }
    				 if(bill.getAmount() >= 100.00 && bill.hasWarning1() && bill.getWarning2() == null ) {
    					 bill.giveWarning();
    					 System.out.println("**Official Stenden Library Warning**");
    					 System.out.println("You '" + member.getName() + "' hereby recieve your second warning.");
    					 System.out.println("This means you have a bill of €100,- or more, please pay your bill on time.");
    					 System.out.println("Secondly, you now have 2 weeks to pay your bill, otherwise it will be sent to the bailiff.");
    					 System.out.println("-Stenden Library"); 
    				 }
    				 if(bill.getAmount() >= 100.00 && bill.getWarning2().getTime() + 1209600000 >= System.currentTimeMillis() ) {
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

    public double getTotalIncome(int year) { // Todo: add parameter `Bill.typeCost type`
        Iterator<Member> it = members.iterator();
        double total = 0.00;
        while(it.hasNext()){
            Member m = it.next();
            Iterator<Bill> bills = m.getBills().iterator();
            while(bills.hasNext()){
                Bill bill = bills.next();
                total += bill.getAmount();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Library started");
             
    }

    /**
     * Add dummy data method:
     */
    public void addDummyData(){
        Title t = new Title("Harry Potter en de vuurbeker");
        t.addArticle(new Roman(t, "11"));
        t.addArticle(new Roman(t, "23"));
        t.addArticle(new Roman(t, "30"));
        titles.add(t);
        /////////////
        t = new Title("30 messteken");
        t.addArticle(new Roman(t, "2"));
        t.addArticle(new Roman(t, "52"));
        titles.add(t);
        /////////////
        t = new Title("Schemer");
        t.addArticle(new A_Film(t, "0"));
        titles.add(t);
        titles.add(t);
        titles.add(t);
        ////////////
        t = new Title("Bad");
        t.addArticle(new Popular(t, "990"));
        titles.add(t);
        titles.add(t);
        titles.add(t);
        ////////////
        Member m = new Member("Jenno", "Vink", "Thuis", "jenno@vinkict.nl", new Date(1996, 9, 14));
        members.add(m);
        m = new Member("Lesley Jordan", "van Oostenrijk", "In tha hood", "lessy@panamapapers.com", new Date(1992, 9, 14));
        members.add(m);
        m = new Member("Pascal", "Drewes", "Coevorden", "pascal@dreweswebdesignitis.com", new Date(1997, 6, 3));
        members.add(m);
        m = new Member("Rik", "Hassing", "1 uur fietsen", "rik@hassing.com", new Date(1985, 9, 14));
        members.add(m);
        
        m = new Member("Ramon", "Valk", "bij kevin(?)", "ramon@valkenier.com", new Date(1960, 3, 14));
        members.add(m);
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
