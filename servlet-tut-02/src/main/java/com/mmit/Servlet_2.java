package com.mmit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/servlet-2"})
public class Servlet_2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.print("<h3>Servlet 2</h3>");
		out.print("<h5>User name: " + req.getParameter("uname") + "</h5>");
		out.print("<h5>Password: " + req.getParameter("upass") + "</h5>");
		out.print("</body></html>");
	}
}
