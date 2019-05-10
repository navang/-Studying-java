-- emp (사원테이블)에 8000 사번 이름은 본인 이름으로 월급 10000 데이터 입력 
-- INSERT       INTOtable_name( columns ) VALUES ( values );


INSERT   INTO    emp(empno, ename, sal  ) VALUES ( 8000, '홍길다' , 10000 );
--  INSERT   INTO     emp(empno, ename, sal  ) VALUES ( 7788, '홍길동' , 9000 ); -- 무결성 제약조건에 위배


INSERT   INTO    emp(empno, ename, sal , deptno  ) VALUES ( 8001, '홍길동' , 9000 ,20); -- 입력
-- INSERT   INTO    emp(empno, ename, sal , deptno  ) VALUES ( 8002, '홍길수' , 9000 ,60); -- 에러 : 무결성제약조건 

COMMIT WORK;
ROLLBACK;
DESCRIBE emp;  -- 구조확인
SELECT * FROM emp; -- 내용확인 
