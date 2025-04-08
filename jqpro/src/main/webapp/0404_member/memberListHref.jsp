<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.mybatis.config.MybatisUtil"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>



</head>
<body>
<%
//서버영역(controller- 서블릿)

//직렬화된 데이터를 스크립트에서 가져온다

//자바 객체로 역직렬화 한다 fromJSON()

//db연결하고 crud 처리하고 결과를 얻는다

	SqlSession sql = MybatisUtil.getInstance();

//memberVo vo = member테이블에서 mem_id=a001인 데이터의 정보를 가져온다
//이름, 전화번호, 이메일, 주소...
List<MemberVo> list = sql.selectList("member.memberList");

sql.close();
%>

<table border='1' class='table table-striped'>
	<tr>
		<td>아이디</td>
		<td>이름</td> <td>주소</td>
		<td>전화번호</td><td>이메일</td>
	</tr>
	
	<%
		for(int i=0;i<list.size();i++){
			MemberVo vo = list.get(i);
	%>		
			<tr><td><%= vo.getMem_id() %></td>
			<td><%= vo.getMem_name() %></td> <td><%= vo.getMem_add1() %></td>
			<td><%= vo.getMem_hp() %></td><td><%= vo.getMem_mail() %></td></tr>
	
	<%		
		}
    %>
</table>

</body>
</html>