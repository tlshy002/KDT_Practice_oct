package oct04_lesson2;

import java.util.Scanner;

// 서울시의 구이름을 선택하거나(1~n) 구이름을 입력하면, 해당 구의 맛집목록 출력

class FoodRecommendSys {
	Scanner sc = new Scanner(System.in);
	String[] gu = { "은평구", "서대문구", "마포구", "종로", "강남구", "강북구" };
	String[][] foodOfGu = {
			{"a", "b", "c"},
			{"a", "b", "c", "뭔가맛집"},
			{"a", "아무튼맛집"},
			{"무슨무슨 맛집", "좋은맛집", "유명맛집", "육사시미집"},
			{"직장인밥집"},
			{"a", "b", "c"},
	};
	int localCode=0;
	
	void menu() {
		System.out.println("*** 서울시 구별 맛집리스트 추천시스템 ver1.0 ***");
		for(int row=0; row<gu.length; row++) {
			System.out.println((row+1)+") "+ gu[row]);
		}
		System.out.println("해당하는 구 번호나 이름을 입력하고 Enter를 누르세요");
		String menu = sc.nextLine();
		
		for(int row=0; row<gu.length; row++) {
			if( menu.equals(gu[row]) ) { // 구이름으로 입력받은경우 정수로 바꾸기
				localCode = row;
			} else { 
				localCode = Integer.parseInt(menu) -1 ; //숫자로 입력받은경우도 정수로 바꾸기
			}
		}
	}
	
	void showFoodList() {
		for(int i=0; i<foodOfGu[localCode].length; i++) {
			System.out.println("● "+ foodOfGu[localCode][i]);
		}		
	}
	
	
}




public class Study8 {
	public static void main(String[] args) {
		FoodRecommendSys sys = new FoodRecommendSys();
		sys.menu();
		sys.showFoodList();
	}

}
