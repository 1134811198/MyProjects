package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.CartItem;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

/**
 * 处理购物车的Servlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	// 更新购物项
	protected void updateCartItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图书的id和图书的数量
		String bookId = request.getParameter("bookId");
		String bookCount = request.getParameter("bookCount");
		// 获取Session对象
		HttpSession session = request.getSession();
		// 获取session域中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			// 更新购物项
			cart.updateCartItem(bookId, bookCount);
		}
		// 重定向到购物车页面
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}

	// 删除购物项
	protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要删除的购物项中图书的id
		String bookId = request.getParameter("bookId");
		// 获取Session对象
		HttpSession session = request.getSession();
		// 获取session域中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			// 删除购物项
			cart.deleteCartItem(bookId);
		}
		// 重定向到购物车页面
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}

	// 清空购物车
	protected void emptyCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取Session对象
		HttpSession session = request.getSession();
		// 获取session域中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			// 清空购物车
			cart.emptyCart();
		}
		// 重定向到购物车页面
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}

	// 将图书添加到购物车
	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图书的id
		String bookId = request.getParameter("bookId");
		// 调用bookService中获取图书的方法
		Book book = bookService.getBookById(bookId);
		// 获取Session对象
		HttpSession session = request.getSession();
		// 获取session域中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			// 创建一个购物车并放到session域中
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		// 将图书添加到购物车中
		cart.addBook2Cart(book);
		//获取该图书对象的购物项
		Map<String, CartItem> map = cart.getMap();
		CartItem cartItem = map.get(bookId);
		//获取该图书对应的购物项中图书的数量
		int count = cartItem.getCount();
		//获取该图书的库存
		Integer stock = book.getStock();
		//将两者进行对比
		if(count > stock) {
			//设置一个提示信息并放到session域中
			session.setAttribute("msg", "该图书的库存只有"+stock+"本！");
			//将该购物项中图书的数量设置为最大库存
			cartItem.setCount(stock);
		}else {
			// 将书名发的session域中
			session.setAttribute("bookTitle", book.getTitle());
		}
		// 获取请求来的地址
		String header = request.getHeader("Referer");
		// 重定向到header
		response.sendRedirect(header);
	}

}
