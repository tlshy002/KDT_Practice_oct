package oct31_beer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerServlet
 */
@WebServlet("/BeerServlet.do")
public class BeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BeerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		
		// HTML로부터 서블릿으로 색정보를 받아옴 --> 이제 색에 맞는 맥주이름을 찾아야함. 근데
		// 맥주 이름을 찾는 기능은 서블릿의 역할이 아님
		// 맥주 이름을 찾는 책임을 갖는 클래스 => BeerExpert
		
		BeerExpert be = new BeerExpert();
		String beerName = be.beerSelect(color);
		
		// 자바 변수이기에 이 데이터를 html로 전달할 수 없음
		// => 서블릿에서 jsp로 데이터 전달
		response.sendRedirect("beerSelection.jsp?BEER=" + beerName); // 주소창으로 데이터 전달
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} //서블릿의 끝=============


class BeerExpert {
	String beerSelect(String color) {
		String name ="";
		switch(color) {
		case "red" : name="TchingTao"; break;
		case "yellow" : name="Corona"; break;
		case "blue" : name="Kirin"; break;
		case "black" : name="Taurine"; break;
		case "ect" : name="Cass"; break;
		}
		return name;
	}
}


