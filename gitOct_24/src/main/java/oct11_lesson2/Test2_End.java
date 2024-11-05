package oct11_lesson2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// 방법2> 
// 더하기,빼기,곱하기,나누기 모든 모튼이 하나의 리스너클래스를 공유해서 사용함 => 그런데 + - * /를 어떻게 구분하는가?
// 구분하는 방법은 버튼의 제목을 읽어서 + - * / 와 비교하기

class CommonListener implements ActionListener {
	JButton button;		Adder2 adder; 
	CommonListener(JButton button, Adder2 adder){ //버튼인스턴스를 인자로 받음
		this.button = button;	 this.adder = adder;
	}
	
	// ActionListener객체가 버튼클릭 이벤트를 감지하면 actionPerformed() 메서드 "자동호출" 
	// 이처럼 자동으로 호출되는 메서들을 콜백함수 하고함 (개발자가 호출한게 아니라 객체가 자동으로 호출함)
	public void actionPerformed(ActionEvent e) { 		
		String str1 = adder.num1.getText();
		String str2 = adder.num2.getText();
		int num1 = Integer.parseInt(str1);//str1에 있는 문자열을 숫자로 바꾼다.
		int num2 = Integer.parseInt(str2);//str2에 있는 문자열을 숫자로 바꾼다.
		double result = 0;
		
		if(button == adder.btn) {
			System.out.println("+버튼");
			result = num1 + num2;
		} else if(button == adder.minus) {
			System.out.println("-버튼");
			result = num1 - num2;
		} else if(button == adder.mul) {
			System.out.println("*버튼");
			result = num1 * num2;
		} else if(button == adder.div) {
			System.out.println("/버튼");
			result = num1 / Double.parseDouble(str2);
		}		
		adder.result.setText(result+"");
	}
}


//윈도우에 설계한 버튼을 동작하도록 한다.
//더하기 계산을 하는 계산기를 설계한다.
class AdderListener2 implements ActionListener {
	AdderListener2(JTextField n1, JTextField n2, JLabel result){ 
		f1 = n1; f2 = n2; this.result = result; 
	}
	JTextField f1, f2; JLabel result;
	@Override
	public void actionPerformed(ActionEvent e) {
		String str1 = f1.getText(); String str2 = f2.getText();
		int num1 = Integer.parseInt(str1);//str1에 있는 문자열을 숫자로 바꾼다.
		int num2 = Integer.parseInt(str2);//str2에 있는 문자열을 숫자로 바꾼다.
		int sum = num1 + num2;
		result.setText(sum+"");//sum에 있는 숫자를 문자열로 바꿔서 JLabel에 출력한다.
	}
}


class Adder2 extends JFrame {
	JTextField num1, num2; JButton btn; JLabel result; FlowLayout flow; Font font; 
	JPanel panel; GridLayout gridLayout; JButton minus,mul,div;
	Adder2(){
		super("더하기 계산기");//윈도우의 제목 설정
		panel = new JPanel();//패널을 생성
		gridLayout = new GridLayout(4,1,5,5);//4행 1열의 그리드레이아웃 생성
		panel.setLayout(gridLayout);//패널의 레이아웃을 4행 1열의 그리드레이아웃으로 설정
		font = new Font("굴림체", Font.BOLD, 40);
		
		num1 = new JTextField(10);//20은 입력창의 길이
		num2 = new JTextField(10);
		num1.setFont(font); num2.setFont(font);
		
		btn = new JButton(" + "); btn.setFont(font);
		minus = new JButton(" - "); minus.setFont(font);//마이너트 제목의 버튼 생성
		mul = new JButton(" * "); mul.setFont(font);//곱하기 제목의 버튼 생성
		div = new JButton(" / "); div.setFont(font);//나누기 제목의 버튼 생성
		
		panel.add(btn); panel.add(minus); panel.add(mul); panel.add(div);//버튼을 패널에 붙임
		result = new JLabel("이곳에 결과가 출력됩니다.");
		
		// 방법1: 버튼마다 리스너클래스를 따로 둠
		// btn.addActionListener(new AdderListener2(num1, num2, result));//버튼과 AdderListener를 연결한다.
		// minus.addActionListener(new MinusListener(num1, num2, result));//버튼과 MinusListener를 연결한다. //각 연산별로 클래스를 다 따로 만듦
		
		
		// 방법2: 모든 버튼이 같은 리스너 클래스를 사용함
		// 관건: 다같은 클래스를 사용하는데, 어떤버튼을 눌렀는지 구분을 어떻게 하나?
		// 버튼인스턴스를 리스너생성자에게 인자로 주기
		btn.addActionListener(new CommonListener(btn, this ));
		minus.addActionListener(new CommonListener(minus, this ));
		mul.addActionListener(new CommonListener(mul, this ));
		div.addActionListener(new CommonListener(div, this ));
		
		
		result.setFont(font); result.setForeground(Color.RED);
		flow = new FlowLayout();
		
		this.setLayout(flow);//현재 윈도우의 레이아웃을 FlowLayout으로 설정
		this.add(num1); this.add(num2); this.add(panel); this.add(result);
		this.setSize(1200, 300);
		this.setLocation(200, 200);//윈도우가 출력되는 위치 설정
		this.setVisible(true);//윈도우를 출력
	}
}
public class Test2_End {
	public static void main(String[] args) {
		Adder2 adder = new Adder2();
	}
}
