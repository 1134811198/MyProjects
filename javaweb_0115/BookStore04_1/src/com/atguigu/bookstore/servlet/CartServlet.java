package com.atguigu.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

public class CartServlet extends BaseServlet {

	private BookService bookService = new BookServiceImpl();
	private static final long serialVersionUID = 1L;


	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取图书的id
		String bookId = request.getParameter("bookId");
		//调用bookService中获取图书的方法
		Book book = bookService.getBookById(bookId);
		//获取Session对象
		HttpSession session = request.getSession();
		//获取session域中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			//创建一个购物车并放到session域中
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//将图书添加到购物车中
		cart.addBook2Cart(book);
		//将书名发的session域中
		session.setAttribute("bookTitle", book.getTitle());
		//获取请求来的地址
		String header = request.getHeader("Referer");
		//重定向到header
		response.sendRedirect(header);
	}

}
