package oct18_lesson2;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JMenu;



// Study7과 다른점
// 7은 레이블에 출력했고 이건 메뉴에 출력함

public class Study11 extends JFrame {
	
	public String currentTime() { //현재시간을 리턴
		Calendar c = Calendar.getInstance(); //Calendar 객체생성
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		String cText = hour + "";
		
		if(hour<10) {
			
		}
		
		return cText;
	}
	
	//메인클래스 안의 클래스. 내부클래스
	class ClockMenu extends JMenu implements Runnable { //메뉴객체이자, 스레드객체
		Thread timer;		Font font;

		ClockMenu(){
			this.setText(currentTime()); //현재 메뉴에 시간출력
			font = new Font("굴림체", Font.BOLD, 20);
			this.setFont(font);
			timer = new Thread(ClockMenu.this); //스레드 객체생성
			timer.start(); //스레드의 메인메서드 run()호출			
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000); //1초대기
				} catch(Exception e) {}
				this.setText(currentTime()); //현재 시간을 메뉴에 출력
			}
		}
		
		
	}//ClockMenu ================================
	
	
	public static void main(String[] args) {

	}
}
