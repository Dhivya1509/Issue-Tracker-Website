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

import com.project.leebugzz.dao.CategoryDao;
import com.project.leebugzz.dao.TicketDao;
import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;
import com.project.leebugzz.service.CategoryRepService;
import com.project.leebugzz.service.TicketService;

@Controller
public class CategoryRepController {

	@Autowired
	private CategoryRepService repService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private CategoryDao categoryDao;

//	@GetMapping("/categoryRepdashboard")
//	public String dashboard() {
//		return "categoryRepdashboard";
//	}

	@GetMapping("/replistissues")
	public String issues(ModelMap ticketModel) {
		List<TicketEntity> tickets = repService.getTickets();
		ticketModel.addAttribute("tickets", tickets);
		return "RepListIssue";
	}

	@GetMapping("/repviewticket/{ticketId}")
	public String displayTicket(@PathVariable int ticketId, ModelMap ticketModel) {
		TicketEntity ticket = ticketService.getTicket(ticketId);
		ticketModel.addAttribute("ticket", ticket);
		List<MessageEntity> messages = ticketService.getMessages(ticketId);
		ticketModel.addAttribute("messages", messages);
		return "RepViewTicket";
	}

	@GetMapping("/repeditticket/{ticketId}")
	public String setStatus(@PathVariable int ticketId, ModelMap m) {
		TicketEntity emp = ticketDao.getTicketById(ticketId);
		m.addAttribute("statusAttribute", emp);
		return "RepUpdateStatus";
	}

	/* It updates model object. */
	@RequestMapping(value = "/repeditsave", method = RequestMethod.POST)
	public String repeditsave(@ModelAttribute("emp") TicketEntity ticketEntity) {
		ticketDao.update(ticketEntity);
		return "redirect:/replistissues";
	}

	@GetMapping("/setCat")
	public String setCat(ModelMap model) {
		model.addAttribute("catAttribute", new UserEntity());
		return "repSetCat";
	}

	@PostMapping("/repSetCat")
	public String saveCat(@ModelAttribute("catAttribute") UserEntity userEntity, Model model) {
		categoryDao.setCat(userEntity.getRepCategory());
		return "redirect:/categoryRepdashboard";
	}

	

	@RequestMapping(method = RequestMethod.GET, value = "/repaddMessage")
	public String addMessageForm(Model model) {
		model.addAttribute("messageAttribute", new MessageEntity());
		return "repAddMessage";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/repaddMessage")
	public String addMessage(@ModelAttribute("messageAttribute") MessageEntity messageEntity,
			BindingResult bindingResult, ModelMap model) {
		List<MessageEntity> messages = ticketService.getMessages(messageEntity.getTicketId());
		model.addAttribute("messages", messages);
		System.out.println(messageEntity.getTicketId());
		ticketService.addMessage(messageEntity);
		return "redirect:/replistissues";
	}
	
	@GetMapping("/repmapticket/{ticketId}")
	public String map(@PathVariable int ticketId, ModelMap map) {
		TicketEntity ticket = ticketDao.getTicketById(ticketId);
		map.addAttribute("ticketAttribute", ticket);
		return "repMapTicket";
	}
	
	@PostMapping("/repmapticket")
	public String saveMap(@ModelAttribute("ticketAttribute")TicketEntity ticketEntity) {
		categoryDao.map(ticketEntity);
		return "redirect:/replistissues";
	}
	
    @GetMapping("/categoryRepdashboard")
    public String dashboard(ModelMap model) {
        List<TicketEntity> tickets=repService.getAllTickets();
        model.addAttribute("tickets",tickets);
        return "categoryRepdashboard";
    }

}
