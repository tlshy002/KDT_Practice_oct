package oct23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}

// DTO(private, getter, setter)
class NameSalaryComm {
	private String name;
	private Double salary;
	private Double commission;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
}

// DAO
class Connect {
	Connect(){}
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ArrayList<NameSalaryComm> al;
	String query = "Select last_name, salary, commission_pct from employees " 
					+ "where commission_pct IS NOT NULL order by commission_pct desc";
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			al = new ArrayList<NameSalaryComm>();
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr","hr");
			stmt = conn.createStatement(); // Statement 인스턴스 생성
			rs = stmt.executeQuery(query); // 쿼리문 실행하고 ResultSet 객체에 결과 받기
			while(rs.next()) {
				String name = rs.getString(1); // 첫번째 속성값 조회
				Double salary = rs.getDouble(2);
				Double comm = rs.getDouble(3);
				
				NameSalaryComm nsc = new NameSalaryComm(); //DTO 객체 생성				
				nsc.setName(name); // DTO클래스 객체의 멤버변수에 값할당
				nsc.setSalary(salary);
				nsc.setCommission(comm);
				al.add(nsc); // ArrayList에 객체 할당
			}
			
			Print p = new Print(); //출력담당 객체 생성
			p.getData(al);
			p.printResult();
			
			
		} catch(Exception e) {
			System.out.println("DB접속 중 오류발생!");
		} finally {
			try {
				conn.close(); //DB접속 해제
			} catch(Exception e) {}
			
		}
 		
	}
}

class Print {
	Print(){}
	ArrayList<NameSalaryComm> al;
	void getData(ArrayList<NameSalaryComm> al) {
		this.al = al;
	}
	void printResult() {
		Iterator iter = al.iterator();
		while(iter.hasNext()) {
			NameSalaryComm nsc = (NameSalaryComm)iter.next();
			String name = nsc.getName();
			Double salary = nsc.getSalary();
			Double comm = nsc.getCommission();
			System.out.println(name+", "+salary+", "+comm);
		}		
	}
} // class Print



public class Study1 {
	public static void main(String[] args) {
		Connect c = new Connect();
		c.init();
	}
}
