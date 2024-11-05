package oct01;

// 월드컵 본선 진출팀 16개국을 A와 B조로 나눔
// A조 8개국과 B조 8개국 이름출력

class WorldCup {
	WorldCup(){}
	String[] nations = { "이란", "일본", "대한민국", "사우디", "호주", "튀니지", "나이지리아", "모로코", 
						"이집트", "세네갈", "멕시코", "코스타리카","미국", "브라질","아르헨티나","우루과이" };


	//나라섞기
	void step1(){
		String temp;
		for(int i=0; i<200; i++) { //200번 섞기
			int nansu = (int)(Math.random()*16);
			temp = nations[0];
			nations[0] = nations[nansu];
			nations[nansu] = temp;			
		}		
	}
	void step2() {
		// 배열의 [0]~[7] 출력
		System.out.println("*** A조 ***");
		for(int i=0; i<8; i++) {
			System.out.print(nations[i] + " ");
		}
		
		// 배열의 [8]~[15] 출력
		System.out.println();
		System.out.println("*** B조 ***");
		for(int i=8; i<16; i++) {
			System.out.print(nations[i] + " ");
		}
	}
	
	
}



public class Study5_WCup {
	public static void main(String[] args) {
		WorldCup wCup = new WorldCup();
		wCup.step1();
		wCup.step2();

	}
}
