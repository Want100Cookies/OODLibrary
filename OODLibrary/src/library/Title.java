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
	
	public Article loan(Member member) {
		return null;
	}
	
	public Bill bringBackArticle(Article article) {
		return null;
	}
}
