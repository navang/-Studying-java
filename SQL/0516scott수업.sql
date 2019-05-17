    SELECT     employee_id, first_name, last_name, phone_number FROM employees
    WHERE employee_id=100;
    
       SELECT     employee_id, first_name, last_name, phone_number FROM employees
    WHERE SALARY=3000;
    
       SELECT     employee_id, first_name, last_name, phone_number FROM employees
    WHERE phone_number = '590.423.4560';
    
    SELECT index_name, index_type FROM user_indexes
    WHERE table_name='EMPLOYEES';
    
    SELECT     employee_id, first_name, last_name, phone_number FROM employees
    WHERE      last_name = 'King';
    
    CREATE INDEX emp_phone_ix ON employees(phone_number); 
    
    
    
    