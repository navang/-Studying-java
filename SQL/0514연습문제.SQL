--<< 도전 문제 >>
SELECT *
FROM employees;
desc employees;
SELECT
    *
FROM departments;

--사원번호, 사원명, 부서명 출력
SELECT E.employee_id , E.FIRST_NAME || ' ' || E.LAST_NAME AS "FULLNAME" , D.department_NAME
FROM employees E , departments D
WHERE E.department_id = D.department_id; 


--사원번호, 사원명, 부서명, 위치 출력
SELECT E.employee_id , E.FIRST_NAME || ' ' || E.LAST_NAME AS "FULLNAME" , D.department_NAME ,d.location_id
FROM employees E, departments D
WHERE E.department_id = D.department_id; 

--사원번호, 사원명, 업무명, 부서명, 위치출력
SELECT E.employee_id , E.FIRST_NAME || ' ' || E.LAST_NAME AS "FULLNAME" ,E.job_id , j.job_title, D.department_NAME ,d.location_id
FROM employees E, departments D, jobs J
WHERE E.department_id = D.department_id AND e.job_id = J.JOB_ID; 

--입사년도별 최고 월급을 받는 사원의 이름과 부서명을 출력*/
SELECT E.FIRST_NAME || ' ' || E.LAST_NAME AS "FULLNAME" , TO_CHAR(h.start_date,'YYYY')
FROM  employees E,  job_history H
WHERE e.employee_id = h.employee_id 
ORDER BY TO_CHAR(h.start_date,'YYYY');
INTERSECT;
-- 사원의 이름과 최고월급, + 사원과 연도 
SELECT E.FIRST_NAME || ' ' || E.LAST_NAME "FULLNAME" ,MAX(E.salary) MAX ,d.department_id ,TO_CHAR(h.start_date,'YYYY')
FROM  employees E,  departments D, job_history H
WHERE ( e.department_id = D.department_id AND e.department_id = D.department_id ) AND ( e.employee_id = h.employee_id)
GROUP BY d.department_id , TO_CHAR(h.start_date,'YYYY'), e.FIRST_NAME || ' ' || E.LAST_NAME ;
 




