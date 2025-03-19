<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
h1{
	/* border: 2px solid blue;
	background: green;
	text-align: center;
	margin: 20px auto;
	padding: 5px;
	width: 40%; */
	
	color: orange;
	text-align: center;
	margin: 20px auto;
	padding: 5px;
	width: 40%;
}
table {
	border: 2px solid blue;
	border-collapse: collapse;
	margin: auto;
}
th {
	width: 300px;
	background: lightpink;
}
td {
	width: 500px;
	height: 60px;
	text-align: center;
	font-style: italic;
	font-size: 1.5em;
	font
}


</style>
</head>
<body>

<h1>자동차</h1>

<%
 String usercar1= request.getParameter("cars1");
 String usercar2[]= request.getParameterValues("cars2");
 
 String str="";
 
 for(int i=0;i<usercar2.length;i++){
	  str+=usercar2[i]+"<br>";
 }

%>

<table border="1">

  <tr>
    <th>자동차1</th>
    <td><%= usercar1 %></td>
  </tr>
  
  <tr>
    <th>자동차2</th>
    <td><%= str %></td>
  </tr>
  

</table>

</body>
</html>