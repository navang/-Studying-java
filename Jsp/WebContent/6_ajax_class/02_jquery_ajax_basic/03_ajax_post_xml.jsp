<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
	<script type="text/javascript">
	$(document).ready(function(){
		var param = { cate : 'book', name : "홍사형"};
		$.ajax({
			type : 	'post',
			data : 	param ,			// 보낼 데이터 
			url  :	'03_server.jsp',
			dataType : 'xml',    //받는 데이터 타입 
			success : parseData
		});
		// $post('03_server.jsp' , param, parseData, 'xml');  //위 객체와 같은 코딩 
		
		function parseData(xmlInfo){
			$('#cate').val($(xmlInfo).find('first').text()); // jquery방식으로 인자 xmlInfo를 text에 
		}
	})
	
	</script>
</head>

<body>
서버로부터 넘겨받은 데이터<br/>
첫번째 데이터 : <input type="text" name="" id="cate"/><br/>
두번째 데이터 : <input type="text" name="" id="name"/><br/>
</body>
</html>


