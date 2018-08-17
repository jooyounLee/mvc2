

$(() => {

	var el = {
			idx : $("input[name='idx']"),
			user_nm : $("input[name='user_nm']"),
			article_pw : $("input[name='article_pw']"),
			re_password : $("input[name='re-password']"),
			title : $("input[name='title']"),
			content : $("textarea[name='content']"),
			isNew : $("input[name='isNew']"),
			modify_btn : $("input[name=btn-modify]"),
			delete_btn : $("input[name=btn-delete]"),
			cancel_btn : $("input[name=btn-cancel]"),
			submit_btn : $("input[name='btn-submit']"),
			url : "/mvc2/ArticleServlet?command="
	},
	
	btnEvent = () => {
		// 확인버튼 클릭 : 쓰기, 수정
		el.submit_btn.on('click', save);
		
		// 수정버튼 클릭
		el.modify_btn.on('click', checkPass);
		
		// 삭제버튼 클릭
		el.delete_btn.on('click', doDelete);
		
		// 취소버튼 클릭 : 리스트로 이동
		el.cancel_btn.on('click', () => {
			location.href= "/mvc2/ArticleServlet?command=articleList";
		});
	},
	
	save = () => {
			var command = (el.isNew.val() === "true") ? "articleWrite" : "articleUpdate";
			var msg = (el.isNew.val() === "true") ? "작성" : "수정";
				url = el.url + command;
			
			if (el.user_nm.val().trim().length < 1) {
				alert("이름을 입력해주세요.");
				el.user_nm.focus();
				return;
			} else if (el.article_pw.val().trim().length < 1) {
				alert("비밀번호를 입력해주세요.");
				el.article_pw.focus();
				return;
			} else if (el.title.val().trim().length < 1){
				alert("제목을 입력해주세요.");
				el.title.focus();
				return;
			} else if (el.content.val().trim().length < 1){
				alert("내용을 입력해주세요.");
				el.content.focus();
				return;
			}
			
			var data = {
					'idx' : el.idx.val(),
					'user_nm' : el.user_nm.val(),
					'article_pw' : el.article_pw.val(),
					'title' : el.title.val(),
					'content' : el.content.val()
			}
			
			$.ajax({
		        type : 'POST',
		        url : url,
		        data : data,
		        success : (result) => {
		            if(result.trim() === "1"){
		            	alert(msg + " 성공");
		            	location.href = el.url + "articleList";
		            } else {
		            	alert(msg + " 실패");
		            	location.href = el.url + "articleList";
		            }      
		        }
		    });
	},
	
	checkPass = () => {
		if (el.re_password.val().trim().length < 1) {
			alert("비밀번호를 입력해주세요.");
			el.re_password.focus();
			return;
		}
		
		var data = {
				'idx' : el.idx.val(),
				're-password' : el.re_password.val()
		}
		
		url = el.url + "checkPass";
		
		$.ajax({
	        type : 'POST',
	        url : url,
	        data : data,
	        success : (result) => {
	            if(result.trim() === "-1") {
	            	alert("비밀번호를 확인해주세요.");
	            	el.re_password.val("");
	            	el.re_password.focus();
	            } else {
	            	location.href = el.url + "articleUpdateForm&idx=" + el.idx.val();
	            }
	        }
	    });
	},
	
	doDelete = () => {
		if (el.re_password.val().trim().length < 1) {
			alert("비밀번호를 입력해주세요.");
			el.re_password.focus();
			return;
		}
		
		url = el.url + "articleDelete";
		
		var data = {
				'idx' : el.idx.val(),
				're-password' : el.re_password.val()
		}
			
		$.ajax({
	        type : 'POST',
	        url : url,
	        data : data,
	        success : (result) => {
	            if(result.trim() === "-1") {
	            	alert("비밀번호를 확인해주세요.");
	            	el.re_password.val("");
	            	el.re_password.focus();
	            } else if (result.trim() === "0") {
	            	alert("삭제 실패");
	            	location.href = el.url + "articleList";
	            } else {
	            	alert("삭제 성공");
	            	location.href = el.url + "articleList";
	            }
	        }
	    });
	}
	
	btnEvent();
});
