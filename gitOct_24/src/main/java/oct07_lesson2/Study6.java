package oct07_lesson2;


//다형성 
class Human {
	Human(){}
	int money = 100;
	void callMe() {
		System.out.println("Human");
	}
}

// Asian 이 가지는 변수는 2개 => 부모와 내 money
// Asian 이 가지는 메서드는 1개 => callMe() => 부모의 메서드를 오버라이딩한거(부모의 메서드를 바꿈)
class Asian extends Human {
	int money = 200;
	void callMe() {
		System.out.println("Asian");
	}
}




public class Study6 {
	public static void main(String[] args) {
		Human h = new Human();
		h.callMe();
		Asian a = new Asian();
		a.callMe();
		
		// 다형성
		Human p = new Asian();
		
	}
}
