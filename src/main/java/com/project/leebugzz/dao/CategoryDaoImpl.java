package com.project.leebugzz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.row.mapper.TicketRowMapper;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TicketEntity> getTickets() {
		// TODO Auto-generated method stub
		String name = jdbcTemplate.queryForObject("select firstName from loggeduser order by id desc limit 1",
				String.class);
		// name = name+",";
		// List<TicketEntity> tickets=jdbcTemplate.query("select * from ticket where
		// holdername=(select firstName from loggeduser order by id desc limit 1) and
		// status!='Closed'", new TicketRowMapper());
		List<TicketEntity> tickets = jdbcTemplate.query("select * from ticket where holdername=? and status!='Closed'",
				new Object[] { name }, new TicketRowMapper());
		return tickets;
	}

	@Override
	public void setCat(String repCategory) {
		// TODO Auto-generated method stub

		jdbcTemplate.update(
				"update user set repCategory=? where user.userId=(select userId from loggedUser order by id desc limit 1)",
				new Object[] { repCategory.toString() });
		jdbcTemplate.update("update user set repCategory=replace(repCategory,',','')");
	}

	@Override
	public void map(TicketEntity ticketEntity) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update ticket set title=? where ticketId=?",
				new Object[] { ticketEntity.getTitle(), ticketEntity.getTicketId() });
		jdbcTemplate.update("update ticket set holderName='' where ticketId=?",
				new Object[] { ticketEntity.getTicketId() });
		jdbcTemplate.update("update ticket set title=replace(title,',','')");

	}

	@Override
	public List<TicketEntity> getAllTickets() {
		String name = jdbcTemplate.queryForObject("select firstName from loggeduser order by id desc limit 1",
				String.class);
		System.out.println(name);
		List<TicketEntity> ticket = jdbcTemplate.query(
				"select * from ticket where ticket.holdername=? and status = 'reopen'", new Object[] { name },
				new TicketRowMapper());
		return ticket;
	}

}
