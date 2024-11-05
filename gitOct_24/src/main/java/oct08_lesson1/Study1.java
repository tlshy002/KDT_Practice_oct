package oct08_lesson1;


// 상속과 다형성 예제
// 손님이 컴퓨터,TV,바나나,사과를 구매하는 설계
// 1차설계: 상속을 사용하지 않고 클래스를 설계
class Guest {
	Guest(int money){ this.money = money; }
	int money; //용돈 변수선언
	
	void buy(Item item) {
		money = money - item.price;
	}
	
}
class Item {
	int price;
	Item(int price) { this.price = price; }
}
class Computer extends Item {
	Computer(int price) { super(price); }
}
class TV extends Item {
	TV(int price) { super(price); }
}
class Banana extends Item {
	Banana(int price) { super(price); }
}
class Apple extends Item {
	Apple(int price) { super(price); }
}



public class Study1 {
	public static void main(String[] args) {
		Guest guest = new Guest(1000000);
		
		// 다형성
		Item com = new Computer(400000);
		Item tv = new TV(500000);
		Item banana = new Banana(3000);
		Item apple = new Apple(10000);
		
		guest.buy(com); System.out.println(guest.money); //잔액출력
		guest.buy(tv); System.out.println(guest.money);
		guest.buy(banana); System.out.println(guest.money);
		guest.buy(apple); System.out.println(guest.money);
		
	}
}
