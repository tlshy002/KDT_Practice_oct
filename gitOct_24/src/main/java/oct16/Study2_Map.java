package oct16;

import java.util.HashMap;

class MapTest {
	
	void doIt() {
		HashMap map1 = new HashMap();
		map1.put("C001", "홍길동");
		
		Object obj1 = map1.get("C001");
		String obj2 = (String)map1.get("C001");
		System.out.println("Map에서 가져온 데이터: "+obj1);
		System.out.println("Map에서 가져온 데이터: "+obj2);
		//int obj3 = (int)map1.get("C001"); //5050데이터를 찾음
		
		int count = map1.size();
		System.out.println("Map에 저장된 데이터 수: "+count);
		
		// Map에 지정된 키가 있는지 존재여부를 알려줌 containsKey() 
		boolean exist1 = map1.containsKey("C001");
		boolean exist2 = map1.containsKey("abcd");
		System.out.println("C001 키가 존재하나? " + exist1);
		System.out.println("abcd 키가 존재하나? " + exist2);
		
		// Map에 지정된 데이터가 존재하는지 여부를 알려주는 메서드 containsValue()
		boolean value1 = map1.containsValue("홍길동");
		boolean value2 = map1.containsValue("hello");
		System.out.println("홍길동 값이 존재함? " + value1);
		System.out.println("hello 값이 존재함? " + value2);
		
		// Map이 비어있는지 여부를 알려주는 메서드 isEmpty()
		boolean empty = map1.isEmpty();
		System.out.println("Map이 비어있나? " + empty);
		
		System.out.println("--------------------------------");
		
		//Map에 제네릭을 사용해서 데이터 타입을 한정할 수 있다
		//예시 키(문자열만), 값(실수만)
		HashMap<String, Double> map2 = new HashMap<String, Double>();
		map2.put("1월",1.123);
		map2.put("2월",5.123);
		map2.put("3월",7.123);
		//1월의 강수량 출력
		Double jan = (Double)map2.get("1월");
		System.out.println("1월의 강수량: "+jan);
		
		
	}
}

public class Study2_Map {
	public static void main(String[] args) {
		MapTest m = new MapTest();
		m.doIt();
		
	}
}
