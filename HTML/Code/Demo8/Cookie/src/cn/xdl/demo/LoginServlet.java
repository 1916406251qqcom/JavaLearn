package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404, "��ҳ������ ������������");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		if((uname!=null&&uname.length()>2) && upass !=null) {
			//��½�ɹ�
			//����һ��Cookie
			Cookie cookie = new Cookie("uname",uname);
			cookie.setMaxAge(30*24*60*60);
			response.addCookie(cookie);
			//response.getWriter().append("��ϲ��, ��¼�ɹ�");
			response.sendRedirect("home.do");
			
		}else {
			//��¼ʧ��
			//���һ����ת��login.html��ԭ��, 2��ʾ�û���¼ʧ��
			response.addCookie(new Cookie("flag", "2"));
			response.sendRedirect("login.html");
		}
		
	}

}
