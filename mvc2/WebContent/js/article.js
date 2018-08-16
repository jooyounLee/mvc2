

$(() => {

	var el = {
			form : $("#form"),
			form_read : $("#form-read"),
			idx : $("input[name='idx']"),
			user_nm : $("input[name='user_nm']"),
			article_pw : $("input[name='article_pw']"),
			re_password : $("input[name='re-password']"),
			title : $("input[name='title']"),
			content : $("textarea[name='content']"),
			isNew : $("input[name='isNew']"),
			read_btn : $("button[name=btn-read]"),
			modify_btn : $("input[name=btn-modify]"),
			delete_btn : $("input[name=btn-delete]"),
			cancel_btn : $("input[name=btn-cancel]"),
			submit_btn : $("input[name='btn-submit']")
	},
	
	btnEvent = () => {
		// 확인버튼 클릭 : 쓰기, 수정
		el.submit_btn.on('click', save);
		
		// 수정버튼 클릭
		el.modify_btn.on('click', ()=>{
			if (el.re_password.val().trim().length < 1) {
				alert("비밀번호를 입력해주세요.");
				el.re_password.focus();
				return;
			}
			var url = "/CheckPassAction.do";
			el.form_read.attr("action", url).submit();
		});
		
		// 삭제버튼 클릭
		el.delete_btn.on('click', ()=>{
			if (el.re_password.val().trim().length < 1) {
				alert("비밀번호를 입력해주세요.");
				el.re_password.focus();
				return;
			}
			var url = "/CheckPassAction.do";
			el.form_read.attr("action", url).submit();
		});
		
		
		// 취소버튼 클릭 : 리스트로 이동
		el.cancel_btn.on('click', () => {
			location.href= "/mvc2/index.jsp";
		});
	},
	
	save = () => {
			var url = "/mvc2/ArticleServlet?command=";
			var command = (el.isNew.val() === "true") ? "articleWrite" : "articleUpdate"
			
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
					user_nm : el.user_nm.val(),
					article_pw : el.article_pw.val(),
					title : el.title.val(),
					content : el.content.val()
			}
			
			$.ajax({
		        type : 'POST',
		        url : url + command,
		        data : {
		        	'user_nm' : el.user_nm.val(),
					'article_pw' : el.article_pw.val(),
					'title' : el.title.val(),
					'content' : el.content.val()
		        },
		        success : (result) => {
		            if(result.trim() === "1"){
		            	console.log(1);
		            } else {
		            	console.log(0);
		            }      
		        }
		    });
	}
	
	btnEvent();
});
