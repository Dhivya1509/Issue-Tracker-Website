package com.project.leebugzz.dao;

import java.util.List;

import com.project.leebugzz.model.TicketEntity;

public interface CategoryDao {

	public List<TicketEntity> getTickets();
	public void setCat(String repCategory);
	public void map(TicketEntity ticketEntity);
	public List<TicketEntity> getAllTickets();
}
