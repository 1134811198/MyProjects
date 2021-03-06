package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

/**
 * 后台管理图书的Servlet
 */
public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
	BookService bookService=new BookServiceImpl();

	// 更新图书
	protected void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要更新的图书的id
	String id = request.getParameter("bookId");
		// 获取新的图书信息
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String price = request.getParameter("price");
	String sales = request.getParameter("sales");
	String stock = request.getParameter("stock");
		// 封装Book对象
	Book book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price),
			Integer.parseInt(sales), Integer.parseInt(stock));
		// 调用bookService中更新图书的方法
		bookService.updateBookById(book);
		// 调用getBooks方法再次查询一遍
	
getBooks(request, response);
	}

	// 获取要修改的图书
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要修改的图书的id
		String id = request.getParameter("bookId");
		// 调用bookService中获取图书的方法
		Book book = bookService.getBookById(id);
		// 将book放到request域中
		request.setAttribute("book", book);
		// 转发到修改图书的页面
		request.getRequestDispatcher("/pages/manager/book_modify.jsp").forward(request, response);
	}

	// 删除图书
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要删除的图书的id
		String id = request.getParameter("bookId");
		// 调用bookService中删除图书的方法
		bookService.deleteBookById(id);
		// 调用getBooks方法
		getBooks(request, response);
	}

	// 添加图书
	protected void addBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		// 封装Book对象
		Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales),
				Integer.parseInt(stock));
		// 调用bookService中保存图书的方法
		bookService.saveBook(book);
		
		// 方式二：直接调用getBooks方法
		getBooks(request, response);
	}

	// 获取所有图书
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用bookService中获取所有图书的方法
		List<Book> books = bookService.getBooks();
		// 将books放到request域中
		request.setAttribute("books", books);
		// 转发到显示所有图书的页面
		request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);
		
	}

}
