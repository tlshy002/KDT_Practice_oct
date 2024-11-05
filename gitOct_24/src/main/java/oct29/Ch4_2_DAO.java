package oct29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oct29.Ch4_1_DAO;


public class Ch4_2_DAO {
	Connection conn; 
	PreparedStatement pstmt;
	ResultSet rs;	
	String query = "Select e.last_name, e.department_Id, d.department_name"
				+ " from employees e, departments d"
				+ " where e.department_Id = d.department_Id"
				+ " and e.department_id = ?"; //조인쿼리
	
	void init(String dept_id) {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			
			Integer id = Integer.parseInt(dept_id); //파라미터값 int로 형변환
			pstmt.setInt(1, id); //첫번째 물음표에 파라미터 값을 정수로 넣음			
			rs = pstmt.executeQuery(); //쿼리를 실행한 결과를 ResultSet객체에 저장
			
			while(rs.next()) {
				String job_id = rs.getString(1);
				int loc_id = rs.getInt(2);
				System.out.println(job_id+", "+loc_id);
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
