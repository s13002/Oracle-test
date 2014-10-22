SELECT MAX(AVG(sal))
FROM employees
GROUP BY deptno
ORDER BY deptno
/
