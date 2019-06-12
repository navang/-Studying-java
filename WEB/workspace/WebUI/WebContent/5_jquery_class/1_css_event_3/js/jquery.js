// 


$(function(){
		//증가
		$('#inc').click(function(){
			//alert("+");
			var fontSize = parseInt($('#txt').css("font-size"));
			fontSize = fontSize + 1 +"px";		
			$('#txt').css({'font-size':fontSize});	
		});
		//감소
		$('#dec').click(function(){
			//alert("+");
			var fontSize = parseInt($('#txt').css("font-size"));
			fontSize = fontSize - 1 +"px";		
			$('#txt').css({'font-size':fontSize});	
		});
		
		//폰트스타일 (폰트-패밀리)
			$('#fontstyle').change(function(){
				var fontStyle = $(this).eq(0).val();
				
				$('#txt').css({'font-family':fontStyle});
		});
	});