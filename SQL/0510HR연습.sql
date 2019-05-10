/*# HR �������� ( employees ���̺� )




*/
 	DESC EMPLOYEES;
    SELECT
        *
    FROM EMPLOYEES;
     -- 1. 2003�⿡ �Ի��� ������� ���, �̸�, �Ի����� ���
    SELECT employee_id , first_name || '' || last_name as full_name , hire_date
    FROM employees
    WHERE HIRE_DATE BETWEEN '03/01/01'AND'03/12/31';
    
    --2. ������ FI_ACCOUNT / FI_MGR / SA_MAN / SA_REP �� ������� ������ ���
    SELECT *
    FROM employees
    WHERE job_id like 'FI_ACCOUNT' OR
          job_id like 'FI_MGR' OR
          job_id like 'SA_MAN' OR
          job_id like 'SA_REP'
    ORDER BY job_id;
   
    --3. Ŀ�̼��� �޴� ������� ����� ���
    SELECT first_name || '' || last_name as full_name
    FROM employees
    WHERE nvl(commission_pct,0) <> '0';
    
    --4.������ SA_MAN �Ǵ� SA_REP�̸� "�Ǹźμ�"�� �� �ܴ� "�� �� �μ�"��� ���
SELECT first_name || '' || last_name as full_name,  decode(job_id,'SA_MAN', '�Ǹźμ�', 'SA_REP','�Ǹźμ�' ,  '�� �� �μ�') AS DEPT
FROM employees;

    