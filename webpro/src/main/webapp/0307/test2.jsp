<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
h1 {
	color: red;
}
table {
	border: 2px solid blue;
	border-collapse: collapse;
}

td {
	width: 300px;
	height: 50px;
	text-align: center;
}
th {
	width: 300px;
	background: skyblue;
}
</style>
</head>
<body>

<h1>JSP : Java Server Page</h1>

<%
  //java언어를 이용하여 프로그램 로직을 구현할 수 있다
  String userName= request.getParameter("name");
  String userPass= request.getParameter("pass");
  String userGend= request.getParameter("gender");
  String userAge= request.getParameter("age");
  
  //DB연결 CRUD 처리 - 결과값을 얻어서
  //결과값으로 응답페이지를 생성한다
  
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
  	<th>성별</th>
  	<td><%= userGend %></td>
  </tr>

  <tr>
  	<th>나이</th>
  	<td><%= userAge %></td>
  </tr>
</table>

</body>
</html>