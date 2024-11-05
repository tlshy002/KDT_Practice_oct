package oct10_lesson2;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FruitInfomation extends JFrame {
	ImageIcon[] icons;	JPanel[] panel;	
	String[] desc = {"<html> 레몬에 포함된 구연산은<br/>피로회복에 좋습니다. </html>",
					"<html> 비타민C가 풍부합니다.<br/>생과일 주스로 마시면 좋습니다.  </html>",
					"<html> 비타민C가 매우 풍부합니다. 다이어트에 좋습니다.</html>",
					"<html> 폴리페놀을 함유하고있어 황산화작용을 합니다.</html>",
					"<html> 비타민C와 플라보노이드를 다량 함유하고 있습니다.</html>",
					"<html> 시네피린을 함유하고 있어 감기예방에 좋습니다.</html>" };
	
	void makePanel() {//패널을 7개 생성하는 메서드
		panel = new JPanel[7]; //패널 인스턴스 7개를 저장할 배열생성
		for(int i=0;i<panel.length; i++) {
			panel[i] = new JPanel();
			if(i == 6) { //7번째 패널인 경우
				panel[i].setLayout(new GridLayout(2,3,5,5)); //2행3열의 GridLayout으로 설정
			} else { //7번째 패널이 아닌 경우
				panel[i].setLayout(new GridLayout(1,2)); //1행2열의 GridLayout으로 설정				
			}
		}
	} 
	void makeIcon() { //이미지를 생성하는 메서드
		String path = "src/main/java/lesson2/";
		String[] names = { "lemon.jpg","orange.jpg","kiwi.jpg","grape.jpg","strawberry.jpg","tangerine.jpg" };
		icons = new ImageIcon[6]; //이미지를 위한 배열생성
		for(int i=0; i<names.length; i++) {
			icons[i] = new ImageIcon(path + names[i]);
		}
	}
	
	public FruitInfomation(String str) { //생성자
		super(str); //윈도우제목
		makePanel();
		makeIcon();
		for(int i=0; i<6; i++) {
			panel[i].add(new JLabel(icons[i])); //이미지를 레이블에 붙임
			panel[i].add(new JLabel(desc[i])); //설명을 레이블에 붙임
			panel[6].add(panel[i]); //마지막 패널에 패널을 붙임
		}
		this.add(panel[6]); //마지막 패널을 윈도우에 붙임
		this.setSize(800, 300);
		this.setLocation(100, 200); //윈도우가 출력되는 위치를 설정 100,200
		this.setVisible(true); 		
	}
	
	
	
	public static void main(String[] args) {
		FruitInfomation f = new FruitInfomation("과일소개");
	}
}
