/*단계별로 복습
1) 테이블 만들기
테이블명 : gogek           
Id 영문자와 숫자로 조합으로 8자까지 가능 기본키
name 한글 5자까지 입력 가능 필수입력
tel 전화번호도 고객을 찾을 수 있지만 입력하지 않을 수도 있음

*/
DROP TABLE gogek;
DROP TABLE sangpum;
DROP TABLE jumun;
DESC gogek;

 CREATE TABLE gogek (
                id      varchar2(8), 
                name    varchar2(10) NOT NULL,
                tel     varchar2(20),
                CONSTRAINTS pk_gogek_id PRIMARY KEY (id),
                CONSTRAINT UK_gogek_tel UNIQUE (tel) 
              
 );
/*           테이블명 : sangpum
No 영문자와 숫자로 6자리 기본키
title 상품명  필수입력
Detail 상품상세설명
Count 개수 저장 필수입력 
Price  상품 가격
*/
 CREATE TABLE sangpum (
                No           varchar2(6), 
                title        varchar2(20) NOT NULL,
                Detail       varchar2(100),
                Count        number(8) NOT NULL,
                Price        number(10),
              
                CONSTRAINTS pk_sangpum_No PRIMARY KEY (NO)
              
 );
/*
           테이블명 : jumun
No 숫자 4자리 기본키
gogek 고객 아이디 참조 
Sangpum 상품번호 참조
Count 주문수량
Jumunil 주문한 날짜
*/
 CREATE TABLE jumun (
                No      number(4), 
                gogek   varchar2(8),
                sangpum     varchar2(6),
                Count       number(8),
                Jumunil       number(10),
                
                CONSTRAINTS pk_jumun_No PRIMARY KEY (No),
                CONSTRAINT fk_jumun_gogek FOREIGN KEY (gogek) REFERENCES gogek (id),
                CONSTRAINT fk_jumun_sangpum FOREIGN KEY (sangpum) REFERENCES sangpum (No)
 );
--2) 데이터 입력 ( 입력시에러가 발생하면 원인을 분석하세요 )

INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','홍길동', '031-333-3333' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo1111','김길동', '031-111-1111' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo2222','홍길동', '031-222-2222' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo9999','박길동', '031-333-3333' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','맹길동', '031-999-9999' ); -- 무결성 제약 조건(HEROES.PK_GOGEK_ID)에 위배됩니다

INSERT INTO gogek ( id, name, tel ) VALUES('babo12345','이길동', '031-333-1234' ); -- id 가 너무 큼 

INSERT INTO gogek ( id, name, tel ) VALUES('123','최길동', '031-999-9999' );

INSERT INTO gogek ( id, name ) VALUES('babo','봉길동' );

INSERT INTO gogek ( id, tel ) VALUES('babo1988','031-888-8888' );

 

 

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00001','이쁜바지', 30, 1000, '싸고이뻐서 금방 다 팔릴 바지입니다' );

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00002','그냥바지', 20, 500, '그냥이뻐고 편안한 바지입니다' );

INSERT INTO sangpum ( no, title, count )VALUES ('B00009','윗도리', 20 );

INSERT INTO sangpum ( no, title, count,price ) VALUES ('Z0001','비싼코트', 3, 20000, '겁나 비싼코트입니다' );

INSERT INTO sangpum VALUES ('Z00001','비싼코트2', 5, 20000, '겁나 비싼 코트입니다' );

INSERT INTO sangpum VALUES ('Z00001','비싼코트3','겁나 비싼 코트입니다', 5, 20000);

 

 

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1000, 'babo1234', 'A00001', 1, '2016/09/09' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1001, 'babo1233', 'Z00001', 1, '2016/09/09' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1002, 'Babo1234', 'A00002', 2, '2016/09/10' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1003, 'babo1234', 'B00001', 1, '2016/09/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1004, 'babo', 'Z00001', 1, '2016/10/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1005, 'babo1234', 'B00009', 1, '2016/11/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1006, 'babo1234', 'B00009', 1, '2016/12/12' );





--전화번호가 없는 고객은 누구인지 고객명을 검색하세요
SELECT  id
FROM gogek
WHERE tel is null
ORDER BY name;

-- 홍씨 성을 가진 고객들의 정보를 검색하세요
SELECT *
FROM gogek
WHERE REGEXP_LIKE(name,'^홍')
ORDER BY name;

--babo2222 고객명을 박길동으로 변경하세요 - 패스 
UPDATE  gogek SET name = '박길동' WHERE id = 'babo2222';
 
--아이디 123 고객의 아이디를 babo123 으로 변경하세요    -- PK
UPDATE  gogek SET id = 'babo2222' WHERE id = '123' ;

--봉길동씨의 전화번호 02-555-5555를 추가하세요
UPDATE  gogek SET tel = '02-555-5555' WHERE name = '봉길동' ;

--상품번호 B00009 에 가격 1200원 그리고 “겁나 쌕시한 옷입니다”라는 상품설명을 추가하세요
UPDATE  sangpum SET price = '1200' WHERE No = 'B00009' ;
UPDATE  sangpum SET detail = '겁나색시한 옷입니다' WHERE No = 'B00009' ;
--이쁜바지 상품이 10개가 팔렸습니다.
UPDATE  sangpum SET count = count-10 WHERE title = '이쁜바지' ;
--Z00001 상품이 3개가 더 입고 되었습니다.
UPDATE  sangpum SET count = count+3 WHERE No = 'Z00001' ;
-- 상품 가격이 1000원을 넘는 상품들을 검색하세요
SELECT *
FROM sangpum
WHERE PRICE > '1000'
ORDER BY NO;
--11월 이후에 주문한 상품 번호를 검색하세요
SELECT sangpum
FROM jumun
WHERE Jumunil > '2016/11/01'
ORDER BY NO;
--babo 고객이 주문한 상품을 A00002로 변경하고 수량을 2개로 수정하세요
UPDATE jumun SET sangpum = 'A00002' WHERE gogek = 'babo' ;
UPDATE jumun SET count = count+2  WHERE gogek = 'babo' ;

--babo1234 고객이 11월에 주문한 상품 번호을 검색하세요
SELECT no
FROM jumun
WHERE ( gogek = 'babo1234') and ( jumunil < 2016/12/01 and jumunil >= 2016/11/01 )
ORDER BY NO;
--B00009 상품을 주문한 고객 아이디를 검색하세요
SELECT gogek
FROM jumun
WHERE  sangpum = 'B00009'
ORDER BY NO;


 