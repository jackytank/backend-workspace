package Bai3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Item item = new Item("Lamborghini Aventador J",
				"https://uhdwallpapers.org/uploads/converted/18/03/08/lamborghini-terzo-millennio-1280x720_89948-mm-90.jpg",
				3400000, 0.11);
		req.setAttribute("item", item);
		req.getRequestDispatcher("/views/Bai3/detail.jsp").forward(req, resp);
	}
}
