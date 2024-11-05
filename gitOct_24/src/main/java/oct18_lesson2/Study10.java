package oct18_lesson2;

public class Study10 implements Runnable {
	// Study9 와는 다르게 main()을 가지고 있는 메인 클래스 자체이 러너블을 상속하고 있을때
	// 스레드 생성하기 위해서 스레드 생성자 인자에 넣을 러너블 인스턴스를 어떻게? 넣느냐.
	// this 로 넣는다.
	
	
	Thread t;
	Study10() {
		t = new Thread(this);
		
	}
	
	public void run() {
	}

	public static void main(String[] args) {

	}

}
