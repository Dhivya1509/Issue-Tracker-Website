package com.project.leebugzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.leebugzz.dao.TicketDao;
import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.service.TicketService;

@Controller
public class UserController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketDao ticketDao;
	
	@GetMapping("/userdashboard")
	public String dash(ModelMap model) {
        List<TicketEntity> tickets=ticketService.notif();
        model.addAttribute("tickets",tickets);
        return "userdashboard";
	}

	@GetMapping("/tickets")
	public String displayTickets(ModelMap ticketModel) {
		List<TicketEntity> tickets=ticketService.getTickets();
		ticketModel.addAttribute("tickets",tickets);
		return "ticketsList";
	}
	
	@GetMapping("/addTicket")
	public String addTicket(Model model)
	{
		model.addAttribute("ticketAttribute", new TicketEntity());
		return "ticketAdd";
	}
	
	@PostMapping("/addTicket")
		public String saveTicket(@ModelAttribute("ticketAttribute") TicketEntity ticketEntity,BindingResult bindingResult)
		{
			ticketService.addTicket(ticketEntity);
			return "redirect:/tickets";
		}
	
	@RequestMapping(method = RequestMethod.GET, value = "/addMessage")
	public String addMessageForm(Model model) {
	model.addAttribute("messageAttribute", new MessageEntity());
	
	return "messageAdd";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/addMessage")
	public String addMessage(@ModelAttribute("messageAttribute") MessageEntity messageEntity, BindingResult bindingResult,ModelMap model) {
	List<MessageEntity> messages=ticketService.getMessages(messageEntity.getTicketId());
	model.addAttribute("messages", messages);
	System.out.println(messageEntity.getTicketId());
	ticketService.addMessage(messageEntity);
	return "redirect:/tickets";
	}
	
    @GetMapping("/usereditticket/{ticketId}")    
    public String edit(@PathVariable int ticketId, ModelMap m){    
        TicketEntity emp=ticketDao.getTicketById(ticketId);    
        m.addAttribute("statusAttribute",emp);  
        return "userUpdateStatus";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/usereditsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") TicketEntity ticketEntity){    
        ticketDao.update(ticketEntity);    
        return "redirect:/tickets";    
    } 
    
    @GetMapping("/contact")
    public String contact(ModelMap model) {

    	return "userContact";
    }
}
