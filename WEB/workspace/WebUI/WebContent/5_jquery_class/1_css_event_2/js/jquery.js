/**
 * 
 */

$(function(){
	$('.rollover').each(function(){
		var a = $(this);
		var img = a.find('img');
		
		// img 속성중에서 src값 변경 attr()
		// replace('a' , 'b') 이용 
		var rpc_off= img.attr('src');
		var rpc_on= rpc_off.replace("_off","_on");
		
		$('<img/>').attr('src','rpc_on');
		
		a.hover(function(){
			img.attr('src', rpc_on);
		}, function(){
			img.attr('src', rpc_off);
		});
		
	});
});