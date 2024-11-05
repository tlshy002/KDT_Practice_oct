package oct30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.net.aso.r;

class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}

public class Ch4_5_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String query = "Select e.last_name, e.job_id, e.department_id, d.department_name"
				+ " From employees e, departments d, locations l"
				+ " Where e.department_id = d.department_id"
				+ " and d.location_id = l.location_id and l.city = ?";
	
	void doIt(String name) {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name); // 첫번째 ?에 인자값 name의 데이터를 문자열로 삽입 
			rs = pstmt.executeQuery(); // 쿼리문 실행 결과를 객체 rs에 할당
			
			while(rs.next()) {
				String last_name = rs.getString(1);
				String job_id = rs.getString(2);
				int dept_id = rs.getInt(3);
				String dept_name = rs.getString(4);
				System.out.println(last_name+","+job_id+","+dept_id+","+dept_name);
			}
			
			
		} catch(Exception e) {
			System.out.println("DB연결중 문제발생");
		} finally {
			try {
				rs.close();
			} catch(Exception e) {}
		}
	}
	
}
