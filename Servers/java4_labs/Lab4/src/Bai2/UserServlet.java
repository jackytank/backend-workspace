package Bai2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = Arrays.asList(new User[] { new User("superman", "1234", true),
				new User("Batman", "4321", false), new User("Brainiac", "7890", true) });
		req.setAttribute("message", "Quản lí người sử dụng");
		req.setAttribute("form", users.get(0));
		req.setAttribute("users", users);
		req.getRequestDispatcher("/views/Bai2/index.jsp").forward(req, resp);
	}
}
