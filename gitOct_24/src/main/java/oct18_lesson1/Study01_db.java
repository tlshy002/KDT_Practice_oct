package oct18_lesson1;

import java.sql.Connection;
import java.sql.DriverManager;

// 오라클DB와 자바를 연동할때 사용하는 클래스: Connection
// 오라클DB에 SQL을 실행할때 사용하는 클래스: Statement, PreparedStatement
// 오라클에서 자바연동를 위해 만들어놓은 라이브러리가 있음 그걸 설치해야함. => jdbc (Java DB Connectivity)

class DBTest {
	DBTest(){}
	Connection conn; // DB와 접속할때 사용하는 객체선언
	void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클의 자바관련 라이브러리 호출
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr"); //계정과 암호 명시 (?,계정,암호)
			System.out.println("DB접속 성공!");
		} catch(Exception e) {
			System.out.println("DB접속 중 문제발생!");
		} finally {
			try {
				conn.close(); //DB와의 접속해제
			} catch(Exception e) {}
		
		}
	}
}

public class Study01_db {
	public static void main(String[] args) {
		DBTest dbtest = new DBTest();
		dbtest.connect();
	}
}
