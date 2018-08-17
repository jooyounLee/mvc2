package kr.mz.study.mvc2.article.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mz.study.mvc2.action.Action;
import kr.mz.study.mvc2.article.dao.ArticleDAO;

public class ArticleWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArticleDAO article = new ArticleDAO();
		
		String article_pw = request.getParameter("article_pw");
		String title = request.getParameter("title");
		String user_nm = request.getParameter("user_nm");
		String content = request.getParameter("content");
		
		
		int result = article.createArticle(article_pw, title, user_nm, content);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
