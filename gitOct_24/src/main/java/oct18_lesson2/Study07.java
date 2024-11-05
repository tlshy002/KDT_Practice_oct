package oct18_lesson2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//스레드를 이용해서 디지털 시계를 윈도우에 출력하는 예제
class DigitalClock extends JFrame {
	DigitalClock() { 
		super("디지컬 시계 만들기"); 
		JPanel panel = new JPanel(); //패널생성
		panel.add(new ClockLabel()); //패널에 시계가 출력되는 레이블을 붙임
		
		this.add(panel, BorderLayout.CENTER); //패널을 윈도우의 가운데에 붙임
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	
	class ClockLabel extends JLabel implements Runnable { //레이블인 동시에 스레드임
		Font font;
		Thread timerThread = null; //스레드를 위한 변수선언
		
		ClockLabel() {
			font = new Font("굴림체",Font.BOLD,20);
			this.setText(makeClockText()); //현재 레이블에 출력할 문자열 설정
			this.setFont(font); //현재 레이블의 폰트를 설정
			
			timerThread = new Thread(ClockLabel.this); //스레드 인스턴스 생성
			timerThread.start(); //스레드의 메인메서드( run() )을 호출 
		}
		
		public void run() {			
			while(true) {
				try {
					Thread.sleep(1000); //1초동안 대기
				} catch(Exception e) {}
				this.setText(makeClockText());
			}
		}	
		
		//현재 시간을 리턴하는 메서드
		public String makeClockText() {
			Calendar c = Calendar.getInstance(); //시간을 추출하는 Calendar인스턴스 생성
			int hour = c.get(Calendar.HOUR_OF_DAY); //현재 시간을 정수로 리턴
			int min = c.get(Calendar.MINUTE); //현재 분을 정수로 리턴
			int sec = c.get(Calendar.SECOND); //현재 초를 정수로 리턴
			
			String clockTxt = hour + ""; //시간을 문자열로 변환
			if(hour < 10) clockTxt = "0"+hour; //두자리 시간으로 만듦
			clockTxt += ":"; //시간뒤에 콜론 : 붙임
			
			if(min < 10) clockTxt = "0"+min; //두자리 시간으로 만듦
			clockTxt = clockTxt + min +":"; //시간뒤에 콜론 : 붙임
			
			if(sec < 10) clockTxt = "0"+sec; //두자리 시간으로 만듦
			clockTxt = clockTxt + sec; 
			
			return clockTxt;
		}
		
	}
}

public class Study07 {
	public static void main(String[] args) {
		DigitalClock c = new DigitalClock();
		
	}
}
