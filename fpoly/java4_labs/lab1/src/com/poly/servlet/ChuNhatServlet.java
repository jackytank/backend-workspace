package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/poly/chunhat.php")
public class ChuNhatServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/param/form-chu-nhat.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double dai = Double.parseDouble(req.getParameter("dai"));
		double rong = Double.parseDouble(req.getParameter("rong"));
		double dientich = dai * rong;
		double chuvi = (dai + rong) * 2;

		req.setAttribute("s", dientich);
		req.setAttribute("c", chuvi);
		
		req.getRequestDispatcher("/views/param/ket-qua.jsp").forward(req, resp);

	}
}
