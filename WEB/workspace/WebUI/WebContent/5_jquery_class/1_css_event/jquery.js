/**
 * 
 */
$(function(){
	// 1) 테이블의 홀수행 배경색을 변경  + 글자색 변경 
	$('#celebs tbody > tr:odd').css({
		'background':'#aee7e8' , 'color': '#0000ff'});
	
	// 2) 테이블에 마우스 올라가면 색변경 
	// (css 파일에 있는 td_mouseover 클래스 지정 )
	$('#celebs >table> tbody tr').mouseover(function(){
		$(this).addClass('td_mouseover');
	}).mouseout(function(){
		$(this).removeClass('td_mouseover');
	});	
	
	// 버튼 이벤트 
	// hide
	$('#hideButton').click(function(){
		$('#intro > img').slideUp('fast'); // slidedown()
	});
	// show
	$('#showButton').click(function(){
		$('#intro > img').show(1500); // hide()
	});
	// toggle
	$('#toggleButton').click(function(){
		$('#intro > img').fadeToggle(300); //toggle() 
		
		/* 토글을 안쓰는경우 잇으면 감추고 없으면 보이기 
		var img =$('#intro > img');
		if( img.is(':visible')){
			img.fadeOut(1000);
		}else {
			imh.fadeIn(1000);
		}
		*/
	});
	
});

