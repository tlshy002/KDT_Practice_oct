package oct01;


// 중복되지 않는 난수 구하기
// 중복 난수 구하는법: (int)(Math.random()*난수범위 + 가장작은난수)

// 알고리즘
// 1. 첫번째 난수를 구함
// 2. 구한 난수를 저장함
// 3. 두번째 난수를 구함
// 4. 저장한 난수와 두번째 난수를 비교
// 5. 다르면 저장함
// 6. 같으면 다시 난수를 구함 (중복되니까 다시 난수 구함)
// 7. 세번째 난수를 첫번째,두번째 난수와 비교
// 근데 이 방법은 위험함.
// (1) 난수개수 많아질수록 너무 많이 계산해야됨
// (2) 만약에! 우연히 계속 같은 난수가 나오면 끝나지않고 무한반복이 될수도...

// 새로운 알고리즘 => 배열 사용하기
// 1. 내가 원하는 모든 난수 범위에 해당하는 수를 배열에 저장
// 2. 만든 배열에 저장된 수를 서로 n번 교환함
// 3. 배열에 저장된 수를 내가 원하는 개수만큼 꺼냄
// 해당 알고리즘에서 고려해야할 데이터 => n

// 1단계) 1~45의 수를 배열에 저장함
// 2단계) 생성한 배열에서 난수번째 수와 난수번째 수를 서로 교환하고 이 과정을 n번 반복
// * n의 값이 너무 작으면 섞이지 않음. n의 값이 너무 커도 의미없음. 적당한 값으로 설정


class LottoGenerator {
	LottoGenerator(){}
	
	//크기 45의 배열생성
	int[] numbers = new int[45];
	
	void firstStep() {
		for (int i=0; i<45; i++) {
			numbers[i] = i + 1;	//배열에 1~45를 저장
		}
	}
	// 1~45의 수를 섞기
	void secondStep() {
		int temp = 0; //저장할 임시변수

		for(int i=0; i<500; i++) { //500번 반복
			//int index1 = (int)(Math.random()*45); // 44~0
			int index2= (int)(Math.random()*45);
			
			temp = numbers[0];
			numbers[0] = numbers[index2];
			numbers[index2] = temp;			
		}		
	}
	// numbers 배열 앞에서 6개 추출
	void thirdStep() {
		System.out.println("랜덤로또 6개>");
		for(int i=0; i<6; i++) {
			System.out.print(numbers[i] +" ");
		}
	}
	
	
}




public class Study3 {
	public static void main(String[] args) {
		
		LottoGenerator lotto = new LottoGenerator();
		lotto.firstStep();
		lotto.secondStep();
		lotto.thirdStep();
		
	}
}
