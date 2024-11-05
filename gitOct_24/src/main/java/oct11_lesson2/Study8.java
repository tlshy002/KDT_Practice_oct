package oct11_lesson2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class TabWindow extends JFrame {
	Font font;	JPanel[] panels; JTabbedPane tabs; //탭이 달린 패널
	TabWindow(){
		super("탭이 있는 윈도우");
		font = new Font("굴림체",Font.BOLD,20);
		panels = new JPanel[4]; //패널 4개가 저장될 배열생성
		for(int i=0; i<5; i++) {
			panels[i-1] = new JPanel();
		}
		panels[0].setBackground(Color.ORANGE);
		panels[1].setBackground(Color.YELLOW);
		panels[2].setBackground(Color.GREEN);
		panels[3].setBackground(Color.PINK);
		tabs = new JTabbedPane();
		
		tabs.addTab("첫번째 텝", panels[0]);	
		tabs.addTab("첫번째 텝", panels[1]);	
		tabs.addTab("첫번째 텝", panels[2]);
		tabs.addTab("첫번째 텝", panels[3]);
		
		this.add(tabs);
		this.setSize(800,500);
		this.setVisible(true);
	}
}

public class Study8 {
	public static void main(String[] args) {
		TabWindow tw = new TabWindow();
	}
}
