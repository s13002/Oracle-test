SELECT empno,ename,yomi
FROM employees
WHERE upper(yomi) = 'TAKAHASHI'
/
