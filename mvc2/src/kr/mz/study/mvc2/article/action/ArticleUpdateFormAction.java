package kr.mz.study.mvc2.article.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mz.study.mvc2.action.Action;
import kr.mz.study.mvc2.article.dao.ArticleDAO;
import kr.mz.study.mvc2.article.model.Article;

public class ArticleUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArticleDAO dao = new ArticleDAO();
		String url = "/form.jsp";
		int idx = Integer.parseInt(request.getParameter("idx"));

		Article result = dao.getArticleDetail(idx);
		
		String content = result.getContent();
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\r\n", "<br/>");
		
		request.setAttribute("result", result);
		request.setAttribute("content", content);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
