package com.project.leebugzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.leebugzz.dao.TicketDao;
import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;
	@Autowired
	TicketDao ticketDao;

	@GetMapping("/viewticket/{ticketId}")
	public String viewTicket(@PathVariable int ticketId, ModelMap ticketModel) {

		TicketEntity ticket = ticketService.getTicket(ticketId);
		ticketModel.addAttribute("ticket", ticket);
		List<MessageEntity> messages = ticketService.getMessages(ticketId);
		ticketModel.addAttribute("messages", messages);
		return "ticketView";
	}

	@GetMapping("/editticket/{ticketId}")
	public String edit(@PathVariable int ticketId, ModelMap m) {
		TicketEntity emp = ticketDao.getTicketById(ticketId);
		m.addAttribute("statusAttribute", emp);
		return "adminUpdateStatus";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") TicketEntity ticketEntity) {
		ticketDao.update(ticketEntity);
		return "redirect:/alltickets";
	}

}
