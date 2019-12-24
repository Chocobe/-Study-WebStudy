package sec03.brd02;

public class BoardService2 {
	private BoardDAO2 boardDAO;
	
	
	public BoardService2() {
		boardDAO = new BoardDAO2();
	}
	
	
	public void addArticle(ArticleVO2 article) {
		boardDAO.insertNewArticle(article);
	}
}
