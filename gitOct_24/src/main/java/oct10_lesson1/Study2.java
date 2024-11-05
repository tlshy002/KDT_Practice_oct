package oct10_lesson1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



// 버튼 색변경
class FourthWindow extends JFrame {
	JButton[] btns; FlowLayout flow;

	
	FourthWindow(String title) {
		super(title); //윈도우 제목설정
		flow = new FlowLayout();
		
		
		btns = new JButton[3]; //배열생성
		this.setLayout(flow);
		btns[0] = new TitledBtn(" 노란색 버튼 ");
		btns[1] = new ColoredButton(" 파란색 버튼 ");
		btns[2] = new JButton(" 그냥 버튼 ");
		
		this.add(btns[0]); this.add(btns[1]); this.add(btns[2]); //버튼을 윈도우에 붙임
		this.setSize(500, 200);
		this.setVisible(true);
	}
}

class TitledBtn extends JButton {
	TitledBtn(String title) {
		this.setBackground(Color.YELLOW); //배경색 지정
		this.setForeground(Color.BLUE); //글자색 지정
		this.setText(title); //버튼에 글자를 출력		
	}
}
class ColoredButton extends JButton {
	ColoredButton(String title) {
		this.setBackground(Color.BLUE); //배경색 지정
		this.setForeground(Color.MAGENTA); //글자색 지정
		this.setText(title); //버튼에 글자를 출력
	}
}
//========================================

class ThirdWindow extends JFrame {
	JPanel panel; //눈에 안보이는 윈도우(패널)
	JButton[] btns;	GridLayout[] grids;
	ThirdWindow(String title) {
		super(title);
		
		btns = new JButton[3]; grids = new GridLayout[2]; //배열생성
		
		grids[0] = new GridLayout(2,1,5,5); //2행1열의 GridLayout 인스턴스 생성 
		grids[1] = new GridLayout(1,2,5,5); //1행2열의 GridLayout 인스턴스 생성 
		
		panel = new JPanel(); //패널 인스턴스 생성
		panel.setLayout(grids[0]); //패널의 레이아웃을 2행1열의 GridLayout으로 설정
		btns[0] = new JButton(" OK ");
		btns[1] = new JButton(" CANCEL ");
		panel.add(btns[0]); panel.add(btns[1]); //버튼을 패널에 붙임
		
		btns[2] = new PressBtn();
		
		this.setLayout(grids[1]);
		this.add(panel);
		this.add(btns[2]);
		this.setSize(500, 200);
		this.setVisible(true);
	}
}
class PressBtn extends JButton {
	PressBtn() {
		super(" PRESS ");
	}
}
class SecondWindow extends JFrame {
	ImageIcon[] flags;	JLabel[] labels; GridLayout gridLayout;
	SecondWindow(String title) {
		super(title); //윈도우의 제목설정
		
		flags = new ImageIcon[4]; labels = new JLabel[4]; //배열생성
		flags[0] = new ImageIcon("src/main/java/lesson1/ar.png");
		flags[1] = new ImageIcon("src/main/java/lesson1/kr.png");
		flags[2] = new ImageIcon("src/main/java/lesson1/ru.png");
		flags[3] = new ImageIcon("src/main/java/lesson1/us.png");
		
		for (int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(flags[i]); //레이블안에 이미지인스턴스 할당해서 감쌈
		}
		gridLayout = new GridLayout(1,4,5,5);
		this.setLayout(gridLayout);
		for(int i=0; i<labels.length; i++) {
			this.add(labels[i]);
		}
		this.setSize(600, 200);
		this.setVisible(true);
	}
}

public class Study2 {
	public static void main(String[] args) {
		//SecondWindow sw = new SecondWindow("제목이 있는 윈도우");
		//ThirdWindow sw1 = new ThirdWindow("A");
		FourthWindow sw2 = new FourthWindow("색 버튼 윈도우");
	}
}
