package com.siva.service;

import com.siva.dao.Insert;
import com.siva.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements InsertService {

	@Autowired
	Insert insert;

	@Override
	public boolean insertEmployee(Employee emp) {
		boolean flag = insert.insertEmployee(emp);
		return flag;
	}
}
