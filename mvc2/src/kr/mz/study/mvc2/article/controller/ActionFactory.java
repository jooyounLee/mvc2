package kr.mz.study.mvc2.article.controller;

import kr.mz.study.mvc2.article.controller.action.Action;
import kr.mz.study.mvc2.article.controller.action.ArticleListAction;

public class ActionFactory {
	public Action getAction(String command) {
		Action action = null;
		
		switch(command) {
			case "articleList": 
				action = new ArticleListAction();
				break;
			case "articleWrite": break;
			case "articleUpdate": break;
			case "articleDelete": break;
			case "articleRead": break;
		}
		
		return action;
	}
}
