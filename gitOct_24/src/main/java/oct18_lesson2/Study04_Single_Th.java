package oct18_lesson2;

import javax.swing.JOptionPane;

public class Study04_Single_Th {
	public static void main(String[] args) {

		//싱글스레드
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요."); //자료입력창 출력
		System.out.println("입력한 값은 "+input+"입니다.");
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초동안 대기
			} catch(Exception e) {}
		}
		System.out.println("펑!");
		
	}
}
