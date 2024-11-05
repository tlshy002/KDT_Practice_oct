package oct07_lesson1;


//문제2 클래스Dool과 Seet의 생성자 설계 
class Hana {
	int i;
	int j;
	double k;
	Hana(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("할아버지 실행");
	}
	Hana(double k) {
		this.k = k;
		System.out.println("할아버지 실행");
	}
}
class Dool extends Hana {
	Dool(int i, int j) {
		super(i, j);
	}
	Dool(double k) {
		super(k);
	}
}

class Seet extends Dool {
	Seet(int i, int j) {
		super(i, j);
	}
	Seet(double k) {
		super(k);
	}
	
}



public class Study6 {
	public static void main(String[] args) {
		Hana hana1 = new Hana(5,6);
		Hana hana2 = new Hana(3.14);
		Dool dool1 = new Dool(5,6);
		Dool dool2 = new Dool(3.14);
		Seet seet1 = new Seet(5,6);
		Seet seet2 = new Seet(3.14);
		
		System.out.println(hana1.i+", "+ hana1.j +", "+ hana2.k);
		System.out.println(dool1.i+", "+ dool1.j +", "+ dool2.k);
		System.out.println(seet1.i+", "+ seet1.j +", "+ seet2.k);
		
		
	}

}
