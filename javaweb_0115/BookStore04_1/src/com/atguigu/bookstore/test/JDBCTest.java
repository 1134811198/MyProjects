package com.atguigu.bookstore.test;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.bookstore.utils.JDBCUtils;

class JDBCTest {

	@Test
	void testConnection() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}

}
