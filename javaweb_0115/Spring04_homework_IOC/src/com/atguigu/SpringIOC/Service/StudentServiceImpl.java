package com.atguigu.SpringIOC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.SpringIOC.Dao.StudentDao;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
	StudentDao studentDao;
	@Override
	public void putOnClothes() {
		studentDao.putOnClothes();
	}

}
