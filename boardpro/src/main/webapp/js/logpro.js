/**
 * 
 */

const loginServer = () =>{
	idValue = $('#id').val().trim();
	passValue = $('#pass').val().trim();
	$.ajax({
		url : `${mypath}/Login.do`,
		data : JSON.stringify({mem_id : idValue, mem_pass : passValue}),
		method : 'post',
		contentType : 'application/json;charset=utf-8',
		dataType : 'html',
		success : function(res){
			location.href=`${mypath}/start/index.jsp`;
		},
		error : function(xhr){
			alert(xhr.status)
		}
		
	})
}

const logoutServer = () =>{
	/*//단축은 url data success dataType 순이다
	$.get(
		`${mypath}/Logout.do`,
		function(res){
					
		},
		'html'
	)*/
	
	$.ajax({
		url : `${mypath}/Logout.do`,
		method : 'get',
		dataType : 'html',
		success : function(res){
			location.href=`${mypath}/start/index.jsp`;
		},
		error : function(xhr){
			alert(xhr.status)
		}
	})
	
}
