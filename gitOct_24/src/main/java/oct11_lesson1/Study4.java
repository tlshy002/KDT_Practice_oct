
package oct11_lesson1;


//인터페이스 생성과정
//게임에 등장하는 캐릭터(왕,여왕,기사)와 무기(칼,도끼,활) 설계하기

//추가문제: 기존 설계에 새로운 캐릭터(마법사)와 무기(지팡이) 추가하기
//상속으로 설계하는 이유 => 확장이 쉬움
//이렇게 확장이 쉽도록 설계하는 방식(시스템을 만듦)을 객체지향(Object Oriented)



//모든 캐릭터의 조상
abstract class GameCharacter {
	Weapon weapon;
	abstract void display();
	void fight() {
		display();
		weapon.useWeapon();
	}
}
class Magician extends GameCharacter {
	Magician() { weapon = new Stick(); }
	@Override
	void display() { System.out.println("나는 마법사이다."); }	
}
class King extends GameCharacter { //왕
	//Sword sword;
	King(){ weapon = new Sword(); }
	void display() { System.out.println("나는 왕이다."); }
}
class Queen extends GameCharacter { //여왕
	//Axe axe;
	Queen(){ weapon = new Axe(); }
	void display() { System.out.println("나는 여왕이다."); }
}
class Knight extends GameCharacter { //기사
	//Bow bow;
	Knight(){ weapon = new Bow(); }
	void display() { System.out.println("나는 기사다."); }
}




// 인터페이스는 상속이 목적이므로 모든 멤버는 반드시 공개!!로 설계해야함
interface Weapon {
	abstract void useWeapon();
}
class Sword implements Weapon { //칼
	Sword(){}
	@Override
	public void useWeapon() { System.out.println("칼입니다."); } 
}
class Axe implements Weapon { //도끼
	Axe(){}
	@Override
	public void useWeapon() { System.out.println("도끼입니다."); }
}
class Bow implements Weapon { //활
	Bow(){}
	@Override
	public void useWeapon() { System.out.println("활입니다."); }
}
class Stick implements Weapon{
	Stick(){}
	@Override
	public void useWeapon() { System.out.println("지팡이입니다.");}
	
}

public class Study4 {
	public static void main(String[] args) {
		King king = new King();
		king.fight();
		
		Queen q = new Queen();
		q.fight();
		
		Knight k = new Knight();
		k.fight();
		
		Magician magic = new Magician();
		magic.fight();
	}
}
