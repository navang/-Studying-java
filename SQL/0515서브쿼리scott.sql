
--1. SCOTT�� �޿����� ���� ����� ������ �����ȣ, �̸�, ������, �޿��� ���
--2. 30�� �μ��� �ּ� �޿����� ���μ��� �ּ� �޿��� ���� �μ��� ���
--3. �������� ��� �޿� �߿��� ���� ���� �޿��� ���� ������ ���
select empno, ename, job, sal 
FROM emp
WHERE sal IN (SELECT min(sal) FROM emp GROUP BY job);

select job, min(sal) FROM emp GROUP BY job;

select EMPNO, ename , job, sal
FROM emp 
where (job,sal) IN( select job, min(sal) from emp group by job);
-- 10�� �μ�������� ������ ������ ������ �˻�
select job from emp where Deptno = 10;

select *
from emp
where job = ANY(select job from emp where deptNo=10);
-- 30�� �μ����� �ּұ޿��� �޴� ������� ���� �޿��� �޴� ����� �������
SELECT min(sal) FROM emp group by deptno ; 

select *
from emp
where sal > any (select min(sal) from emp where deptno=10);

select *
from emp
where job in (select job from emp where deptno=10);

------------- ��� �Ѹ��� ������κ��� ���� ���� ���ִ� ����� ������ �����ȣ, �̸� ,������ ����� 
SELECT e.empno, e.ename , e.job 
FROM emp e
WHERE exists (SELECT * FROM emp e2 WHERE e.empno=e2.mgr);
--- ���Ʒ� ���� �ݴ� ���� ���ϰ� �ִ� ����, �Ʒ��� ���ϰ� ���� ���� 
-- ��縸 �ִ� �������� �˻�
SELECT e.empno, e.ename , e.job 
FROM emp e
WHERE not exists (SELECT * FROM emp e2 WHERE e.empno=e2.mgr);
--4. �����ȣ�� 7521�� ������ ���� ��� 7934�� �������� �޿��� ���� �޴� ����� ������ ���
--5. ������ ��MANAGER���� ����� ������ �̸�, ����, �μ���, �ٹ����� ���
--6. 'WARD'�� �μ��� ������ ���� ��� ��� ���







----------------------------------------
--(1) �μ��� �޿���� ���̺� ���� 
drop table stat_salary;
creatE TABLE stat_salary (
                stat_date   date  not  null,  -- ��¥
                dept_no   number,      --�μ�
                emp_count number,      --�����
                tot_salary number,        --�޿��Ѿ�
                avg_salary number );     -- �޿����
    --(2) ��¥�� �μ���ȣ �Է�
    
    INSERT INTO stat_salary ( stat_date, dept_no)
    SELECT sysdate, deptno FROM dept;
    
    select * from stat_salary;
--(3) �����, �޿��Ѿ�, ��ձ޿� �Է�(?) -> ����
UPDATE stat_salary s
SET     ( S.EMP_COUNT, S.TOT_SALARY, S.AVG_SALARY)
        = (SELECT COUNT(*), SUM(SAL), AVG(SAL) FROM EMP E WHERE E.DEPTNO = S.DEPT_NO GROUP BY DEPTNO);
        
        DROP TABLE EMP_COPY;
        CREATE TABLE  emp_copy AS select * from emp;
        
        SELECT * FROM EMP_COPY;
        
    -- 1, SCOTT�� ������ �޿��� JONES �� ������ �޿��� ����
    SELECT DEPTNO, SAL
    FROM EMP_COPY 
    WHERE ENAME='JONES';
    
    UPDATE EMP_COPY e
    SET   ( e.job, e.sal)
        = (SELECT job, e2.sal FROM EMP_COPY e2 WHERE e2.ENAME='SCOTT') 
   WHERE e.ENAME='JONES';
        
    -- 2. �μ����� SALES�� ����� ������ ���� 
DELETE FROM EMP_COPY WHERE DEPTNO = ( SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

--3.  King���� �����ϴ� ��� ����� �̸��� �޿��� ���
select *
from emp e , dept
where mgr_id = king;

--4. ������ 30�� �μ��� ���� ���޺��� ���� ������� ���


--5. 10�� �μ��� ������ �� 30�� �μ��� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ���





-----------------------------------------------------------------------------------

CREATE OR REPLACE VIEW v_emp AS 
                select empno, ename, deptno from emp; 
                
                select * from emp;          -- ���� ���̺�
                select * from v_emp;        -- �������̺� 
                
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '�ͽ���' , 30);
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '�����' , 30);  -- ���� ���̺��� PK ���� 
                INSERT INTO v_emp(empno, ename, deptno) VALUES(7777, '�����' , 60);  -- ���� ���̺��� FK ����
                
                ----�б� ���� �� ����
CREATE OR REPLACE VIEW v_emp AS
            select empno, ename, deptno from emp
            with read only;
                
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '�ͽ���' , 30); -- �б����� 
                
INSERT INTO v_emp(empno, ename, deptno) VALUES(7777, '�ڽ���' , 20);

-- ��� ��ȣ, �����, �μ��� -> V_EMP_INFO 
CREATE OR REPLACE VIEW v_EMP_INFO AS
            select e.empno empno, e.ename ename, d.dname dname from emp e, dept d 
            WHERE e.deptno = d.deptno;
            
            select * from v_emp_info;
            
            INSERT INTO V_EMP_INFO AS(empno, ename , dname) VALUES (7777, '�ڽ���' , 20); -- join �� ���� ���̺� ���� �Է� �Ұ� 
            
            
--      [ ���� ] �μ����� �μ���, �ּұ޿�, �ִ�޿�, �μ��� ��� �޿��� �����ϴ� DEPT_SUM �並�����Ͽ���.  

CREATE OR REPLACE VIEW DEPT_SUM AS
            select d.dname, e.DEPTNO DEPTNO, MIN(E.SAL) MIN, MAX(E.SAL) MAX, ROUND(AVG(E.SAL)) AVG from emp e, dept d 
            WHERE e.deptno = d.deptno
            GROUP BY d.dname, e.deptno;

SELECT * FROM dept_sum;

INSERT INTO emp(empno, ename, sal, deptno ) VALUES (8890, '����ȫ' , 10300, 20); 

----------------------------------------------------------------------------------------------

--������ 
CREATE SEQUENCE seq_emp_empno
              start with 5000;

INSERT INTO emp(empno, ename, deptno) VALUES(seq_emp_empno.nextval, 'ȫ3', 10);
SELECT  * FROM emp;

select seq_emp_empno.currval FROM dual;


