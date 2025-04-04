<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  // 서버영역
  
  // 직렬화된 데이터를 스크립트에서 가져온다
  
  // 자바 객체로 역직렬화 한다 fromJSON()
  
  // db연결하고 crud 처리하고 결과를 얻는다
  
  //memberVo vo = member테이블에서 mem_id=a001인 데이터의 정보를 가져온다
  //이름, 전화번호, 이메일, 주소...
  
  //memberVo객체를 직렬화해서 요청한 클라이언트 영역으로 다시 보낸다 -toJSON()
  
  //텍스트 기반의 json문자열
    
%>
<%-- 주석 --%>
{

	"mem_id"   : "a001",
	"mem_name" : "김은대",
	"mem_hp"   : "010-1234-5678",
	"mem_mail" : "kk1234@naver.com"

}