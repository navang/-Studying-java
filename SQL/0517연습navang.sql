create table ex_member(
id varchar2(10), -- ���̵�  pk 
pass varchar2(10) not null, -- �н����� not null
name varchar2(20) not null, -- �̸� not null 
tel varchar2(20), -- ��ȭ��ȣ  
addr varchar2(100) -- �ּ�

);



-- ��ǰ ���̺�
create table ex_good(
gno varchar2(10), -- ��ǰ��ȣ pk 
gname varchar(30) not null, -- ��ǰ��  not null
gdetail varchar2(300), -- �󼼼���
price number);  -- ����

-- �ֹ� ���̺�
create table ex_order (
ono number,  -- ��ȣ 
orderno varchar2(20), -- �ֹ���ȣ pk
gno varchar2(10), -- ��ǰ��ȣ fk 
id varchar2(10), -- ȸ�� ���̵� fk
count number,  -- ����
status varchar2(10) -- ��ۻ���
);

create sequence seq_order_ono;

-----------------------------------------------------------
-- 1. �ֹ����̺�� ȸ�����̺�, ��ǰ���̺��� ���踦 �δ´ٸ�?

SELECT  * FROM ex_member;
drop table ex_member;
SELECT  * FROM ex_good;
drop table ex_good;
SELECT  * FROM ex_order;
drop table ex_order;
-- pk �ο�
ALTER  TABLE   ex_member
ADD CONSTRAINT  pk_member PRIMARY KEY(id);
ALTER  TABLE   ex_good
ADD CONSTRAINT  pk_good PRIMARY KEY(gno);
ALTER  TABLE   ex_order
ADD CONSTRAINT  pk_order PRIMARY KEY(orderno);
-- fk �ο�
ALTER TABLE ex_order
ADD CONSTRAINT  fk_order_id  FOREIGN KEY (id) REFERENCES      ex_member  (id);
ALTER TABLE ex_order
ADD CONSTRAINT  fk_order_gno FOREIGN KEY (gno)  REFERENCES      ex_good  (gno);




-- ȸ�� ���̺� ����Ÿ �Է�
insert into ex_member(id, pass, name, tel, addr )
values('kim', '1111', '��浿', '02-222-2222','���� ������ �̻۵�'); -- in

insert into ex_member(id, pass, name, tel, addr )
values('park', '1111', '�ڱ浿', '03-333-3333','��õ ������ �̻۵�'); --in

insert into ex_member(id, pass, name, tel, addr )
values('meng', '1111', '�ͱ浿', '04-444-4444','��� ������ �̻۵�'); --in

commit;

-- ���� ���̺� ����Ÿ �Է�
insert into ex_good( gno, gname, gdetail, price )
values('1001', '�Ӹ���', '���� ��� �Ӹ���', 200 ); --in


insert into ex_good( gno, gname, gdetail, price )
values('2002', '������-A', '������� ������ �޸��� ������', 10000 ); --in

insert into ex_good( gno, gname, gdetail, price )
values('2010', '������-B', '���� ������� ������ �����ϰ� �޸��ٴ� ������', 20000 ); --in

insert into ex_good( gno, gname, gdetail, price )
values('3333', '�ڵ������̽�', '�ΰ� �����ϴ� �ڵ��� ���̽�', 1500 ); --in

commit;



-- �ֹ� ���̺� ����Ÿ �Է�

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161212', '1001', 'park', 1, '��ۿϷ�'); --in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161212', '2010', 'park', 1, '�����'); --pk order ����

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161111', '1001', 'kim', 2, '�ֹ�'); -- in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20161111', '3333', 'kim', 3, '�ֹ�'); --pk order ����

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '1001', 'park', 3, '�ֹ�'); --in

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '2010', 'park', 1, '�����'); -- pk order

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20163333', '2002', 'park', 2, '�ֹ�'); -- pk order

insert into ex_order( ono, orderno, gno, id, count, status )
values( seq_order_ono.nextval, '20165050', '1001', 'meng', 1, '�����'); -- in 

commit;
---------------------------------------------------------------------------

--1. ������� �ֹ� ������ ��ǰ ���� ���
select *from ex_order;
SELECT o.orderno , o.status, g.gdetail
FROM ex_order o INNER JOIN ex_good g
ON o.gno = g.gno
WHERE o.status = '�����';
--
--2. �ֹ� ���� ��ǰ ������ �� ���� ���
select *from ex_order;
SELECT o.orderno , g.gname, g.gdetail, m.name
FROM ex_order o 
INNER JOIN ex_good g ON o.gno = g.gno
INNER JOIN ex_member m ON o.id = m.id
WHERE o.status = '�ֹ�';

--3. �ֹ����� �� ����(ID�� ���)�� �ֹ��� ��ǰ�� �ѱݾ��� ���
SELECT o.ono , m.id,(g.price*o.count) total
FROM ex_order o 
INNER JOIN ex_member m ON o.id = m.id
INNER JOIN ex_good g ON o.gno = g.gno
GROUP BY o.ono , m.id, g.price,o.count;
              
--
--4. [����] 3���� �ֹ� ������ �� ���� ��ǰ�� �� �� ���� ��� 
SELECT   o.orderno, g.gname,  o.count
FROM ex_order o 
INNER JOIN ex_member m ON o.id = m.id
INNER JOIN ex_good g ON o.gno = g.gno
GROUP BY o.orderno, g.gname, o.count;
SELECT
    *
FROM emp;



-- [��] 20161212   �Ӹ��� �� 1�� 