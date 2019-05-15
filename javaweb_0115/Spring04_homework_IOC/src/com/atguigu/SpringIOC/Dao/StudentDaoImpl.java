package com.atguigu.SpringIOC.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public void putOnClothes() {
    System.out.println("穿衣服");		
	}

	
}
