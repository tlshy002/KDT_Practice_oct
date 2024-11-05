package oct07_lesson1;



class A {
	A(){}
	int data1 = 1;
	void test() {
		System.out.println("클래스 A의 test메서드");
	}
}
// B가 A를 상속함. A가 부모 B가 자식클래스
class B extends A {
	B(){}
}

class BB extends B {
	
}


public class Study1 {
	public static void main(String[] args) {
		B b = new B();
		b.test();
	}
}
