import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class learningTest extends HttpServlet{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
		public learningTest() {
		// TODO Auto-generated constructor stub
    	super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  //先跟html一樣設置解碼器
		response.setContentType("text/html");  //可以寫JS
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI(); //先拿到位址
			request.setAttribute("requestUri", requestUri);//用[name , value]的方式存取資料。
			request.getRequestDispatcher("Search.jsp").forward(request, response);//跳轉到jsp
			return;
		}
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));//結果
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][2];   //存key 跟 存value
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {//把得到的資料寫入網頁
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //傳入request , response的get form
	}

}
	


