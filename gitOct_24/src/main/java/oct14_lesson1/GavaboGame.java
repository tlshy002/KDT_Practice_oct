package oct14_lesson1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BtnListener implements ActionListener {
	String btnName;		JLabel label;
	BtnListener(String btnName, JLabel label){
		this.btnName = btnName;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("버튼누름");
	}
	
	int rnd() {
		return (int)(Math.random()*3+1);
	}
}


public class GavaboGame extends JFrame {
	JButton[] btns;
	JPanel btnPanel, resultPanel;
	JLabel label;
	Font font;
	GridLayout gird;
	String[] title = { "가위","바위","보" }; //버튼의 제목용 배열
	String btnName;
	
	public GavaboGame() {
		super("가위바위보 게임");
		font = new Font("굴림체",Font.BOLD, 40);
		gird = new GridLayout(2,1,5,5); //2행1열 //버튼패널과 결과패널이 위,아래에 위치
		
		btnPanel = new JPanel();
		btns = new JButton[3];
		for(int i=0; i<title.length; i++) {
			btns[i] = new JButton(title[i]); //버튼생성
			btns[i].setFont(font);
			btnPanel.add(btns[i]); //생성된 버튼을 버튼패널에 넣음 //총 3개의버튼을 버튼패널에 붙임
			
			btnName = title[i];
			btns[i].addActionListener(new BtnListener(btnName, label)); //버튼과 BtnListener 리스너 연결
		}
		
		label = new JLabel("여기에 게임의 결과가 출력됩니다");
		label.setFont(font);
		resultPanel = new JPanel();
		resultPanel.add(label); //레이블을 결과패널에 넣음
		
		this.setLayout(gird);
		this.add(btnPanel);
		this.add(resultPanel);
		this.setSize(800, 200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		GavaboGame g = new GavaboGame();
	}
}
