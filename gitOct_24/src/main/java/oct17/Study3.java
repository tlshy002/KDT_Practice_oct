package oct17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class StuInfo {
	HashMap<String, Double> map = new HashMap<String, Double>();
	void init() {
		map.put("이동욱", 170.1);
		map.put("김치곤", 178.6);
		map.put("김형욱", 180.3);
		map.put("오미경", 160.8);
		map.put("심정연", 158.7);
	}
	void makeList() {
		// 키 추출
		Collection colKey = map.keySet();
		Iterator iter1 = colKey.iterator();
		String name;

		Collection colValue = map.values();
		Iterator iter2 = colValue.iterator();
		Double cm;
		
/*		while(iter1.hasNext() || iter2.hasNext()) {
			name = (String)iter1.next(); 
			System.out.print("이름: "+ name);
			cm = (Double)iter2.next();
			System.out.println("  신장: "+ cm);			
		}
		while(iter1.hasNext()) {
			name = (String)iter1.next(); 
			System.out.print("학생 명단: ");
			System.out.print(name);
		}*/
	}
	
	
	String name;
	Double cm, sum, size;
	
	void printNameSumAve() {
		Set set = map.entrySet(); // Map->Set 으로 바꾼다
		Iterator iter3 = set.iterator();

		while(iter3.hasNext()) {
			Entry entry = (Entry)iter3.next(); 
			name = (String)entry.getKey();
			cm = (Double)entry.getValue();
			System.out.print("학생 명단: ");
			System.out.println(name +" ");
			sum += cm;
		}
		System.out.println("신장의 합: "+ sum);
		System.out.println("평균 신장: "+sum / map.size());
	}
}


public class Study3 {
	public static void main(String[] args) {
		StuInfo s = new StuInfo();
		s.init();
		s.makeList();
		s.printNameSumAve();
		
		
	}
}
