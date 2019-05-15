package com.atguigu.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.beans.Department;
import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.DepartmentMapperResultMap;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import com.atguigu.mybatis.dao.EmployeeMapperResultMap;

public class TestMyBatis {
	
	@Test
	public void testBatchUpdate() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> emps = new ArrayList<Employee>();
			emps.add(new Employee(2, "婷姐44", "tt@atguigu.cn", 0));
			emps.add(new Employee(3, "柴柴44", "cc@atguigu.cn", 0));
			emps.add(new Employee(4, "刚刚44", "gg@atguigu.cn", 0));
			
			mapper.upadateEmpBetch(emps);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testBatchInsert() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> emps = new ArrayList<Employee>();
			emps.add(new Employee(null, "婷姐", "tt@atguigu.com", 0));
			emps.add(new Employee(null, "柴柴", "cc@atguigu.com", 0));
			emps.add(new Employee(null, "刚刚", "gg@atguigu.com", 0));
			
			mapper.addEmpBatch(emps);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDynamicForeach() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(1);
			ids.add(2);
			ids.add(3);
			List<Employee> emps = mapper.getEmpsByIds(ids);
			System.out.println(emps );
		} finally {
			session.close();
		}
	}
	@Test
	public void testDynamicChoose() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee condition = new Employee(null, null,null, 1);
			List<Employee> emps = mapper.getEmpsByConditionChoose(condition);
			System.out.println(emps );
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDynamicSet() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee condition = new Employee(11, "Jerry","Jerry@sina.com", 2);
			mapper.updateEmpsByConditionSet(condition);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDynamicTrim() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee condition = new Employee(null, "Jerry","Jerry@sina.com", 2);
			List<Employee> emps = mapper.getEmpsByConditionTrim(condition);
			System.out.println(emps );
		} finally {
			session.close();
		}
	}
	@Test
	public void testDynamicIf() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee condition = new Employee(null, "Jerry",null, 2);
			List<Employee> emps = mapper.getEmpsByConditionIf(condition);
			System.out.println(emps );
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testResultMapCollection() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			DepartmentMapperResultMap mapper = session.getMapper(DepartmentMapperResultMap.class);
			Department dept  = mapper.getDeptAndEmpsStep(1);
			System.out.println(dept.getDepartmentName());
			System.out.println("--------------------");
			System.out.println(dept.getEmps());
			session.commit();
		} finally {
			session.close();
		}
	}
	@Test
	public void testResultMapAssociation() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperResultMap mapper = session.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmployeeAndDeptStep(1);
			System.out.println(employee.getLastName());
			System.out.println("-----------------------------");
			System.out.println(employee.getDept());
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testSelect() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//List<Employee > emps = mapper.getEmps();
			//Map<String,Object>  map = mapper.getEmployeeByIdReturnMap(11);
			
			Map<Integer ,Employee> map  = mapper.getEmpsReturnMap();
			System.out.println(map);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void testParameter()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//Employee employee = mapper.getEmployeeByIdAndLastName(11, "Jerry");
			
			Map<String,Object> map = new HashMap<>();
			//id  lastName 
			map.put("id", "11");
			map.put("ln", "Jerry");
			map.put("tableName", "tbl_employee");
			Employee employee= mapper.getEmployeeByMap(map);
			System.out.println(employee);
			
			
			session.commit();
		} finally {
			session.close();
		}
		
	}
	
	
	
	@Test
	public void testCRUD() throws Exception {
		// 获取SqlSessionFactory对象
		SqlSessionFactory ssf = getSqlSessionFactory();
		// 获取SqlSession对象
		SqlSession session = ssf.openSession();
		
		// ssf.openSession(true); 获取带自动提交的session
		try {
			// 获取EmployeeMapper接口的代理实现类对象
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//查询
			Employee employee = mapper.getEmployeeById(1);
			System.out.println(employee);
			
			//添加
//			Employee employee = new Employee(null, "Jerry", "jerry@sina.com", 0);
//			Integer result = mapper.addEmployee(employee);
//			System.out.println("result: " +result );
//			System.out.println("主键值:" + employee.getId());
			//修改
//			Employee employee = new Employee(9, "Jerry", "tom@sina.com", 0);
//			mapper.updateEmployee(employee);
			
			//删除
//			Boolean result = mapper.deleteEmployeeById(10);
//			System.out.println("result: " +result );
			
			
			//Jdbc 插入数据获取主键值:
//			Connection conn  = null ;
//			PreparedStatement ps = conn.prepareStatement("sql",PreparedStatement.RETURN_GENERATED_KEYS);
//			int resu = ps.executeUpdate();
//			
//			ResultSet rs  = ps.getGeneratedKeys();
//			if(rs.next()) {
//				rs.getInt(1);
//			}
			
			//增删改操作必须提交
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}
	
	@Test
	public void testMapper()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		//获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapper mapper =  session.getMapper(EmployeeMapper.class);
			Employee employee  = mapper.getEmployeeById(1);
			
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		//获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			/**
			 * Parameters:
				statement   Unique identifier matching the statement to use.  SQL语句的唯一标识
				parameter   A parameter object to pass to the statement    执行SQL的参数
			 * 
			 */
			Employee employee  =
					 session.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.selectEmployee", 1);
					
			
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

}
