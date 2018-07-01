package com.siva.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.siva.model.Employee;

@Repository
public class DAOImpl implements Insert {

	@Autowired
	private DataSource datasource;

	@Override
	public boolean insertEmployee(Employee emp) {
		boolean flag = false;

		try {
			String sql = "insert into test values(?,?)";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
			Object[] arg = { emp.getId(), emp.getName() };
			int i = jdbcTemplate.update(sql, arg);

			if (i > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
