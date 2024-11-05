package oct10_lesson1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class FifthWindow extends JFrame {
	BorderLayout borderLayout;	JButton[] btns;	JButton btn;
	String[] titles = {"첫번째", "두번째","세번째","네번째","다섯번째"}; //버튼 5개의 제목
	
	FifthWindow(String title){
		super(title);
		borderLayout = new BorderLayout();
		this.setLayout(borderLayout); // setLayout() => 배치관리자를 설정하는 메서드
		
		btns = new JButton[5]; //버튼 5개를 저장할 배열 생성		
		for(int i=0; i<titles.length; i++) {
			btns[i] = new JButton(titles[i]);
		}
		this.add(btns[0], BorderLayout.EAST);
		this.add(btns[1], BorderLayout.WEST);
		this.add(btns[2], BorderLayout.SOUTH);
		this.add(btns[3], BorderLayout.NORTH);
		this.add(btns[4], BorderLayout.CENTER);
		this.add(btn);
		
		this.setSize(450, 300);
		this.setVisible(true);
	}
}

public class Study3 {
	public static void main(String[] args) {
		FifthWindow sw = new FifthWindow("버튼테스트");
	}
}
