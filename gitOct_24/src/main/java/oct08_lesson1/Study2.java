package oct08_lesson1;



class MrKim {
	MrKim(){}
	Product product;
	void with(Product product) { this.product = product; }
	
	
//	Camera camera; Camcoder camcoder; Printer printer;
//	void with(Camera camera) { this.camera = camera; } //카메라를 가지고 있는 메서드
//	void with(Camcoder camcoder) { this.camcoder = camcoder; }
//	void with(Printer printer) { this.printer= printer; }
}

class Product {
	String name;
	Product(String name) { this.name = name; }
}

class Camera extends Product {
	Camera(String name){ super(name); }
}
class Camcoder extends Product {
	Camcoder(String name){ super(name); }
}
class Printer extends Product {
	Printer (String name){ super(name); }
}




public class Study2 {
	public static void main(String[] args) {
		MrKim kim = new MrKim();
		Camera cam = new Camera("니콘 카메라");
		kim.with(cam);
//		System.out.println(camera.name); //이거랑
		
		Camcoder camcoder = new Camcoder("소니 캠코더");
		kim.with(camcoder);
		System.out.println(camcoder.name); //이거랑 둘이 뭔차이?
	}
}
