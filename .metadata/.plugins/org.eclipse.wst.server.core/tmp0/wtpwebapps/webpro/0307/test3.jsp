<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 2px solid blue;
	border-spacing: 20px;
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

<%
  //전송데이터 받기
  String userId = request.getParameter("id");
  String foods[] = request.getParameterValues("food");
  String file = request.getParameter("file");
  
  String str="";
  
  for(int i=0;i<foods.length;i++){
	  str+=foods[i]+"<br>";
  }

%>
 <table border="1">
 
   <tr>
     <th>아이디</th>
     <td><%= userId %></td>
   </tr>
 
   <tr>
     <th>좋아하는 음식</th>
     <td><%= str %></td>
   </tr>
 
   <tr>
     <th>첨부파일</th>
     <td><%= file %></td>
   </tr>
 
 </table>


</body>
</html>