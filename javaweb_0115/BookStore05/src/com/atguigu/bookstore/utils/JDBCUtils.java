package com.atguigu.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	// 创建数据源
	private static DataSource dataSource = new ComboPooledDataSource();
	// 创建ThreadLocal对象
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
	// 获取连接
//	public static Connection getConnection() {
//		Connection connection = null;
//		try {
//			connection = dataSource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
	// 获取连接
		public static Connection getConnection() {
			// 从threadLocal中获取连接
			Connection connection = threadLocal.get();
			if (connection == null) {
				try {
					// 从连接池中获取一个连接
					connection = dataSource.getConnection();
					// 将连接设置到threadLocal中
					threadLocal.set(connection);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return connection;
		}

//	// 释放连接
//	public static void releaseConnection(Connection conn) {
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
		public static void releaseConnection() {
			// 从threadLocal中获取连接
			Connection connection = threadLocal.get();
			if (connection != null) {
				try {
					// 关闭连接
					connection.close();
					// 将关闭的连接从threadLocal中移除
					threadLocal.remove();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}
