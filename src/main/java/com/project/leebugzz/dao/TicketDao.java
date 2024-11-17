package com.project.leebugzz.dao;

import java.util.List;

import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;

public interface TicketDao {

	public List<TicketEntity> getTickets();

	public Object addTicket(TicketEntity ticketEntity);

	public TicketEntity getTicket(int ticketId);

	public int update(TicketEntity p);

	public TicketEntity getTicketById(int ticketId);

	public void addMessage(MessageEntity messageEntity);

	public List<MessageEntity> getMessages(int ticketId);

	public List<TicketEntity> notif();

}
