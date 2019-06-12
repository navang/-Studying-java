
$(function(){
	var anchors = $('.tabSet').find('a');
	var panelDivs = $('.tabSet').find('div.panel');
	
	panelDivs.hide();	 
	anchors.show();
	
	//현재상태에서 출력	
	var lastAnchor = anchors.filter('.on');
	var lastPanel = $(lastAnchor.attr('href'));
	
	lastPanel.show(); // 초기패널 (첫번째)
	
	anchors.click(function(){
		
		anchors.removeClass('on'); // 이전 a에서 클래스의 on값을 지움
		$(this).attr('class','on');// 클릭한 a에 클래스=on 추가
	
		 lastAnchor = anchors.filter('.on');
		 lastPanel = $(lastAnchor.attr('href'));

		 
		 
		panelDivs.hide(); // 이전(사실 모든 패널) 숨김
		lastPanel.show(); // on값있는거 출력
		
	});
	
	
	

});