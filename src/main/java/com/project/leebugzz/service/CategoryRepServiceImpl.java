package com.project.leebugzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leebugzz.dao.CategoryDao;
import com.project.leebugzz.model.TicketEntity;

@Service
public class CategoryRepServiceImpl implements CategoryRepService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<TicketEntity> getTickets() {
		// TODO Auto-generated method stub
		return categoryDao.getTickets();
	}

	@Override
	public List<TicketEntity> getAllTickets() {
		// TODO Auto-generated method stub
		return categoryDao.getAllTickets();
	}

}