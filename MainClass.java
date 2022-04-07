package com.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.Person;
import com.dao.PersonDaoImpl;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext ctx=new ClassPathXmlApplicationContext("aaplicationContext.xml");
		
		PersonDaoImpl pdao = (PersonDaoImpl) ctx.getBean("person_dao");
		
		Person person = (Person) ctx.getBean("person_bean");
		
		// adding a single record
	
		person.setId(1);
		person.setName("Vipul");
		person.setCity("baramati");
		pdao.create(person);
		
		person.setId(2);
		person.setName("Ganesh");
		person.setCity("solapur");
		pdao.create(person);	

		  
//-----------------------------------------------
			    
		// adding the bulk of records
	    Person person7 = (Person) ctx.getBean("person_bean");
	    person7.setId(3);
	    person7.setName("Nagesh");
	    person7.setCity("Texas");
	   
	    
	    Person person8 = (Person) ctx.getBean("person_bean");
	    person8.setId(4);
	    person8.setName("Shubham");
	    person8.setCity("berminghum");
	    
	    List<Person> l = new ArrayList<>();
	    l.add(person7);
	    l.add(person8);
	    
	    pdao.addBatch(l);
	  
//-----------------------------------------------		
	    
	    // fetching a single record (BPRM)	
	    
	    Person person44 = pdao.retrieve(1);
	    
	    System.out.println(person44);
		
//--------------------------------------------------
	    
	    // fetching a bulk of records (BPRM)
	    
	    List<Person> list = pdao.retrAll();
	    
	    for (Person person2 : list) {
			
	    	System.out.println(person2);
		}
		
//------------------------------------------------------------------------------
	    
	    // fetching the name & city for a single record---->(subset of column)-->(RM)
	    
	    String str = pdao.retrDetails(1);		
		  
	    System.out.println(str);
	    
	    
	}
 
}
