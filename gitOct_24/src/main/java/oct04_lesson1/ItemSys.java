package oct04_lesson1;

import java.util.Scanner;

class ItemManagementSys {
	ItemManagementSys(){}
	Item[] item = new Item[2];
	
	Scanner sc = new Scanner(System.in);
	
	
	void findItem() {
		System.out.println("검색하려는 상품의 코드를 입력하세요.");
		String name = sc.nextLine();
		
	}
	
	
	
	String findNation(int code) {
		String nation="";
		switch(code) {
		case 1: nation = "대한민국";
		case 2: nation = "중국";
		case 3: nation = "기타";
		}		
		return nation;
	}
}

class Item {
	Item(){}
	String iCode;
	String iName;
	String iPrice;
	String madeIn;
	String time;
	
}


public class ItemSys {
	public static void main(String[] args) {

	}

}
