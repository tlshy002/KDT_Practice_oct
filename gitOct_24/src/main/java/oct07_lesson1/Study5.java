package oct07_lesson1;



// super 생성자 설계하기
// 문제1: 클래스 Two 와 Three 의 생성자를 설계하기
class One {
	int i; String name;
	One(int i) { this.i = i; System.out.println("부모실행");}
	One(String name) { this.name = name; }
}

class Two extends One {
	Two(int i) {
		super(i);
	}
	Two(String name) {
		super(name);
	}
}

class Three extends Two {
	Three(int i) {
		super(i);
	}
	Three(String name) {
		super(name);
	}
}




public class Study5 {
	public static void main(String[] args) {
		Three th = new Three(1);	System.out.println(th.i);
		Three th2 = new Three("A");	System.out.println(th2.name);
	}

}
