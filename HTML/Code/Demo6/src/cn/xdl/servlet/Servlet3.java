package cn.xdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s3.do")
public class Servlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("GET���������");
		response.getWriter().append("������˧��~  aiya  �ò��û��� ~ ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("POST���������");
		String uname = request.getParameter("uname");
		//�����������ֵı����ʽ: 
		//����1,�ֽ����� ,����2�����
		//uname = new String(uname.getBytes("iso-8859-1"),"UTF-8");
		
		String upass = request.getParameter("upass");
		System.out.println("uname:"+uname);
		if("gaofeifei".equals(uname)) {
			response.getWriter().append("<h1>���ѱ�����, ��������,�ټ� !~ </h1>");
		}else if("dahonghong".equals(uname)&&"aigaofeifei".equals(upass)) {
			response.getWriter().append("<h1>��ϲ�� ! ��¼�ɹ��� ���Ծ���ķ������ǵ�avi rmvb�ȵȵ���Դ�� ~ ~ </h1>");
		}else {
			response.getWriter().append("<h1>��ϲ��, ӵ���˵�¼���ʸ�, �����ϴ�2��T������ �����Ա ~ </h1><input type='file'/>");
		}
	}
	
}
