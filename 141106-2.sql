INSERT INTO dept_copy(deptno, dname, loc)
VALUES (70, '海外', '浦添')
/
SAVEPOINT KEN
/
INSERT INTO dept_copy(deptno, dname, loc)
VALUES (80, '製造', 'うるま')
/
SELECT * FROM dept_copy
WHERE deptno IN(70,80)
/
ROLLBACK TO KEN
/
SELECT * FROM dept_copy
WHERE deptno IN(70,80)
/
