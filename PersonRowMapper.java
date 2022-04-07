package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs,int recNo) throws SQLException{
		
		return (rs.getString("name")+" "+rs.getString("city"));
	}
}
