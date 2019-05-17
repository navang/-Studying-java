/*
ACCEPT p_dan PROMPT  '구구단 단을 입력 : '
DECLARE
  v_dan   INTEGER := &p_dan;
cnt     INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
        cnt := v_dan * i;
        dbms_output.put_line( v_dan || ' * ' || i || ' = ' || cnt );
    END LOOP; 
END;

--2.1부터100까지의 홀수의 합과 짝수의 합을 출력

DECLARE
  v_odd   INTEGER :=0;
  v_even   INTEGER:=0;

BEGIN

    FOR i IN 1..100 LOOP
        IF i mod 2 = 0 THEN v_even := v_even + i;
        ELSE v_odd := v_odd + i ;
        END IF;
    END LOOP; 

        dbms_output.put_line( '짝수의 합 :' || v_even);
        dbms_output.put_line( '홀수의 합 :' || v_odd);
 END;
 
 */
 -- 부서 번호를 입력받아 사원번호 , 이름, 급여를 출력
 
 set serveroutput on;
-- ACCEPT p_deptno PROMPT '부서번호?'

 
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
--연습문제 

--[ scott 계정 ]
select * from emp;
--1. 업무가 jones와 같거나 월급이 ford의 월급 이상인 사원의 정보를 이름, 업무, 부서번호, 급여를 출력  
select *
from emp
where JOB = ANY (select JOB from emp where ename='JONES');
select *
from emp
where SAL > ANY (select SAL from emp where ename='FORD');
-- 단, 업무별, 월급이 많은 순으로
--1 답안 
select ename , job, deptno, sal
from emp
where JOB = ANY (select JOB from emp where ename='JONES')
    OR SAL > ANY (select SAL from emp where ename='FORD')
ORDER BY SAL DESC;

--2. scott 또는 ward와 월급이 같은 사원의 정보를 이름, 업무, 급여를 출력
select ename , job,  sal
from emp
where sal = ALL (select sal from emp where ename='SCOTT')
    OR SAL = ALL (select SAL from emp where ename='WARD')
ORDER BY SAL DESC;
--3. chicago에서 근무하는 사원과 같은 업무를 하는 사원의 이름, 업무를 출력
select * from dept;

SELECT ename, job
FROM emp
WHERE job = any (
            SELECT e.job
            FROM  emp e INNER JOIN dept d
            ON e.deptno = d.deptno
            WHERE loc = 'CHICAGO');

--4. 부서별로 월급이 평균 월급보다 높은 사원을 부서번호, 이름, 급여를 출력
SELECT deptno, ename, sal
FROM emp
where SAL > any (
                SELECT round(avg(sal)) avg
                FROM EMP
                group by deptno 
                 ) 
ORDER BY DEPTNO;
--5. 말단 사원의 사번, 이름, 업무, 부서번호를 출력

SELECT e1.empno, e1.ename, e1.job, e1.deptno
FROM emp e1
WHERE not EXISTS (SELECT * FROM emp e2 where e1.empno = e2.mgr); -- 사원번호가 누군가의 MGR이 아닐때 






