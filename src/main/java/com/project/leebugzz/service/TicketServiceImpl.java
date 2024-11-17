package com.project.leebugzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leebugzz.dao.TicketDao;
import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Override
	public List<TicketEntity> getTickets(){
		return ticketDao.getTickets();
	}


	@Override
	public void addTicket(TicketEntity ticketEntity) {
		// TODO Auto-generated method stub
		ticketDao.addTicket(ticketEntity);
		
	}


	@Override
	public TicketEntity getTicket(int ticketId) {
		// TODO Auto-generated method stub
		return ticketDao.getTicket(ticketId);
	}


	@Override
	public List<MessageEntity> getMessages(int ticketId) {
		// TODO Auto-generated method stub
		return ticketDao.getMessages(ticketId);
	}


	@Override
	public void addMessage(MessageEntity messageEntity) {
		// TODO Auto-generated method stub
		ticketDao.addMessage(messageEntity);
		
	}


	@Override
	public List<TicketEntity> notif() {
		return ticketDao.notif();
	}

//
//	@Override
//	public void update(TicketEntity ticketEntity) {
//		// TODO Auto-generated method stub
//		ticketDao.update(ticketEntity);
//		
//	}


//	@Override
//	public void updateStatus(int ticketId) {
//		// TODO Auto-generated method stub
//	    ticketDao.updateStatus(ticketId);
//	}
	
}
