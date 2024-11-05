package oct18_lesson1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 오라클DB의 사원정보테이블(employees)에 있는 모든데이터를 검색해서 자바로 옮긴 후 콘솔에 출력하기

class AllEmployees {
	AllEmployees(){}
	Connection conn;
	Statement stmt; // DB의 명령어(SQL)을 전달할때 사용하는 클래스
	ResultSet rs; // DB에서 검색한 데이터들을 일시 저장할 때 사용하는 클래스
	String sql_select = "select * from employees"; // 자바에서 SQL문을 작성할때는 끝에 ;세미콜론 안붙임
	
	// 자바에서 작성한 SQL문을 데이터베이스에게 전달해주는 역할: Statement
	// SQL문을 받은 오라클은 SQL문을 실행함.
	// SQL문을 실행한 결과를 자바에서 받을때 사용하는 클래스 : ResultSet
	
	void doIt() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클의 자바관련 라이브러리 호출
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr"); 
			stmt = conn.createStatement(); // Statement 인스턴스 생성 
			rs = stmt.executeQuery(sql_select); //매개변수안의 SQL문을 실행하고 결과는 ResultSet에 저장
			
			while(rs.next()) { //모든 검색결과가 처리될때까지 반복
				System.out.print(rs.getString(1)+", "); //사번
				System.out.print(rs.getString(2) + rs.getString(3)+", "); //성+이름
				System.out.println(rs.getString(4)); //이메일
				System.out.println(rs.getString(5)); //전화번호
				System.out.println(rs.getString(6)); //업무코드
				System.out.println();
				
			}
		} catch(Exception e) {
			System.out.println("DB처리중 문제발생");
		} finally {
			try {
				conn.close(); //DB접속해제
			} catch(Exception e) {}
		}
	}
}

public class Study02_sql {
	public static void main(String[] args) {
		AllEmployees e = new AllEmployees();
		e.doIt();
	}
}
