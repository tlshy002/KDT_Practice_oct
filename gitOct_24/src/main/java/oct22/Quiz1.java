package oct22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//SQL 2장의 연습문제 1번
// 자바와 <--> DB를 연결할때
// 자바에서는 클래스를 준비하고 오라클은 라이브러리를 준비해야한다

// 토스모바일 요금제 개통후기 및 가격비교
// https://blog.naver.com/vangarang/223034931967
class OracleXE11g {
	static final String LIB = "oracle.jdbc.driver.OracleDriver";
	static final String NAME = "jdbc:oracle:thin:@localhost:1521:XE";
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

class NameSalary { 
	NameSalary(){}
	String name; //이름 저장변수
	Double salary; //월급 저장변수
	
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


// DB에 접속하는 역할을 하는 클래스,객체 ==> DAO(Data Access Object)
class Chapter02 { 
	Chapter02(){}
	Connection conn; // DB와의 접속
	Statement stmt; // SQL을 DB로 전송
	ResultSet rs; // DB의 결과 처리
	
	// 쿼리문에 ;세미콜론 빼라
	String query = "select last_name, salary from employees where salary > "; 
	Scanner sc; // 콘솔을 통해 데이터입력받음
	ArrayList<NameSalary> al; //NameSalary클래스의 객체만 저장되는 ArrayList 선언
	
	void init() {
		try {
			Class.forName(OracleXE11g.LIB); //오라클 라이브러리 호출
			conn = DriverManager.getConnection(OracleXE11g.NAME,"hr","hr");
			stmt = conn.createStatement();
			al = new ArrayList<NameSalary>(); // ArrayList 생성
			
			int salary = getFromConsole(); // 콘솔에 입력받은 값 할당
			query += salary; //입력받은 값을 쿼리문에 합침
			rs = stmt.executeQuery(query); //실행결과를 받음
			System.out.println(query);
			
			// 수신한 결과를 DTO에 저장함
			while(rs.next()) {
				NameSalary ns = new NameSalary(); //DTO인스턴스 생성
				// 이름조회
				String name = rs.getString(1); // Select 다음의 1번째를 String 으로 수신함
				// 월급조회
				Double money = rs.getDouble(2);// Select 다음의 2번째를 Double 로 수신함
				
				ns.setName(name);// 조회된 이름을 세터를 이용해서 DTO에 넣음
				ns.setSalary(money);// 조회된 월급을 세터를 이용해서 DTO에 넣음
				al.add(ns); // 조회결과가 저장된 DTO 객체를 ArrayList에 저장				
			}
			Chapter02_print p = new Chapter02_print();
			p.putData(al);
			p.showResult();
			
			
		} catch(Exception e) {
			System.out.println("DB 작업 중 문제발생!");
		} finally {
			// DB접속 해제
			// 접속과 해제는 반드시 쌍으로 처리해야함. 파일처리와 네트워크도 동일함. 
			try {
				conn.close();
			} catch(Exception e) {}
		}
	}// doIt() 
	
	int getFromConsole() {
		sc = new Scanner(System.in);
		System.out.println("검색하려는 월급을 입력하세요.");
		int salary = sc.nextInt();
		return salary;
	}
} // class 끝===============================================

public class Quiz1 {
	public static void main(String[] args) {
		Chapter02 c = new Chapter02();
		c.init();
	
		
		
		
	}
}
