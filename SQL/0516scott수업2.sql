/*
ACCEPT p_dan PROMPT  '������ ���� �Է� : '
DECLARE
  v_dan   INTEGER := &p_dan;
cnt     INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
        cnt := v_dan * i;
        dbms_output.put_line( v_dan || ' * ' || i || ' = ' || cnt );
    END LOOP; 
END;

--2.1����100������ Ȧ���� �հ� ¦���� ���� ���

DECLARE
  v_odd   INTEGER :=0;
  v_even   INTEGER:=0;

BEGIN

    FOR i IN 1..100 LOOP
        IF i mod 2 = 0 THEN v_even := v_even + i;
        ELSE v_odd := v_odd + i ;
        END IF;
    END LOOP; 

        dbms_output.put_line( '¦���� �� :' || v_even);
        dbms_output.put_line( 'Ȧ���� �� :' || v_odd);
 END;
 
 */
 -- �μ� ��ȣ�� �Է¹޾� �����ȣ , �̸�, �޿��� ���
 
 set serveroutput on;
-- ACCEPT p_deptno PROMPT '�μ���ȣ?'

 
 DECLARE
    v_deptno    emp.deptno%type := 20;
    v_empno    emp.empno%type;
    v_ename    emp.ename%type;
    v_sal    emp.sal%type;
    CURSOR emp_cursor IS SELECT empno, ename, sal FROM emp WHERE deptno=20 ORDER BY ename;
BEGIN
    OPEN emp_cursor;
    LOOP
    DBMS_OUTPUT.PUT_line('00');
        FETCH emp_cursor INTO v_empno, v_ename, v_sal;
                DBMS_OUTPUT.PUT_line(lpad(v_empno, 6) || lpad(v_ename, 10) || lpad(v_sal, 10));
        EXIT WHEN emp_cursor%NOTFOUND;

    END LOOP;
    CLOSE emp_cursor;
END;
/    

--------------------------------------------------------------------
--�������� 

--[ scott ���� ]
select * from emp;
--1. ������ jones�� ���ų� ������ ford�� ���� �̻��� ����� ������ �̸�, ����, �μ���ȣ, �޿��� ���  
select *
from emp
where JOB = ANY (select JOB from emp where ename='JONES');
select *
from emp
where SAL > ANY (select SAL from emp where ename='FORD');
-- ��, ������, ������ ���� ������
--1 ��� 
select ename , job, deptno, sal
from emp
where JOB = ANY (select JOB from emp where ename='JONES')
    OR SAL > ANY (select SAL from emp where ename='FORD')
ORDER BY SAL DESC;

--2. scott �Ǵ� ward�� ������ ���� ����� ������ �̸�, ����, �޿��� ���
select ename , job,  sal
from emp
where sal = ALL (select sal from emp where ename='SCOTT')
    OR SAL = ALL (select SAL from emp where ename='WARD')
ORDER BY SAL DESC;
--3. chicago���� �ٹ��ϴ� ����� ���� ������ �ϴ� ����� �̸�, ������ ���
select * from dept;

SELECT ename, job
FROM emp
WHERE job = any (
            SELECT e.job
            FROM  emp e INNER JOIN dept d
            ON e.deptno = d.deptno
            WHERE loc = 'CHICAGO');

--4. �μ����� ������ ��� ���޺��� ���� ����� �μ���ȣ, �̸�, �޿��� ���
SELECT deptno, ename, sal
FROM emp
where SAL > any (
                SELECT round(avg(sal)) avg
                FROM EMP
                group by deptno 
                 ) 
ORDER BY DEPTNO;
--5. ���� ����� ���, �̸�, ����, �μ���ȣ�� ���

SELECT e1.empno, e1.ename, e1.job, e1.deptno
FROM emp e1
WHERE not EXISTS (SELECT * FROM emp e2 where e1.empno = e2.mgr); -- �����ȣ�� �������� MGR�� �ƴҶ� 






