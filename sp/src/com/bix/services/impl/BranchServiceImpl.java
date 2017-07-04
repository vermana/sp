package com.bix.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bix.dao.BranchDao;
import com.bix.services.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	
	@Autowired BranchDao branchDao;
	
	@Transactional
	@Override
	public String getDBDate() {
		
		branchDao.getCurrentDate();
		
		return null;
	}

}
