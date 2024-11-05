package oct04_lesson2;

import java.util.Scanner;

// 2차원배열을 이용한 지뢰찾기
// 10행10열의 2차원배열에서 0이면 지뢰없음. 1이면 지뢰있음

class MineField {
	MineField(){
		mine = new int[10][10];
		putMine(); //지뢰설치 메서드호출
	}	
	int[][] mine; //2차원배열선언
	Scanner sc = new Scanner(System.in);
	
	int getRow() {
		System.out.println("지뢰가 있을만한 행의 위치를 입력하세요.(0~9사이)");
		return sc.nextInt();
	}
	int getCol() {
		System.out.println("지뢰가 있을만한 열의 위치를 입력하세요.(0~9사이)");
		return sc.nextInt();
	}
	
	
	void hint(int row, int col) { //선택한 위치의 주변(상하좌우)에 지뢰여부를 알려줌
		boolean flag = false;
		// if 문: 선택한 위치의 왼쪽과 오른쪽이 배열의 범위를 벗어나는지 확인.
		//왼쪽값이 -음수가 아니고 열의 범위를 안 벗어난다면~~
		if( (col-1) >= 0 && (col+1)< mine[0].length ) { 
			if(mine[row][col-1] == 1) flag = true;
			if(mine[row][col+1] == 1) flag = true;
		} //입력한 위치의 왼쪽(열-1)과 오른쪽(열+1)에 지뢰가 있는지(==1)를 검사함
		if( (col-1) >= 0 && (col+1)< mine[0].length ) { 
			if(mine[row-1][col] == 1) flag = true;
			if(mine[row+1][col] == 1) flag = true;
		} //입력한 위치의 위(행-1)와 아래(행+1)에 지뢰가 있는지(==1)를 검사함
		
		
		if(flag) {
			System.out.println("근처에 지뢰가 있습니다");
			
		}
	}
	
	
	
	void doIt() {
		int gameCount = 0; //게임횟수용 변수
		int found = 0; //찾은 지뢰 개수용 변수
		while(true) {
			int row = getRow(); //콘솔에서 행을 입력받음 
			int col = getCol(); //콘솔에서 열을 입력받음
			gameCount++; //게임횟수를 증가한다.
			if(mine[row][col] == 1) {
				System.out.println("지뢰를 찾았습니다!!");
				found++;
				System.out.println("지금까지 찾은 지뢰의 수: "+found);
				gameCount--; //지뢰를 찾은 경우 게임횟수를 증가시키지 않는다
				if(found == 10) break; //찾은 지뢰의 개수가 10개면 게임종료
			} else { //입력한 행과열에 지뢰가 없는경우
				System.out.println(row + ", " + col + "에 지뢰는 없습니다.");
				hint(row, col); //힌트 메세지를 출력한다. ex) 근처에 지뢰가 있습니다. 
			}
			if(gameCount == 10) break; //게임 횟수가 10번이면 게임종료
		}
		if(found == 10) System.out.println("승리를 축하합니다~"); 
		else System.out.println("다음 기회에...");
	}
	
	
	
	void putMine() { //지뢰설치 메서드
		System.out.println("*** 지뢰찾기 게임 ver 1.0 ***");
		System.out.println("지뢰의 개수를 입력하세요(1~99)");		
		int mineCount = 0; //지뢰개수
		int maxMineCount = sc.nextInt(); //입력받은 지뢰개수 저장
		
		while(true) {
			int row = (int)(Math.random()*10); //0~9까지의 난수. 행번호
			int col = (int)(Math.random()*10); //0~9까지의 난수. 행번호
			if(mine[row][col] == 0) { //지뢰가 없는경우
				mine[row][col] = 1; //1을저장(지뢰를설치)
				mineCount++;
			}
			if(mineCount == 10) break; //지뢰개수가 10개이면 반복종료
		}
		
		//지뢰확인 반복문
		for(int row=0; row<10; row++) {
			for(int col=0; col<10; col++) {
				System.out.print(mine[row][col]);
			}
			System.out.println();
		}
		
	}
	
}


public class Study9 {
	public static void main(String[] args) {
		MineField mf = new MineField();
		
		mf.putMine();
		mf.doIt();
	}

}
