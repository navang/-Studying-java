create table ex_member(
id varchar2(10), -- 아이디  pk 
pass varchar2(10) not null, -- 패스워드 not null
name varchar2(20) not null, -- 이름 not null 
tel varchar2(20), -- 전화번호  
addr varchar2(100) -- 주소

);



-- 상품 테이블
create table ex_good(
gno varchar2(10), -- 상품번호 pk 
gname varchar(30) not null, -- 상품명  not null
gdetail varchar2(300), -- 상세설명
price number);  -- 가격

-- 주문 테이블
create table ex_order (
ono number,  -- 번호 
orderno varchar2(20), -- 주문번호 pk
gno varchar2(10), -- 상품번호 fk 
id varchar2(10), -- 회원 아이디 fk
count number,  -- 갯수
status varchar2(10) -- 배송상태
);

create sequence seq_order_ono;

-----------------------------------------------------------
-- 1. 주문테이블과 회원테이블, 상품테이블의 관계를 맺는다면?

SELECT  * FROM ex_member;
drop table ex_member;
SELECT  * FROM ex_good;
drop table ex_good;
SELECT  * FROM ex_order;
drop table ex_order;
-- pk 부여
ALTER  TABLE   ex_member
ADD CONSTRAINT  pk_member PRIMARY KEY(id);
ALTER  TABLE   ex_good
ADD CONSTRAINT  pk_good PRIMARY KEY(gno);
ALTER  TABLE   ex_order
ADD CONSTRAINT  pk_order PRIMARY KEY(orderno);
-- fk 부여
ALTER TABLE ex_order
ADD CONSTRAINT  fk_order_id  FOREIGN KEY (id) REFERENCES      ex_member  (id);
ALTER TABLE ex_order
ADD CONSTRAINT  fk_order_gno FOREIGN KEY (gno)  REFERENCES      ex_good  (gno);




-- 회원 테이블 데이타 입력
insert into ex_member(id, pass, name, tel, addr )
values('kim', '1111', '김길동', '02-222-2222','서울 멋지구 이쁜동'); -- in

insert into ex_member(id, pass, name, tel, addr )
values('park', '1111', '박길동', '03-333-3333','인천 멋지구 이쁜동'); --in

insert into ex_member(id, pass, name, tel, addr )
values('meng', '1111', '맹길동', '04-444-4444','경기 멋지구 이쁜동'); --in

commit;

-- 상픔 테이블 데이타 입력
insert into ex_good( gno, gname, gdetail, price )
values('1001', '머리끈', '아주 비싼 머리끈', 200 ); --in


insert into ex_good( gno, gname, gdetail, price )
values('2002', '자전거-A', '비싸지만 빠르게 달리는 자전거', 10000 ); --in

insert into ex_good( gno, gname, gdetail, price )
values('2010', '자전거-B', '아주 비싸지만 느리고 안전하게 달린다는 자전거', 20000 ); --in

insert into ex_good( gno, gname, gdetail, price )
values('3333', '핸드폰케이스', '싸고 유행하는 핸드폰 케이스', 1500 ); --in

commit;



-- 주문 테이블 데이타 입력

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161212', '1001', 'park', 1, '배송완료'); --in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161212', '2010', 'park', 1, '배송중'); --pk order 위배

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161111', '1001', 'kim', 2, '주문'); -- in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161111', '3333', 'kim', 3, '주문'); --pk order 위배

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '1001', 'park', 3, '주문'); --in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '2010', 'park', 1, '배송중'); -- pk order

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '2002', 'park', 2, '주문'); -- pk order

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20165050', '1001', 'meng', 1, '배송중'); -- in 

commit;
---------------------------------------------------------------------------

--1. 배송중인 주문 내역과 상품 정보 출력
select *from ex_order;
SELECT o.orderno , o.status, g.gdetail
FROM ex_order o INNER JOIN ex_good g
ON o.gno = g.gno
WHERE o.status = '배송중';
--
--2. 주문 들어온 상품 내역과 고객 정보 출력
select *from ex_order;
SELECT o.orderno , g.gname, g.gdetail, m.name
FROM ex_order o 
INNER JOIN ex_good g ON o.gno = g.gno
INNER JOIN ex_member m ON o.id = m.id
WHERE o.status = '주문';

--3. 주문별로 고객 정보(ID만 출력)와 주문한 상품의 총금액을 출력
SELECT o.ono , m.id,(g.price*o.count) total
FROM ex_order o 
INNER JOIN ex_member m ON o.id = m.id
INNER JOIN ex_good g ON o.gno = g.gno
GROUP BY o.ono , m.id, g.price,o.count;
              
--
--4. [과제] 3번에 주문 내역을 한 개의 상품명 외 몇 개로 출력 
SELECT   o.orderno, g.gname,  o.count
FROM ex_order o 
INNER JOIN ex_member m ON o.id = m.id
INNER JOIN ex_good g ON o.gno = g.gno
GROUP BY o.orderno, g.gname, o.count;
SELECT
    *
FROM emp;



-- [예] 20161212   머리끈 외 1개 