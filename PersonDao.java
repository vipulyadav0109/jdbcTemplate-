package com.dao;

import java.util.List;

public interface PersonDao {

	int create(Person p);

	Person retrieve(int id);

	String retrDetails(int id);

	List<Person> retrAll();

	void addBatch(List<Person> l);
}
