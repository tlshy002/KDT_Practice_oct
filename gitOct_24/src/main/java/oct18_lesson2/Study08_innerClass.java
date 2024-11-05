package oct18_lesson2;

// 내부클래스의 this 는 2가지의미가 있음. Two도 자신이고 Three도 자신이니까. 
// 현재인스턴스가 둘중 뭘 의미하는지 컴파일러가 모름
// 그래서 누구클래스의 인스턴스인지 표시해줘야함
class Two {
	class Three {
		//Three의 인스턴스냐, Two의 인스턴스냐?
		Two t = Two.this; //Two의 인스턴스를 뜻하는 this
		Three th = Three.this; 
	}
}

class One {
	One one;
	void doIt() {
		one = this; //this 의 의미: 현재의 인스턴스
	}
}


public class Study08_innerClass {
	public static void main(String[] args) {

	}
}
