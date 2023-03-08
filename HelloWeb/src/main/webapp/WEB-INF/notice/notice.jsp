<%@page import="co.dev.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/sidebar.jsp"%>
<%@ include file="../includes/top.jsp"%>
<%
	NoticeVO vo = (NoticeVO)request.getAttribute("notice");
    String mw = (String)session.getAttribute("id");  
%>

	<table class="table">
		
		<tr>
			<td>글번호</td><td><input type="text" name="nid" readonly value="<%=vo.getNoticeId()%>"></td>
			
		</tr>
		
		<tr>
			<td>제목</td><td><input type="text" name="title" readonly value="<%=vo.getNoticeTitle()%>"></td>
			<td>조회수 <%=vo.getHitCount() %></td>
		</tr>
		
		<tr>
			<td>작성자</td><td><input type="text" name="writer" value="<%=vo.getNoticeWriter()%>"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea cols= "30" rows="5" name="subject"><%=vo.getNoticeSubject() %></textarea></td>
		</tr>
		<tr>
			<td>파일</td><td>
			<%if(vo.getAttach() !=null){%>
			<input type="text" name="attach" value="<%=vo.getAttach()%>">
				
			<%} else{ %>
			<input type="text" name="attach">
			<% }%> 
			</td>
		</tr>
		
			
			
			<%if(mw.equals(vo.getNoticeId())){ %>
			
			<td colspan="2" align="center">
				<button id="modBtn">수정</button>
				<button id="delBtn">삭제</button>
			</td>
			</tr>
			<%} else{}%>
			
			
			
			
					
	</table>
	<form id="myFrm" action="noticeModify.do">


	</form>
	<script>
		document.querySelector('#modBtn').addEventListener('click',function(){
			let myFrm = document.querySelector('#myFrm');
			// let nid = document.querySelector('input[name="nid"]').value;
			// let title = document.querySelector('input[name="title"]').value;
			// let subject = document.querySelector('textarea[name="subject"]').textContent;
			
			myFrm.append(document.querySelector('input[name="nid"]'));
			myFrm.append(document.querySelector('input[name="title"]')); 
			myFrm.append(document.querySelector('textarea[name="subject"]'));
			myFrm.submit();
		
		});
		//삭제.
		document.querySelector('#delBtn').addEventListener('click',function(){
			let myFrm = document.querySelector('#myFrm');
			myFrm.action = 'noticeRemove.do';  // myFrm.setAttribute('action','noticeRemove.do')
			// FrontController에 NoticeRemoveControl();
			// 서비스 : noticeRemove(int nid), mapper: deleteNotice(int nid); 
			myFrm.append(document.querySelector('input[name="nid"]'));
			myFrm.submit();
		})

	</script>




<%@ include file="../includes/footer.jsp"%>