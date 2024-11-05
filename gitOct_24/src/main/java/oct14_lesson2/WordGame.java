package oct14_lesson2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// 단어 랜덤 선택하기 위해서 단어 선택클래스 생성
// 클래스 책임하나만 가짐
class RandomWord {
	RandomWord(){}
	String[] words = { "tree","flower","ocean","computer","school","teacher","student","monitor","earth","congratulations" };
	String quizWord() {
		return words[rnd()];
	}
	int rnd() {
		return (int)(Math.random()*words.length);
	}
}

class WordGameListener implements ActionListener {
	WordGameListener(JButton btn, WordGame wordGame) {
		this.btn = btn; 	this.wordGame = wordGame;		
	}
	JButton btn; WordGame wordGame;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼의 제목(현재 "?")을 버튼의 위치와 일치하는 단어의 문자로 바꾸기
		// 바꿀때 필요한것: 단어와 누른 버튼, 몇번째 버튼인지가 필요함. 이를 확인하기위해 전체 버튼이 필요함
		// 이런 데이터를 어떻게 가져오는가? => 생성자로가져옴
		for(int i=0; i<wordGame.btns.length; i++) {
			if(btn == wordGame.btns[i]) {
				//System.out.println(i+1 + " 번쩨 버튼을 눌렀음");
				//System.out.println(wordGame.word.charAt(i)); // charAt(i) 번째의 문자를 리턴
				btn.setText(wordGame.word.charAt(i) + ""); // 문자 + "" => 문자열 setText() 윈도우에 출력
			}					
		}
			
	}
}
class OkBtnListener implements ActionListener {
	String word; 	JTextField text;	JLabel label;
	OkBtnListener(String word, JTextField text, JLabel label) {
		this.word = word;
		this.text = text;
		this.label = label;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력한 단어와 퀴즈단어가 같은지 비교
		String inputWord = text.getText();
		if(word.equals(inputWord)) {
			label.setText("정답!");
			System.out.println("정답!");
		} else {
			label.setText("다음기회에..."); //레이블에 문장출력
			System.out.println("다음기회에...");
		}
	}
}

public class WordGame extends JFrame {
	WordGame() {
		super("단어 맞추기");
		font = new Font("굴림체",Font.BOLD,30);
		grid = new GridLayout(2,1,5,5); //2행1열 
		this.setLayout(grid);
		
		
		panel = new JPanel(); //버튼 n개가 들어갈 패널
		panel2 = new JPanel();
		text = new JTextField(20); text.setFont(font);
		
		rndWord = new RandomWord();
		word = rndWord.quizWord(); // quizWord()리턴메서드에서 랜덤단어 리턴함. 퀴즈로 사용할 단어 저장

		result = new JLabel(); //정답,오답 표기할 레이블생성 	
		result.setFont(font);
		okBtn = new JButton(" 정답 확인 "); 	
		okBtn.setFont(font);
		okBtn.addActionListener(new OkBtnListener(word, text, result)); // "정답확인"버튼과 OkBtnListener 리스너와 연결
		
		btns = new JButton[word.length()]; //단어의 길이로 버튼배열 생성
		for(int i=0; i<word.length(); i++) {
			btns[i] = new JButton(" ? "); // ? 제목의 버튼생성
			btns[i].setFont(font); //버튼에 폰트적용			
			
			ActionListener al = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			};
			
			
			//btns[i].addActionListener(new WordGameListener( btns[i], this )); //버튼과 WordGameListener 리스너 연결하기
			panel.add(btns[i]); //생성된 버튼을 윈도우에 붙임
		} //단어의 길이만큼 버튼생성
		
		
		this.add(panel); //1행에 패널을 붙임(패널에 버튼 n개 붙어있음)
		panel2.add(text); //텍스트필드를 붙임 두번째 패널에 붙임
		panel2.add(okBtn);
		panel2.add(result);
		this.add(panel2); //2행에 텍스트필드가 붙어있는 패널을 붙임
		this.setSize(1000, 200);
		this.setVisible(true);
		
	}
	JButton okBtn;
	JButton[] btns;
	RandomWord rndWord;
	Font font;
	String word;
	JPanel panel, panel2;
	GridLayout grid; //윈도우를 2행1열로 분리하고 1행에는 패널(패널안에 단어 n개 배치),2행에는 텍스트필드를 배치
	JTextField text;
	JLabel result;
	
	public static void main(String[] args) {
		WordGame game = new WordGame();
		
	}
}
