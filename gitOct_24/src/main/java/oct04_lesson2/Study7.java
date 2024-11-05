package oct04_lesson2;

import java.util.Scanner;

// 2차원배열을 이용한 맥주추천 시스템

class BeerRecommend {
	BeerRecommend(){}
	Scanner sc = new Scanner(System.in);
	String[] color = { "밝은황색","갈색","흑색","적색","노란색" };
	String[][] beers = {
			{ "OB라거", "크라운 비어", "코로나" },	
			{ "버드와이저", "하이네켄", "칭따오", "카스" },	
			{ "기네스", "스타우트", "블랙야크", "코렐", "다크엔젤" },	
			{ "기린", "아이리스", "레드드래건", "KGB" },	
			{ "에델바이스", "옐로우하우스", "야크", "엑스트림" },	
	}; //색깔별 맥주
	
	int menu() {
		System.out.println("*** 맥주 소개 시스템 ver1.0 ***");
		for(int i=0; i<color.length; i++) {
			System.out.println((i+1)+") "+ color[i]);
		}
		System.out.println("원하는 번호를 입력하고 Enter를 누르세요");
		return sc.nextInt(); //Study6에서는 menu 를 인스턴스변수로 두고 menu()함수를 void 로 했는데 이번에는 리턴함수사용함
	}
	
	void doIt() {
		int menu = menu();
		System.out.println("다음의 맥주를 추천합니다~");
		for(int i=0; i<beers[menu-1].length; i++) {
			System.out.println("● " +beers[menu-1][i]);
		}
		System.out.println("이용해주셔서 감사합니다");
	}
	
	
	
}




public class Study7 {
	public static void main(String[] args) {
		BeerRecommend sys = new BeerRecommend();
		sys.doIt();
		
	}
}
