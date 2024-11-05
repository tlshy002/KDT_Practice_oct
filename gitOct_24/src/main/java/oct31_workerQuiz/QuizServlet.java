package oct31_workerQuiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/findQuiz.do")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QuizServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

class FindWorkerDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String query = "Select e.last_name, d.department_name"
				+ " from employees e, departments d"
				+ " where e.employee_id = d.department_id"
				+ " and employee_id = ?";
	String name; //쿼리문 실행결과 값을 담을 변수
	String deptName; //쿼리문 실행결과 값을 담을 변수
	
	String findName(String emp_id) {
		try {
			Class.forName(OracleXE11g2.LIB);
			conn = DriverManager.getConnection(OracleXE11g2.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(emp_id));
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				//조회결과를 가져온다.
			}else {
				//조회결과가 없슴
			}
			
			name = rs.getString(1);
			deptName = rs.getString(2);

		} catch(Exception e) {
			System.out.println("DB작업중 문제발생!");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch(Exception e) {}
		}
		return "";//(name +","+ deptName);
	}

}
/*
 * Select e.employee_name, d.department_name 
 * from employees e, departments d
 * where e.employee_id, d.department_id
 * and employee_id = ?
 * */
class OracleXE11g2 {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}