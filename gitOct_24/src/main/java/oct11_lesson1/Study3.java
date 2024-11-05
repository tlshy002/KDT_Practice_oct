package oct11_lesson1;


// 인터페이스의 멤버는 상수와 추상메서드.
// 인터페이스 안의 메서드는 추상메서드만 가능함
// 근데 인터페이스 안의 추상메서드에는 abstract 키워드 생략가능함.
// 왜냐, 어차피 인터페이스 안에 메서드는 추상메서드만 존재가능하기 때문임

interface Test1 {
	final int MAX = 100; //상수만 가능
	int MIN = 10; //일반변수가 아닌 상수임	// 인터페이스 안에는 상수만 사용가능하기 때문에 final 생략가능	
	abstract void test1(); //abstract 생략가능
	void test2();
}
abstract class Test2 {	
}

public class Study3 {
	public static void main(String[] args) {
		//Test1 t1 = new Test1();
		//Test2 t2 = new Test2();
	}
}
