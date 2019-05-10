DESC INFO;
SELECT * FROM INFO;

SELECT NAME, decode ( substr(jumin, 8, 1 ) , 1, '����', 3, '����' , '���� ' ) AS gender
FROM INFO;

SELECT CASE substr(jumin, 8, 1)
            WHEN '1' THEN '����'
            WHEN '3' THEN '����'
            ELSE '����'
        END  as gender
    FROM info;
    
    
SELECT
    *
FROM emp;
-- �μ���ȣ�� 10�̸鿵����, 20�̸� ������, 30�̸� IT�� �� �ܴ� ����η� ���
SELECT  decode ( substr(deptno, 1, 2 ) , 10, '������', 20, '������' , 30, 'IT�� ' , '�����') AS dept
FROM emp;

SELECT CASE substr(deptno, 1, 2)
            WHEN '10' THEN '������'
            WHEN '20' THEN '������'
            WHEN '30' THEN 'IT��'
            ELSE '�����'
        END AS dept
    FROM emp;
          

-- ����(job)�� analyst�̸� �޿� ������ 10%�̰� clerk�̸� 15%, manager�̸� 20%�� ��� �����ȣ, �����, ����, �޿�, ������ �޿��� ���
SELECT empno,ename,sal, sal+(decode(job,'ANALYST',sal*0.1,'CLERK',sal*0.15,'MANAGER',sal*0.2)) as afterpromotion
FROM emp;

SELECT empno,ename,job,sal,
CASE job 
WHEN 'ANALYST' THEN sal+sal*0.1
WHEN 'CLERK' THEN sal+sal*0.15
WHEN 'MANAGER' THEN sal+sal*0.2
END as afterpromotion
FROM emp;


SELECT ROWNUM, empno, ename FROM emp WHERE rownum <=5; 
-- ������ ��SALESMAN���� ������� ������ ���, ����, �ּҰ�, �ִ밪�� ���ϱ�
SELECT avg(sal) avg, sum(sal) sum, min(sal) min, max(sal) max
FROM    emp
WHERE   job='SALESMAN';

--Ŀ�̼�(COMM)�� �޴� ������� ����
SELECT  COUNT(COMM) FROM emp WHERE nvl(comm,0) <>0;      --  !=  <> �����ʴ� 

/*
SELECT columns  
FROM  table_name  
WHERE condition
GROUP BY group_by_expression
HAVING condition
ORDER BY column;
*/
 -- �μ������ο���, ��ձ޿�, �����޿�, �ְ�޿�, �޿��� ���� ���ϱ�
SELECT deptno, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp  
GROUP BY deptno; 
 -- �μ������ο���, ��ձ޿�, �����޿�, �ְ�޿�, �޿��� ���� ���ϱ� (�μ��� �޿��� ���� ���� ������
SELECT deptno, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp  
GROUP BY deptno 
ORDER BY sum DESC;         

 -- �μ��� ������ �׷��Ͽ� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���ϱ�
SELECT deptno, JOB, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp  
GROUP BY deptno , job
order by deptno;  
-- �޿��� �ִ� 2900 �̻��κμ��� ���� �μ���ȣ, ��� �޿�, �޿��� ���� ���
SELECT deptno, count(*) cnt, round(avg(sal)) avg, max(sal) max, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp  
GROUP BY deptno
HAVING MAX(SAL) >= 2900
ORDER BY sum DESC; 

-- ������ �޿��� ����� 3000�̻��� ������ ���� ������, ��� �޿�, �޿��� ���� ���
SELECT job, count(*) cnt, round(avg(sal)) avg, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp  
GROUP BY job 
HAVING AVG(SAL) >= 3000
ORDER BY JOB;

-- ��ü �հ� �޿��� 5000���ʰ��ϴ� �� ������ ���ؼ� ������ �޿� �հ踦 ���
SELECT deptno, count(*) cnt, round(avg(sal)) avg, sum(sal) sum    --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp 
WHERE JOB <> 'SALESMAN'
GROUP BY deptno
HAVING SUM(SAL)>5000
ORDER BY SUM(SAL) DESC;
��, SALESMAN�������ϰ� �޿� �հ谡 ���� ������ ����

--  �������ְ� �޿��� �ּ� �޿��� ���̸� ���϶�
SELECT deptno, count(*) cnt, max(sal) max ,  min(sal) min, MAX(SAL)-MIN(SAL) --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp
WHERE SAL >0
GROUP BY deptno;
 

-- �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���

 SELECT deptno, count(*) cnt, max(sal) max ,  min(sal) min, MAX(SAL)+MIN(SAL) sum --�����Լ��� �ش� �׷���� �÷��� ����
FROM  emp
GROUP BY deptno
HAVING COUNT(*) >4;


