--[ hr 계정 ]
--1. Zlotkey와 동일한 부서에 속한 모든 사원의 이름과 입사일을 표시하는 질의를 작성하십시오. 
--   Zlotkey는 제외하십시오.
select *from employees;


--2. 급여가 평균 급여보다 많은 모든 사원의 사원 번호와 이름을 표시하는 질의를 작성하고 
-- 급여에 대해 오름차순으로 정렬하십시오.

--3. King에게 보고하는 모든 사원의 이름과 급여를 표시하십시오.
SELECT employee_id, first_name||' '||last_name "fullname", salary
FROM employees 
WHERE  manager_id = any (select manager_id 
                            from employees
                            where last_name = 'King');
--4. Executive 부서의 모든 사원에 대한 부서 번호, 이름 및 업무 ID를 표시하십시오.
SELECT e.department_id , e.first_name||' '||e.last_name "fullname", e.job_id
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
where d.department_name = any (
                            SELECT department_name
                            FROM departments
                            where department_name = 'Executive'
                            );
--5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 
--  모든 사원의 사원 번호, 이름 및 급여를 표시하는 질의를 작성하십시오.
