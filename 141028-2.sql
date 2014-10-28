SELECT empno, ename, deptno, dname
FROM employees LEFT JOIN departments
USING(deptno)

/
