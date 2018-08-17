package kr.mz.study.mvc2.article.action;

import kr.mz.study.mvc2.action.Action;

public class ArticleActionFactory {
	
	public Action getAction(String command) {
		Action action = null;
		
		switch(command) {
			case "articleList" : 
				action = new ArticleListAction();
				break;
				
			case "articleWrite" : 
				action = new ArticleWriteAction();
				break;
				
			case "articleUpdate" : 
				action = new ArticleUpdateAction();
				break;
				
			case "articleDelete" : 
				action = new ArticleDeleteAction();
				break;
				
			case "articleRead" : 
				action = new ArticleReadAction();
				break;
			
			case "checkPass" :
				action = new CheckPassAction();
				break;
				
			case "articleUpdateForm" : 
				action = new ArticleUpdateFormAction();
				break;
		}
		
		return action;
	}
}
