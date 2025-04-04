<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

//서버영역

//직렬화된 데이터를 스크립트에서 가져온다

//자바 객체로 역직렬화 한다 fromJSON()

//db연결하고 crud 처리하고 결과를 얻는다

//List<memberVo> list = member테이블에서 모든 사람의 데이터의 정보를 가져온다
//24명의 이름, 전화번호, 이메일, 주소...

//list 자바객체를 직렬화해서 요청한 클라이언트 영역으로 다시 보낸다 -toJSON()

//텍스트 기반의 json데이터 - 객체 배열

%>

[
	
	{

		"mem_id"   : "a001",
		"mem_name" : "김은대",
		"mem_hp"   : "010-1234-5678",
		"mem_mail" : "kk1234@naver.com"

	}
	,
	
	{

		"mem_id"   : "a001",
		"mem_name" : "이이",
		"mem_hp"   : "010-3455-3456",
		"mem_mail" : "jd4334@naver.com"

	}
	,
	
	{

		"mem_id"   : "a002",
		"mem_name" : "박구황",
		"mem_hp"   : "010-6349-8467",
		"mem_mail" : "sf8444@naver.com"

	}
	,
	
	{

		"mem_id"   : "a003",
		"mem_name" : "손금대",
		"mem_hp"   : "010-8763-1344",
		"mem_mail" : "ac3432@naver.com"

	}
	,
	
	{

		"mem_id"   : "a004",
		"mem_name" : "우동백",
		"mem_hp"   : "010-3966-4536",
		"mem_mail" : "df2634@naver.com"

	}
	,
	
	{

		"mem_id"   : "a005",
		"mem_name" : "최은",
		"mem_hp"   : "010-7423-0423",
		"mem_mail" : "kd1234@naver.com"

	}
	


]




