SELECT deptno, job, COUNT(*), AVG(sal)
FROM employees
GROUP BY deptno, job
ORDER BY deptno, job
/
