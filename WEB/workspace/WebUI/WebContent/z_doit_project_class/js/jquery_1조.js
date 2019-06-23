

$(function(){
	
	//1. 오늘날짜 set하기
	var dt = new Date(); //오늘 날짜를 dt에 삽입
	var recentYear = dt.getFullYear(); //오늘 날짜중 년도를 삽입
    var recentMonth = dt.getMonth() + 1; //오늘 날짜중 월을 삽입
    var recentDay = dt.getDate(); //오늘 날짜중 일을 삽입
    $('#date_wrap>.year').text(recentYear); //삽입
    $('#date_wrap>.month').text(recentMonth); //삽입
    $('#date_wrap>.date').text(recentDay); //삽입
    
    //2. 검색어를 입력하세요 이미지 지우기
    $('#keyword').click(function(){ //id값 keyword를 클릭하면
    	$('#keyword').css("background-position","0 -500px"); //해당 이미지를 500px만큼 보내서 안보이게 처리
    });
    $('#keyword').blur(function(){ // 마우스 포인터가 다른 곳을 클릭했을 때
    	$('#keyword').css("background-position","0 -0px");	//해당 이미지가 원래 위치로 돌아옴
    });
	
    //3. 공지사항, 질문과답변, 저자문의 
    var tabmenu = $('#tabmenu').find('dt'); //공지사항,질문과 답변,저자문의
    
    tabmenu.eq(0).addClass('selected'); // 첫번째 요소에만 일단 클래스를 부여한다(초기값이기 때문)
    
    var lastMenu = tabmenu.filter('.selected'); // select 이름을 가진 클래스를 걸러서 변수에 넣는다
    var lastCon = lastMenu.next(); //필터링한 클래스의 형제인 dd를 변수에 넣는다(list에 해당)
    var img_over = lastMenu.find('img').attr('src'); // 흰색 탭메뉴화면(파일 끝자리 이름이 over)을 변수에 넣는다
    var img_out = img_over.replace('_over','_out'); // 회색 탭메뉴화면(파일 끝자리 이름이 out)을 변수에 넣는다
    
    tabmenu.mouseover(function(){ //각각 탭에 마우를 올려놓을 때마다 이벤트 적용
       lastCon.hide(); // 내용 숨기기
       lastMenu.removeClass('selected'); //클래스 해제
       lastMenu.find('img').attr('src',img_out); //기존 적용되어있는 탭에 이미지를 회색 이미지로 바꿈
       
       lastMenu = $(this); 
       lastMenu.addClass('selected');
       
       img_out = lastMenu.find('img').attr('src'); //선택된 탭(위에서 회색이미지로 바꿨음)을 out 변수에 다시 넣음
       img_over = img_out.replace('_out','_over'); //out변수에 넣어놓은 걸 다시 over로 바꿔서 변수 내용 바꿈
       
       lastMenu.find('img').attr('src',img_over); //선택된 탭의 속성을 over로 바꿈
       lastCon = lastMenu.next(); //선택된 탭의 형제요소를 변수에 넣음
       lastCon.show(); //변수에 넣은 형제요소 보여주기
    });
	
    
    //4. 책 화면 슬라이더
    $('#best_bg>ul').bxSlider({ //jquery의 플러그인인 bxSlider를 활용
    	minSlides : 6,    //한 화면에 slide 갯수 6개가 나오고
		maxSlides : 8,	//최대 슬라이드 허용 갯수가 8개
		slideMargin : 80,  //슬라이더의 마진 값이 80px
		slideWidth : 250, //넓이 250px
		
		auto : true,  //자동으로 슬라이더가 돌아가게 설정
		moveSlides : 2  	//슬라이더 2개씩 이동
    });
    
    
    //5. 로그인 닫기
    $('.login_wrap img').click(function(){ //class=login_wrap의 자손인 img를 클릭하면
    	$('#login_f').offset({top : 30}); //id=login_f의 offset(절대값 좌표로 변경) 위로 30pixel만큼 이동
    	$(".login_close_btn img").on("click", function(){ //class=login_close_btn의 자손인 img를 클릭하면
    		$('#login_f').hide(); //id=login_f가 숨겨짐
    	});
    });
    
    //6. 전체메뉴 출력 및 닫기
    $('#total_btn').click(function(){ //id=total_btn을 클릭하면
    	$('#total_menu').toggle();	//id=total_menu를 toggle(show/hide) 할 수 있게 활성화
    	$("#total_close img").on("click", function(){ //id=total_close의 자손인 img를 클릭하면
    		$('#total_menu').hide();	//id=total_menu의 전부가 숨겨짐
    	});
    });
    
    //7. 쿠키활용
    $(function(){
    	if(!$.cookie('BDB3')){ //BDB3이란 이름의 쿠키값이 없으면
    		window.open("promotion.html","","width=900, height=700");//promotion.html을 실행	
    	}else{
    	}
    });
    
    //추가. 알림판
   
   $('#roll_banner_wrap dt').hover(function(){  //알림판 배너에 마우스를 댔을때
	 var a = $(this).find("img").attr("src");  //해당 dt의 index중 img src의 값을 a에 삽입
	 var a1 = a.replace('_out',"_over"); //a의 src값을 _over로 변경한 값을 a1에 저장
	 $(this).find("img").attr("src", a1); //선택된 dt의 img src값에 a1을 넣어 변경
	 $('#roll_banner_wrap dd').hide(); // 모든 dd(banner)를 숨기고
	 $(this).next().show();	//선택된 dt에 밑에 있는 dd를 보여줌

   },function(){
	   var b = $(this).find("img").attr("src"); //위와 반대로
		 var b1 = b.replace('_over',"_out");
		 $(this).find("img").attr("src", b1);
   });
});  
