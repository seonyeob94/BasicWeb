/**
 * 
 */

const boardWriter= () =>{
	$.ajax({
		url : `${mypath}/BoardWriter.do`,
		data : JSON.stringify(formData),
		method : 'post',
		contentType : 'application/json;charset=utf-8',
		dataType : 'json',
		success : function(res){
			alert(res.flag)
		},
		error : function(xhr){
			alert(xhr.status);
		}
			
	})
}


const boardListServer = () =>{
	
	vtype =$("#stype option:selected").val().trim(); //writer, subject, content
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
					code+=`	<div class="card">
						      <div class="card-header">
						        <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
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
						               <p class ="p2">
						               
						               <input type="button" data-idx="${v.num}" value="수정" name="modify"  class="action">
						               <input type="button" data-idx="${v.num}" value="삭제" name="delete"  class="action">
						               </p>
						            </div>
						            <p class="p3">
						                            ${v.content} <br>
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