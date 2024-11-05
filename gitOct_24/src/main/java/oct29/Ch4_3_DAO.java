package oct29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oct29.Ch4_1_DAO;


public class Ch4_3_DAO {
	Connection conn; 
	PreparedStatement pstmt;
	ResultSet rs;	
	String query = "Select e.last_name, d.department_name, I.city"
				+ " from employees e, departments d, locations I"
				+ " where e.department_Id = d.department_Id"
				+ " and I.location_id = d.location_id"
				+ " and e.commission_pct IS NOT NULL"; //조인쿼리
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); //쿼리를 실행한 결과를 ResultSet객체에 저장
			
			while(rs.next()) {
				String name = rs.getString(1);
				String dept_name = rs.getString(2);
				String loc_id = rs.getString(3);
				System.out.println(name+", "+dept_name+", "+loc_id);
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
