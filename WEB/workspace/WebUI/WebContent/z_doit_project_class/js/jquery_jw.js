

/*
 *  <p id="date_wrap">
      <span class="year">0000</span> 년
      <span class="month">00</span> 월
      <span class="date">00</span>일
   </p>
 */
$(function(){
	var fullDate = new Date();
	//alert(fullDate.getDate());
	$('#date_wrap >.year').html(fullDate.getYear()+1900);
	$('#date_wrap >.month').html(fullDate.getMonth()+1);
	$('#date_wrap >.date').html(fullDate.getDate());
	
	
});

