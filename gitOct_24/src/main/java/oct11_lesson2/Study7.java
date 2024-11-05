package oct11_lesson2;


//Na 클래스가 Na에서 You로 보내기
class You {
	You(){}
	int one =1; 
	void doIt() { System.out.println("You"); }
	
	You(Na na) { System.out.println(na.total); } 
}
class Na {
	Na(){}
	void doIt() { 
		You you = new You(); 
		You you2 = new You( this );
		System.out.println(you.one);
		you.doIt();
	}
	int total = 500;
	void callMe() { System.out.println("Na"); }
}

public class Study7 {
	public static void main(String[] args) {
		Na na = new Na();
		na.doIt();
	}
}
