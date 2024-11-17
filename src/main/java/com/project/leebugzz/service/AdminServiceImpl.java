package com.project.leebugzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leebugzz.dao.AdminDao;
import com.project.leebugzz.model.CategoryEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return adminDao.getUsers();	
	}

	@Override
	public List<TicketEntity> getUserTickets(String userName) {
		// TODO Auto-generated method stub
		
		return adminDao.getUserTickets(userName);
	}

	@Override
	public List<TicketEntity> getAll() {
		// TODO Auto-generated method stub
		return adminDao.getAll();
	}

	@Override
	public void updateHolder(int ticketId, String holderName) {
		// TODO Auto-generated method stub
		adminDao.updateHolder(ticketId, holderName);
		
	}

	@Override
	public void addCategory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		adminDao.addCategory(categoryEntity);
		
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		adminDao.deleteCategory(categoryId);
		
	}

	@Override
	public List<CategoryEntity> getCategories() {
		// TODO Auto-generated method stub
		return adminDao.getCategories();
	}


}
