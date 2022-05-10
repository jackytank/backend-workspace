package com.poly.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dang-ky")
public class DangKyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/param/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
		boolean married = Boolean.parseBoolean(req.getParameter("married"));
		String country = req.getParameter("country");
		String notes = req.getParameter("notes");
		String[] hobbies = req.getParameterValues("hobby");
		
		System.out.println(username);
		System.out.println(gender);
		System.out.println(married);
		System.out.println(country);
		System.out.println(notes);
		System.out.println(Arrays.toString(hobbies));
		
		req.setAttribute("param.username", username);
		req.setAttribute("param.password", password);
		req.setAttribute("param.gender", gender);
		req.setAttribute("param.married", married);
		req.setAttribute("param.country", country);
		req.setAttribute("param.hobby", hobbies);
		req.setAttribute("param.notes", notes);
		req.getRequestDispatcher("/views/param/result.jsp").forward(req, resp);
	}
}
