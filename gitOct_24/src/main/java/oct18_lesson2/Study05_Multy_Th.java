package oct18_lesson2;

import javax.swing.JOptionPane;

//멀티스레드

// 화면에서 데이터를 입력받는 스레드
class Thread1 extends Thread {

	public void run() {
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요."); //자료입력창 출력
		System.out.println("입력한 값은 "+input+"입니다.");
	}
	
}
// 카운트다운 진행 스레드
class Thread2 extends Thread {

	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초동안 대기
			} catch(Exception e) {}
		}
		System.out.println("펑!");
	}
	
}

public class Study05_Multy_Th {
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();

	}
}
