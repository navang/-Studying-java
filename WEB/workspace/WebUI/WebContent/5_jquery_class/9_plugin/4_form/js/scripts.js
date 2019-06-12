/**
 * 
 */


$(function(){
	$('#signup > form').validate({
		rules : {
			name: {
				required : true,
				
			},
			email: {
				required : true,
				email : true
			},
			website : {
				url : true
			},
			password :{
				required: true,
				minlength: 6
			},
			passcof : {
				equalTo : '#password'
			}
		},
		success : function(label){ 
		label.addClass('valid');
		//label.text('성공');
		}
		
	});
		$('.check-all').click(function(){
			if($(this).is(":checked")){
				$('.agree').attr('checked',false);
			}else{
				$('.agree').attr('checked',true);
			}
			
			//$('input[checked="checked"].agree').attr('checked',false);
		});
		
});