package com.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.imp.XdlUserDAOOracleImp;

/**
 * Servlet implementation class CheckName
 */
@WebServlet("/checkName.do")
public class CheckName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		XdlUserDAO  userDao  = new XdlUserDAOOracleImp();
		// ��ȡ������ 
		String username = request.getParameter("username");
		boolean  f = userDao.checkName(username);
		PrintWriter pw = response.getWriter();
		pw.write(f+"");
		pw.close();
	}

}



