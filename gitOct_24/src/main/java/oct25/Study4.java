package oct25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

class NameJobSalary {
	private String name;//사원의 이름
	private String job_id;//업무코드
	private Double salary;//월급
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}//DTO
class Chapter02_12 {
	Connection con; PreparedStatement pstmt; ResultSet rs; ArrayList<NameJobSalary> al;
	String query = "select last_name, job_id, salary from employees"
			+ " where job_id in(?,?) and salary not in(?,?,?)";//PreparedStatement용 쿼리
	void init() {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME,"hr","hr");
			pstmt = con.prepareStatement(query);//PreparedStatement 인스턴스 생성
			pstmt.setInt(3, 2500);//세번째 물음표에 2500을 정수(int)로 넣는다.
			pstmt.setInt(4, 3500);//네번째 물음표에 3500을 정수로 넣는다.
			pstmt.setInt(5, 7000);//다섯번째 물음표에 7000을 정수로 넣는다.
			pstmt.setString(1, "SA_REP");//첫번째 물음표에 "SA_REP"를 문자열(String)로 넣는다.
			pstmt.setString(2, "ST_CLERK");//두번째 물음표에 "ST_CLERK"를 문자열로 넣는다.
			rs = pstmt.executeQuery();//select를 실행하고 결과를 ResultSet에 넣는다.
			al = new ArrayList<NameJobSalary>();
			while(rs.next()) {
				NameJobSalary njs = new NameJobSalary();
				njs.setName(rs.getString(1));//select 다음 첫번째 결과를 문자열(String)으로 저장
				njs.setJob_id(rs.getString(2));//select 다음 두번째 결과를 문자열로 저장
				njs.setSalary(rs.getDouble(3));//select 다음 세번째 결과를 실수(Double)로 저장
				al.add(njs);//DTO를 ArrayList에 저장한다.
			}
			showResult();//ArrayList에 저장된 조회결과를 출력한다.
		}catch(Exception e) {
			System.out.println("DB작업 중 문제발생!");
		}finally {
			try {
				con.close();//DB와 접속을 해제한다.
			}catch(Exception e) {}
		}
	}
	void showResult() {
		Iterator it = al.iterator();
		while(it.hasNext()) {
			NameJobSalary njs = (NameJobSalary)it.next();
			System.out.println(njs.getName()+","+njs.getJob_id()+","+njs.getSalary());
		}
	}//ArrayList에 저장된 조회결과를 출력하는 메서드
}//DAO
public class Study4 {

	public static void main(String[] args) {
		Chapter02_12 c12 = new Chapter02_12(); 
		c12.init();
	}

}
