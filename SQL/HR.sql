SELECT *FROM employees;
DESC employees;
--< �������� >>
-- �λ���� ( hr ���� )���� EMPLOYEES ���̺���

--1. EMPLOYEES ���̺��� ��� �̸��� first_name�� last_name�� ���� full_name���� ���
ALTER TABLE EMPLOYEES ADD ( full_name varchar2(20));

SELECT first_name || '' || last_name as full_name
FROM employees
ORDER BY full_name ; 

--2. �μ���ȣ�� 30(���źμ�)�̰� �޿� 10000�̸��� ����� full_name�� ����,�μ���ȣ�� ���
SELECT salary, departMent_id
FROM employees
WHERE salary <= 10000 AND departMent_id = 30
ORDER BY full_name ,salary, departMent_id ;

--3. �μ���ȣ�� 30�̰� �޿��� 10000�޷� ���ϸ� �޴� 2006�⵵ ���� �Ի��� ����� full_name�� ���
SELECT salary, departMent_id, first_name || '' || last_name as full_name
FROM employees
WHERE salary <= 10000 AND departMent_id = 30 AND HIRE_DATE < '06/01/01'
ORDER BY full_name  ;

--4. �μ���ȣ�� 30(���źμ�)�̰� �޿��� 10000������ ����� �μ���ȣ�� 60(IT�μ�)���� �޿��� 5000�̻��� ����� ��ȸ
SELECT *
FROM employees
WHERE (salary <= 10000 AND departMent_id = 30) OR (salary >= 5000 AND departMent_id = 60)
ORDER BY departMent_id ASC ;

--5. �����ȣ�� 110������ 120���� ��� �� �޿��� 5000���� 10000������ �������� ��ȸ
SELECT first_name || '' || last_name as full_name  , EMPLOYEE_ID ,salary
FROM employees
WHERE (EMPLOYEE_ID >=110 AND EMPLOYEE_ID <=120) AND (salary >= 5000 AND salary <= 10000)
ORDER BY full_name ;
 
--6. �����ȣ�� 110������ 120���� �ƴ� ����� ��ȸ
 SELECT first_name || '' || last_name as full_name  
FROM employees
WHERE (EMPLOYEE_ID <=110 OR EMPLOYEE_ID >=120)
ORDER BY full_name ;
-- WHERE EMPLOYEE_ID NOT BETWEEN 110 AND 120; 
--7. �μ���ȣ�� 30(���źμ�), 60(IT�μ�), 90(�濵�μ�)�� ���� ����� ��ȸ
  SELECT * 
FROM employees
WHERE (departMent_id = 30 OR departMent_id = 60 OR departMent_id = 90)
ORDER BY departMent_id ASC ;
--8. �μ���ȣ�� 30(���źμ�), 60(IT�μ�), 90(�濵�μ�) ���� �μ��� ���� ����� ��ȸ
   SELECT * 
FROM employees
WHERE (departMent_id != 30 AND departMent_id != 60 AND departMent_id != 90)
ORDER BY departMent_id ASC ;
--9. ��ȭ��ȣ���� 590���� �����ϴ� ������ ��ȭ��ȣ�� ��ȸ
SELECT first_name || '' || last_name as full_name , phone_number 
FROM employees
WHERE  phone_number LIKE '590%' 
ORDER BY  phone_number ;
 