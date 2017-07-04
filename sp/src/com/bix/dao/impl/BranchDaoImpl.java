package com.bix.dao.impl;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bix.dao.BranchDao;
import com.bix.entities.Branch;

@Repository
public class BranchDaoImpl implements BranchDao {

	@Autowired SessionFactory sessionFactory;
	
	
	
	@Override
	public String getCurrentDate() {
	
		
Query query =	sessionFactory.getCurrentSession().createSQLQuery("SELECT SYSDATE()");
		
	Branch br=new Branch();
	
	br.setBranchName("Branchone");
	br.setBranchNumber("200");
	
     sessionFactory.getCurrentSession().save(br);
	
  System.out.println("HERE IS THE TIME" + query.list());
	
		// TODO Auto-generated method stub
		return null;
	}

}
