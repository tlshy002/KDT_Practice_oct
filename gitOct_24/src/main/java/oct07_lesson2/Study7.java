package oct07_lesson2;



// 다형성의 특징 ===> 반드시 암기!!!
// 1. 다형성으로 사용할 수 있는 변수는 오직 부모의 변수임
// 2. 다형성으로 사용할 수 있는 메서드는 오버라이딩한 메서드. 오버라이딩한 메서드가 없으면 부모의 메서
class Company {
	Company(){}
	int size = 500; 
	double output = 567.879;
	void doIt() { System.out.println("Company"); }
	void doDo() { System.out.println("Company2"); }
}

class Samsung extends Company {
	Samsung() { super(); }
	int size = 1000;	int sum = 20000;
	void doIt() { System.out.println("Samsung"); }
	void callMe() { System.out.println("Samsung2"); }
}



public class Study7 {
	public static void main(String[] args) {
		Company c = new Samsung(); //다형성
	}
}
