package oct18_lesson2;


class T1 implements Runnable {
	public void run() {	}
}

public class Study09 {
	public static void main(String[] args) {
		
		Runnable r = new T1();
		Thread t = new Thread(r); //인터페이스를 통해 스레드를 만든경우, 러너블 인스턴스를 스레드 생성자에 인자로 줌.
		t.start();
	}
}
