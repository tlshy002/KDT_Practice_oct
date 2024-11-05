package oct10_lesson2;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class FirstWindow extends JFrame {
	FlowLayout flowLayout;
	JLabel label1;	JLabel label2;
	JCheckBox checkBoxTest;
	JCheckBox[] checkBox;
	JRadioButton[] radiobtn;
	
	String[] checkName = { "윈도우98","윈도우2002","윈도우XP" };
	String[] radioName = { "펜티엄4","애슬론XP","셀러론" };
	String br = "<html><br/></html>";
	
	
	FirstWindow(String title){ //생성자. 인스턴스생성하자마자 실행
		super(title);		
		flowLayout = new FlowLayout();
		
		label1 = new JLabel("설치되어 있는 OS선택(복수) ");
		label2 = new JLabel("컴퓨터 CPU 종류 선택 ");
		
		
		// 아래 코드처럼 생겼는데, 체크박스가 여러개니까 배열로 처리함
		checkBoxTest = new JCheckBox("윈도우 98");		
		checkBox = new JCheckBox[3];  //체크박스 배열생성
		// checkName = new String[3]; //쳌박이름 배열은 새로생성하면 안됨. 위에 이미 배열만들었는데 새로 만들면 빈칸됨
		for(int i=0; i<checkName.length; i++) {
			checkBox[i] = new JCheckBox(checkName[i]);
			//this.add(checkBox[i]);
		}
		
		radiobtn = new JRadioButton[3];
		for(int i=0; i<radiobtn.length; i++) {
			radiobtn[i] = new JRadioButton(radioName[i]);
		}
		
		
		this.setLayout(flowLayout);
		this.add(label1);
		//this.add(checkBoxTest);
		this.add(checkBox[0]);
		this.add(checkBox[1]);
		this.add(checkBox[2]);
		
		this.add(new JLabel(br)); //string 은 컴포넌트가 아니라서 윈도우에 바로 붙일수없음. 레이블로 감싸서 붙이기
		this.add(label2);
		this.add(radiobtn[0]);
		this.add(radiobtn[1]);
		this.add(radiobtn[2]);
		
		this.setSize(500,200);
		this.setVisible(true);
	}
}



public class Test {
	public static void main(String[] args) {
		FirstWindow sw = new FirstWindow("체크 박스 예제1");
	}

}
