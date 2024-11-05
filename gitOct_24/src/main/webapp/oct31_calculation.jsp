<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>연산의 결과는 다음과 같습니다.</h2>
<%
	String result = request.getParameter("RESULT");
%>
<h3>연산의 결과 :  <%= result %></h3>
</body>
</html>