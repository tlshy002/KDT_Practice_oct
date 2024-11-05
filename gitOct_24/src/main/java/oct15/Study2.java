package oct15;

import java.util.ArrayList;
import java.util.LinkedList;

// 컬렉션 프레임워크에는 서로다른 데이터타입의 데이터가 저장됨
// 특정한 형태의 데이터만 저장할 수도 있음
// 예를 들어, 정수만 저장할 수 있는 컬렉션 프레임워크를 생성할 수 있음
// DB할때 제네릭으로만 처리함. DB데이터가 오염되면 안되니까
// 컬렉션 프레임워크를 특정한 데이터만 저장하도록 선언하는 방법 => 제네릭(Generic)


class SuperMan {}
class SuperWoman {}

class GenericTest {
	GenericTest(){}
	void doIt() {
		// 일반적인 컬렉션프레임워크 선언 
		ArrayList al1 = new ArrayList();
		al1.add(1); al1.add(new SuperMan());  //아무거나 저장됨		
	
		// 모든 기본형데이터가 객체타입으로 바뀌는거 오토박스
		//제네릭으로 정수(int가 아닌 객체타입(Integer,레퍼클래스)임!)만 저장되는 컬렉션 프레임워크 선언
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(100); al2.add(new Integer(300)); //al2.add(3.14); //실수이므로 에러
		
		// SuperMan 인스턴스만 저장되는 컬렉션 프레임워크 선언
		LinkedList<SuperMan> al3 = new LinkedList<SuperMan>();
		al3.add(new SuperMan());  // al3.add(SuperWoman()); //SuperMan인스턴스가 아니므로 에러
	
		
		
	}
}


public class Study2 {
	public static void main(String[] args) {
		
		
		


	}
}
