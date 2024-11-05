package oct04_lesson1;









class Product {
	Product(){}
	Product(String code, String name, String price, String madeIn) {
		this.code = code; 
		this.name = name;
		this.price = price;
		this.madeIn = madeIn;
	}
	
	Product(String code, String name, String price) {
		//this.code = code; this.name = name; this.price = price; madeIn = "대한민국";
		
		//모든생성자가 같은일을함. 하는일이 겹치는데 생성자가 생성자를 호출하는건 어떨까? 짬처리시키기
		//메서드가 메서드 호출하듯이 생성자가 생성자를 호출할수있다. 
		//하지만! 이름을 바꿔서 호출해야함. --> 이름을 this 로 바꿔서 호출함 => this 생성자
		this(code, name, price, "대한민국");
		
	}
	
	Product(String code, String name){
		//this.code = code; this.name = name; price = "10,000"; madeIn = "대한민국";
	}
	
	String code;
	String name;
	String price;
	String madeIn;
}

public class Study1 {
	public static void productTest() {
		Product p1 = new Product();
		p1.code = "A123"; p1.name = "키보드"; p1.price = "1,000"; p1.madeIn = "미국";
		
		Product p2 = new Product("B123", "마우스", "5,000", "중국");
		Product p3 = new Product("C123", "마우스", "5,000"); //원산지 생략하면 대한민국
		Product p4 = new Product("D123", "마우스", "중국"); //가격생략하면 10,000
		
		System.out.println(p1.code+", "+p1.name+", "+p1.price+", "+p1.madeIn);
		System.out.println(p2.code+", "+p2.name+", "+p2.price+", "+p2.madeIn);
		System.out.println(p3.code+", "+p3.name+", "+p3.price+", "+p3.madeIn);
		System.out.println(p4.code+", "+p4.name+", "+p4.price+", "+p4.madeIn);
		
	}
	public static void main(String[] args) {
		
	
	}
}