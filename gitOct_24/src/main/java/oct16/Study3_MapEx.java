package oct16;

import java.util.HashMap;
import java.util.Scanner;

class S_Tel {
	Scanner sc;
	HashMap<String,String> phDB;
	S_Tel() {
		sc = new Scanner(System.in);
		phDB = new HashMap<String,String>();
	}
	void init() { //Map 에 저장
		phDB.put("박미정", "010-1234-1234");
		phDB.put("정수혁", "010-5555-1234");
		phDB.put("윤정철", "010-2222-1234");
	}
	void search() {
		System.out.println("학생의 이름을 입력하세요.");
		String name = sc.nextLine();
		int cnt = phDB.size();
		String result = phDB.get(name);
		if(result != null) {
			System.out.println("전화번호는 "+result+"입니다.");
		} else System.out.println("입력한 사람의 전화번호는 존재하지 않습니다.");
	}
}


public class Study3_MapEx {
	public static void main(String[] args) {
		S_Tel s = new S_Tel();
		s.init();
		s.search();
	}
}
