package kr.mz.study.mvc2.article.controller;

import kr.mz.study.mvc2.article.controller.action.*;

public class ActionFactory {
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
			case "articleRead": break;
		}
		
		return action;
	}
}
