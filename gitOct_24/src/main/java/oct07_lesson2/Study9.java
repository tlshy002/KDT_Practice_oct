package oct07_lesson2;



// 다형성의 목적예제: 도형의 면적 구하기
// 다형성 적용하기 => 다형성을 적용하려면 상속관계여야함

// 그러려면 부모클래스가 필요함 => Circle Rectangle Triangle 에서 공통점 찾기
// 공통점은 변수이름이 다르더라도 데이터의 성격이 같으면 공통점임

abstract class Shape {
	double size = 0;
	abstract void makeSize(); //면적을 구한다는 공통점은 있지만, 공식이 다 달라서 지금 작성할수가 없음. => 그래서 추상메서드화
}



class Circle extends Shape {
	int r = 5;
	//double size = 0; //면적을위한 변수
	void makeSize() {
		size = r * r * 3.14;
	}
}

class Rectangle extends Shape{
	int width = 5; 
	int height = 10;
	void makeSize() {
		size = width * height;		
	}
}

class Triangle extends Shape {
	int width = 5; 
	int height = 10;
	void makeSize() {
		size = width * height * 0.5;		
	}
}

public class Study9 {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.makeSize();
		System.out.println(c.size);
		
		Rectangle r = new Rectangle();
		r.makeSize();
		System.out.println(r.size);
		
		Triangle t = new Triangle();
		t.makeSize();
		System.out.println(t.size);
		
		//---------------------------------------------
		Shape s = new Circle();//다형성
		s.makeSize();//원의 면적 계산
		
		System.out.println(s.size);
		s = new Rectangle();//다형성
		
		s.makeSize();//사각형의 면적 계산
		System.out.println(s.size);
		s = new Triangle();//다형성
		
		s.makeSize();//삼각형의 면적 계산
		System.out.println(s.size);
	
		
		
//		Shape s = new Circle();
		
		
	}
}
