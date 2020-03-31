package com.myspring2.test01;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtils {
	public static String getViewName(HttpServletRequest request) throws Exception {
		String viewName = request.getServletPath();
		return viewName.replace(".do", "");
	}
}
