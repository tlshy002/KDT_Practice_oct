package oct11_lesson1;


//인터페이스 정리
//인터페이스의 정체: 인터페이스는 상수와 추상메서드를 멤버로 가짐
//인터페이스도 추상클래스처럼 상속이 목적임 => 따라서 인스턴스 생성안됨

//인터페이스를 만들면 public 을 안적어도 문제없지만, 오버라이딩할때 public 꼭 표기하기
//인터페이스의 멤버는 무조건 완전공개(public)임
//인터페이스에는 public 이 생략되어 있음을 꼭 알아둬.
//인터페이스의 메서드 앞에 abstract 생략되어있음
//인터페이스의 상수 앞에 final 생략되어있음

//인터페이스는 상속한다고 안하고 "구현한다"라고 표현함. implements 키워드 사용함
//인터페이스 간에 상속가능함 인터페이스 간에 상속할땐 extends 키워드 사용
//인터페이스 간에는 다중 상속이 가능함

interface Bird {}
interface Horse {}

//인터페이스가 인터페이스 상속할때 extends 사용하고 다중상속가능
interface Unicorn extends Bird, Horse { 
	
}
class MyCar implements Unicorn { //클래스가 인터페이스를 사용할땐 implements 사용
	
}

public class Study5 {
	public static void main(String[] args) {

	}
}
