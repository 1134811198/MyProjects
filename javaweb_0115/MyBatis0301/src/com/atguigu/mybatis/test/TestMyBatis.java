package com.atguigu.mybatis.test;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.beans.EmployeeExample;
import com.atguigu.mybatis.beans.EmployeeExample.Criteria;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class TestMyBatis {
	
	@Test
	public void testMBGMyBatis3() throws Exception {
		SqlSessionFactory ssf  = getSqlSessionFactory();
		SqlSession session  = ssf.openSession();
		
		try {
			EmployeeMapper mapper= session.getMapper(EmployeeMapper.class);
			// 查询名字中带有 '刚' 并且性别为 0,  或者email中带有 'z'
			EmployeeExample example  = new EmployeeExample();
			
			Criteria  c = example.createCriteria();
		
			c.andLastNameLike("%刚%");
			c.andGenderEqualTo("0");
			
			//对于或的条件，需要重新封装到一个Criteria中
			Criteria  c1 = example.createCriteria();
			c1.andEmailLike("%z%");
			//或的条件还需要  或 到example中
			
			example.or(c1);
			
			
			List<Employee> emps = mapper.selectByExample(example);
			System.out.println("emps: " +emps  );
			
		} finally {
			session.close();
		}
	}
	

	
	@Test
	public void testMBG() throws Exception {
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("mbg.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}
	
	

}
