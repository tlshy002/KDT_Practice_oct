package oct08_lesson1;


// GS25가 있음.
// 라면 신라면 1500원
// 우유 바나나우유 1200원
// 빵 슈크림빵 2000
// 김밥 제육김밥 1000
// 편의점 사장이 편의점의 모든 상품의 가격합을 계산함. 가격합을 출력함
// 홍길동이 편의점의 라면과 김밥, 우유 구매함. 
// 홍길동이 구매한 상품의 가격합을 출력함

class GS25 {
	GS25(){}
	Owner owner = new Owner();
	HongGilldong gill = new HongGilldong();
	
	Ramen ramen = new Ramen("신라면", 1500);
	Milk milk = new Milk("바나나우유", 1200);
	Bread bread = new Bread("슈크림빵", 2000);
	Kimbab kimbab = new Kimbab("제육김밥", 1000);
}
class Owner{
	int total;
	void calculate(GS25 gs) {
		total = gs.ramen.price + gs.milk.price + gs.bread.price + gs.kimbab.price;
	}
	void printTotal() {
		System.out.println("편의점의 모든 상품의 합은 "+total+"원이다.");
	}	
}
class HongGilldong{
	int total;
	void buy(Ramen ramen, Milk milk, Kimbab kimbab) {
		total = ramen.price + milk.price + kimbab.price;
	}
	void buyPrint() {
		System.out.println("홍길동이 구매한 상품의 가격은 "+total+"원이다.");		
	}
}
class GS_Item {
	GS_Item(){}
	String name;
	int price;
	
	GS_Item(String name, int price) {
		this.name = name; 
		this.price = price;		
	}
}

class Ramen extends GS_Item {
	Ramen(){}
	Ramen(String name, int price){
		super(name, price);
	}
}
class Milk extends GS_Item {
	Milk(){}
	Milk(String name, int price){
		super(name, price);
	}
}
class Bread extends GS_Item {
	Bread(){}
	Bread(String name, int price){
		super(name, price);
	}
}
class Kimbab extends GS_Item {
	Kimbab(){}
	Kimbab(String name, int price){
		super(name, price);
	}
}







public class Study4 {
	public static void main(String[] args) {
		
		GS25 gs = new GS25();
		
		gs.owner.calculate(gs);
		gs.owner.printTotal();
		
		gs.gill.buy(gs.ramen, gs.milk, gs.kimbab);
		gs.gill.buyPrint();
		
		
		
	}
}
