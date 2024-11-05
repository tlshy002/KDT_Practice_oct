package oct02_lesson1;

// 프로야구 모의경기
// 방문팀과 홈팀의 야구게임을 1회~9회까지 이닝별 점수를 출력하고 점수합계를 출력
// 방문팀 5개팀, 홈팀 5개팀
// 이닝별 점수는 난수로 (범위 0~5)

// 도전과제 추가)
// 1. 총점 출력
// 2. 홈팀의 경우 9회말을 안할 수도 있다. 
// (방문팀이 9회초를 해도 점수가 작아서 홈팀이 9회말을 안해도 되는경우)

class Playground {
	Playground(){}
	String[] eastern = { "두산 베어스", "롯데 자이언츠", "삼성 라이언즈", "SSG 랜더스", "KT 위즈" };
	String[] western = { "기아 타이거즈","엘지 트윈스", "키움 히어로즈", "한화 이글스", "NC 다이노즈" };
	Visit visit; Home home;
	
	// 초기화 메서드
	void init() {
		visit = new Visit(); 
		home = new Home();
		visit.name = eastern[rnd()]; //방문팀 이름 설정
		home.name = western[rnd()]; //홈팀 이름 설정
	}
	
	// 야구시작
	void doPlay() {
		for(int i=0; i<9; i++) {
			int visitScore = rnd0to5(); //초 공격 점수생성
			visit.inning[i] = visitScore;
			visit.total = visit.total + visitScore; //방문팀 점수누적
			
			if(i == 8) { //9회말 공격인지 비교
				// 방문팀 점수가 더크면 홈팀 9회말 공격
				if(visit.total >= home.total) { 
					int homeScore = rnd0to5(); //말 공격 점수생성
					home.inning[i] = homeScore;
					home.total = home.total + homeScore; //홈팀 점수누적
				} else {
					System.out.println("9회말 안함");
				}
			}	else {
				if(visit.total >= home.total) { 
					int homeScore = rnd0to5(); //말 공격 점수생성
					home.inning[i] = homeScore;
					home.total = home.total + homeScore; //홈팀 점수누적			
				}
			}			
		}
	}
	
	int rnd() {		
		return (int)(Math.random()*5);
	}
	int rnd0to5() {
		return (int)(Math.random()*6);
	}
	
	void printResult() {
		System.out.println("방문팀의 이름> " + visit.name);
		for(int i=0; i<9; i++) {
			System.out.print(visit.inning[i]+" ");
		}
		System.out.println("=> 총점: " + visit.total);
		System.out.println();
		System.out.println("홈팀의 이름> "+ home.name);
		for(int i=0; i<9; i++) {
			System.out.print(home.inning[i]+" ");
		}
		System.out.println("=> 총점: " + home.total);
		System.out.println();
	}
}

// 방문팀 객체
class Visit {
	Visit(){}
	String name;
	int[] inning = new int[9]; //9회 점수를 위한 점수
	int total;
}

// 홈팀 객체
class Home {
	Home(){}
	String name;
	int[] inning = new int[9]; //9회 점수를 위한 점수
	int total;
}


public class Teacher_Baseball {
	public static void main(String[] args) {
		Playground baseball = new Playground();
		baseball.init();
		//방문팀 이름출력
		//System.out.println(baseball.visit.name);
		//System.out.println(baseball.home.name);
		
		baseball.doPlay();
		baseball.printResult();
	}

}
