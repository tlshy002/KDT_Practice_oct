package oct01;

//문자열을 기본형으로 바꾸기


public class Study2_WrapperClass {
	public static void main(String[] args) {
		
		int arr1 = Integer.parseInt(args[0]);
		double arr2 = Double.parseDouble(args[1]);
		boolean arr3 = Boolean.parseBoolean(args[2]);
		
		System.out.println(arr1 + ","+ arr2 + ","+ arr3);
		
		
		int data1 = 200; // 기본형 int
		Integer data2 = new Integer(200); // 참조형 Integer		
		System.out.println(data1 +","+ data2);
		
		int sum1 = data1 + data1;
		int sum2 = data2 + data2;
		int sum3 = data1 + data2;		
		System.out.println(sum1);
		
		// 기본형 변수에 참조형 데이터가 저장(오토언박싱:autoUnBoxing)
		int test1 = new Integer(300);
		
		// 참조형 변수에 기본형 데이터가 저장(오토박싱:autoBoxing)
		Integer test2 = 300;
		
		
		// 문자열을 기본형으로 바꾸기 => 래퍼클래스 사용
		// 문자열 형태의 정수를 정수형 타입으로 바꾸는 법
		int result1 = Integer.parseInt("100");
		
		// 문자열 실수 -> 실수로 
		double result2 = Double.parseDouble("3.14");
		
		// 문자열 불린을 -> 불린으로
		boolean result3 = Boolean.parseBoolean("true");
	}
}
