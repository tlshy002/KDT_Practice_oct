package oct02_lesson1;

import java.util.Scanner;

import oct02_lesson2.Today;

// 배열을 이용한 간단한 게시글 작성 시스템
// 콘솔에 작성자의 이름, 제목, 내용, 작성일을 입력해서 게시글을 시스템에 등록함
// 등록된 게시글에서 작성자 명으로 게시글을 검색한다

class BBSsystem {
	BBSsystem(){}
	//게시글(BBS)인스턴스를 N개 담을 배열 선언(배열이 아직 생성되지 않음)
	//배열만들었다고 착각하면 안돼! 
	//배열만들때 크기를 알아야만드는데 인스턴스 몇개만들지는 init()에서 입력받을거임
	BBS[] bbs; 
	Scanner scan = new Scanner(System.in);
	
	
	//게시글 개수 입력메서드
	void init() {
		System.out.println("*** 게시글 관리 시스템 ver1.0 ***");
		System.out.println("작성할 게시글의 수를 입력하세요.");
		int count = scan.nextInt();
		scan.nextLine(); //게시글 수를 입력한 후 Enter 처리
		bbs = new BBS[count]; //입력한 게시글 수로 배열을 생성 //배열 몇개 만들지를 여기서 입력받음
	}
	//게시글 등록 메서드
	void inputBBS() {
		for(int i=0; i<bbs.length; i++) { //입력한 게시글 개수만큼 (배열길이)반복
			BBS bbs = new BBS(); //게시글 인스턴스 생성
			
			System.out.println("작성자를 입력하세요");
			bbs.writer = scan.nextLine(); //콘솔에서 입력한 이름을 저장
			System.out.println("글 제목를 입력하세요");
			bbs.title = scan.nextLine();
			System.out.println("글 내용을 입력하세요");
			bbs.content = scan.nextLine();
			Today today = new Today();
			bbs.inputDate = today.yyyymmdd()+" "+today.hhmmss();
			
			this.bbs[i] = bbs; //작성된 게시글(BBS)를 배열에 저장
			// this.bbs 는 메서드밖에 선언한 인스턴스배열이고 bbs는 for문의 지역인스턴스변수

		}
	}
	
	//게시글 찾기
	void find() {
		System.out.println("*** 게시글 검색하기 ***");
		System.out.println("작성자 명을 입력하세요");
		String name = scan.nextLine(); //콘솔에 입력한 이름을 변수에 저장
		for(int i=0; i<bbs.length; i++) {
			if(name.equals(bbs[i].writer) ) {
				System.out.print("#글제목: "+bbs[i].title);
				System.out.print("#글내용: "+bbs[i].content);
				System.out.print("#작성일: "+bbs[i].inputDate);
				break; //게시글을 찾았으므로 반복 중단
			}
		}
		
		
	}

}

class BBS {
	BBS(){}
	String writer; //작성자
	String title; //제목
	String content;
	String inputDate;
}


public class Study1 {
	public static void main(String[] args) {
		Today today = new Today();
		BBSsystem bs = new BBSsystem();
		bs.init();
		bs.inputBBS();

		bs.find();
	}
}
