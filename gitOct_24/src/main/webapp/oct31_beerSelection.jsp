<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>��õ�� ���ִ� ������ �����ϴ�.</h2>
	<%
		// �Ķ�����̸��� BEER�� ����ִ� �����̸��� �������� ������
		String name = request.getParameter("BEER");
	 %>
	 <h3>��õ�� ���� �̸�: <%= name %></h3> 
</body>
</html>