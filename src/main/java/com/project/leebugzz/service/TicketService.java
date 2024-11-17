package com.project.leebugzz.service;

import java.util.List;

import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;

public interface TicketService {

	public List<TicketEntity> getTickets();

	public void addTicket(TicketEntity ticketEntity);

	public TicketEntity getTicket(int ticketId);

	public List<MessageEntity> getMessages(int ticketId);

	public void addMessage(MessageEntity messageEntity);

	public List<TicketEntity> notif();

//	public void updateStatus(TicketEntity ticketEntity);

//	public void updateStatus(int ticketId);
}
