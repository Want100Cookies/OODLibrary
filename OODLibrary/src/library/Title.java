package library;

import java.util.ArrayList;

public class Title {
	private String name;
	private ArrayList<Article> articles;
	
	public Title(String name) {
		this.name = name;
		articles = new ArrayList<Article>();
	}
	
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	public ArrayList<Article> getArticles() {
		return this.articles;
	}
	
	public Article loan(Member member) {
		if (articles.size() > 0) {
			for (Article article : articles) {
				if (article.getBorrower() == null) {
					article.setBorrower(member);
					return article;
				}
			}
		}
		
		return null;
	}
}
