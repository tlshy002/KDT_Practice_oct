package oct07_lesson1;

// super 제어자


class GrandParent {
	GrandParent(){}
	int data1 = 50;
}

class Parent extends GrandParent {
	Parent(){}
	int data1 = 100;	
	void test() {
		System.out.println(super.data1);
	};
}

class Child extends Parent {
	Child(){}
	int data1 = 500; //이름이 같은 변수를 자식도 갖는다면?
	int data2 = 200; //부모를 상속받은 자식은 변수가 3개라고 볼수있다.
	void doIt() {
		System.out.println(data1+", "+super.data1);
	}
}


public class Study2 {
	public static void main(String[] args) {
		Child c = new Child();
		c.doIt();		
		c.test();
	}
}
