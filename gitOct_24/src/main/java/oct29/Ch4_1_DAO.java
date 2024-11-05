package oct29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}

public class Ch4_1_DAO {
	Connection conn; 
	PreparedStatement pstmt;
	ResultSet rs;	
	String query = "Select e.last_name, e.department_Id, d.department_name"
				+ " from employees e, departments d"
				+ " where e.department_Id = d.department_Id"; //조인쿼리
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); //쿼리를 실행한 결과를 ResultSet객체에 저장
			
			while(rs.next()) {
				String name = rs.getString(1);
				int num = rs.getInt(2);
				String dept_name = rs.getString(3);
				System.out.println(name+", "+num+", "+dept_name);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB작업 중 문제발생!!");
		} finally {
			try {
				conn.close();
			} catch(Exception e) {}
		}
	}

}
