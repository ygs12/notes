package com.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.web.common.BaseServlet;

/**
 * 使用BaseServlet处理请求 Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		System.out.println("实例化");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 添加用户
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("新增用户信息1");
		response.sendRedirect(request.getContextPath()+"/jsp/user/add.jsp");
	}

	// 修改用户
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("编辑用户信息1");
		response.sendRedirect(request.getContextPath()+"/jsp/user/update.jsp");
	}

	// 展示用户
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("展示用户信息1");
		response.sendRedirect(request.getContextPath()+"/jsp/user/list.jsp");
	}
}
