/*�ܰ躰�� ����
1) ���̺� �����
���̺�� : gogek           
Id �����ڿ� ���ڷ� �������� 8�ڱ��� ���� �⺻Ű
name �ѱ� 5�ڱ��� �Է� ���� �ʼ��Է�
tel ��ȭ��ȣ�� ���� ã�� �� ������ �Է����� ���� ���� ����

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
/*           ���̺�� : sangpum
No �����ڿ� ���ڷ� 6�ڸ� �⺻Ű
title ��ǰ��  �ʼ��Է�
Detail ��ǰ�󼼼���
Count ���� ���� �ʼ��Է� 
Price  ��ǰ ����
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
           ���̺�� : jumun
No ���� 4�ڸ� �⺻Ű
gogek �� ���̵� ���� 
Sangpum ��ǰ��ȣ ����
Count �ֹ�����
Jumunil �ֹ��� ��¥
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
--2) ������ �Է� ( �Է½ÿ����� �߻��ϸ� ������ �м��ϼ��� )

INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','ȫ�浿', '031-333-3333' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo1111','��浿', '031-111-1111' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo2222','ȫ�浿', '031-222-2222' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo9999','�ڱ浿', '031-333-3333' ); -- in

INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','�ͱ浿', '031-999-9999' ); -- ���Ἲ ���� ����(HEROES.PK_GOGEK_ID)�� ����˴ϴ�

INSERT INTO gogek ( id, name, tel ) VALUES('babo12345','�̱浿', '031-333-1234' ); -- id �� �ʹ� ŭ 

INSERT INTO gogek ( id, name, tel ) VALUES('123','�ֱ浿', '031-999-9999' );

INSERT INTO gogek ( id, name ) VALUES('babo','���浿' );

INSERT INTO gogek ( id, tel ) VALUES('babo1988','031-888-8888' );

 

 

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00001','�̻۹���', 30, 1000, '�ΰ��̻��� �ݹ� �� �ȸ� �����Դϴ�' );

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00002','�׳ɹ���', 20, 500, '�׳��̻��� ����� �����Դϴ�' );

INSERT INTO sangpum ( no, title, count )VALUES ('B00009','������', 20 );

INSERT INTO sangpum ( no, title, count,price ) VALUES ('Z0001','�����Ʈ', 3, 20000, '�̳� �����Ʈ�Դϴ�' );

INSERT INTO sangpum VALUES ('Z00001','�����Ʈ2', 5, 20000, '�̳� ��� ��Ʈ�Դϴ�' );

INSERT INTO sangpum VALUES ('Z00001','�����Ʈ3','�̳� ��� ��Ʈ�Դϴ�', 5, 20000);

 

 

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1000, 'babo1234', 'A00001', 1, '2016/09/09' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1001, 'babo1233', 'Z00001', 1, '2016/09/09' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1002, 'Babo1234', 'A00002', 2, '2016/09/10' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1003, 'babo1234', 'B00001', 1, '2016/09/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1004, 'babo', 'Z00001', 1, '2016/10/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1005, 'babo1234', 'B00009', 1, '2016/11/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1006, 'babo1234', 'B00009', 1, '2016/12/12' );





--��ȭ��ȣ�� ���� ���� �������� ������ �˻��ϼ���
SELECT  id
FROM gogek
WHERE tel is null
ORDER BY name;

-- ȫ�� ���� ���� ������ ������ �˻��ϼ���
SELECT *
FROM gogek
WHERE REGEXP_LIKE(name,'^ȫ')
ORDER BY name;

--babo2222 ������ �ڱ浿���� �����ϼ��� - �н� 
UPDATE  gogek SET name = '�ڱ浿' WHERE id = 'babo2222';
 
--���̵� 123 ���� ���̵� babo123 ���� �����ϼ���    -- PK
UPDATE  gogek SET id = 'babo2222' WHERE id = '123' ;

--���浿���� ��ȭ��ȣ 02-555-5555�� �߰��ϼ���
UPDATE  gogek SET tel = '02-555-5555' WHERE name = '���浿' ;

--��ǰ��ȣ B00009 �� ���� 1200�� �׸��� ���̳� �ٽ��� ���Դϴ١���� ��ǰ������ �߰��ϼ���
UPDATE  sangpum SET price = '1200' WHERE No = 'B00009' ;
UPDATE  sangpum SET detail = '�̳������� ���Դϴ�' WHERE No = 'B00009' ;
--�̻۹��� ��ǰ�� 10���� �ȷȽ��ϴ�.
UPDATE  sangpum SET count = count-10 WHERE title = '�̻۹���' ;
--Z00001 ��ǰ�� 3���� �� �԰� �Ǿ����ϴ�.
UPDATE  sangpum SET count = count+3 WHERE No = 'Z00001' ;
-- ��ǰ ������ 1000���� �Ѵ� ��ǰ���� �˻��ϼ���
SELECT *
FROM sangpum
WHERE PRICE > '1000'
ORDER BY NO;
--11�� ���Ŀ� �ֹ��� ��ǰ ��ȣ�� �˻��ϼ���
SELECT sangpum
FROM jumun
WHERE Jumunil > '2016/11/01'
ORDER BY NO;
--babo ���� �ֹ��� ��ǰ�� A00002�� �����ϰ� ������ 2���� �����ϼ���
UPDATE jumun SET sangpum = 'A00002' WHERE gogek = 'babo' ;
UPDATE jumun SET count = count+2  WHERE gogek = 'babo' ;

--babo1234 ���� 11���� �ֹ��� ��ǰ ��ȣ�� �˻��ϼ���
SELECT no
FROM jumun
WHERE ( gogek = 'babo1234') and ( jumunil < 2016/12/01 and jumunil >= 2016/11/01 )
ORDER BY NO;
--B00009 ��ǰ�� �ֹ��� �� ���̵� �˻��ϼ���
SELECT gogek
FROM jumun
WHERE  sangpum = 'B00009'
ORDER BY NO;


 