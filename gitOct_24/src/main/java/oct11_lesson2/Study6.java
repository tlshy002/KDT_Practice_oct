package oct11_lesson2;

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

// 추상메서드를 오버라이드 안해서 오류발생
// AdderListener 리스너와 btn 버튼을 연결하면 됨
class AdderListener implements ActionListener {
	
	AdderListener(JTextField n1, JTextField n2, JLabel r){ //생성자 매개변수로 Adder 클래스의 값받기 
		f1=n1; f2=n2; result = r;
	}
	JTextField f1,f2;
	JLabel result;
	
	@Override
	public void actionPerformed(ActionEvent e) { //이벤트를 인식하자마자 해당메서드 실행함
		// num1,num2 에 입력된 데이터 읽어오기 -> 숫자로 형변환 -> 결과를 result 에 출력
		
		String str1 = f1.getText();
		String str2 = f2.getText();
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int sum = num1 + num2;
		
		System.out.println("입력한 첫번째 데이터: " + num1 );
		System.out.println("입력한 두번째 데이터: " + num2 );
		System.out.println(sum);
		result.setText(sum+""); //sum 에 있는 숫자를 문자열로 바꿔서 JLabel에 출력함
		
	} 
}

class Adder extends JFrame {
	JButton btn;	JTextField num1, num2;	JLabel result;	Font font;	FlowLayout flow;	
	JPanel panel; GridLayout grid;	JButton minus, mul, div;
	Adder(){
		super("더하기 계산기");
		panel = new JPanel();
		grid = new GridLayout(4,1,5,5);
		panel.setLayout(grid);
		
		
		flow = new FlowLayout();
		result = new JLabel("이곳에 결과가 출력됩니다.");
		num1 = new JTextField(10);
		num2 = new JTextField(10);
		btn = new JButton(" + ");
		btn.addActionListener(new AdderListener(num1, num2, result));
		
		minus = new JButton(" - ");
		mul = new JButton(" * ");
		div = new JButton(" / ");
		
		
		
		font = new Font("굴림체", Font.BOLD, 20);
		btn.setFont(font);
		minus.setFont(font);
		mul.setFont(font);
		div.setFont(font);
		num1.setFont(font);
		num2.setFont(font);
		result.setFont(font);
		this.setLayout(flow);
		this.add(num1);
		this.add(num2);
		this.add(btn);	this.add(minus);	this.add(mul);	this.add(div);
		this.add(result);
		
		this.setSize(800, 200);
		this.setLocation(1000, 300);
		this.setVisible(true);
	}
}

public class Study6 {
	public static void main(String[] args) {
		Adder adder = new Adder();
	}
}
