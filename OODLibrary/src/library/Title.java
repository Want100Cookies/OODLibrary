package library;

import java.util.ArrayList;

public class Title<T extends Article> {
	
	private String name;
	private ArrayList<T> articles;
	
	public Title(String name) {
		this.name = name;
		articles = new ArrayList<T>();
	}
	
	public void addArticle(T article) {		
		articles.add(article);
	}
	
	public ArrayList<T> getArticles() {
		return this.articles;
	}
	
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
	
	/**
	 * extra method buiten class diagram om:
	 */
	public String getTitle(){
	   return name;
	}
}
