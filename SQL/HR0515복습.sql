SELECT * FROM employees;
SELECT * FROM departments;
-- 1. 연도별로 입사자들의 최소급여, 최대 급여, 급여의 총합 그리고 평균 급여를 구하시오
SELECT to_char( hire_date,'YYYY'),COUNT(*) CNT,  min(salary) min , max(salary) max , sum(salary) sum , ROUND(avg(salary)) avg 
FROM employees
GROUP BY to_char( hire_date,'YYYY')
ORDER BY to_char( hire_date,'YYYY');
-- 2. 부서별 평균 급여가 $10,000 이상인 부서만 구하시오. ( 평균급여가 높은 순으로 )
SELECT d.department_name, ROUND(AVG(E.salary)) AVG 
FROM EMPLOYEES E INNER JOIN departments D
ON e.department_id=d.department_id
WHERE e.salary > 10000
GROUP BY d.department_name
ORDER BY AVG(E.salary) DESC;

-- 3. 부서별 최대 급여를 구하시오.  해당되는 부서번호는 10번과 20번임
SELECT d.department_name, MAX(E.salary) MAX 
FROM EMPLOYEES E INNER JOIN departments D
ON e.department_id=d.department_id
WHERE D.department_id ='10' OR D.department_id ='20'
GROUP BY d.department_name;
--4. 이름의 성이 'King' 사원의 사번과 부서명을 출력 ( employees, departments )
SELECT e.employee_id, d.department_name 
FROM EMPLOYEES E , departments D
WHERE e.department_id = d.department_id AND e.LAST_NAME LIKE 'King';
--5. 이름의 성이 'King' 사원의 사번과 부서명 그리고 업무명을 출력 ( employees, departments, jobs )
SELECT e.employee_id, d.department_name , j.job_title
FROM EMPLOYEES E , departments D , jobs j
WHERE e.department_id = d.department_id AND e.job_id=j.job_id and e.LAST_NAME LIKE 'King';
--6. 2007년 상반기에 입사한 사원들의 사번과 이름, 입사일 그리고 부서명을 출력
SELECT  e.employee_id, e.first_name||' '||e.last_name "fullname" , e.hire_date , d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE to_char( hire_date,'YYYY/MM/DD') >= '2007/01/01' AND to_char( hire_date,'YYYY/MM/DD') <'2007/07/01'
ORDER BY to_char( hire_date,'YYYY/MM/DD');

--(*) Grant는 아직 부서가 배정받지 못한 상태이지만 Grant도 출력되려면
SELECT  e.employee_id, e.first_name||' '||e.last_name "fullname" , e.hire_date , d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE to_char( hire_date,'YYYY/MM/DD') >= '2007/01/01' AND to_char( hire_date,'YYYY/MM/DD') <'2007/07/01'
ORDER BY to_char( hire_date,'YYYY/MM/DD');
--7. 'Executive' 부서에서 사원과 해당 사원의 관리자 이름을 출력
SELECT  d.department_name , e.first_name||' '||e.last_name "fullname", d.manager_id
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_name ='Executive';

 --(*) 관리자가 없는 사원인 'King'이 출력되려면
SELECT  d.department_name , e1.first_name||' '||e1.last_name "fullname", d.manager_id, e2.first_name||' '||e2.last_name "MGRname"
FROM employees e1  
LEFT OUTER JOIN departments d ON e1.department_id = d.department_id 
LEFT OUTER JOIN employees e2 ON e1.manager_id = e2.employee_id
WHERE d.department_name ='Executive';