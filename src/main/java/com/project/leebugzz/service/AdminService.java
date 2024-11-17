package com.project.leebugzz.service;

import java.util.List;

import com.project.leebugzz.model.CategoryEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;

public interface AdminService {

	public List<UserEntity> getUsers();

	public List<TicketEntity> getUserTickets(String userName);

	public List<TicketEntity> getAll();

	public void updateHolder(int ticketId, String holderName);

	public void addCategory(CategoryEntity categoryEntity);

	public void deleteCategory(int categoryId);

	public List<CategoryEntity> getCategories();
	



	

}
