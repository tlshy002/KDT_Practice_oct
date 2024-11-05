package oct11_lesson1;



class SangsuTest {
	int data1 = 10; //변수선언
	final int data2 = 20; //상수선언
	final int DATA3 = 30; //상수선언
	static final int DATA4 = 40; //상수선언
	
	
	void test() {
		data1 = 100; //변수에 저장된 데이터 변경가능
		//data2 = 100; //상수에 저장된 데이터 변경불가능
	}
	final void doIt() { //final 이 붙은 메서드는 오버라이딩 할수없음. (즉, 자식이 바꿀수없음)
		System.out.println("diIt");
	}
}

class SangsuChild extends SangsuTest {

	@Override
	void test() {
		// TODO Auto-generated method stub
		super.test();
	}	
}

final class Parent {
	Parent(){}
}
//class Child extends Parent {
//}


public class Study1 {
	public static void main(String[] args) {
		SangsuTest test = new SangsuTest();
		int a = test.DATA3;
		int b = SangsuTest.DATA4;
	}
}
