window.onload = function(){

		//var frm = document.getElementById('frm');
		//var inputs = document.querySelectorAll("input");
		var frm = document.querySelector('#frm');
		var inputs = document.querySelectorAll("input");
		
		frm.onsubmit = function(e){
			e.preventDefault();
			//alert("서버로");
			
		/*	var agree = frm.agree;
			//alert(agree.checked)
			if(!agree.checked) {
				alert('ㅎ약관 확인 ㅎ');
				return;
			}*/
			// 별칭이 ['babo','geni', 'idiot','gdb']
		
			var nickname = document.getElementById('nickname').value;
			var baned = ['babo','geni', 'idiot','gdb'];
			alert(baned);
			
			frm.submit();
		}


	}