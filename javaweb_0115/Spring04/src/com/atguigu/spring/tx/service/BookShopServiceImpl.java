package com.atguigu.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.spring.tx.dao.BookShopDao;
import com.atguigu.spring.tx.exception.UserAccountException;

@Transactional
@Service
public class BookShopServiceImpl  implements BookShopService{
	
	@Autowired
	private BookShopDao bookShopDao; 
	
	/**
	 * 	propagation: 事务的传播行为   一个事务方法被另外一个事务方法调用时， 被调用的事务方法如何使用事务. 
	 * 		REQUIRED(默认值): 使用调用者的事务  propagation=Propagation.REQUIRED
	 * 		REQUIRES_NEW:  将调用者的事务挂起，开启新的事务来使用.propagation=Propagation.REQUIRES_NEW
	 *  
	 *  
	 *  isolation: 事务的隔离级别. 
	 *      isolation=Isolation.DEFAULT Mysql.Oracle等的默认隔离级别
	 *  	1  读未提交     存在脏读问题 isolation=Isolation.READ_UNCOMMITTED
	 *      2  读已提交     存在不可重复读问题    最常用. isolation=Isolation.READ_COMMITTED
	 *      4  可重复读     存在幻读问题 isolation=Isolation.REPEATABLE_READ
	 *      8  串行化        效率很低. isolation=Isolation.SERIALIZABLE
	 *      
	 *  事务的回滚与不回滚: 默认情况下会对所有的运行时异常回滚. 
	 *  rollbackFor   
	 *  rollbackForClassName
	 *  noRollbackFor
	 *  noRollbackForClassName 
	 *  
	 *  事务的只读:
	 *  	readOnly:true/false
	 *  		true:  只读。 如果当前事务中没有对数据库进行增删改的操作，就有必要将当前的事务设置
	 *                     为只读。 有助于帮助数据库的引擎优化事务.readOnly=true
	 *          false: 非只读. 如果当前事务中有对数据库进行增删改的操作，就一定要设置为非只读事务. 
	 *                readOnly=false
	 *                       
	 *  事务的超时设置:
	 *  	 timeout:设置事务在强制回滚之前可以占用的时间. 
	 *  			  可以避免一个事务对一个连接占用过长的时间. timeout=3  三秒
	 *  	
	 */
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
					isolation=Isolation.READ_COMMITTED,
					/*noRollbackFor= {UserAccountException.class},*/
					readOnly=false,timeout=3)
	
	public void buyBook(String username, String isbn) {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//1. 先查询书的价格
		Integer price = bookShopDao.findBookPriceByIsbn(isbn);
		//2. 改库存
		bookShopDao.updateBookStock(isbn);
		
		//3. 改余额
		bookShopDao.updateUserAccount(username, price);
	}
}
