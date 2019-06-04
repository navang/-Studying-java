/**
 * 
 */
   var price = new Array();
   var content1 = new Array();
   var sum = 0;
   var txt;
   var content;
   var ids = ['menu1','menu2','menu3','menu4','menu5','menu6'];

   window.onload = function(){
      var tds = document.getElementsByClassName('menu') ;
      for(var i =0; i<tds.length; i++){
         
            tds[i].onclick = function(){
               for(var j=0; j<tds.length; j++){
               tds[j].style.backgroundColor = "#ffffff";}
               this.style.backgroundColor = "red";
               
               var p = this.childNodes[2].nodeValue;
               var i = this.childNodes[0].nodeValue;
               var target = document.getElementById("count");
               var count = target.options[target.selectedIndex].value;
               content = document.getElementById('content');
               
               document.getElementById('btn').onclick = function(){   
                  var a = p*count;
                     txt = document.getElementById('total');       
                     sum = sum+a;
                     txt.value = sum;         
                     content1.push(i, "를(을)", count, " 개 주문", "<br/>");
                     
                     content.innerHTML = content1.join('') ;   
                 }
               
               
               
            }                                                                                                  
         }   
      }

   