package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		String uname = null;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("uname")) {
					uname = cookie.getValue();
				}
			}
		}
		if(uname==null) {
			//�û���δ��¼
			//���һ����ת��login.html��ԭ��, 1��ʾ�û���δ��¼��״̬��,������  ��ҳ
			response.addCookie(new Cookie("flag", "1"));
			response.sendRedirect("login.html");
		}else {
			//�û��Ѿ���¼
			response.getWriter().append("��ӭ��:"+uname);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
