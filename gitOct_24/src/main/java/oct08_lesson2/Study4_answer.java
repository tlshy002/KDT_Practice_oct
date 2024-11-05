package oct08_lesson2;


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
	GS25(Ramen ramen, Milk milk, Bread bread, Kimbab kimbab){
		this.ramen = ramen;
		this.milk = milk;
		this.bread = bread;
		this.kimbab = kimbab;
		items[0] = ramen;
		items[1] = milk;
		items[2] = bread;
		items[3] = kimbab;
	}
	
	Sajang owner = new Sajang();
	MrHong hong = new MrHong();
	
	// Ramen ramen;	Milk milk;	Bread bread;	Kimbab kimbab;
	Sangpoom ramen; Sangpoom milk; Sangpoom bread; Sangpoom kimbab; //다형성
	//데이터 타입이 같으면 배열을 만들수있음
	Sangpoom[] items = new Sangpoom[4];
}
class Sajang {
	int sum;
	void calculate(GS25 gs) {
		sum = gs.ramen.price + gs.milk.price + gs.bread.price + gs.kimbab.price;
	}
	void printTotal() {
		System.out.println("편의점의 모든 상품의 합은 "+sum+"원이다.");
	}	
}



class MrHong {
	int sum;
	void buy(Sangpoom item) { sum += item.price; }
//	void buy(Ramen ramen) { sum += ramen.price;	}
//	void buy(Milk milk) { sum += milk.price; }
//	void buy(Kimbab kimbab) { sum += kimbab.price; }
	
	void buyPrint() {
		System.out.println("홍길동이 구매한 상품의 가격은 "+sum+"원이다.");		
	}
}

class Sangpoom {
	Sangpoom(){}
	String name;
	int price;
	
	Sangpoom(String name, int price) {
		this.name = name; 
		this.price = price;		
	}
}
class Milk extends Sangpoom {
	Milk(){}
	Milk(String name, int price){
		super(name, price);
	}
}
class Bread extends Sangpoom {
	Bread(){}
	Bread(String name, int price){
		super(name, price);
	}
}
class Kimbab extends Sangpoom {
	Kimbab(){}
	Kimbab(String name, int price){
		super(name, price);
	}
}

class Ramen extends Sangpoom {
	Ramen(){}
	Ramen(String name, int price){
		super(name, price);
	}
}

public class Study4_answer {
	public static void main(String[] args) {
		

		Ramen r = new Ramen("신라면", 1500);
		Milk m = new Milk("바나나우유", 1200);
		Bread b = new Bread("슈크림빵", 2000);
		Kimbab k = new Kimbab("제육김밥", 1000);
		
		GS25 gs = new GS25(r, m, b, k);
		
		gs.owner.calculate(gs);
		gs.owner.printTotal();
		
		gs.hong.buy(gs.ramen); // r과 gs.ramen의 인스턴스는 동일한 인스턴스임
		gs.hong.buy(gs.milk);
		gs.hong.buy(gs.kimbab);
		gs.hong.buyPrint();
		
		if(r == gs.ramen) { System.out.println("같다"); } 
		else { System.out.println("다르다"); }		
	}
}
