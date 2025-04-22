/**
 * 
 */

const hitUpdateServer = () =>{

		$.ajax({
				url : `${mypath}/HitUpdate.do`,
				data : {num : vidx},
				method : 'get',
				dataType : 'json',
				success : function(res){
					
					//alert(res.flag)
					
					//성공하면 화면의 조회수를 증가
					//target변수는 jsp에서 이벤트 대상 this를 대입받은 변수
					
					//화면의 조회수 span요소를 검색
					hit = $(target).parents('.card').find('.hi');
					
					//화면의 조회수의 값을 가져온다
					hitValue = parseInt($(hit).text())+1;
					
					//hitValue의 값으로 조회수 span요소의 값을 변경한다
					$(hit).text(hitValue);
					
				},
				error : function(xhr){
					alert(xhr.status);
				}
				
	})			
}

const replyUpdateServer = () =>{
	$.ajax({
			url : `${mypath}/ReplyUpdate.do`,
			data : JSON.stringify(reply), // {renum : 5, cont : "dfdfd"}
			method : 'post',
			dataType : 'json',
			success : function(res){
				//db수정 성공하면
				//화면의 내용 바꾸기
				//alert(res.flag);
				$(vp3).html(modiout);
				
			},
			error : function(xhr){
				alert(xhr.status);
			}
	})
}

const replyDeleteServer =() =>{
	$.ajax({
			url : `${mypath}/ReplyDelete.do`,
			data : {renum : vidx}, // renum : 6
			method : 'get',
			dataType : 'json',
			success : function(res){
				//db삭제 성공하면
				//화면의 reply-body를 삭제
				
				//alert(res.flag);
				$(target).parents('reply-body').remove();
			},
			error : function(xhr){
				alert(xhr.status);
			}
			
	
	
	})
}

const replyListServer =() =>{
	
	//controller  -service - dao -xml
	// view - json데이터 생성
	$.ajax({
		url : `${mypath}/ReplyList.do`,
		data : {bonum : vidx}, // bonum : 23
		method : 'get',
		dataType : 'json',
		success : function(res){
			console.log(res);
			
			
			code = "";
			
			$.each(res, function(i,v){
				cont = v.cont;
				cont = cont.replaceAll(/\n/g, "<br>");
				
				code += `<div class="reply-body">
					       <div class="p12">
					          <p class="p1">
					                작성자:<span class="wr">${v.name}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                날짜 :<span class="da">${v.redate}</span>         
					          </p>
					          <p class ="p2">`
										               
														   
								 if(uvo != null && uvo.mem_name == v.name)  {
					              code += ` <input type="button" data-idx="${v.renum}" 
								  value="댓글수정" name="r_modify"  class="action">
										              
								  <input type="button" data-idx="${v.renum}" 
								  value="댓글삭제" name="r_delete"  class="action">`
								 }
											               
								 code += `  </p>
					       </div>
					       <p class="p3">
					              ${cont} <br>
					       </p>
					        				            
						 </div>`;
			})//반복문
			
			//target : board.jsp의 이벤트 발생시 this를 대입받아 설정한 전역변수
			$(target).parents('.card').find('.reply-body').remove();
			vcard = $(target).parents('.card').find('.card-body');
			$(vcard).append(code);
			
			
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})

}

const replyInsertServer =() =>{
	
	$.ajax({
		url : `${mypath}/ReplyInsert.do`,
		method : 'post',
		data : JSON.stringify(reply), //reply객체  - name, bonum, cont
		dataType : 'json',
		contentType : 'application/json;charset=utf-8',
		success : function(res){
			//댓글 저장 성공하면 댓글 리스트 가져오기
			//alert(res.flag);
			
			replyListServer();
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
		
}

const boardWriter= () =>{
	
	$.ajax({
		url : `${mypath}/BoardWriter.do`,
		data : JSON.stringify(formData),
		method : 'post',
		contentType : 'application/json;charset=utf-8',
		dataType : 'json',
		success : function(res){
			//alert(res.flag)
			//글쓰기 성공이면
			//list
			currentPage = 1;
			boardListServer();
			
		},
		error : function(xhr){
			alert(xhr.status);
		}
			
	})
}


const boardListServer = () =>{
	
	vtype =$("#stype option:selected").val() //writer, subject, content
	vword =$('#sword').val().trim();
	
			$.ajax({
				url : '/boardpro/BoardList.do',
				method : 'post',
				data : JSON.stringify({page : currentPage, stype : vtype, sword : vword}),
				contentType : 'application/json;charset=utf-8',
				dataType : 'json',
				success : function(res){
					
					console.log(res)
					
					code = `<div class="container mt-3">
						<div id="accordion">`;
					
						$.each(res.datas, function(i,v){
							
							content = v.content;
							
							content = content.replaceAll(/\n/g, "<br>")
							
							
							
					code+=`	<div class="card">
						      <div class="card-header">
						        <a class="btn action" data-idx="${v.num}" name="replist"
								data-bs-toggle="collapse" href="#collapse${v.num}">
						        ${v.subject}
						        </a>
						      </div>
						      <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
						        <div class="card-body">
						            <div class="p12">
						               <p class="p1">
						                          작성자:<span class="wr">${v.writer}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                          이메일:<span class="em">${v.mail}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                          조회수:<span class="hi">${v.hit}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                          날짜 :<span class="da">${v.wdate}</span>         
						               </p>
						               <p class ="p2">`
						               
									   
									 if(uvo != null && uvo.mem_name == v.writer)  {
						              code += ` <input type="button" data-idx="${v.num}" 
									  value="수정" name="modify"  class="action">
						              
									  <input type="button" data-idx="${v.num}" 
									  value="삭제" name="delete"  class="action">`
									 }
						               
									 code += `  </p>
						            </div>
						            <p class="p3">
						              ${content} <br>
						            </p>
						            <p class="p4">
						            <textarea rows="" cols="60"></textarea>
						            <input type="button" data-idx="${v.num}" value="등록" name="reply"  class="action">
						            </p>
						            
						        </div>
						      </div>
						    </div>`
					})	//반복문
					
					code += `</div></div>`
					
					$('#result').html(code);
					
					//페이지 리스트 번호 출력
					plist = pageList(res.sp, res.ep, res.tp);
					$('#pagelist').html(plist);
					
				},
				error : function(xhr){
					alert(xhr.status);
				}
				
			})
	
}

const pageList = (sp, ep, tp) =>{
	
	pager = `<ul class="pagination">`;
	
	//이전버튼
	 if(sp>1){
		pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`
	 }
	
	//페이지 번호
	for(i=sp; i<=ep;i++){
		
		if(i == currentPage){
			pager += `<li class="page-item active"><a class="page-link pno" href="#">${i}</a></li>`
		}else{
			pager += `<li class="page-item"><a class="page-link pno" href="#">${i}</a></li>`
		}
	}
	
	//다음버튼
	if(ep<tp){
		pager += ` <li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`
	}
	
	pager += `</ul>`
	
	return pager;
}

