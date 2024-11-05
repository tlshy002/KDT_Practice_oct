package oct01;

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
	
	int visitScore = 0;
	int homeScore = 0;
	
	void totalScore() {		
		//방문팀은 9회말까지 진행한걸 더함
		for(int i=0; i<9; i++) {
			visitScore += visit.inning[i]; 
		}
		//홈팀은 8회말까지 진행한걸 더함
		for(int i=0; i<8; i++) {
			homeScore += home.inning[i];
		}
	}
	

	void printResult() {
		
		System.out.println("방문팀의 이름> " + visit.name);
		for(int i=0; i<9; i++) {
			System.out.print(visit.inning[i]+" ");
		} System.out.println();		
		
		// 홈팀은 8회말까지 진행
		System.out.println("홈팀의 이름> "+ home.name);		
		for(int i=0; i<8; i++) { 
			System.out.print(home.inning[i]+" ");
		}
		
		//방문팀은 9회말까지의 합, 홈팀은 8회말까지의 점수합
		totalScore();
		
		// 홈팀 8회말까지만 해도 이미 방문팀보다 점수가 크면
		if(homeScore > visitScore) { 
			home.inning[8] = 0; //홈팀 9회말을 0점으로
			System.out.println(home.inning[8]);		
			System.out.println("홈팀은 9회말 안했어요~!");
		} else {
			System.out.print(home.inning[8]);
			homeScore = homeScore + home.inning[8]; //홈팀9회말 결과를 총합에 반영
		} System.out.println();
		
		
		System.out.println("방문팀 총점> "+visitScore);
		System.out.println("홈팀 총점> "+homeScore);
		
	} //----------------------------- 결과출력 메서드
	
	
	// 초기화 메서드
	void init() {
		visit = new Visit(); 
		home = new Home();
		visit.name = eastern[rnd()]; //방문팀 이름 설정
		home.name = western[rnd()]; //홈팀 이름 설정
	}
	
	// 야구시작
	void doPlay() {
		// 9회말 공격
		for(int i=0; i<9; i++) {
			visit.inning[i] = rnd0to5(); //초
			home.inning[i] = rnd0to5(); //말
		}
	}
	

	

	
	int rnd() {		
		return (int)(Math.random()*5);
	}
	int rnd0to5() {
		return (int)(Math.random()*6);
	}
}

// 방문팀 객체
class Visit {
	Visit(){}
	String name;
	int[] inning = new int[9]; //9회 점수를 위한 점수
}

// 홈팀 객체
class Home {
	Home(){}
	String name;
	int[] inning = new int[9]; //9회 점수를 위한 점수
}


public class Study6_BaseBall {
	public static void main(String[] args) {
		Playground baseball = new Playground();
		baseball.init();
		
		//방문팀 이름출력
		System.out.println(baseball.visit.name);
		System.out.println(baseball.home.name);
		
		baseball.doPlay();
		baseball.printResult();
		
	}

}
