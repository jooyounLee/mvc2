package kr.mz.study.mvc2.article.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mz.study.mvc2.action.Action;

public class ArticleReadAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(request.getParameter("command"));
		System.out.println(request.getParameter("idx"));
		
		
		
	}
}
