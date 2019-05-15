package com.atguigu.Spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDaoimpl implements EmployeeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insert(String name, String sex) {
    
		String sql="insert into newemp(name,sex) values (?,?)";
		jdbcTemplate.update(sql, "Jack","man");
	}

}
