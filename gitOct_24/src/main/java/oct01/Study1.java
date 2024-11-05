package oct01;

// main 메서드 매개변수의 정체: 문자열 배열
// main 메서드 매개변수의 args에 데이터를 어떻게 전달하는가?



public class Study1 {
	public static void main(String[] args) {
		System.out.println(args.length);
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
