SELECT * FROM employees;
SELECT * FROM departments;
-- 1. �������� �Ի��ڵ��� �ּұ޿�, �ִ� �޿�, �޿��� ���� �׸��� ��� �޿��� ���Ͻÿ�
SELECT to_char( hire_date,'YYYY'),COUNT(*) CNT,  min(salary) min , max(salary) max , sum(salary) sum , ROUND(avg(salary)) avg 
FROM employees
GROUP BY to_char( hire_date,'YYYY')
ORDER BY to_char( hire_date,'YYYY');
-- 2. �μ��� ��� �޿��� $10,000 �̻��� �μ��� ���Ͻÿ�. ( ��ձ޿��� ���� ������ )
SELECT d.department_name, ROUND(AVG(E.salary)) AVG 
FROM EMPLOYEES E INNER JOIN departments D
ON e.department_id=d.department_id
WHERE e.salary > 10000
GROUP BY d.department_name
ORDER BY AVG(E.salary) DESC;

-- 3. �μ��� �ִ� �޿��� ���Ͻÿ�.  �ش�Ǵ� �μ���ȣ�� 10���� 20����
SELECT d.department_name, MAX(E.salary) MAX 
FROM EMPLOYEES E INNER JOIN departments D
ON e.department_id=d.department_id
WHERE D.department_id ='10' OR D.department_id ='20'
GROUP BY d.department_name;
--4. �̸��� ���� 'King' ����� ����� �μ����� ��� ( employees, departments )
SELECT e.employee_id, d.department_name 
FROM EMPLOYEES E , departments D
WHERE e.department_id = d.department_id AND e.LAST_NAME LIKE 'King';
--5. �̸��� ���� 'King' ����� ����� �μ��� �׸��� �������� ��� ( employees, departments, jobs )
SELECT e.employee_id, d.department_name , j.job_title
FROM EMPLOYEES E , departments D , jobs j
WHERE e.department_id = d.department_id AND e.job_id=j.job_id and e.LAST_NAME LIKE 'King';
--6. 2007�� ��ݱ⿡ �Ի��� ������� ����� �̸�, �Ի��� �׸��� �μ����� ���
SELECT  e.employee_id, e.first_name||' '||e.last_name "fullname" , e.hire_date , d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE to_char( hire_date,'YYYY/MM/DD') >= '2007/01/01' AND to_char( hire_date,'YYYY/MM/DD') <'2007/07/01'
ORDER BY to_char( hire_date,'YYYY/MM/DD');

--(*) Grant�� ���� �μ��� �������� ���� ���������� Grant�� ��µǷ���
SELECT  e.employee_id, e.first_name||' '||e.last_name "fullname" , e.hire_date , d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE to_char( hire_date,'YYYY/MM/DD') >= '2007/01/01' AND to_char( hire_date,'YYYY/MM/DD') <'2007/07/01'
ORDER BY to_char( hire_date,'YYYY/MM/DD');
--7. 'Executive' �μ����� ����� �ش� ����� ������ �̸��� ���
SELECT  d.department_name , e.first_name||' '||e.last_name "fullname", d.manager_id
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_name ='Executive';

 --(*) �����ڰ� ���� ����� 'King'�� ��µǷ���
SELECT  d.department_name , e1.first_name||' '||e1.last_name "fullname", d.manager_id, e2.first_name||' '||e2.last_name "MGRname"
FROM employees e1  
LEFT OUTER JOIN departments d ON e1.department_id = d.department_id 
LEFT OUTER JOIN employees e2 ON e1.manager_id = e2.employee_id
WHERE d.department_name ='Executive';