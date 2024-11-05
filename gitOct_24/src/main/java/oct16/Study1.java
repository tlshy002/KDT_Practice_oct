package oct16;

import java.util.ArrayList;
import java.util.Iterator;
//속성이 너무 많아지면 생성자에 넣기에 한계가 있음. 다 넣기 힘들어


class UserInfo {	
	UserInfo(String name, String address){
		this.name = name;	this.address = address;
	}
	private String name;
	private String address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}


public class Study1 {
	public static void main(String[] args) {
		
		ArrayList<UserInfo> userDB = new ArrayList<UserInfo>();
		UserInfo user1 = new UserInfo("홍길동","서울"); //생성자로 인스턴스 생성
		UserInfo user2 = new UserInfo("김길동","인천"); 
		UserInfo user3 = new UserInfo("박길동","광주"); 
		userDB.add(user1);
		userDB.add(user2);
		userDB.add(user3);
		
		Iterator iter = userDB.iterator();		
		//UserInfo useInfo = iter.next(); //에러생김 왜? => 자료형이 안맞음		
		//next()의 리턴타입은 모든 자료형을 반환하기 때문에 Object 타입임.
		//Object userInfo = iter.next(); //앞의 자료형을 Object 로 바꾸면 저장은 가능하나, UserInfo의 인스턴스 멤버에 접근 불가능
		
		
		//Object 타입을 UserInfo로 형변환(casting)
		UserInfo userInfo2 = (UserInfo)iter.next(); 
		
		//System.out.println(userInfo1.name); //에러
		//System.out.println(userInfo2.name);
		
		System.out.println(userInfo2.getName());
		System.out.println(userInfo2.getAddress());
		
		
		
		//DB에서 조회된 데이터를 저장하는 역할의 클래스를 Data Transfer Object (DTO)라고 함
		//현재 이 프로젝트에서 DTO는 UserInfo이다
		
		// DTO 작성규칙: 
		// 1.모든 속성을 은닉해서(private) 노출되지 않도록 함
		// DB에 있는 데이터는 노출되면 안됨
		// 인스턴스에 .연산자로 바로, 직접 접근하면 안됨
		// useInfo.name
		// 2.속성을 볼수 없기 때문에, 속성을 볼수있는 getter 메서드를 작성한다. //값을 보여줘야하니까 리턴메서드
		// userInfo.getName()
		// 3.속성을 못보기 때문에, 속성에 값을 넣어주는 setter 메서드를 작성함 //값을 넣기만 하면 되니까 void
	}
}
