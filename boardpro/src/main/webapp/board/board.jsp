<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="com.google.gson.Gson"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  
  <script src="../js/jquery-3.7.1.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

  <script src="../js/board.js"></script>
  <script src="../js/jquery.serializejson.min.js"></script>

<style>
html, body {padding:-10; margin:-10; height:100%; width: 100%;   }

body *{
  box-sizing:   border-box;
}

body{
  min-width : 1000px;
}
/* #result{
  width : 100%;
  padding : 1px;
} */
.container{
   margin : 5px;
   max-width : 99%;
}
.p12{
  display: flex;
  flex-direction:  row;
}
p{
   border  : 1px dotted lightgray;
   padding : 5px;
   margin  :2px;
}
.p1{
   flex:  70%;
   word-break:keep-all; /* 줄바꿈: 단어단위로  */
}
.p2{
   flex : 30%;
   text-align:  right;
}

.card-body{
   display:  flex;
   flex-direction:  column;
}
input[name=reply]{
   height : 55px;
   vertical-align: top;
}
textarea {
	width : 70%;
}

nav {
  margin: 2%;
}

nav a{
 visibility: hidden;
}
#pagelist{
   margin-left : 10%;
}

.card-header:hover{
  background : #0078FF;
}

.reply-body{
  border : 1px dotted orange;
  background : #efdada;
  margin : 2px;
  padding : 2px;
}

.modal label{
  width : 100px;
  height : 30px;
}

span.pa{
 display : none;/* listPageServer에서 password  를 안보이도록*/
}

#modifyform{
  display: none;
}
#btnok, #btnreset{
  height : 40px;
  vertical-align: bottom;
}


</style>



<script>
//JSP 실행 순서가  Java => JSTL => HTML => javascript
 
<%
//session 값 얻기 - 가장 먼저 실행
MemberVo vo = (MemberVo)session.getAttribute("loginok");

//vo 자바객체를 json형태의 데이터로 직렬화
String ss = null;

Gson gson = new Gson();
if(vo != null) ss = gson.toJson(vo);

/*
ss = {
	"mem_id" : "a001",
	"mem_pass" : "asdfasdf",
	"mem_name" : "김은대"
} 
*/


%>


uvo = <%= ss %>
console.log(uvo);


currentPage = 1;
mypath =  '<%= request.getContextPath()%>';


$(function(){
	
	boardListServer();
	
	//다음버튼 이벤트
	$(document).on('click','#next', function(){
		currentPage = parseInt($('.pno').last().text())+1;
		boardListServer();
	})
	
	//이전버튼 이벤트
	$(document).on('click','#prev', function(){
		currentPage = parseInt($('.pno').first().text())-1;
		boardListServer();
	})
	
	//페이지 번호 클릭 이벤트
	$(document).on('click','.pno', function(){
		currentPage = parseInt($(this).text());
		boardListServer();
	})
	
	//검색 버튼 이벤트
	$('#search').on('click',function(){
		currentPage=1;
		boardListServer();
	})
	
	//stype이 전체일 때  sword의 값을 지운다
	$('#stype').on('change', function(){
		
		type = $('option:selected', this).val();
		
		if(type == "") $('#sword').val("")
		currentPage=1;
		boardListServer();
	})
	
	//글쓰기 이벤트
	$('#write').on('click', function(){
		//로그인 했는지 안했는지 비교 - session값이 필요
		
		if(uvo == null){
			alert("로그인 하세요");
		}else{
			//모달창 띄우기
			$('#wModal').modal('show');
			
			//모달창의 이름에 로그인 한 사람의 이름을 출력
			$('#wModal #writer').val(uvo.mem_name);
			$('#wModal #writer').prop('readonly', true);
		}
	})
	
	//글쓰기 모달창에서 전송버튼 클릭 이벤트
	$('#send').on('click', function(){
		
		//입력한 모든 데이터를 모으기
		formData = $('#wform').serializeJSON();
		
		//서버로 보내기
		boardWriter();
		
		//모달창 내용지우기
		
		$('#wform .txt').val("");
		
		
		//모달창 닫기
		$('#wModal').modal('hide');
		
	})
	
	
	//수정, 삭제 댓글 등록, 댓글 삭제, 댓글 수정, 댓글리스트(제목클릭, 등록버튼클릭) -이벤트 핸들러 설정
	$(document).on('click','.action', function(){
		
		
		target = $(this); // target 변수는 board.js에서 이벤트 발생요소를 참조하는 변수
		
		vname = $(this).attr('name');
		vidx = $(this).data('idx');
		
		if(vname == "delete"){
			
			alert(vidx + "번 글 삭제");
			
		}else if(vname == "modify"){
			
			alert(vidx + "번 글 수정");
			
			
		}else if(vname == "reply"){
			alert(vidx + "번 글에 댓글 달기");
			
			
			//입력한 댓글 내용 가져오기
			cont = $(this).prev().val();
			
			//renum, bonum, cont, name
			//빈객체를 생성 - 동적으로 속성을 추가하고 값을 대입
			reply = {};
			reply.bonum = vidx;
			reply.cont = cont;
			reply.name = uvo.mem_name;
			
			//서버로 전송하기 - 저장하기

			replyInsertServer();
			
			
		}else if(vname == "replist"){
			
			//댓글리스트 가져오기
			replyListServer();
		}else if(vname == "r_modify"){
			alert(vidx + "번 댓글 수정");
		}else if(vname == "r_delete"){
			alert(vidx + "번 댓글 삭제");
			
			//서버전송
			replyDeleteServer();
			
		}
		
		
	})
	
	
	
	
	
})
</script>

</head>
<body>

 <div id="modifyform">
<textarea rows="5" cols="50"></textarea>
<input type="button" value="확인" id="btnok">
<input type="button" value="취소" id="btnreset">
</div>
 
  <br>
  <!--  <input type="button" data-bs-toggle="modal" data-bs-target="#wModal"  id="write" value="글쓰기">  -->
<!--  <input type="button" id="write" value="글쓰기"> -->
  <BR>
  <br>
   <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
  <div class="container-fluid">
  <input type="button" id="write" value="글쓰기">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <form class="d-flex">
      
      <select class="form-select" id="stype">
		  <option value="">전체</option>
		  <option value="writer">작성자</option>
		  <option value="subject">제목</option>
		  <option value="content">내용</option>
	  </select>
      
        <input class="form-control me-2" type="text" id="sword" placeholder="Search">
        <button id="search" class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>
   
   

   <!-- 리스트 3개씩을 출력 -->
   <div id="result"></div>
   
   <br>
   <br>
   
   <!-- 페이지정보를 출력  -->
   <div id="pagelist"></div>
   
   
<!------- 글쓰기   The Modal  ------- -->
<div class="modal" id="wModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">게시글 작성하기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       
       <form name="wfrom" id="wform">
            <label>이름</label>
            <input type="text" class="txt" id="writer" name="writer"> <br> 
            
            <label>제목</label>
            <input type="text" class="txt" id="subject" name="subject"> <br> 
            
            <label>메일</label>
            <input type="text"  class="txt" id="mail" name="mail"> <br> 
            
            <label>비밀번호</label>
            <input type="password"  class="txt" id="password"   name="password"> <br> 
            
            <label>내용</label>
            <br>
            <textarea rows="5" cols="40"  class="txt" id="content"  name="content"></textarea>
            <br>
            <br>
            <input type="button" value="전송" id="send">
        </form>
       
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
   
  
  
<!----- 글 수정  The Modal    ----->
<div class="modal" id="uModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">게시글 수정하기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       
       <form name="ufrom" id="uform">
       
            <input type="hidden" id="unum" name="num">
            <label>이름</label>
            <input type="text" class="txt" id="uwriter" name="writer"> <br> 
            
            <label>제목</label>
            <input type="text" class="txt" id="usubject" name="subject"> <br> 
            
            <label>메일</label>
            <input type="text"  class="txt" id="umail" name="mail"> <br> 
            
            <label>비밀번호</label>
            <input type="password"  class="txt" id="upassword"   name="password"> <br> 
            
            <label>내용</label>
            <br>
            <textarea rows="5" cols="40"  class="txt" id="ucontent"  name="content"></textarea>
            <br>
            <br>
            <input type="button" value="전송" id="usend">
        </form>
       
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
  
   
</body>
</html>











