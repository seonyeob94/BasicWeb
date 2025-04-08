<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="kr.or.ddit.mybatis.config.MybatisUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//json일때는 http파일이 들어가면 안됨

//서버영역(controller- 서블릿)

//직렬화된 데이터를 스크립트에서 가져온다

//자바 객체로 역직렬화 한다 fromJSON()

//db연결하고 crud 처리하고 결과를 얻는다

	SqlSession sql = MybatisUtil.getInstance();

//memberVo vo = member테이블에서 mem_id=a001인 데이터의 정보를 가져온다
//이름, 전화번호, 이메일, 주소...
	List<MemberVo> list = sql.selectList("member.memberList");

     sql.close();
//memberVo객체를 직렬화해서 요청한 클라이언트 영역으로 다시 보낸다 -toJSON()
// 	Gson gson = new Gson();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String result = gson.toJson(list);
//텍스트 기반의 json 형식의 배열데이터
	out.print(result);
	out.flush();
	

%>
