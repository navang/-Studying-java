--[ hr ���� ]
--1. Zlotkey�� ������ �μ��� ���� ��� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻʽÿ�. 
--   Zlotkey�� �����Ͻʽÿ�.
select *from employees;


--2. �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��ϰ� 
-- �޿��� ���� ������������ �����Ͻʽÿ�.

--3. King���� �����ϴ� ��� ����� �̸��� �޿��� ǥ���Ͻʽÿ�.
SELECT employee_id, first_name||' '||last_name "fullname", salary
FROM employees 
WHERE  manager_id = any (select manager_id 
                            from employees
                            where last_name = 'King');
--4. Executive �μ��� ��� ����� ���� �μ� ��ȣ, �̸� �� ���� ID�� ǥ���Ͻʽÿ�.
SELECT e.department_id , e.first_name||' '||e.last_name "fullname", e.job_id
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
where d.department_name = any (
                            SELECT department_name
                            FROM departments
                            where department_name = 'Executive'
                            );
--5. ��� �޿����� ���� �޿��� �ް� �̸��� u�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� 
--  ��� ����� ��� ��ȣ, �̸� �� �޿��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻʽÿ�.
