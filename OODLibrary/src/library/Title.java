package library;

import java.util.ArrayList;

public class Title {
	private String name;
	private Class type;
	private ArrayList<Article> articles;
	
	public Title(String name, Class type) {
		this.name = name;
		this.type = type;
		articles = new ArrayList<Article>();
	}
	
	public void addArticle(Article article) {
		if (article.getClass() != type) {
			throw new IllegalArgumentException("Article is not of correct type");
		}
		
		articles.add(article);
	}
	
	public ArrayList<Article> getArticles() {
		return this.articles;
	}
	
	public Article loan(Member member) {
		if (articles.size() > 0) {
			for (Article article : articles) {
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
