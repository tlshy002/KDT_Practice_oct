package oct25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
}
class NewSalary { //DTO
	private int emp_id;
	private String name;
	private double salary;
	private int newSalary;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(int newSalary) {
		this.newSalary = newSalary;
	}
} // DTO

class Ch3_2 {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<NewSalary> al;
	String query = "Select employee_id, last_name, salary, round(salary * 1.15) from employees";
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			al = new ArrayList<NewSalary>(); // ArrayList 생성
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr","hr");
			pstmt = conn.prepareStatement(query); // 인스턴스 생성
			rs = pstmt.executeQuery(); //쿼리를 실행하고 결과를 받음
			while(rs.next()) {
				Integer emp_id = rs.getInt(1); 
				Double salary = rs.getDouble(3);
				String name = rs.getString(2);
				Integer newSalary = rs.getInt(4); 
				
				NewSalary ns = new NewSalary(); // DTO 객체생성
				ns.setEmp_id(emp_id);
				ns.setName(name);
				ns.setSalary(salary);
				ns.setNewSalary(newSalary);
				al.add(ns); // DTO를 ArrayList에 저장
			}
			
			Print print = new Print(al); //출력 객체 생성
			print.printResult(); //결과출력
			
		} catch(Exception e) {
			System.out.println("DB작업 중 문제발생!");
		} finally {
			try {
				conn.close(); //DB접속 해제
			} catch(Exception e) {}
		}
	}
}

class Print {
	ArrayList<NewSalary> result;
	Print(ArrayList<NewSalary> result) {
		this.result = result;
	}
	void printResult() {
		Iterator iter = result.iterator(); 
		System.out.println("사원번호 / 사원이름 / 월급 / 새월급");
		while(iter.hasNext()) {
			NewSalary ns = (NewSalary)iter.next();
			System.out.print(ns.getEmp_id() + ", ");
			System.out.print(ns.getName() + ", ");
			System.out.print(ns.getSalary() + ", ");
			System.out.println(ns.getNewSalary()); 
		}
	}
}

public class Study1 {
	public static void main(String[] args) {
		Ch3_2 ch = new Ch3_2();
		ch.init();
		
	}
}
