package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.User;

@WebServlet({ "/user/index", "/user/edit/*", "/user/create", "/user/update", "/user/delete", "/user/reset" })
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		User user = new User();
		String URI = req.getRequestURI();
		if (URI.contains("edit")) {
			try {
				String id = URI.substring(URI.lastIndexOf("/") + 1);
				user = userDAO.findByID(id);
				req.setAttribute("message", "Fill to form success!");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Fill to form fail!");
			}
		} else if (URI.contains("create")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				userDAO.insert(user);
				req.setAttribute("message", "Insert success!");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Insert fail!");
			}
		} else if (URI.contains("update")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				userDAO.update(user);
				req.setAttribute("message", "Update success!");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Update fail!");
			}
		} else if (URI.contains("delete")) {
			try {
				String id = req.getParameter("id");
				userDAO.remove(id);
				req.setAttribute("message", "remove success!");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "remove fail!");
			}
		}
		req.setAttribute("form", user);
		req.setAttribute("items", userDAO.findAll());
		findAll(req, resp);
		req.getRequestDispatcher("/views/Bai3/user.jsp").forward(req, resp);
	}

	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			List<User> list = dao.findAll();
			req.setAttribute("items", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		}

	}
}
