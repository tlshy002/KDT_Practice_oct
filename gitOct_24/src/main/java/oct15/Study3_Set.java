package oct15;

import java.util.HashSet;
import java.util.Set;

// Set을 상속한 대표적인 클래스: HashSat, TreeSet, LinkedHasSet
// Set 컬렉션프레임워크의 특징: 저장 데이터의 순서 유지안됨. 동일한 데이터 저장안됨

class SetTest {
	SetTest(){}
	void doIt() {
		HashSet set1 = new HashSet();
		set1.add(1);
		set1.add(3.14);
		set1.add('a');
		set1.add("Korea");
		SuperMan sm = new SuperMan();
		set1.add(sm);
		
		// 동일한 데이터는 저장되지 않음. 따라서 20번째 줄의 데이터는 저장안됨
		// set1에 저장된 데이터는 5개뿐
		set1.add(1); set1.add(3.14); set1.add('a'); set1.add("Korea"); set1.add(sm);
		System.out.println("HashSet에 저장된 데이터수: "+set1.size());
		System.out.println(set1); //저장한 데이터 순서유지 안됨
		
		// get() 메서드의 심각한 문제
		// 5번째 데이터를 찾는데 15번이나 이동함
		
		
		
		
		
		Set set2 = new HashSet(); //다형성
	}
}

public class Study3_Set {
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.doIt();
	}
}
