/* 
SELECT �˻��� �׸�� 
FROM    ���̺��
WHERE   ���� ;
*/
DESC EMP;
-- ��� ����� ������ �޿�, �޿��� ���ʽ��� ���� �հ� ��� 
SELECT ename || '' || JOB AS DESIGNER, sal, sal+NVL(comm,0) YEONBONG -- AS YEONBONG AS����
FROM emp; 

-- ������̺��� �μ���ȣ�� ��� 
SELECT ALL deptno FROM emp;
SELECT DISTINCT deptno FROM emp;

-- 1- 20�� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �μ���ȣ ���
SELECT empno, ename, job, mgr FROM emp WHERE deptno =20;
-- 2- �Ի����� 81/01/01���� 81/06/09�� ����� �����ȣ, �̸�, �Ի����� ���
SELECT empno, ename, hiredate FROM emp WHERE  hiredate >= '81/01/01' AND hiredate <= '81/06/09';

-- 3- �������� salesman, clerk�� ������� �̸��� ������ ���
SELECT  ename, job FROM emp WHERE job='SALESMAN' OR job='CLERK';
SELECT  ename, job FROM emp WHERE lower(job)='salesman' OR lower(job)='clerk';

-- 4- ������ president�̰� �޿��� 1500�̻��̰ų� ������ salesman�� ����� ������ ���
SELECT  empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE (sal >=1500) OR (job='SALESMAN');

/*
SELECT �ķ���
FROM ���̺��
WHERE ���ǹ�
ORDER BY ���ı��� ;
*/
-- �μ���ȣ�� ���ĵ� ������̺� ��� 
SELECT *
FROM emp
ORDER BY deptno ASC; -- ASC�������� DESC��������

-- �μ���ȣ�� ���ĵ�  ������ ���������� ������̺� ��� 
SELECT *
FROM emp
ORDER BY deptno ASC , sal DESC; -- ASC�������� DESC��������

--�ֱ� �Ի������ ��� �޿� �Ի����� ���
SELECT ename, sal, hiredate
FROM emp
ORDER BY hiredate DESC;
-- Ŀ�̼��� ���������� ��� 
SELECT *
FROM emp
ORDER BY nvl(comm,0) DESC;


-- 6- Ŀ�̼�(comm)�� ���� ����� �̸�, �޿�, Ŀ�̼��� ���
SELECT ename, sal, comm
FROM emp
WHERE nvl(comm,0) =0 ;
-- 8- �̸� A�� �����ϴ� ����� ���
SELECT ename
FROM emp
WHERE ENAME LIKE 'A%';
-- 9- �̸��� �ι�° ���ڰ� L�� ����� ���
SELECT ename
FROM emp
WHERE ename like '_L%';
-- 10- �̸��� L�� �� �� �̻� ���Ե� ����� ���
SELECT ename
FROM emp
WHERE ENAME LIKE '%L%L%';
-- 11- Ŀ�̼�(COMM)�� NULL�� �ƴ� ����� ��� ������ ���
SELECT *
FROM emp
WHERE COMM IS NOT NULL;


-- 12- ���ʽ��� �޿����� 10%�� ���� ��� ����� ���� �̸�, �޿�, ���ʽ��� ���
SELECT *
FROM emp
WHERE SAL+COMM >= (1.1)*SAL;

-- 13- ������ clerk�̰ų� analyst�̰� �޿��� 1000, 3000, 5000�� �ƴ� ��� ����� ������ ���
SELECT *
FROM emp
WHERE (JOB ='CLERK' OR JOB = 'ANALYST' ) AND (SAL !=1000 AND SAL !=3000 AND SAL !=5000);
-- WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000, 3000, 5000); 

-- 14- �μ��� 30�̰ų� �Ǵ� �����ڰ� 7782�� ����� ��� ������ ���
SELECT *
FROM emp
WHERE DEPTNO =30 OR MGR='7782';




