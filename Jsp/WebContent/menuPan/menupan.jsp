<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="product.model.*,product.service.*" %>   
<%@ page import="java.util.List" %>
<%

	ViewProductService productService = ViewProductService.getInstance();
	//페이지수 얻어오기 
	int totalPageCount = productService.getTotalPage();
	// 페이지 번호 받기
	String pNum = request.getParameter("pno");
   // 전체 메세지 레코드 검색 
   List <ProductRec> pRec =  productService.getProductList(pNum);
   
    
%> 

<!--  받아와서 디비값수정 -->
<% request.setCharacterEncoding("utf-8"); %>


   
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAFE</title>
<script type="text/javascript" src='../lib/jquery-3.4.1.min.js'></script>
<script type="text/javascript">

$(function(){
			
	

	
		var tsum=0;
		$('.menuCount').each(function(){
			$(this).change(function(){
			//alert( $(this).val() ); //< 개수구하기
			var item = $(this).parent().find('span');
			//alert(item.eq(0).text()); //메뉴명
			var td1menu = item.eq(0).text();
			var td2count = $(this).val();
			var price = item.eq(1).text();
			
			var sum =td2count*price;
			tsum = tsum + sum;
 			$('#total').val(tsum);
			// table 에 메뉴, 개수 , 삭제버튼 올려줌 
			
		    $('#listTable').append('<tr><td>'+ td1menu +'</td><td>' + td2count + '</td><td>'+ 
		    		'<input class="del" price='+ sum +' type="button"/>' +'</td></tr>');
			$(this).val('0');
		});
		});
 			// 삭제
			$('#listTable').on('click', '.del', function(){
				$(this).parent().parent().remove();
				tsum = tsum - $(this).attr("price");
				$('#total').val(tsum);
			});
});
</script>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
     <div id="leftdiv">
<table class="menutbl">
	<tr id="menutitle">
		<th colspan=3 id="titleText">M E N U</th>
	</tr>
	
 <% if( pRec.isEmpty() ) { %>
     남겨진 메세지가 하나도~~없습니다. <br>
  <% } else { %>
 
<tr class="menus">
   <%
   int count = 0;
   for(ProductRec rec : pRec){ 
   	if(count %3 ==0){	
   %> 
   <tr></tr>
   <%
   	}
   %>
		<td id='<%=rec.getpNo() %>' class='menu'>
			<img src='<%=rec.getpPath() %>'/> <br/>
			<span id="label1" value = ''><%=rec.getpName() %></span>
			<span id="price1" value = ''><%=rec.getpPrice() %></span>원
			<br/>
			<select name="menu1Count" id="menu1Count" class='menuCount'>
				<option value='0'>0</option>
				<option value='1'>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
				<option value='5'>5</option>
			</select><a><%=rec.getpEach() %></a><a>개</a>
		</td>
  <%
   count++;
  } //end of for %>
   

  </tr>
  <% } // end if-else %>



</table>
</div>

<div id="rightdiv">
<table id="listTable">
	<tr id="listtitle">
		<th colspan=3 id="titleText">주문내역</th>
	</tr>
	<tr id="totallist">
		<td colspan='3'>
			총합 : <input type='text'  id='total'/> 원 
			<input type='button'	value='주문하기'  id='btn'/>
		</td>
	</tr>
	<tr id="listtr">
		<td width="150">목록</td>
		<td width="100">갯수</td>
		<td width="50">삭제</td>
	</tr>
	
</table>
</div>

</body>
</html>