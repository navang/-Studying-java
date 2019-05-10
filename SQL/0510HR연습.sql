/*# HR 계정에서 ( employees 테이블 )




*/
 	DESC EMPLOYEES;
    SELECT
        *
    FROM EMPLOYEES;
     -- 1. 2003년에 입사한 사원들의 사번, 이름, 입사일을 출력
    SELECT employee_id , first_name || '' || last_name as full_name , hire_date
    FROM employees
    WHERE HIRE_DATE BETWEEN '03/01/01'AND'03/12/31';
    
    --2. 업무가 FI_ACCOUNT / FI_MGR / SA_MAN / SA_REP 인 사원들의 정보를 출력
    SELECT *
    FROM employees
    WHERE job_id like 'FI_ACCOUNT' OR
          job_id like 'FI_MGR' OR
          job_id like 'SA_MAN' OR
          job_id like 'SA_REP'
    ORDER BY job_id;
   
    --3. 커미션을 받는 사원들의 명단을 출력
    SELECT first_name || '' || last_name as full_name
    FROM employees
    WHERE nvl(commission_pct,0) <> '0';
    
    --4.업무가 SA_MAN 또는 SA_REP이면 "판매부서"를 그 외는 "그 외 부서"라고 출력
SELECT first_name || '' || last_name as full_name,  decode(job_id,'SA_MAN', '판매부서', 'SA_REP','판매부서' ,  '그 외 부서') AS DEPT
FROM employees;

    