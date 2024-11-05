package oct04_lesson1;

import java.util.Scanner;

// 배열과 클래스를 사용한 영한사전 시스템


class EngKorDictionarySys {
	EngKorDictionarySys(){}
	Scanner sc = new Scanner(System.in);
	Word[] word; // 인스턴스배열 선언
	
	void init() {
		word = new Word[10]; //10개의 배열생성		
		// 인스턴스 생성!
		word[0] = new Word("sun", "태양");		word[5] = new Word("tree", "나무");
		word[1] = new Word("car", "차");			word[6] = new Word("way", "길");
		word[2] = new Word("flower", "꽃");		word[7] = new Word("moon", "달");
		word[3] = new Word("sea", "바다");		word[8] = new Word("river", "강");
		word[4] = new Word("star", "별");		word[9] = new Word("dream", "꿈");
	}

	void findWord() {
		boolean notFound = true;
		System.out.println("검색할 영어단어를 입력하세요.");
		String str = sc.nextLine();
		for(int i=0; i<word.length; i++) {
			if( (word[i].eng).equals(str) ) {
				System.out.println("단어의 뜻: "+word[i].kor);
				notFound = false; //단어를 찾았으니 아래 if문 실행안함 
				break;
			}			
		}
		if(notFound) System.out.println("단어를 찾을 수 없습니다.");
		System.out.println("사전 시스템을 종료합니다.");
	}
}

class Word {
	Word(){}
	Word(String eng, String kor){
		this.eng = eng; this.kor = kor;
	}
	String eng;	String kor;
}

public class Study2 {
	public static void main(String[] args) {
		EngKorDictionarySys sys = new EngKorDictionarySys();
		
		
		sys.init();
		sys.findWord();
		
	}
}
