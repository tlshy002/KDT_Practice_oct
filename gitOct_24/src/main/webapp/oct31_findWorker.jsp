<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��ȸ���</h2>
<%
	String name = request.getParameter("NAME");
%>
<h3>��ȸ�� ����� �̸��� <%= name %></h3>
</body>
</html>