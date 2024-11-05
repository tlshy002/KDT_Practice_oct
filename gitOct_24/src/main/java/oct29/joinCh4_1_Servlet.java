package oct29;

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

/**
 * Servlet implementation class joinCh4_Servlet
 */
@WebServlet("/joinServlet")
public class joinCh4_1_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinCh4_1_Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // 클래스에서 선언된 변수(인스턴스변수)는 자동 초기화됨
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Ch4_1_DAO dao = new Ch4_1_DAO(); //DAO 객체 생성
		dao.init();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
