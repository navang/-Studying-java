-- ����� , �޿�, ���� ( �޿� /12) �� ����ϵ� ������ �ʴ������� �ݿø��Ͽ� ��� 


SELECT ename , sal , round(sal/12,-2) "����"
FROM    emp; 


    -- �����  , �޿�, ���� (�޿��� 3,3%) �� ������ �����ϰ� ��� 
desc emp;

SELECT ename , sal ,round(sal*0.967,-1) "����", trunk(sal*0.033,-1) as "����"
FROM    emp; 
desc emp;
SELECT
    *
FROM emp;
 -- smith�������� �����ȣ, ����, ������(�ҹ���) ���
 SELECT empno, ename, lower(job) as job
 FROM emp
WHERE ename like 'SMITH'
ORDER BY empno;
 
-- �����ȣ, �����(ù���ڸ� �빮��), ������(ù���ڸ��빮��)�� ���
 SELECT empno, initcap(ename)as ename, initcap(job)  as job
 FROM emp
ORDER BY empno;
-- �̸��� ù���ڰ� ��K������ũ�� ��Y������ ���� ����� ����( �����ȣ, �̸�, ����, �޿�, �μ���ȣ)�� ����ϵ� �̸������� ����
 SELECT empno, job, sal, deptno
 FROM emp
 WHERE SUBSTR(ename,1,1) <'Y' AND SUBSTR(ename,1,1) > 'K'
ORDER BY ename;
-- �̸��� 5���� �̻��λ������ ���
 SELECT empno, job, sal, deptno
 FROM emp
 WHERE LENGTH(ename) >=5
ORDER BY ename;
-- �̸��� 15�ڷ� ���߰���ڴ� ���ʿ� �����ʿ��� ��*���� ä���
SELECT RPAD(ename , 15, '*')  AS NAME
FROM emp
;
-- ������ 10�ڷ� ���߰���ڴ� �����ʿ� ���ʿ� ��-���� ä���
SELECT  LPAD(sal, 1O, '-') AS SAL
 FROM emp
;
 ---------------------------------------------------
--������� �ٹ��� ���� ������ ��������� ��� 
SELECT *
FROM emp
ORDER BY sysdate - nvl(hiredate,sysdate) DESC;

-- ���� ��¥���� ���ƿ��� '��'���� ��¥ ���ϱ� 
SELECT next_day(sysdate,'��') FROM DUAL;
-- 5���� ������ ��
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-- ������� �ٹ��� ���� �� �� �� ���ΰ��� ���
SELECT ename, hiredate, trunc(sysdate-hiredate)  total_day,
trunc((sysdate-hiredate)/7) weeks, ceil(mod(sysdate-hiredate,7)) days
FROM emp;
         
  
-- �Ի����ڿ��� �Ի�⵵�� ���
SELECT ename, hiredate, to_char(hiredate, 'YYYY') hireyear 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'MM') hireMONTH 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'DD') hireDAY 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'hh:mi') hireDAY 
FROM emp; 

-- �Ի����ڸ� ��1999�� 1�� 1�ϡ� �������� ���
SELECT ename, hiredate, to_char(hiredate, 'YYYY"��"MM"��"DD"��"') hireDAY 
FROM emp; 
 

-- 1981�⵵�� �Ի��� ��� �˻�
SELECT *
FROM emp
WHERE to_char(hiredate, 'YYYY')=1981;

-- 5���� �Ի��� ��� �˻�
SELECT *
FROM emp
WHERE to_char(hiredate, 'MM') =5 ;
 
-- �޿� �տ� $�� �����ϰ� 3�ڸ� ���� ,�� ���      

-- 10�� �μ��� ����� ��������� �ٹ� ������ ���
SELECT ename, trunc( months_between (sysdate,hiredate))
FROM emp
WHERE deptno=10;

SELECT   '-' || trim(' �̼��� ')|| '-' as col1,
         '-'|| ltrim(' �̼��� ') || '-' as col2,
         '-'|| rtrim(' �̼��� ') || '-' as col3 
         
         from dual;


select sysdate from dual;

-- ������ ���ڿ��� �������̻�����ĥ�ȱ��� ���ڷ� ��ü
SELECT translate(sal, '0123456789', '�����̻�����ĥ�ȱ�')
FROM EMP;

-- ������ ���ڿ��� 0����$���� �ٲپ� ���
SELECT 
REPLACE(' ��  ��  �� ', ' ', '')
FROM DUAL;

SELECT translate(sal, '0123456789', '9578621430')
FROM emp;

SELECT translate(sal, '9578621430', '0123456789')
FROM emp;


