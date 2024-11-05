package oct07_lesson2;


abstract class Temporary {
	void test() { System.out.println("test"); }
	abstract void doIt();
	abstract void doDo();
	void doSome() { System.out.println("doSome"); }
}

class Complete extends Temporary {

	@Override
	void doIt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void doDo() {
		// TODO Auto-generated method stub
		
	}
	
}


//에러발생 이유?
//상속하지 않고 바로 인스턴스로 사용?? 불가능
//추상클래스의 목적은 오직 상속으로 사용하는 것이기때문에 직접 인스턴스 생성할 수 없음.


abstract class King {
	int gold = 100;
	abstract void callMe();
}
class Queen extends King {
	int gold = 150;
	void callMe() { System.out.println("나는 왕비다"); }
}
class Prince extends Queen {
	int gold = 200;
	void callMe() { System.out.println("나는 왕자다"); }
}
class Princess extends Prince {
	int gold = 250;
	void callMe() { System.out.println("나는 공주다"); }
}






public class Study8 {
	public static void main(String[] args) {
		
		//다형성
		King q = new Queen();		System.out.println(q.gold);
		q.callMe();
		King pr = new Prince();		System.out.println(q.gold);
		pr.callMe();
		King pc = new Princess();	System.out.println(q.gold);
		pc.callMe();
		
		
		
	}
}
