package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.Person;
import com.dao.PersonDao;

@Repository("person_dao")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private JdbcTemplate jt;
	
	
	
	@Override
	public int create(Person p) {

		// inserting a single record into the db
		return jt.update("insert into person1 values(?,?,?)", p.getId(), p.getName() , p.getCity() );
	}

	@Override
	public Person retrieve(int id) {

		// fetching the complete set of columns for a perticular record in a table
		return jt.queryForObject("select * from person1 where id =?",BeanPropertyRowMapper.newInstance(Person.class),id);
	}

	@Override
	public List<Person> retrAll() {

		// fetching the complete set of columns for all records in a table
		return jt.query("select * from person1", BeanPropertyRowMapper.newInstance(Person.class));
	}

	@Override
	public void addBatch(List<Person> l) {

		// adding bulk of records at a time
		
		List<Object[]> list = new ArrayList<>();			// Object[] ---> for a single record...
		
		for(Person p:l) {
			
			list.add(new Object[] {p.getId() , p.getName() , p.getCity()});  // each argument is considered as a seperate Object 
		}
		
		jt.batchUpdate("insert into person1 values(?,?,?)",list);  // adding a complete list at a time...
	}
	
	@Override
	public String retrDetails(int id) {

		// fetching the subset of columns for a perticular record...
		return jt.queryForObject("select name , city from person1 where id=?",new PersonRowMapper(),id).toString();
	
	
	}


}
