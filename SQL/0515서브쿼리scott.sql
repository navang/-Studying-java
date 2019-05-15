
--1. SCOTT의 급여보다 많은 사원의 정보를 사원번호, 이름, 담당업무, 급여를 출력
--2. 30번 부서의 최소 급여보다 각부서의 최소 급여가 높은 부서를 출력
--3. 업무별로 평균 급여 중에서 가장 적은 급여를 가진 직업을 출력
select empno, ename, job, sal 
FROM emp
WHERE sal IN (SELECT min(sal) FROM emp GROUP BY job);

select job, min(sal) FROM emp GROUP BY job;

select EMPNO, ename , job, sal
FROM emp 
where (job,sal) IN( select job, min(sal) from emp group by job);
-- 10번 부서사원들의 업무와 동일한 직원들 검색
select job from emp where Deptno = 10;

select *
from emp
where job = ANY(select job from emp where deptNo=10);
-- 30번 부서별로 최소급여를 받는 사원보다 많은 급여를 받는 사원의 정보출력
SELECT min(sal) FROM emp group by deptno ; 

select *
from emp
where sal > any (select min(sal) from emp where deptno=10);

select *
from emp
where job in (select job from emp where deptno=10);

------------- 적어도 한명의 사원으로부터 보고를 받을 수있는 사원의 정보를 사원번호, 이름 ,업무를 ㅂ출력 
SELECT e.empno, e.ename , e.job 
FROM emp e
WHERE exists (SELECT * FROM emp e2 WHERE e.empno=e2.mgr);
--- 위아래 쿼리 반대 위는 부하가 있는 직원, 아래는 부하가 없는 직원 
-- 상사만 있는 직원들을 검색
SELECT e.empno, e.ename , e.job 
FROM emp e
WHERE not exists (SELECT * FROM emp e2 WHERE e.empno=e2.mgr);
--4. 사원번호가 7521의 업무와 같고 사번 7934인 직원보다 급여를 많이 받는 사원의 정보를 출력
--5. 업무가 ‘MANAGER’인 사원의 정보를 이름, 업무, 부서명, 근무지를 출력
--6. 'WARD'와 부서와 업무가 같은 사원 명단 출력







----------------------------------------
--(1) 부서별 급여통계 테이블 생성 
drop table stat_salary;
creatE TABLE stat_salary (
                stat_date   date  not  null,  -- 날짜
                dept_no   number,      --부서
                emp_count number,      --사원수
                tot_salary number,        --급여총액
                avg_salary number );     -- 급여평균
    --(2) 날짜와 부서번호 입력
    
    INSERT INTO stat_salary ( stat_date, dept_no)
    SELECT sysdate, deptno FROM dept;
    
    select * from stat_salary;
--(3) 사원수, 급여총액, 평균급여 입력(?) -> 수정
UPDATE stat_salary s
SET     ( S.EMP_COUNT, S.TOT_SALARY, S.AVG_SALARY)
        = (SELECT COUNT(*), SUM(SAL), AVG(SAL) FROM EMP E WHERE E.DEPTNO = S.DEPT_NO GROUP BY DEPTNO);
        
        DROP TABLE EMP_COPY;
        CREATE TABLE  emp_copy AS select * from emp;
        
        SELECT * FROM EMP_COPY;
        
    -- 1, SCOTT의 업무와 급여로 JONES 의 업무와 급여를 수정
    SELECT DEPTNO, SAL
    FROM EMP_COPY 
    WHERE ENAME='JONES';
    
    UPDATE EMP_COPY e
    SET   ( e.job, e.sal)
        = (SELECT job, e2.sal FROM EMP_COPY e2 WHERE e2.ENAME='SCOTT') 
   WHERE e.ENAME='JONES';
        
    -- 2. 부서명이 SALES인 사원의 정보를 삭제 
DELETE FROM EMP_COPY WHERE DEPTNO = ( SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

--3.  King에게 보고하는 모든 사원의 이름과 급여를 출력
select *
from emp e , dept
where mgr_id = king;

--4. 월급이 30번 부서의 최저 월급보다 많은 사원들을 출력


--5. 10번 부서의 직원들 중 30번 부서의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력





-----------------------------------------------------------------------------------

CREATE OR REPLACE VIEW v_emp AS 
                select empno, ename, deptno from emp; 
                
                select * from emp;          -- 원본 테이블
                select * from v_emp;        -- 가상테이블 
                
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '맹심이' , 30);
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '콩심이' , 30);  -- 원본 테이블의 PK 오류 
                INSERT INTO v_emp(empno, ename, deptno) VALUES(7777, '뱍심이' , 60);  -- 원본 테이블의 FK 오류
                
                ----읽기 전용 뷰 생성
CREATE OR REPLACE VIEW v_emp AS
            select empno, ename, deptno from emp
            with read only;
                
                INSERT INTO v_emp(empno, ename, deptno) VALUES(8888, '맹심이' , 30); -- 읽기전용 
                
INSERT INTO v_emp(empno, ename, deptno) VALUES(7777, '박심이' , 20);

-- 사원 번호, 사원명, 부서명 -> V_EMP_INFO 
CREATE OR REPLACE VIEW v_EMP_INFO AS
            select e.empno empno, e.ename ename, d.dname dname from emp e, dept d 
            WHERE e.deptno = d.deptno;
            
            select * from v_emp_info;
            
            INSERT INTO V_EMP_INFO AS(empno, ename , dname) VALUES (7777, '박심이' , 20); -- join 된 여러 테이블에 동시 입력 불가 
            
            
--      [ 연습 ] 부서별로 부서명, 최소급여, 최대급여, 부서의 평균 급여를 포함하는 DEPT_SUM 뷰를생성하여라.  

CREATE OR REPLACE VIEW DEPT_SUM AS
            select d.dname, e.DEPTNO DEPTNO, MIN(E.SAL) MIN, MAX(E.SAL) MAX, ROUND(AVG(E.SAL)) AVG from emp e, dept d 
            WHERE e.deptno = d.deptno
            GROUP BY d.dname, e.deptno;

SELECT * FROM dept_sum;

INSERT INTO emp(empno, ename, sal, deptno ) VALUES (8890, '레드홍' , 10300, 20); 

----------------------------------------------------------------------------------------------

--시퀀스 
CREATE SEQUENCE seq_emp_empno
              start with 5000;

INSERT INTO emp(empno, ename, deptno) VALUES(seq_emp_empno.nextval, '홍3', 10);
SELECT  * FROM emp;

select seq_emp_empno.currval FROM dual;


