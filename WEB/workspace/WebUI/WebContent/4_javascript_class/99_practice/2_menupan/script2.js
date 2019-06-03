/**
 * 
 */
   var price = new Array();
   var content = new Array();
   
   var sum = 0;
   var txt;
   var con;
 
window.onload = function (){
	 con = document.getElementById('content')
	 
	 for(var i=0; i<10; i++){
		 if( document.getElementById('btn').onclick = function(){}){
			 content[i] = con.innerHTML;
		 }
	 }
	 
	 
   document.getElementById('menu1').onclick = function(){
	   // 색 레드로 
	  document.getElementById('menu1').style.backgroundColor = "red";
     
	 
      
      document.getElementById('btn').onclick = function(){
    	  	  // 색 화이트로 
        	  document.getElementById('menu1').style.backgroundColor = "white";
        	  // 개수값 받아오기 
        	  var target = document.getElementById("count");
              var count = target.options[target.selectedIndex].value;     // 옵션 value 값
              var a = 1000*count;
               txt = document.getElementById('total');       
               sum = sum+a;
               txt.value = sum; 
               
               
               con.innerHTML = "아메리카노" + count + "개는 " +a + "원 입니다";   
               

           }
   }
   document.getElementById('menu2').onclick = function(){
      //content = document.getElementById('content')
      var target = document.getElementById("count");
           var count = target.options[target.selectedIndex].value;     // 옵션 value 값
           document.getElementById('btn').onclick = function(){
              var a = 2000*count;         
               txt = document.getElementById('total');       
               sum = sum+a;
               txt.value = sum;      
               con.innerHTML = "카페라떼" + count + "개는 " +a + "원 입니다";   
            
           }
           
   }
   document.getElementById('menu3').onclick = function(){
     // content = document.getElementById('content')
      var target = document.getElementById("count");
           var count = target.options[target.selectedIndex].value;     // 옵션 value 값
           document.getElementById('btn').onclick = function(){
              var a = 3000*count;
              con.innerHTML = "쥬스" + count + "개는 " +a + "원 입니다";            
               txt = document.getElementById('total');       
               sum = sum+a;
               txt.value = sum;         
           }
   }
   document.getElementById('menu4').onclick = function(){
      //content = document.getElementById('content')
      var target = document.getElementById("count");
           var count = target.options[target.selectedIndex].value;     // 옵션 value 값
           document.getElementById('btn').onclick = function(){
              var a = 2000*count;
              con.innerHTML = "과자" + count + "개는 " +a + "원 입니다";            
               txt = document.getElementById('total');       
               sum = sum+a;
               txt.value = sum;         
           }
   }
   document.getElementById('menu5').onclick = function(){
      //content = document.getElementById('content')
      var target = document.getElementById("count");
           var count = target.options[target.selectedIndex].value;     // 옵션 value 값
           document.getElementById('btn').onclick = function(){
              con.innerHTML = "엿  " + count + "개는 " + 1000*count + "원 입니다";   
               var a = 1000*count;
               
             txt = document.getElementById('total');       
               sum = sum+a;
               txt.value = sum;
                     
           }
   }
   document.getElementById('menu6').onclick = function(){
     //content = document.getElementById('content')
      var target = document.getElementById("count");
           var count = target.options[target.selectedIndex].value;     // 옵션 value 값
           document.getElementById('btn').onclick = function(){
              var a = 1500*count;
              con.innerHTML = "땅콩  " + count + "개는 " + a + "원 입니다";   
               sum = sum+a
               txt = document.getElementById('total');       
               txt.value = sum;
                     
           }
      }
   }