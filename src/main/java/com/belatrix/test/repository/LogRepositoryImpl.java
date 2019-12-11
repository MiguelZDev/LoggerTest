package com.belatrix.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepositoryImpl implements LogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(String msg, int level) {
		return jdbcTemplate.update("insert into Log_Values (message,level) values (?,?)", msg, level);
	}

}
