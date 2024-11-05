package oct08_lesson2;


class MrKim {
	MrKim(){}
	Camera camera; Camcoder camcoder; Printer printer;
	void with(Camera camera) { this.camera = camera; } //카메라를 가지고 있는 메서드
	void with(Camcoder camcoder) { this.camcoder = camcoder; }
	void with(Printer printer) { this.printer= printer; }
}

class Camera {
	Camera(String name){ this.name = name; }
	String name;
}
class Camcoder {
	Camcoder(String name){ this.name = name; }
	String name;	
}
class Printer {
	Printer (String name){ this.name = name; }
	String name;	
}



public class Test {
	public static void main(String[] args) {
		MrKim kim = new MrKim();
		Camera cam = new Camera("니콘 카메라");
		
		kim.with(cam);
		System.out.println(kim.camera.name); 
		System.out.println(cam.name);
		if(kim.camera == cam) { //둘이 같음
			System.out.println("같다");
		}
		
		Camcoder camcoder = new Camcoder("소니 캠코더");
		kim.with(camcoder);
		System.out.println(camcoder.name); //이거랑 둘이 뭔차이?
		System.out.println(kim.camcoder.name);
	}
}