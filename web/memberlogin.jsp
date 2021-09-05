<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% int result = (Integer)request.getAttribute("result"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
		<h1>로그인</h1>
	    <form method="post" action="login">
	    	아이디 : <input type ="text" name ="id" required = "required"><br>
           	비밀번호 : <input type = "password" name = "pw" required><br>
            <input type = "submit" value = "등록">
    </form>
</body>
</html>
