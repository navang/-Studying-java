<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/jquery.tempgauge.js"></script>
<script type="text/javascript">
$(function(){
	//네이버 눌릴때
	$('#naver').click(function(){
		$.ajax({
			type : 'get', 
			url  : './jsp/proxy_naver.jsp',
			success : function (data){
				var rank = $('.PM_CL_realtimeKeyword_rolling', data);
				$('#result').empty();
				$('#result').append(rank);
		}
	});
});
	// 멜론
	$('#melon').click(function(){
		$.post('./jsp/proxy_melon.jsp', function(data){
			var songchart = $('.typeRealtime >ul >li', data);
			$('#result').empty();
			songchart.each(function(){
				var rank = $('.rank', this).text();
				var title = $('.song', this).text();
				var img = $('.mlog', this).html();
				$('#result').append(img + rank + "위" +title + "<br/>")
			});
			
			
			
		
		});
	});
	// 다음
	$('#daum').click(function(){
		$.post('./jsp/proxy_daum.jsp', function(data){
			var section = $('.roll_txt', data);
			$('#result').empty();
			section.each(function(){
				var ranked = $('.txt_issue', this).find('.link_issue').text();
				
				$('#result').append(ranked + "<br/>")
			});
			

		});
	});
	
	//기상청$

	$('#kma').click(function(){
		
		$.ajax({
			type : 'post', 
			url  : './jsp/proxy_kma.jsp',
			//	dataType : 'xml',
			success : function(kmadata){
				var data = $('data', kmadata);
				
			
					//alert($(data[0]).html());
					$('#result').empty();
					$('.graph').empty();
					for(var i=0; i<data.length; i++){
						$('#result').append('이시각 >>' + $(data).find('hour').eq(i).html() + '시, 온도는' +
						$(data).find('temp').eq(i).html()+ '도 입니다'+'</br>');	
			// 반복적으로 추가해주자 
			
// 			var chartimg[i] = tempGauge({
// 				borderColor:"black",
// 				borderWidth: 4,
// 				defaultTemp: $(data).find('temp').eq(i).text(),
// 				fillColor:"red",
// 				showLabel:true,
// 				labelSize: 12,
// 				maxTemp: 30,
// 				minTmp:0,
// 				width:30
// 			});		
			
			$('#chart').append('<td width="50" align="center">' + $(data).find('temp').eq(i).html() + '</td>');
			//시간
			$('#graph').append('<td width="50" align="center">' + $(data).find('hour').eq(i).html() +'시'+ '</td>');
		
		} // for
		
					$('.tempGauge-demo').tempGauge({
						borderColor:"black",
						borderWidth: 4,
						defaultTemp: 22,
						fillColor:"red",
						showLabel:true,
						labelSize: 12,
						maxTemp: 30,
						minTmp:0,
						width:30
					});
		
		
		
		} //function(kmadata)
		
		
		
		
	});
});
});
</script>
</head>
<body>
<h1>선택</h1>
<button id = 'naver'>네이버</button>
<button id = 'melon'>멜론</button>
<button id = 'daum'>다음</button>
<button id = 'kma'>날씨</button>
<div id='result'></div>


		
 <div class="tempGauge-demo"></div> 

<table border="1">
<tr id="chart">

</tr>
<tr id="graph">

</tr>
</table>

</body>
</html>