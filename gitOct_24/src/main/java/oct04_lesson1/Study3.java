package oct04_lesson1;

import java.util.Scanner;

// 배열과 클래스를 이용한 시스템: 버스 노선 안내 시스템
// 버스번호를 입력하면 해당 번호의 정류장명이 출력
//실행예
//버스번호를 입력하고 Enter 를 누르세요
//10
//광화문->종로3가->종로5가->동대문
//노선번호 없는 경우, 해당 번호의 버스는 존재하지 않습니다.


class BusRouteSys {
	BusRouteSys(){}
	Scanner sc = new Scanner(System.in);
	Bus[] bus;
	Bus[] buses;
	
	void init() {
		bus = new Bus[10];
		
		//버스정보 저장
		bus[0] = new Bus(10, "명지초->명지중->명지고->명지대");		bus[5] = new Bus(15, "명지초->명지중->명지고->명지대");
		bus[1] = new Bus(11, "명지초->명지중->명지고->명지대");		bus[6] = new Bus(16, "명지초->명지중->명지고->명지대");
		bus[2] = new Bus(12, "명지초->명지중->명지고->명지대");		bus[7] = new Bus(17, "명지초->명지중->명지고->명지대");
		bus[3] = new Bus(13, "명지초->명지중->명지고->명지대");		bus[8] = new Bus(18, "명지초->명지중->명지고->명지대");
		bus[4] = new Bus(14, "명지초->명지중->명지고->명지대");		bus[9] = new Bus(19, "명지초->명지중->명지고->명지대");
	}
	
	void init2() {
		buses = new Bus[3];
		
		//배열크기 5인 배열을 하나 만들고, 그걸 생성자의 매개변수로 전달해서 인스턴스 만들기
		String[] bus1Stations = {"광화문", "종로1가", "종로3가", "종로5가", "동대문"}; 
		Bus bus1 = new Bus(10, bus1Stations);
		
		String[] bus2Stations = {"남대문", "남영동", "노량진", "대방동", "영등포", "문래동"}; //배열크기 6
		Bus bus2 = new Bus(20, bus2Stations);
		String[] bus3Stations = {"강남역", "역삼동", "선릉역", "잠실동", "구의동", "성내동", "왕십리"}; //배열크기 7
		Bus bus3 = new Bus(30, bus3Stations);
		
		buses[0] = bus1;
//		buses[0].busNum = bus1.busNum; //인스턴스 생성하기 전에는 클래스내부 멤버변수못씀
//		buses[0].stations = bus1.stations; 
		buses[1] = bus2; buses[2] = bus3;
	}
	
	void findBus() {
		boolean notFound = true;
		System.out.println("10~19번 버스번호를 입력하고 Enter 를 누르세요.");
		int busNum = sc.nextInt();
		for(int i=0; i<bus.length; i++) {
			if( bus[i].busNum == busNum ) {
				System.out.println("버스경로: " + bus[i].route);
				notFound = false;
				break;
			}
		}
		if(notFound) System.out.println("없는 버스입니다.");
		System.out.println("버스경로 안내 시스템을 종료합니다.");
	}
	void findBus2() {
		boolean notFound = true;
		System.out.println("검색하려는 버스번호를 입력하고 Enter 를 누르세요.");
		int busNum = sc.nextInt();
		for(int i=0; i<buses.length; i++) {
			if( busNum == buses[i].busNum ) {
				
				for(int j=0; j<buses[i].stations.length; j++) {
					System.out.println( buses[i].stations[j] );
				}
				notFound = false;
				break;
			}
		}
		if(notFound) System.out.println("없는 버스입니다.");
		System.out.println("버스경로 안내 시스템을 종료합니다.");
	}
	
} // class BusRouteSys =================================================================

class Bus{
	Bus() {}
	Bus(int busNum, String route) {
		this.busNum = busNum; this.route = route;
	}
	Bus(int busNum, String[] stations) {
		this.busNum = busNum; this.stations = stations;
	}
	int busNum;
	String route;
	String[] stations; //배열이름 선언만 해두고 크기는 나중에정함.
}

public class Study3 {
	public static void main(String[] args) {
		BusRouteSys sys = new BusRouteSys();
//		sys.init();
		
		BusRouteSys sys2 = new BusRouteSys();
		sys2.init2();
		sys2.findBus2();
		
	}
}
