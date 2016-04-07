package library;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
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

    public ArrayList<Bill> getFines() {
        return null;
    }

    public void sendWarningLetters(ArrayList<Bill> bills) {

    }

    public void sendMemberToBailiff(Member member) {

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
        t = new Title("Het mooiste wat er is");
        t.addArticle(new B_Film(t, "24"));
        titles.add(t);
        ////////////
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
}
