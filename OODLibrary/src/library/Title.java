package library;

import java.util.ArrayList;

public class Title<T extends Article> {
	
	private String name;			// The name of the title
	private ArrayList<T> articles;	// The list of articles for this specific title
	
	public Title(String name) {
		this.name = name;
		articles = new ArrayList<T>();
	}
	
	/**
	 * Add a article to the title
	 * @param article
	 */
	public void addArticle(T article) {		
		articles.add(article);
	}
	
	/**
	 * Get all articles for this title
	 * @return ArrayList<T>
	 */
	public ArrayList<T> getArticles() {
		return this.articles;
	}
	
	/**
	 * Loan a article from the article list. (ie. start loanperiod and set borrower and return the article)
	 * Return null if there are no available articles for loan
	 * @param member
	 * @return T
	 */
	public T loan(Member member) {
		if (articles.size() > 0) {
			for (T article : articles) {
				if (article.getBorrower() == null) {
					article.startLoanPeriod();
					article.setBorrower(member);
					return article;
				}
			}
		}
		
		return null;
	}
}
