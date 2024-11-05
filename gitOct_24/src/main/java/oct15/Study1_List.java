package oct15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ListTest {
	ListTest(){}
	void doIt() {
		
		//데이터저장(순서유지, 동일한 데이터저장)에 사용하는 메서드 add()
		
		ArrayList al = new ArrayList(); //연속된 공간사용
		al.add(1);
		al.add(true); //현재 [1]에 true 가 있는데 여기에 삽입되면 기존데이터가 모두 뒤로 이동함
		al.add(3.14); 
		al.add('a');
		al.add(new Tiger());
		al.add("Korea");
		al.add(0,100); //인자 2개 --> [0]위치에 100을 삽입
		al.add(2, 1.234);
		al.remove(0); // [0]위치의 데이터 삭제
		
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		System.out.println(al.get(3));
		System.out.println("ArrayList 객체al의 세번째 값: "+al.get(2));
		System.out.println("ArrayList 객체al의 크기: "+al.size()); // al의 ArrayList에 저장된 데이터수를 리턴
	
		
		
		
		//ArrayList와 LinkedList의 조상이 같으므로 둘의 메서드는 동일함.
		
		
		LinkedList ll = new LinkedList(); //비연속된 공간사용
		ll.add(1);
		ll.add(3.14);
		ll.add(true);
		ll.add('a');
		ll.add(new Tiger());
		ll.add("Korea");
			
		
		// 데이터 검색에 사용하는 메서드 get() -> 리턴메서드		
		System.out.println(al.get(1));
		
		// get() 메서드를 구현해보자~
		
		Object data1 = al.get(2);
		
		
		
		//다형성 가능 // List 를 상속받았구나~
		List al2 = new ArrayList(); 
		List ll2 = new LinkedList();
		
		
		// 자바의 최상위클래스. 다형성적용가능
		// Object 자료형으로 만들면 모두 담을수있음. 언젠간 쓰니 기억해둬
		Object obj = new String();
		Object obj1 = new ArrayList();
		Object obj2 = new LinkedList();
		
		
	}
}

class Tiger {

	@Override
	public String toString() {
		return "누구가 2024년10원15일, 컬렉션프레임워크 수업중 작성";
	}
	
}
class Lion {
	Object get() {
		Object obj = 1; //다형성이니까 변수에 다 들어감 다형성정의가 뭐냐, 조상자료형에 자식이 할당된거.
		return obj;
	}
}

public class Study1_List {
	public static void main(String[] args) {
		ListTest t = new ListTest();
		t.doIt();
		
		Tiger tiger = new Tiger();
		//System.out.println(tiger);
	}
}
