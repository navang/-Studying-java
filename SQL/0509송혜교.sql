DESC INFO;
SELECT * FROM INFO;

SELECT NAME, decode ( substr(jumin, 8, 1 ) , 1, '남자', 3, '남자' , '여자 ' ) AS gender
FROM INFO;

SELECT CASE substr(jumin, 8, 1)
            WHEN '1' THEN '남자'
            WHEN '3' THEN '남자'
            ELSE '여자'
        END  as gender
    FROM info;
    
    
SELECT
    *
FROM emp;
-- 부서번호가 10이면영업부, 20이면 관리부, 30이면 IT부 그 외는 기술부로 출력
SELECT  decode ( substr(deptno, 1, 2 ) , 10, '영업부', 20, '관리부' , 30, 'IT부 ' , '기술부') AS dept
FROM emp;

SELECT CASE substr(deptno, 1, 2)
            WHEN '10' THEN '영업부'
            WHEN '20' THEN '관리부'
            WHEN '30' THEN 'IT부'
            ELSE '기술부'
        END AS dept
    FROM emp;
          

-- 업무(job)이 analyst이면 급여 증가가 10%이고 clerk이면 15%, manager이면 20%인 경우 사원번호, 사원명, 업무, 급여, 증가한 급여를 출력
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
-- 업무가 ‘SALESMAN’인 사람들의 월급의 평균, 총합, 최소값, 최대값을 구하기
SELECT avg(sal) avg, sum(sal) sum, min(sal) min, max(sal) max
FROM    emp
WHERE   job='SALESMAN';

--커미션(COMM)을 받는 사람들의 수는
SELECT  COUNT(COMM) FROM emp WHERE nvl(comm,0) <>0;      --  !=  <> 같지않다 

/*
SELECT columns  
FROM  table_name  
WHERE condition
GROUP BY group_by_expression
HAVING condition
ORDER BY column;
*/
 -- 부서별로인원수, 평균급여, 최저급여, 최고급여, 급여의 합을 구하기
SELECT deptno, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp  
GROUP BY deptno; 
 -- 부서별로인원수, 평균급여, 최저급여, 최고급여, 급여의 합을 구하기 (부서별 급여의 합이 높은 순으로
SELECT deptno, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp  
GROUP BY deptno 
ORDER BY sum DESC;         

 -- 부서별 업무별 그룹하여 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하기
SELECT deptno, JOB, count(*) cnt, round(avg(sal)) avg, min(sal) min, max(sal) max, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp  
GROUP BY deptno , job
order by deptno;  
-- 급여가 최대 2900 이상인부서에 대해 부서번호, 평균 급여, 급여의 합을 출력
SELECT deptno, count(*) cnt, round(avg(sal)) avg, max(sal) max, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp  
GROUP BY deptno
HAVING MAX(SAL) >= 2900
ORDER BY sum DESC; 

-- 업무별 급여의 평균이 3000이상인 업무에 대해 업무명, 평균 급여, 급여의 합을 출력
SELECT job, count(*) cnt, round(avg(sal)) avg, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp  
GROUP BY job 
HAVING AVG(SAL) >= 3000
ORDER BY JOB;

-- 전체 합계 급여가 5000를초과하는 각 업무에 대해서 업무와 급여 합계를 출력
SELECT deptno, count(*) cnt, round(avg(sal)) avg, sum(sal) sum    --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp 
WHERE JOB <> 'SALESMAN'
GROUP BY deptno
HAVING SUM(SAL)>5000
ORDER BY SUM(SAL) DESC;
단, SALESMAN은제외하고 급여 합계가 높은 순으로 정렬

--  업무별최고 급여와 최소 급여의 차이를 구하라
SELECT deptno, count(*) cnt, max(sal) max ,  min(sal) min, MAX(SAL)-MIN(SAL) --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp
WHERE SAL >0
GROUP BY deptno;
 

-- 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력

 SELECT deptno, count(*) cnt, max(sal) max ,  min(sal) min, MAX(SAL)+MIN(SAL) sum --직계함수와 해당 그룹명의 컬럼이 가능
FROM  emp
GROUP BY deptno
HAVING COUNT(*) >4;


