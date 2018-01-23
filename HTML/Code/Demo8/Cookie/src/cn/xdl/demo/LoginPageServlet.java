package cn.xdl.demo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class LoginPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<!DOCTYPE html> " + 
				"<html> " + 
				"<head> " + 
				"<meta charset='UTF-8'> " + 
				"<title>Insert title here</title> ");
		response.getWriter().append("<script>");
		
		
		Cookie[] cookies = request.getCookies();
		String flag = null;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("flag")) {
					flag = cookie.getValue();
				}
				
			}
		}
		//����ִ�е�����, flag�����������, 
		
		if(flag==null) {
			//-	null ��ʾ�û�ֱ�Ӵ��˵�¼ҳ��
		}else if(flag.equals("1")) {
			//-	1	 ��ʾ�û�����ҳ��ת����¼
			response.getWriter().append("alert('����δ��½, �޷�������ҳ,���ȵ�¼ !')");
		}else if(flag.equals("2")){
			//-	2	��ʾ�û���¼ʧ��, ��ת���˵�¼ҳ��
			response.getWriter().append("alert('���ź�, ����¼ʧ���� ,�����µ�¼ !')");
		}
		//����������ʲô���, ������һ��Cookie ������������ı��, �Ҹ��Ǻ�, ����ɾ��!
		Cookie flagCookie = new Cookie("flag","");
		flagCookie.setMaxAge(0);
		response.addCookie(flagCookie);
		
		response.getWriter().append("</script>");
		
		response.getWriter().append(		
				"</head> " + 
				"<body> " + 
				"	<h1>�û���¼</h1> " + 
				"	<form action='login.do' method='POST'> " + 
				"	 " + 
				"	<p><input name='uname' placeholder='�������ʺ�'></p> " + 
				"	<p><input name='upass' type='password' placeholder='����������'></p> " + 
				"	<p><input value='��¼' type='submit' ></p> " + 
				"	</form> " + 
				"</body> " + 
				"</html>")
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
