package oct18_lesson2;

import javax.swing.JOptionPane;


// 스레드예제: 10초동안 사용자가 입력하지 않으면 프로그램 종료
class InputThread extends Thread { // 데이터를 입력받는 스레드
	InputThread(){}
	public void run() {
		System.out.println("10초 이내에 입력해야합니다.");
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요."); //자료입력창 출력
		Study06.inputCheck = true; //값이 입력되었다고 선언
		System.out.println("입력한 값은 "+input+"입니다.");
	}	
}
//카운트다운 진행 스레드
class CountDownThread extends Thread {
	CountDownThread(){}
	public void run() {
		for(int i=10; i>0; i--) {
			if(Study06.inputCheck) break; //입력값을 받았기때문에 카운트다운 중단
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초동안 대기
			} catch(Exception e) {}
		}
		if(Study06.inputCheck) {
			System.exit(0); //모든 프로그램을 종료함
		}
		System.out.println("10초동안 값이 입력되지 않아 종료합니다.");
		System.exit(0); //모든 프로그램을 종료함
	}	
}
// 입력받았을때 카운트다운을 멈추게 하고 싶음.
// 입력받는 스레드와 카운트다운의 스레드는 독립적인데, 입력받았는지 카운트다운스레드가 어떻게 아는가?
// 독립적인 두 스레드 사이를 연결할 징검다리 역할의 무언가?가 필요함. 
// 어떻게 구현할까? ---> static boolean inputCheck = false; static 이라 인스턴스 만들필요없어서 이럴때 빠르게 사용가능함!


public class Study06 {
	static boolean inputCheck = false; //false:입력되지 않음. true:입력됨

	public static void main(String[] args) {		
		InputThread it = new InputThread();
		CountDownThread ct = new CountDownThread();
		it.start();
		ct.start();
	}
}
