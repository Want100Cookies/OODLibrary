/**
 * 
 */
package library;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void test() {
		Library lib = new Library();
		
        Title title1 = new Title("Harry Potter en de vuurbeker");
        title1.addArticle(new Roman(title1, "11"));
        title1.addArticle(new Roman(title1, "23"));
        title1.addArticle(new Roman(title1, "30"));
        lib.addTitle(title1);
        /////////////
        Title title2 = new Title("30 messteken");
        title2.addArticle(new Roman(title2, "2"));
        t.addArticle(new Roman(title2, "52"));
        lib.addTitle(title2);
        /////////////
        Title title3 = new Title("Schemer");
        title3.addArticle(new A_Film(title3, "0"));
        title3.addArticle(new A_Film(title3, "4"));
        title3.addArticle(new A_Film(title3, "3"));
        lib.addTitle(title3);
        ////////////
        Title title4 = new Title("Bad");
        title4.addArticle(new Popular(title4, "990"));
        title4.addArticle(new Popular(title4, "993"));
        title4.addArticle(new Popular(title4, "991"));
        lib.addTitle(title4);
        ////////////
	    Member jenno = new Member("Jenno", "Vink", "Thuis", "jenno@vinkict.nl", new Date(1996, 9, 14));
	    lib.addMember(jenno);
	    Member lesley = new Member("Lesley Jordan", "van Oostenrijk", "In tha hood", "lessy@panamapapers.com", new Date(1992, 9, 14));
	    lib.addMember(lesley);
	    Member pascal = new Member("Pascal", "Drewes", "Coevorden", "pascal@dreweswebdesignitis.com", new Date(1997, 6, 3));
	    lib.addMember(pascal);
	    Member rik = new Member("Rik", "Hassing", "1 uur fietsen", "rik@hassing.com", new Date(1985, 9, 14));
	    lib.addMember(rik);
	       
	    Member ramon = new Member("Ramon", "Valk", "bij kevin(?)", "ramon@valkenier.com", new Date(1960, 3, 14));
	    lib.addMember(ramon);
	    
	    System.out.println("Persoon " + ramon.getName() + " heeft het volgende boek ("
	    		+ "geprobeerd te lenen" + lib.loan(ramon, title2).toString());
	    

	}

}
