<%@page import="kh.my.board.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%
	// 이곳은 자바 문법에 따름
	ArrayList<Board> volist = (ArrayList<Board>)request.getAttribute("boardvolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	String writer = (String)request.getSession().getAttribute("memberLoginInfo");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<h1>게시판</h1>
	<p><%=writer %> 님 환영합니다!</p>
	<table border = "1">
		<tr>
			<td>💡 글번호 💡</td>
			<td>✏ 글제목 ✏</td>
			<td>🖋 작성자 🖋</td>
			<td>📆 작성일 📆</td>
		</tr>
		<tr>
<%
		if(volist != null) {
		for(Board vo:volist){ 
%>
		</tr>
		<tr>
			<td><a href="boardcontent?no=<%=vo.getBno()%>"> <%=vo.getBno()%> </a></td>
			<td>
			<%
				// 답글 몇단에 따라서 Re: 붙여주기
				for(int i = 0; i<vo.getBreLevel(); i++){
			%>
					Re:
			<%
				}
			%>
			<%=vo.getTitle()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getCreateDate()%></td>
		</tr>
		
		<%
			} 		
		}
		%>
	</table>


	<%
		if (startPage > 1){
	%>
		👈🏻이전  
	<%
		}
		for (int i = startPage; i <= endPage; i++) {
	%>
	<a href="boardlist?pagenum=<%=i%>"> <%=i%>  </a>
	<%
		if (i != endPage) {
	%>
	,
	<%
		}
	}
	if (endPage < pageCount) {
	%>
		 다음👉🏻
	<%
	}
	%>
<br>
<a href = "boardwrite">✍🏻새글쓰기✍🏻</a>
</body>
</html>