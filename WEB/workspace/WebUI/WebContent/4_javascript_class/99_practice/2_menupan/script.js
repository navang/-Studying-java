/**
 * 
 */

window.onload = function (){
	
	var td = document.getElementsByClassName('menu');
	for(var i=0; i<td.length; i++ ){
		alert(i);
		td[i].onclick = function(){
			//alert(i);
			alert(this.childNodep[0].nodeValue + 
					this.childNodep[1].nodeValue )
		}
	}

	var price = new Array();
	var content = new Array();

	//#### 1. TD에 이벤트 발생
	document.getElementById('menu1').addEventListener("click", function(){
		document.getElementById('menu1').style.backgroundColor = "white";
		document.getElementById('menu1').style.backgroundColor = "red";
				})
	document.getElementById('menu2').onclick = function(){
	alert('menu2');}
	document.getElementById('menu3').onclick = function(){
	alert('menu3');}
	document.getElementById('menu4').onclick = function(){
	alert('menu4');}
	document.getElementById('menu5').onclick = function(){
	alert('menu5');}
	document.getElementById('menu6').onclick = function(){
	alert('menu6');}
	
	
	
	//#####  2. 확인 버튼 클릭시 선택한 TD의 색을 다시 흰색으로
	document.getElementById('btn').addEventListener("click", function(){
		document.getElementById('menu1').style.backgroundColor = "blue";
				})
		
}
	//#####  3. 값 계산하여 총합 구하기 - 각각 TD 클릭시 배열에 저장하였다가 계산
