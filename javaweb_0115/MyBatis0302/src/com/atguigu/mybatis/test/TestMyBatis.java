package com.atguigu.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestMyBatis {
	

	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testPagehelper() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//设置分页信息
			Page<Object > page = PageHelper.startPage(9, 1);  // 页码   每页显示的条数
			List<Employee> emps = mapper.getEmps();
			
			//PageInfo    查到的数据的集合      分页逻辑显示的页码
			PageInfo<Employee>  info = new PageInfo<>(emps,5);
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			System.out.println("============== 获取分页相关的信息=================");
			System.out.println("总页码:" + page.getPages());
			System.out.println("当前页:" + page.getPageNum() );
			System.out.println("总条数:" + page.getTotal() );
			System.out.println("每页显示的条数:" + page.getPageSize() );
			
			System.out.println("============== 获取更详细分页相关的信息=================");
			System.out.println("总页码:" + info.getPages());
			System.out.println("当前页:" + info.getPageNum() );
			System.out.println("总条数:" + info.getTotal() );
			System.out.println("每页显示的条数:" + info.getPageSize() );
			System.out.println("是否有上一页:" +info.isHasPreviousPage());
			System.out.println("是否有上一页:" +info.isHasNextPage());
			System.out.println("是否是第一页:" + info.isIsFirstPage());
			System.out.println("是否是最后一页:"+ info.isIsLastPage());
			
			System.out.println(" 分页逻辑");
			int [] nums = info.getNavigatepageNums();
			for (int i : nums) {
				System.out.print(i + "   ");
			}
			
		} finally {
			session.close();
		}
	}
	

}
