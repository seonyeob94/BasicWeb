<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
h1{
	color: red;
}

</style>
</head>
<body>

<h1>JSP: Java Server Page</h1>

<%
  String userName= request.getParameter("name");
  String userPass= request.getParameter("pass");
  String info= request.getParameter("area");
  
  info= info.replaceAll("\n", "<br>");


%>
<table border="1">
  <tr>
  	<th>이름</th>
  	<td><%= userName %></td>
  </tr>
  
  <tr>
  	<th>비밀번호</th>
  	<td><%= userPass %></td>
  </tr>
  
  <tr>
  	<th>자기소개</th>
  	<td><%= info %></td>
  </tr>
</table> 

</body>
</html>