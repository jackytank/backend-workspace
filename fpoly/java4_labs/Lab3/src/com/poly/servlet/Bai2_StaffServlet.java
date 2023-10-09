package com.poly.servlet;

import java.io.File;
import java.io.IOException;

import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

@MultipartConfig
@WebServlet("/staff")
public class Bai2_StaffServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/Bai2/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getParameterMap());
		try {
			File dir = new File(req.getServletContext().getRealPath("/files"));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			Part photo = req.getPart("photo_file");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());

			DateTimeConverter dtc = new DateConverter(new Date(0));
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);

			Bai2_Staff staff = new Bai2_Staff();
			staff.setPhoto(photoFile.getName());
			
			BeanUtils.populate(staff, req.getParameterMap());
			System.out.println(staff.getFullname());
			System.out.println(staff.getBirthday());
			req.setAttribute("bean", staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/Bai2/result.jsp").forward(req, resp);
	}
}
