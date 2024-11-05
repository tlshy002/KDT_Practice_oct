package oct01;

// 중복되지 않는 난수 구하기 응용

// 자바백화점에서 가을이벤트로 10명 고객 추첨해서 상품증정
// 응모한 고객 수는 총 1206명


class AutumnEvent {
	AutumnEvent(){}
	
	int[] numbers = new int[1206];
	void step1() {
		for(int i=0; i<1206; i++) {
			numbers[i] = i+1;
		}
	}
	
	// 배열의 길이가 1206이므로 최소 4000번 이상은 섞기
	void step2() {
		int temp = 0;
		for(int i=0; i<4000; i++) {
			int nansu = (int)(Math.random()*1206);
			
			// 난수번째 수와 첫번째 수를 교환
			temp = numbers[0];
			numbers[0] = numbers[nansu];
			numbers[nansu] = temp;
		}
	}
	
	// 섞인배열에서 당첨번호 10개 뽑기
	void step3() {
		System.out.println("****** 당첨 응모번호 ******");
		for(int i=0; i<10; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}


public class Study4_LottoEvent {
	public static void main(String[] args) {
		AutumnEvent event = new AutumnEvent();
		event.step1();
		event.step2();
		event.step3();
		
		
	}
}
