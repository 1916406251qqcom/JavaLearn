package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	/**
	 * request:  ������� , ��װ�������е�������Ϣ, ����ͨ��һϵ�е�api  ��ȡ�����е�����!
	 * response: ��Ӧ���� , ��װ����Ӧ��һЩ������ʽ, ���ǿ���ͨ����Ӧ���� �Կͻ���(Ҳ���������) , ����һЩ��Ӧ!
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ��������Ϊ��ҳ, �����ݱ���Ϊutf-8
		response.setContentType("text/html;charset=utf-8");
		//��ȡ����Ӧ��
		response.getWriter().append("��������").append("�ǺǺ�");
	}
}
