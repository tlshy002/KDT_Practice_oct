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


// 방법1> 
// 더하기,빼기,곱하기,나누기 각 연산별 클래스를 만드는 방법
// 각 버튼마다 별도로 ActionListener을 상속해서 이벤트 처리클래스를 만듦
// 이 방법은 버튼마다 리스너 클래스가 다 필요함


//윈도우에 설계한 버튼을 동작하도록 한다.
//더하기 계산을 하는 계산기를 설계한다.
class AdderListener1 implements ActionListener {
	AdderListener1(JTextField n1, JTextField n2, JLabel result){ 
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
class MinusListener implements ActionListener {
	MinusListener(JTextField n1, JTextField n2, JLabel result) {
		f1 = n1; f2 = n2; this.result = result; 
	}
	JTextField f1, f2; JLabel result;
	@Override
	public void actionPerformed(ActionEvent e) {
		String str1 = f1.getText(); String str2 = f2.getText();
		int num1 = Integer.parseInt(str1);//str1에 있는 문자열을 숫자로 바꾼다.
		int num2 = Integer.parseInt(str2);//str2에 있는 문자열을 숫자로 바꾼다.
		int m = num1 - num2;
		result.setText(m+"");//sum에 있는 숫자를 문자열로 바꿔서 JLabel에 출력한다.		
	}
}
class Adder1 extends JFrame {
	JTextField num1, num2; JButton btn; JLabel result; FlowLayout flow; Font font; 
	JPanel panel; GridLayout gridLayout; JButton minus,mul,div;
	Adder1(){
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
		btn.addActionListener(new AdderListener1(num1, num2, result));//버튼과 AdderListener를 연결한다.
		minus.addActionListener(new MinusListener(num1, num2, result));//버튼과 MinusListener를 연결한다. //각 연산별로 클래스를 다 따로 만듦
		
		result.setFont(font); result.setForeground(Color.RED);
		flow = new FlowLayout();
		
		this.setLayout(flow);//현재 윈도우의 레이아웃을 FlowLayout으로 설정
		this.add(num1); this.add(num2); this.add(panel); this.add(result);
		this.setSize(1200, 300);
		this.setLocation(200, 200);//윈도우가 출력되는 위치 설정
		this.setVisible(true);//윈도우를 출력
	}
}
public class Test {
	public static void main(String[] args) {
		Adder2 adder = new Adder2();
	}
}
