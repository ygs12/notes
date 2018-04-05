/**
 * 
 */
package com.user.web.common;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有Servlet类的父类
 * 
 * 规范:
 * 处理JSON,XML,Text->Ajax
 * public void xxxXxxx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 * }
 * 
 * public String xxxXxxx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 * 
 * }
 * 
 * 请求方式:
 * userServlet?method=serlvet中的方法名称
 * @author Administrator
 *
 */
public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用了Service方法");
		// this 指向子类实例
		Class<? extends BaseServlet> clazz = this.getClass();
		// 获取当前调用方法名称
		String methodName = request.getParameter("method");
		
		try {
			// 通过反射构建一个方法对象
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			// 获取当前方法对象的返回值类型的类型名称
			String returnClassName =  method.getReturnType().getSimpleName().toLowerCase();
			// 判断返回类型名称
			if ("string".equals(returnClassName)) {
				String returnValue = method.invoke(this, request, response).toString();
				// 转发请求
				request.getRequestDispatcher(returnValue).forward(request, response);
			} else if ("void".equals(returnClassName)) {
				// 处理Ajax请求
				// 直接执行子类中处理的方法(反射方式执行 子类中的方法)
				method.invoke(this, request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
