package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getMethod();
		System.out.println(method);
		if (method.equalsIgnoreCase("post")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			if ("admin".equals(username) && "1234".equals(password)) {
				req.getRequestDispatcher("/views/param/home.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "Wrong credential!!!");
				req.getRequestDispatcher("/views/param/login-form.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("/views/param/login-form.jsp").forward(req, resp);
		}
	}
}
