package oct31_calculation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculationServelt
 */
@WebServlet("/calculation.do")
public class calculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public calculationServlet() {
        super();
    }
    
    // 이번에는 파라미터 3개를 받아야함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String operator = request.getParameter("op");
		String num2 = request.getParameter("num2");
		System.out.println(num1+operator+num2);
		
		calculation cal = new calculation();
		double result = cal.doit(num1, operator, num2);
		
		response.sendRedirect("calculation.jsp?RESULT="+result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //서블릿끝======================

class calculation {
	double doit(String n1, String op, String n2) {
		Double num1 = Double.parseDouble(n1);
		Double num2 = Double.parseDouble(n2);
		Double result = 0.0;
		switch(op) {
		case "+" : result = num1 + num2; break;
		case "-" : result = num1 - num2; break;
		case "*" : result = num1 * num2; break;
		case "/" : result = num1 / num2; break;
		}
		return result;
	}
}
