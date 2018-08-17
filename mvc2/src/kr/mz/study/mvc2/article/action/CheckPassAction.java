package kr.mz.study.mvc2.article.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mz.study.mvc2.action.Action;
import kr.mz.study.mvc2.article.dao.ArticleDAO;

public class CheckPassAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArticleDAO dao = new ArticleDAO();
		
		int result = 0;
		String idx = request.getParameter("idx");
		String article_pw = request.getParameter("re-password");
		
		if(idx != null && article_pw != null) {
			
			String originPassword = dao.checkPassword(Integer.parseInt(idx));
			
			if(!article_pw.equals(originPassword)) {
				result = -1;
			} else {
				result = 1;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
