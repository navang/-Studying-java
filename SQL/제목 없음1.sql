/* 
SELECT 검색할 항목들 
FROM    테이블명
WHERE   조건 ;
*/
DESC EMP;
-- 모든 사원의 사원명과 급여, 급여와 보너스를 더한 합계 출력 
SELECT ename || '' || JOB AS DESIGNER, sal, sal+NVL(comm,0) YEONBONG -- AS YEONBONG AS생략
FROM emp; 

-- 사원테이블에서 부서번호를 출력 
SELECT ALL deptno FROM emp;
SELECT DISTINCT deptno FROM emp;

-- 1- 20번 부서에서 근무하는 사원의 사원번호, 이름, 부서번호 출력
SELECT empno, ename, job, mgr FROM emp WHERE deptno =20;
-- 2- 입사일이 81/01/01에서 81/06/09인 사원의 사원번호, 이름, 입사일을 출력
SELECT empno, ename, hiredate FROM emp WHERE  hiredate >= '81/01/01' AND hiredate <= '81/06/09';

-- 3- 담당업무가 salesman, clerk인 사원들의 이름과 업무를 출력
SELECT  ename, job FROM emp WHERE job='SALESMAN' OR job='CLERK';
SELECT  ename, job FROM emp WHERE lower(job)='salesman' OR lower(job)='clerk';

-- 4- 업무가 president이고 급여가 1500이상이거나 업무가 salesman인 사원의 정보를 출력
SELECT  empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE (sal >=1500) OR (job='SALESMAN');

/*
SELECT 컴럼명
FROM 테이블명
WHERE 조건문
ORDER BY 정렬기준 ;
*/
-- 부서번호로 정렬된 사원테이블 출력 
SELECT *
FROM emp
ORDER BY deptno ASC; -- ASC오름차순 DESC내림차순

-- 부서번호로 정렬된  월급이 높은순으로 사원테이블 출력 
SELECT *
FROM emp
ORDER BY deptno ASC , sal DESC; -- ASC오름차순 DESC내림차순

--최근 입사순으로 사원 급여 입사일자 출력
SELECT ename, sal, hiredate
FROM emp
ORDER BY hiredate DESC;
-- 커미션이 높은순으로 출력 
SELECT *
FROM emp
ORDER BY nvl(comm,0) DESC;


-- 6- 커미션(comm)이 없는 사원의 이름, 급여, 커미션을 출력
SELECT ename, sal, comm
FROM emp
WHERE nvl(comm,0) =0 ;
-- 8- 이름 A로 시작하는 사원명 출력
SELECT ename
FROM emp
WHERE ENAME LIKE 'A%';
-- 9- 이름이 두번째 문자가 L인 사원명 출력
SELECT ename
FROM emp
WHERE ename like '_L%';
-- 10- 이름에 L이 두 번 이상 포함된 사원명 출력
SELECT ename
FROM emp
WHERE ENAME LIKE '%L%L%';
-- 11- 커미션(COMM)이 NULL이 아닌 사원의 모든 정보를 출력
SELECT *
FROM emp
WHERE COMM IS NOT NULL;


-- 12- 보너스가 급여보다 10%가 많은 모든 사원에 대해 이름, 급여, 보너스를 출력
SELECT *
FROM emp
WHERE SAL+COMM >= (1.1)*SAL;

-- 13- 업무가 clerk이거나 analyst이고 급여가 1000, 3000, 5000이 아닌 모든 사원의 정보를 출력
SELECT *
FROM emp
WHERE (JOB ='CLERK' OR JOB = 'ANALYST' ) AND (SAL !=1000 AND SAL !=3000 AND SAL !=5000);
-- WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000, 3000, 5000); 

-- 14- 부서가 30이거나 또는 관리자가 7782인 사원의 모든 정보를 출력
SELECT *
FROM emp
WHERE DEPTNO =30 OR MGR='7782';




