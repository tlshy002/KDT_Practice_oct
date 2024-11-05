package oct23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class OracleXE11g2 {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}
// DTO, DAO
class ConnectDAO {
	ConnectDAO(){}
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	
	void init() {
		try {
			Class.forName(OracleXE11g2.LIB);
			conn = DriverManager.getConnection(OracleXE11g2.NAME);
			
		} catch(Exception e) {
			System.out.println("DB 접속 중 문제발생!");
		} finally {
			try {
				conn.close();
			} catch(Exception e) {}
		}
		
	}
}


public class Study2 {
	public static void main(String[] args) {

	}
}
