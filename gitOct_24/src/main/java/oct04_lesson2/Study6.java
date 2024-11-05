package oct04_lesson2;

import java.util.Scanner;

// 2차원배열을 이용한 전세계 대륙별 국가이름 출력 시스템
class InternationalSys {
	InternationalSys(){}
	String[] cont = { "아시아", "유럽", "북미", "남미", "아프리카", "오세아니아" }; //대륙별 이름
	String[][] nations = {
			{ "한국","중국","일본","태국","베트남","라오스","캄보다이","필리핀","말레이지아" },
			{ "영국","프랑스","독일","스페인","포르투갈","스위스","스웨던","덴마크" },
			{ "미국","캐나다","멕시코","쿠바","버진아일랜드" },
			{ "브라질","아르헨티나","우루과이","칠레","콜럼비아","파나마" },
			{ "나이지리아","리비아","모로코","봉고","나미비아","오리셔스" },
			{ "호주","뉴질랜드" },
	};
	int menu;
	Scanner sc = new Scanner(System.in);
	
	void menu() {
		for(int i=0; i<cont.length; i++) {
			System.out.println((i+1)+") "+cont[i]);
		}
		System.out.println("원하는 번호를 입력하고 Enter를 누르세요");
		menu = sc.nextInt();
	}
	
	void showNations() {
		switch(menu) {
		case 1: for(int i=0; i<nations[0].length; i++) //0행의 
				System.out.println(nations[0][i]); break; //0~i 까지의 열
		case 2: for(int i=0; i<nations[1].length; i++) System.out.println(nations[0][i]); break;
		case 3: for(int i=0; i<nations[2].length; i++) System.out.println(nations[0][i]); break;
		case 4: for(int i=0; i<nations[3].length; i++) System.out.println(nations[0][i]); break;
		case 5: for(int i=0; i<nations[4].length; i++) System.out.println(nations[0][i]); break;
		case 6: for(int i=0; i<nations[5].length; i++) System.out.println(nations[0][i]); break;
		default: System.out.println("잘못된 선택입니다.");
		}
	}
}



public class Study6 {
	public static void main(String[] args) {
		InternationalSys sys = new InternationalSys();
		sys.menu();
		sys.showNations();		
	}
}
