package oct10_lesson1;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class MyButton extends JButton {
	MyButton() {
		super("나만의 버튼");
	}
}

class FirstWindow extends JFrame {
	JButton btn1, btn2;	FlowLayout flowLayout;	GridLayout gridLayout;
	JCheckBox checkBox; JRadioButton radioButton; JLabel label; JTextField textField;
	JComboBox comboBox; String[] cities = {"서울","수원","인천","의정부","부평","이천","평택"};
	MyButton mybtn;
	
	FirstWindow(){
		btn1 = new JButton(" 확인 "); //확인 제목의 버튼인스턴스 생성
		btn2 = new JButton(" 취소 "); //확인 제목의 버튼인스턴스 생성
		
		mybtn = new MyButton();
		comboBox = new JComboBox(cities);
		checkBox = new JCheckBox("체크박스"); //체크박스 인스턴스 생성
		radioButton = new JRadioButton("라디오 버튼");
		label = new JLabel("레이블");
		textField = new JTextField("텍스트 필드");
		flowLayout = new FlowLayout();
		gridLayout = new GridLayout(1,2,100,100); //1행2열, 가운데 공백간격, 위아래 간격
		
		this.setLayout(flowLayout); // setLayout() => 배치관리자를 설정하는 메서드
		
		this.add(mybtn);
		this.add(btn1); //버튼을 윈도우에 붙임
		this.add(btn2); //버튼을 윈도우에 붙임
		
		this.add(comboBox);
		this.add(checkBox); this.add(radioButton); this.add(label); this.add(textField);
		
		this.setSize(500, 200); //픽셀단위임 가로세로 크기 설정
		this.setVisible(true); //윈도우를 화면에 출력하는 메서드 호출
		
		
	}
}


public class Study1 {
	public static void main(String[] args) {
		FirstWindow fw = new FirstWindow();
	}
}
