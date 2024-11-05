package oct15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//컬렉션 프레임워크 List와 Set에 저장된 데이터를 검색하기 위해 Iterator객체를 사용함

class IteratorTest {
	IteratorTest(){}
	void doIt() {
		ArrayList al = new ArrayList();		al.add(100); al.add(3.14); al.add("korea");
		
		// Iterator를 만들어주는 메서드를 사용하여 Iterator 인스턴스 생성 (new 키워드로 생성하는 대신 Iterator를 생성해주는 메서드를 이용함)
		// Iterator 객체의 next()메서드를 이용해서 데이터를 가져옴
		Iterator it1 = al.iterator(); // 이터레이터 인스턴스 it1생성
		System.out.println(it1.next());// 화살표 기능, 역할 next() 이동해서 가져옴
		System.out.println(it1.next());// 화살표 기능
		System.out.println(it1.next());// 화살표 기능
		
		
		// Iterator 객체의 hasNext() 메서드는 가져올 데이터가 있으면 true, 없으면 false 를 리턴함
		// 주로 반목문을 사용해서 데이터를 가져올때 사용함
		ArrayList al2 = new ArrayList();		al2.add(100); al2.add(3.14); al2.add("korea");
		Iterator itt1 = al2.iterator();
		while(itt1.hasNext()) {
			Object obj = itt1.next();
			System.out.println(obj);
		}
		
		
		
		
		// next() 메서드도 리턴메서드임. 
		// 변수에 담고싶다면 get()과 마찬가지로 Object 자료형으로 선언
		HashSet hs = new HashSet();		hs.add(1); hs.add(3.14); hs.add("korea");
		Iterator it2 = hs.iterator();
		Object obj1 = it2.next();	System.out.println(obj1);
		Object obj2 = it2.next();	System.out.println(obj2);
		Object obj3 = it2.next();	System.out.println(obj3);
		
		// 반복문 사용의 관건
		// 다음 데이터가 없는데 값을 가져오면 안되니까
		// 다음 데이터의 유무를 확인할때 사용 => hasNext()
		HashSet hs2 = new HashSet();		hs2.add(500); hs2.add(3.14); hs2.add("Apple");
		Iterator itt2 = hs2.iterator();
		while(itt2.hasNext()) {
			Object obj = itt2.next();
			System.out.println(obj);
		}
		
	}
}

public class Study4_Iterator {
	public static void main(String[] args) {
		IteratorTest test = new IteratorTest();
		test.doIt();
	}
}
