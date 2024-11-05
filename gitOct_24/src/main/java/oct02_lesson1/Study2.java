package oct02_lesson1;

import java.util.Scanner;

// 배열을 이용한 상품관리 시스템

// 등록할 상품코드를 입력하세요
// A100
// 등록할 상품이름을 입력하세요
// 키보드
// 등록할 상품의 가격을 입력하세요
// 15000 *주의할점 상품의 가격도 문자임
// 등록할 상품의 원산지를 입력하세요 (1:대한민국, 2:중국, 3:기타)
// 1
// --2번더 반복--
// 검색할 상품을 입력하세요
// 상품코드: A100, 상품이름: 키보드, 상품가격: 15000, 원산지: 대한민국, 등록일: 2024/10/02 15:09:05

class ManagementSystem {
	ManagementSystem(){}
	
	Item[] p = new Item[3];
	Scanner sc = new Scanner(System.in);
	//Today2 today = new Today2();
	
	// 상품등록 함수 (상품코드, 이름, 가격, 원산지)입력받기
	void itemAdd() {
		// 생김새 p[0] = new Item();
		for(int i=0; i<p.length; i++) {
			p[i] = new Item(); //인스턴스 생성
			
			System.out.println("등록할 상품코드를 입력하세요");
			p[i].iCode = sc.nextLine();
			System.out.println("등록할 상품이름을 입력하세요");
			p[i].iName = sc.nextLine();
			System.out.println("등록할 상품의 가격을 입력하세요");
			p[i].iPrice = sc.nextLine();
			System.out.println("등록할 상품의 원산지를 입력하세요");
			p[i].madein = sc.nextLine();			
			
			//p[i].todayDate = today.yyyymmdd() + today.hhmmss(); // 리턴메서드
			System.out.println(p[i].iCode + p[i].iName + p[i].iPrice + p[i].madein);
		}		
	}
	// 상품검색 함수
	
	
}

class Item {
	Item(){}
	String iCode;
	String iName;
	String iPrice;
	String madein;
	String todayDate;
}



public class Study2 {
	
	
	
	public static void main(String[] args) {
		ManagementSystem sys = new ManagementSystem();
		sys.itemAdd();
	}

}
