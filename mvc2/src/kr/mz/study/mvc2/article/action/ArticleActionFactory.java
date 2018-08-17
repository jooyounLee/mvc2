package kr.mz.study.mvc2.article.action;

import kr.mz.study.mvc2.action.Action;

public class ArticleActionFactory {
	public Action getAction(String command) {
		Action action = null;
		
		switch(command) {
			case "articleList": 
				System.out.println("action factory");
				action = new ArticleListAction();
				break;
			case "articleWrite": 
				action = new ArticleWriteAction();
				break;
			case "articleUpdate": break;
			case "articleDelete": break;
			case "articleRead": 
				action = new ArticleReadAction();
				break;
		}
		
		return action;
	}
}
