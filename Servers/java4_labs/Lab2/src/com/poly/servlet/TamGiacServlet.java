package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/tam-giac", "/dien-tich", "/chu-vi" })
public class TamGiacServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/param/tam-giac.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(req.getParameter("a"));
		double b = Double.parseDouble(req.getParameter("b"));
		double c = Double.parseDouble(req.getParameter("c"));

		if ((a + b > c) && (a + c > b) && (b + c > a)) {
			String URI = req.getRequestURI();
			if (URI.contains("dien-tich")) {
				double p = (a + b + c) / 2;
				double dientich = Math.sqrt(p * (p - a) * (p - b) * (p - c));
				req.setAttribute("message", "Diện tích của tam giác là " + dientich);
			} else {
				double chuvi = a + b + c;
				req.setAttribute("message", "Chu vi của tam giác là " + chuvi);
			}
			// Heron formula
		} else {
			req.setAttribute("message", "Không thỏa mãn các cạnh của một tam giác");
		}
		req.getRequestDispatcher("/views/param/tam-giac.jsp").forward(req, resp);
	}
}
