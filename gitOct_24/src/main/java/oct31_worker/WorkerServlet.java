package oct31_worker;

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


@WebServlet("/findWorker.do")
public class WorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WorkerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		
		WorkerDAO dao = new WorkerDAO();
		String name = dao.findName(emp_id);
		
		response.sendRedirect("findWorker.jsp?NAME="+name);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
} //서블릿=============================

class WorkerDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String query = "Select last_name From employees Where employee_id = ?";
	String result; //쿼리문 실행결과 값을 담을 변수
	
	String findName(String emp_id) {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(emp_id));
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				//조회결과를 가져온다.
			}else {
				//조회결과가 없슴
			}
			
			result = rs.getString(1);

		} catch(Exception e) {
			System.out.println("DB작업중 문제발생!");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch(Exception e) {}
		}
		return result;
	}
}
class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}
