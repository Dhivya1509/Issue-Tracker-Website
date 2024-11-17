package com.project.leebugzz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.leebugzz.model.CategoryEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;
import com.project.leebugzz.row.mapper.CategoryRowMapper;
import com.project.leebugzz.row.mapper.TicketRowMapper;
import com.project.leebugzz.row.mapper.UserRowMapper;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = jdbcTemplate.query("select * from user where userId>0", new UserRowMapper());
		return users;
	}

	@Override
	public List<TicketEntity> getUserTickets(String userName) {
		// TODO Auto-generated method stub
		List<TicketEntity> userTickets = jdbcTemplate.query("select * from ticket where createrName=?",
				new Object[] { userName }, new TicketRowMapper());
		return userTickets;
	}

	@Override
	public List<TicketEntity> getAll() {
		// TODO Auto-generated method stub
		List<TicketEntity> userTickets = jdbcTemplate.query("select * from ticket", new TicketRowMapper());
		return userTickets;
	}

	@Override
	public void updateHolder(int ticketId, String repName) {
		// TODO Auto-generated method stub
		// jdbcTemplate.update("update ticket set holderName=NULL where ticketId=?",new
		// Object[] {ticketId});
		jdbcTemplate.update("update ticket set holderName='' where ticketId=?", new Object[] { ticketId });
		System.out.println("-");
		update(ticketId, repName);
	}

	@Override
	public void update(int ticketId, String repName) {

		jdbcTemplate.update("update ticket set holderName=? where ticketId=?", new Object[] { repName, ticketId });
		jdbcTemplate.update("update ticket set holderName=replace(holderName,',','')");
	}

	@Override
	public List<CategoryEntity> getCategories() {
		// TODO Auto-generated method stub
		List<CategoryEntity> categories = jdbcTemplate.query("select * from category", new CategoryRowMapper());
		return categories;
	}

	@Override
	public void addCategory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into category(categoryName) values(?)",
				new Object[] { categoryEntity.getCategoryName() });
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from category where categoryId=?", new Object[] { categoryId });
	}
}
