package com.demo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
	public static Cookie add(String name, String value, int hours, HttpServletResponse resp) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours);
		cookie.setPath("/");
		resp.addCookie(cookie);
		return cookie;
	}

	public static String get(String name, HttpServletRequest req) {
		Cookie[] arr = req.getCookies();
		if (arr != null) {
			for (Cookie cookie : arr) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
