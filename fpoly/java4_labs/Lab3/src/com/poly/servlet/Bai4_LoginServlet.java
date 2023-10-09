package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Bai4_LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = CookieUtils.get("username", req);
		String password = CookieUtils.get("password", req);
		
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.getRequestDispatcher("/views/Bai4/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		if (!username.equalsIgnoreCase("poly")) {
			req.setAttribute("message", "Wrong username!!!");
		} else if (password.length() < 6) {
			req.setAttribute("message", "Wrong password!!!");
		} else {
			req.setAttribute("message", "Login successfully!!");
			// remember login credential
			int hours = (remember == null) ? 0 : 30 * 24;
			CookieUtils.add("username", username, hours, resp);
			CookieUtils.add("password", password, hours, resp);
		}

		req.getRequestDispatcher("/views/Bai4/login.jsp").forward(req, resp);
	}
}
