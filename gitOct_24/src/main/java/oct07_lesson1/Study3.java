package oct07_lesson1;

// super 생성자


class Cat {
	int age;
	Cat(int age) {
		this.age = age;
	}
}
class Tiger extends Cat {
	Tiger(){
		super(123); // Cat(123); 부모인스턴스를 호출해서 생성을 해야 자식이 만들어짐
	} 
} 


class Korean {
	Korean(){
		System.out.println("Korean 생성자");
	}
}
class MrLee extends Korean {
	MrLee(){
		super(); //부모 생성자 호출
		System.out.println("MrLee 생성자"); //자식생성자가 부모생성자를 호출
	}
}



public class Study3 {
	public static void main(String[] args) {
		Cat cat1 = new Cat(1);
		MrLee lee = new MrLee(); //자식의 생성자를 호출하니 부모생성자도 같이 호출됨
		
		
		
	}
}
