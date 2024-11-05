package oct11_lesson1;


//상수 예제

//사원정보: 사원이름, 사워의 부서번호, 사원월급, 사원의 입사일
//부서번호: 개발부(30) 홍보부(40) 영업부(50) 총무부(60)
class Employee {
	Employee(){}
	static final int SOFT = 30;
	static final int AD = 40;
	static final int SALE = 50;
	static final int TOTAL = 60;

	
	String name; int department_no; int salary; String hire_date;
	Employee(String name, int department_no, int salary, String hire_date) {
		this.name = name; this.department_no = department_no; this.salary = salary; this.hire_date = hire_date; 
	}
}

public class Study2 {
	public static void main(String[] args) {
		Employee emp1 = new Employee("홍길동",Employee.SOFT,300,"2024-10-05");
		Employee emp2 = new Employee("김길동",Employee.AD,350,"2024-08-20");
		Employee emp3 = new Employee("이길동",Employee.SALE,400,"2024-07-14");
		Employee emp4 = new Employee("최길동",Employee.TOTAL,450,"2024-06-19");
	}
}
