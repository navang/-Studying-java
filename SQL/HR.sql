SELECT *FROM employees;
DESC employees;
--< 도전문제 >>
-- 인사관리 ( hr 계정 )에서 EMPLOYEES 테이블에서

--1. EMPLOYEES 테이블에서 사원 이름을 first_name과 last_name를 합쳐 full_name으로 출력
ALTER TABLE EMPLOYEES ADD ( full_name varchar2(20));

SELECT first_name || '' || last_name as full_name
FROM employees
ORDER BY full_name ; 

--2. 부서번호가 30(구매부서)이고 급여 10000미만인 사원의 full_name과 월급,부서번호를 출력
SELECT salary, departMent_id
FROM employees
WHERE salary <= 10000 AND departMent_id = 30
ORDER BY full_name ,salary, departMent_id ;

--3. 부서번호가 30이고 급여가 10000달러 이하를 받는 2006년도 이전 입사한 사원의 full_name을 출력
SELECT salary, departMent_id, first_name || '' || last_name as full_name
FROM employees
WHERE salary <= 10000 AND departMent_id = 30 AND HIRE_DATE < '06/01/01'
ORDER BY full_name  ;

--4. 부서번호가 30(구매부서)이고 급여가 10000이하인 사원과 부서번호가 60(IT부서)에서 급여가 5000이상인 사원을 조회
SELECT *
FROM employees
WHERE (salary <= 10000 AND departMent_id = 30) OR (salary >= 5000 AND departMent_id = 60)
ORDER BY departMent_id ASC ;

--5. 사원번호가 110번에서 120번인 사원 중 급여가 5000에서 10000사이의 사원명단을 조회
SELECT first_name || '' || last_name as full_name  , EMPLOYEE_ID ,salary
FROM employees
WHERE (EMPLOYEE_ID >=110 AND EMPLOYEE_ID <=120) AND (salary >= 5000 AND salary <= 10000)
ORDER BY full_name ;
 
--6. 사원번호가 110번에서 120번이 아닌 사원을 조회
 SELECT first_name || '' || last_name as full_name  
FROM employees
WHERE (EMPLOYEE_ID <=110 OR EMPLOYEE_ID >=120)
ORDER BY full_name ;
-- WHERE EMPLOYEE_ID NOT BETWEEN 110 AND 120; 
--7. 부서번호가 30(구매부서), 60(IT부서), 90(경영부서)에 속한 사원을 조회
  SELECT * 
FROM employees
WHERE (departMent_id = 30 OR departMent_id = 60 OR departMent_id = 90)
ORDER BY departMent_id ASC ;
--8. 부서번호가 30(구매부서), 60(IT부서), 90(경영부서) 외의 부서에 속한 사원을 조회
   SELECT * 
FROM employees
WHERE (departMent_id != 30 AND departMent_id != 60 AND departMent_id != 90)
ORDER BY departMent_id ASC ;
--9. 전화번호에서 590으로 시작하는 사원명과 전화번호를 조회
SELECT first_name || '' || last_name as full_name , phone_number 
FROM employees
WHERE  phone_number LIKE '590%' 
ORDER BY  phone_number ;
 