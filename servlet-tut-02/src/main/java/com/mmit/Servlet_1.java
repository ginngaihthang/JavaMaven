package com.mmit;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet-1"})
public class Servlet_1 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// retrive alue from request
		var username = req.getParameter("uname");
		var pass = req.getParameter("upass");
		// invoke other resource using forward
		getServletContext().getRequestDispatcher("/servlet-2").forward(req, resp);
		
		//resp.sendRedirect(req.getContextPath() + "/servlet-2");
	}
}
