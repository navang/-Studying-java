-- emp (������̺�)�� 8000 ��� �̸��� ���� �̸����� ���� 10000 ������ �Է� 
-- INSERT       INTOtable_name( columns ) VALUES ( values );


INSERT   INTO    emp(empno, ename, sal  ) VALUES ( 8000, 'ȫ���' , 10000 );
--  INSERT   INTO     emp(empno, ename, sal  ) VALUES ( 7788, 'ȫ�浿' , 9000 ); -- ���Ἲ �������ǿ� ����


INSERT   INTO    emp(empno, ename, sal , deptno  ) VALUES ( 8001, 'ȫ�浿' , 9000 ,20); -- �Է�
-- INSERT   INTO    emp(empno, ename, sal , deptno  ) VALUES ( 8002, 'ȫ���' , 9000 ,60); -- ���� : ���Ἲ�������� 

COMMIT WORK;
ROLLBACK;
DESCRIBE emp;  -- ����Ȯ��
SELECT * FROM emp; -- ����Ȯ�� 
