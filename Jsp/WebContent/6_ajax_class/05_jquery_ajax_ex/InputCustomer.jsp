<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 고객관리 프로그램 </title>
<script  type="text/javascript"  src="../../lib/jquery-3.4.1.min.js"> </script>
<script type="text/javascript" >

$(function(){
	$('input[value="입력"]').click(function(){
		$.ajax({
			type : 'get',
			url  : './DataInput.jsp',
			data : { 
					'name' : $("#name").val(),
					'age' : $("#age").val(),
					'tel' : $("#tel").val(),
					'addr' : $("#addr").val()
			},
			dataType : 'json',
			success  : function(data){					
					$('#listTable').text(data.result);
			},
			error : function(e){
				alert("에러"+e);
			}
		});
	
	});
	
	$('input[value="가져오기"]').click(function(){
		
		$.ajax({
			type : 'get',
			url  : './DataSelect.jsp',
			dataType : 'xml',
			success  : function (data){
				$('#myDiv').children().remove();  // div의 자식 요소를 삭제 
				for(var i=0; i<$(data).find('person').length; i++){ 
					$('#myDiv').append('<table border = 1><tr><td width="80" align="center">'+
							$.text($(data).find("person").find("name").eq(i))+'</td><td width="50" align="center">'+
							$.text($(data).find("person").find("age").eq(i))+'</td><td width="100" align="center">'+
							$.text($(data).find("person").find("tel").eq(i))+'</td><td width="250" align="center">'+
							$.text($(data).find("person").find("addr").eq(i))+'</td></tr></table>');
					}
				}
			});
		});	
});
		
</script>
</head>
<!-- <body> -->
<body>

<h2> 고객정보 입력 </h2>

<form name="inForm" method="post">
<table border = 1>
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
	<tr>
		<td align="center"><input type="text" size="8" name="name" id="name"></td>
		<td align="center"><input type="text" size="4" name="age" id="age"></td>
		<td align="center"><input type="text" size="12" name="tel" id="tel"></td>
		<td align="center"><input type="text" size="30" name="addr" id="addr"></td>
	</tr>
	<tr>
		<td colspan="4" align="center"> 
			<input type="button" value="입력" >	<!--  onclick="insertCustomer()" -->
		</td>
	</tr>
</table>

<br>
<hr>

<h2> 고객정보 목록보기  </h2>
<table border='0' width="510"> 
	<tr>
		<td align="right"><input type="button" value="가져오기" ></td> <!-- onclick="getData()" -->
	</tr>
</table>
<table border = 1 id="listTable">
	<tr>
		<td width="80" align="center">Name</td>
		<td width="50" align="center">Age</td>
		<td width="100" align="center">Tel</td>	
		<td width="250" align="center">Addr</td>
	</tr>
</table>
<div id="myDiv"> </div>

</form>
</body>
</html>