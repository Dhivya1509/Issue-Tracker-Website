package com.project.leebugzz.dao;

import java.util.List;

import com.project.leebugzz.model.CategoryEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;

public interface AdminDao {

	public List<UserEntity> getUsers();

	public List<TicketEntity> getUserTickets(String userName);

	public List<TicketEntity> getAll();

	public void updateHolder(int ticketId, String repName);

	public void update(int ticketId, String repName);

	public List<CategoryEntity> getCategories();

	public void addCategory(CategoryEntity categoryEntity);

	public void deleteCategory(int categoryId);
}
