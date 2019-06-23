<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
	
	<script>
	$(function(){
		$.ajax({
			type : 'get', 
			url  : '04_server.jsp',
			data : { cate : '책' , name : '홍길자'},
			success : function (resText){ // parseData를 생략하고 함수를 바로 씀 
					  var obj = {};
				      obj = eval("("+resText+")");
					  $("#cate").val(obj.first);
					}
			// dataType 이 text
		});
		

	})
	    
	</script>
</head>

<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


