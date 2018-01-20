package cn.xdl.demo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2.do")
public class Servlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if(count == null) {
			count = 0;
		}
		count++;
		context.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter()
		.append("<html>")
		.append("<head><title>��̬��ҳ����Servlet</title></head>")
		.append("<body>")
		.append("<h3>��ǰ��վ���ʴ���:"+count+"</h3>");
		for (int i = 0; i < 1000; i++) {
			response.getWriter()
			.append("������<input type='radio'><hr>");
		}
		response.getWriter()
		.append("</body>")
		.append("</html>")
		;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
