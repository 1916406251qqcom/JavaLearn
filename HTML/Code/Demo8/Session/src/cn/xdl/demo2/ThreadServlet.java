package cn.xdl.demo2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t.do")
public class ThreadServlet extends HttpServlet {
	//��ǰƱ��
	private int count = 10;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ʾ��ǰ��Ʊ����
		synchronized (this) {
			if(count>0) {
				System.out.println("��Ʊ����, ���ڳ�Ʊ��...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count--;
				System.out.println("��Ʊ�ɹ�,��ǰ��Ʊ:"+count);
			}else {
				System.out.println("��Ʊ����,  ���ܹ���~ ");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
