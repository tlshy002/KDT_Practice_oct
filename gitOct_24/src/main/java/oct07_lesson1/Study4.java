package oct07_lesson1;


class IamKing {
	String name;
	IamKing(String name) {
		this.name = name;
	}
}
class IamSun extends IamKing {
	IamSun(String name) {
		super(name);
	}
}


public class Study4 {
	public static void main(String[] args) {
		IamKing king1 = new IamKing("세종"); System.out.println(king1.name);
		IamKing king2 = new IamKing("태종"); System.out.println(king2.name);
		IamSun sun = new IamSun("세자"); System.out.println(sun.name);
	}

}
