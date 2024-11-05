package oct18_lesson2;


class SecondThread extends Thread {

	public void run() { //main()역할
		for(int i=0; i<500; i++) {
			System.out.print("+");
		}// +를 500개 출력
	}	
}
class ThirdThread implements Runnable {

	public void run() { //main()역할
		for(int i=0; i<500; i++) {
			System.out.print("-");
		}// -를 500개 출력
		
	}	
}

public class Study03_Thread {
	public static void main(String[] args) {
		SecondThread thread2 = new SecondThread();
		
		
		Runnable thread3 = new ThirdThread(); // Runnable 타입으로 객체 생성하고
		Thread thread_3 = new Thread(thread3); // 그 객체로 스레드 객체생성
		
		thread2.start();
		thread_3.start();
	}
}
