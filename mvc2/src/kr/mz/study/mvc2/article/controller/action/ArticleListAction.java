package kr.mz.study.mvc2.article.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mz.study.mvc2.article.dao.ArticleDAO;

public class ArticleListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAO article = new ArticleDAO();
		String url = "/index.jsp";
		
		// 전체 글 수--
		int totalPostCount = article.getListCount();

		// 한 페이지당 글 수--
		int countPostPerPage = 6;
		
		// 한 블럭당 페이지 수--
		//int countPagePerBlock = 3;
		
		// page parameter
		String pageParam = request.getParameter("p");
		int selectPageNum = 1;
		if(pageParam != null) {
			selectPageNum = Integer.parseInt(pageParam);
		}	
		
		// 페이지 첫번째 글
		int firstPost = countPostPerPage * (selectPageNum - 1);
		if(firstPost < 0) {
			firstPost = 0;
		}
		System.out.println("articleListAction : " + article.getArticleList(firstPost, countPostPerPage));
		// 게시물 리스트 get
		request.setAttribute("articleList", article.getArticleList(firstPost, countPostPerPage));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
