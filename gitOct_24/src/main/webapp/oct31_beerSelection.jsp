<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>추천된 맥주는 다음과 같습니다.</h2>
	<%
		// 파라미터이름이 BEER에 들어있는 맥주이름을 서블릿에서 가져옴
		String name = request.getParameter("BEER");
	 %>
	 <h3>추천된 맥주 이름: <%= name %></h3> 
</body>
</html>