<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>������ ����� ������ �����ϴ�.</h2>
<%
	String result = request.getParameter("RESULT");
%>
<h3>������ ��� :  <%= result %></h3>
</body>
</html>