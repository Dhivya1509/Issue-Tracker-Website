package com.project.leebugzz.service;

import java.util.List;

import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;

public interface CategoryRepService {
	

	public List<TicketEntity> getTickets();

	public List<TicketEntity> getAllTickets();


}
