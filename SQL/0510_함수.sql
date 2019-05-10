-- 사원명 , 급여, 월급 ( 급여 /12) 를 출력하되 월급은 십단위에서 반올림하여 출력 


SELECT ename , sal , round(sal/12,-2) "월급"
FROM    emp; 


    -- 사원명  , 급여, 세금 (급여의 3,3%) 를 원단위 절삭하고 출력 
desc emp;

SELECT ename , sal ,round(sal*0.967,-1) "월급", trunk(sal*0.033,-1) as "세금"
FROM    emp; 
desc emp;
SELECT
    *
FROM emp;
 -- smith의정보를 사원번호, 성명, 담당업무(소문자) 출력
 SELECT empno, ename, lower(job) as job
 FROM emp
WHERE ename like 'SMITH'
ORDER BY empno;
 
-- 사원번호, 사원명(첫글자만 대문자), 담당업무(첫글자만대문자)로 출력
 SELECT empno, initcap(ename)as ename, initcap(job)  as job
 FROM emp
ORDER BY empno;
-- 이름의 첫글자가 ‘K’보다크고 ‘Y’보다 작은 사원의 정보( 사원번호, 이름, 업무, 급여, 부서번호)를 출력하되 이름순으로 정렬
 SELECT empno, job, sal, deptno
 FROM emp
 WHERE SUBSTR(ename,1,1) <'Y' AND SUBSTR(ename,1,1) > 'K'
ORDER BY ename;
-- 이름이 5글자 이상인사원들을 출력
 SELECT empno, job, sal, deptno
 FROM emp
 WHERE LENGTH(ename) >=5
ORDER BY ename;
-- 이름을 15자로 맞추고글자는 왼쪽에 오른쪽에는 ‘*’로 채운다
SELECT RPAD(ename , 15, '*')  AS NAME
FROM emp
;
-- 월급은 10자로 맞추고숫자는 오른쪽에 왼쪽엔 ‘-‘로 채운다
SELECT  LPAD(sal, 1O, '-') AS SAL
 FROM emp
;
 ---------------------------------------------------
--현재까지 근무일 수가 ㅏㄶ은 사람순으로 출력 
SELECT *
FROM emp
ORDER BY sysdate - nvl(hiredate,sysdate) DESC;

-- 현재 날짜에서 돌아오는 '월'요일 날짜 구하기 
SELECT next_day(sysdate,'월') FROM DUAL;
-- 5월의 마지막 날
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-- 현재까지 근무일 수가 몇 주 몇 일인가를 출력
SELECT ename, hiredate, trunc(sysdate-hiredate)  total_day,
trunc((sysdate-hiredate)/7) weeks, ceil(mod(sysdate-hiredate,7)) days
FROM emp;
         
  
-- 입사일자에서 입사년도를 출력
SELECT ename, hiredate, to_char(hiredate, 'YYYY') hireyear 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'MM') hireMONTH 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'DD') hireDAY 
FROM emp; 

SELECT ename, hiredate, to_char(hiredate, 'hh:mi') hireDAY 
FROM emp; 

-- 입사일자를 ‘1999년 1월 1일’ 형식으로 출력
SELECT ename, hiredate, to_char(hiredate, 'YYYY"년"MM"월"DD"일"') hireDAY 
FROM emp; 
 

-- 1981년도에 입사한 사원 검색
SELECT *
FROM emp
WHERE to_char(hiredate, 'YYYY')=1981;

-- 5월에 입사한 사원 검색
SELECT *
FROM emp
WHERE to_char(hiredate, 'MM') =5 ;
 
-- 급여 앞에 $를 삽입하고 3자리 마다 ,를 출력      

-- 10번 부서의 사원의 현재까지의 근무 월수를 계산
SELECT ename, trunc( months_between (sysdate,hiredate))
FROM emp
WHERE deptno=10;

SELECT   '-' || trim(' 이순신 ')|| '-' as col1,
         '-'|| ltrim(' 이순신 ') || '-' as col2,
         '-'|| rtrim(' 이순신 ') || '-' as col3 
         
         from dual;


select sysdate from dual;

-- 월급을 숫자에서 ‘영일이삼사오육칠팔구’ 글자로 대체
SELECT translate(sal, '0123456789', '영일이삼사오육칠팔구')
FROM EMP;

-- 월급의 숫자에서 0을‘$’로 바꾸어 출력
SELECT 
REPLACE(' 이  순  신 ', ' ', '')
FROM DUAL;

SELECT translate(sal, '0123456789', '9578621430')
FROM emp;

SELECT translate(sal, '9578621430', '0123456789')
FROM emp;


