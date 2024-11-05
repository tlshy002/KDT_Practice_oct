<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>조회결과</h2>
<%
	String name = request.getParameter("NAME");
%>
<h3>조회된 사원의 이름은 <%= name %></h3>
</body>
</html>