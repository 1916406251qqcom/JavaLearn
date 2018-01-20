package cn.xdl.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.bean.Book;
import cn.xdl.db.Oracle_BookDao_Imp;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//ͨ��dao ��ѯ����ͼ��
		List<Book> books = new Oracle_BookDao_Imp().findAll();
		//��ʼ���ɶ�̬��ҳ
		response.getWriter()
		.append("<html>")
		.append("<head><title>ͼ�����ϵͳ</title><link rel='stylesheet' type='text/css' href='css/book.css'></head>")
		.append("<body>"
				+ "<div>");
		if(books==null || books.size()==0) {
			response.getWriter().append("<center><h1>������ʱ�޷���ѯ, ���Ժ�����</h1></center>");
		}else {
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				
				response.getWriter()
				.append("<div class='book'>")
				.append("<img src='"+book.getImgpath()+"'>")
				.append("<p class='book_p1'>"+book.getName()+"</p>")
				.append("<p class='book_p2'><span class='book_rmb'>"+book.getRmb()+"��</span><span class='book_buy'><button>����</button></span></p>")
				.append("<p><a href='deletebook.do?id="+book.getId()+"'><button>ɾ��</button></a></p>")
				.append("</div>")
				;
				
			}
		}
		response.getWriter()
		.append("</div></body>")
		.append("</html>")
		;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
