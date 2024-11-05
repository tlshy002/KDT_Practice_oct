package oct25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


class NameSalary { 
	NameSalary(){}
	private String name; //이름 저장변수
	private Double salary; //월급 저장변수
	
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
}//DTO(모든 변수는 은닉함(private)

class Ch2_1 {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Scanner sc;
	ArrayList<NameSalary> al;	
	
	// PreparedStatement를 훨씬 많이 씀. 왜? 그 이유는... 쿼리에 데이터가 들어가는 자리에 ? 작성하면 됨
	// Statement 는 쿼리를 +연산자로 연결해줘야함. 불편
	String query = "select last_name, salary from employees where salary > ?";  //?에 데이터를 넣는다
	
	int getFromConsole() {
		sc = new Scanner(System.in);
		System.out.println("검색하려는 월급을 입력하세요.");
		int salary = sc.nextInt();
		return salary;
	}
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			conn = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, getFromConsole()); //첫번째 물음표로 데이터를 넣는다
			rs = pstmt.executeQuery(); //쿼리를 실행한 결과값 저장
			
			while(rs.next()) {
				NameSalary ns = new NameSalary(); //DTO 객체생성
				ns.setName(rs.getString(1));  //조회된 이름을 DTO에 저장
				ns.setSalary(rs.getDouble(2)); //조회된 월급을 DTO에 저장 
				al.add(ns);
			}
			Chapter02_print p = new Chapter02_print();
			p.putData(al);
			p.showResult();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB접속 중 문제발생!");
		}
		finally {
			try {
				conn.close();
			} catch(Exception e) {}
		}
	}
}
class Chapter02_print {
	Chapter02_print(){}
	ArrayList<NameSalary> al;
	void putData(ArrayList<NameSalary> al) {
		this.al = al; //조회결과가 저장된 ArrayList를 받음
	}
	void showResult() {
		System.out.println("======조회결과======");
		Iterator it = al.iterator();
		while(it.hasNext()) {
			NameSalary ns = (NameSalary)it.next(); //ArrayList에 저장된 DTO를 가져옴
			String name = ns.getName(); //게터를 통해 DTO에 저장된 데이터를 가져옴
			Double salary = ns.getSalary();
			System.out.println(name+", "+salary);
		}
	} // ArrayList에 저장된 DTO를 화면에 출력함
	
}

public class Study2 {

	public static void main(String[] args) {
		Ch2_1 ch = new Ch2_1();
		ch.init();
	}
}
