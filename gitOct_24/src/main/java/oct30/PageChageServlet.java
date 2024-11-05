package oct30;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageChageServlet
 */
@WebServlet("/PageChage.do")
public class PageChageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageChageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿에서 브라우저로 전환하는 2가지 --> 선택이 매우 중요(잘못하면 ㅈ됨) 새로고침할때마다 구매횟수가 여러번 들어갈수도
		// 1. Redirect 방식
		// 2. Forward 방식
		// 개발방식을 개발자가 선택해야 하는데 치명적인 문제발생 가능성이 있기에 차이를 분명히 알고 사용해야함
		
		// 1. 리다이렉트 방식
		//response.sendRedirect();
		
		// 2. 포워드 방식
		//RequestDispatcher rd = request.getRequestDispatcher("");
		//rd.forward(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("page2.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
