import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select1 {
	private String _user = "s13002";
	private String _pass = "password";
	private String _host = "172.16.40.4";
	private String _sid = "db11";
	
	public static void main(String[] args){

		Select1 select1 = new Select1();
		try {
			select1.select();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void select() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean empIsExists = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);
			
			String S = "SELECT emp.empno, emp.ename, emp.job, mgr.ename, dept.dname, dept.loc " +
			  	"FROM employees emp LEFT JOIN employees mgr " +
			  	"ON (emp.mgr = mgr.empno) " +
			  	"LEFT JOIN departments dept " +
			  	"ON (emp.deptno = dept.deptno)";

			st = conn.createStatement();
			rs = st.executeQuery(S);

			while(rs.next()){
				int emp_no = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				String mgr_name = rs.getString(4);
				String dname = rs.getString(5);
				String loc = rs.getString(6);

				System.out.printf("社員番号： %s\t社員名: %s\t職員: %s\t上司の名前: %s\t部所名： %s\t場所 %s\n",
					 emp_no, ename, job, mgr_name, dname, loc);
			}

		

		}catch(ClassNotFoundException e){
			throw e;
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}finally{
			if(conn != null){
				conn.close();
			}
			if(st != null){
				st.close();
				st = null;
			}
			if(rs != null){
				rs.close();
				rs = null;
			}
		}
	}
}
