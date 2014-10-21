SELECT ename,
   DECODE(deptno, 10, sal * 1.10,
                  20, sal * 1.20, sal)
                  NEW_SAL
FROM employees
/
