package oct17;

import java.util.Map.Entry;
//import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class MapTest {
	ArrayList al = new ArrayList();
	Iterator iter1 = al.iterator();
	
	HashSet hs = new HashSet();
	Iterator iter2 = hs.iterator();
	
	HashMap hmTest = new HashMap();
	//Iterator iter3 = hmTest.iterator(); //에러 발생	
// Map 에는 iterator() 메서드가 존재하지 않음! 그럼 iterator 객체를 못만드는데 사용 못하나..? 방법 있음
// Map 에서 iterator 객체를 사용하는 방법 => 3가지	
	// 1. Map 에 저장된 키를 이용해서 Iterator 생성가능
	// 2. Map 에 저장된 값을 이용해서 Iterator 생성가능
	// 3. Map 에 저장된 키와 값의 쌍을 이용해서 Iterator 생성가능
	
	
	
	void doIt() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(100, "홍길동");
		hm.put(200, "김길동");
		hm.put(300, "박길동");
		
		// 1번방식: 키(정수)를 이용해서 이터레이터 객체생성 => 학번을 빨리찾음
		// keySet() => Map 에서 키만 추출하는 리턴메서드
		hm.keySet();
		
		//다형성 가능
		ArrayList al1 = new ArrayList();
		List l = new ArrayList();
		Collection c = new ArrayList();
		
		// ---------------------------------------------------------------
		Collection key = hm.keySet(); //키만 추출해서 컬렉션 자료형에 넣고 이터레이터 객체 생성
		Iterator iter3 = key.iterator();
		while(iter3.hasNext()) {
			Integer num = (Integer)iter3.next();
			System.out.println("학번: "+num);
		}
		
		
		// 2번방식: 값(문자열)을 이용해서 이터레이터 객체생성 => 이름을 빨리찾음
		// values() => Map 에서 키만 추출하는 리턴메서드
		Collection vaule2 = hm.values(); //키만 찾아 컬렉션 자료형에 넣고 이터레이터 객체 생성 //리턴타입이 콜렉션
		//Iterator iter4 = value2.iterator();
		while(iter3.hasNext()) {
			Integer num = (Integer)iter3.next();
			System.out.println("학번: "+num);
		}
		
		
		// 3번방식: Map 에 저장된 키와 값의 쌍을 이용해서 Iterator 생성가능 

		
		Set set = hm.entrySet(); // Map -> Set 으로 바꿈 //이제 바뀌었으니 이터레이터 메서드 사용가능
		Iterator iter5 = set.iterator();
		
		while(iter5.hasNext()) { //가져올 데이터 있는지.
			Entry keydata = (Entry)iter5.next();
			Integer num = (Integer)keydata.getKey();
			String name = (String)keydata.getValue();
			System.out.println("학번: "+ num +", 이름: "+name);
			
		}
		
		
		
	}
	
	
	
	
	
}

public class Study1 {
	public static void main(String[] args) {
		MapTest m = new MapTest();
		m.doIt();
	}
}
