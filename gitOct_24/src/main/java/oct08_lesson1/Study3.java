
package oct08_lesson1;

class Unit {
	int mana;
	void attack(Unit unit) { //인자에 new Marine, new Hidra, new Zilet 이 들어갈수있음
		unit.mana = unit.mana - 10; 
	}
//	void attack(Marine m) {
//		m.mana = m.mana - 10;
//	}
//	void attack(Hidra h) {
//		h.mana = h.mana - 10;
//	}
//	void attack(Zilet z) {
//		z.mana = z.mana - 10;
//	}
}
class Medic {
	Medic(){}
	void recover(Unit u) {
		u.mana = 100;
	}
	
	void recover(Marine m) {
		m.mana = 100;
	} //머린의 마나를 100으로 되돌리는 메서드
	void recover(Hidra h) {
		h.mana = 100;
	}
	void recover(Zilet z) {
		z.mana = 100;
	}
}

class Marine extends Unit {
	Marine(int mana) { this.mana = mana; }	
}
class Hidra extends Unit {
	Hidra(int mana) { this.mana = mana; }
}
class Zilet extends Unit {
	Zilet(int mana) { this.mana = mana; }
}




public class Study3 {
	public static void main(String[] args) {
		Marine m1 = new Marine(100); System.out.println(m1.mana); //100
		Hidra h1 = new Hidra(100); System.out.println(h1.mana); //100
		Zilet z1 = new Zilet(100); System.out.println(z1.mana); //100
		
		//머린이 히드라를 공격
		m1.attack(h1); System.out.println(h1.mana); //90		
		//질럿이 히드라 공격
		z1.attack(h1); System.out.println(h1.mana); //80		
		//히드라가 머린 공격
		h1.attack(m1); System.out.println(m1.mana); //90
		
		Medic medic = new Medic();
		medic.recover(h1);
		System.out.println(h1.mana);
		
	}
}
