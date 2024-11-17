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

import com.project.leebugzz.model.CategoryEntity;
import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.model.UserEntity;
import com.project.leebugzz.service.AdminService;
import com.project.leebugzz.service.TicketService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	TicketService ticketService;
	

	
	@GetMapping("/admindashboard")
	public String dashboard() {
		return "admindashboard";
	}
	
	@GetMapping("/users")
	public String users(ModelMap userModel) {
		List<UserEntity> users=adminService.getUsers();
		userModel.addAttribute("users",users);
		return "usersList";
	}
	
	@GetMapping("/tickets/{userName}")
	public String tickets(@PathVariable String userName,ModelMap ticketModel) {
		List<TicketEntity> userTickets=adminService.getUserTickets(userName);
		ticketModel.addAttribute("userTickets", userTickets);
		return "adminUserTickets";
	}
	
	@GetMapping("/adminviewticket/{ticketId}")
	public String viewTicket(@PathVariable int ticketId,ModelMap ticketModel) {
		TicketEntity ticket=ticketService.getTicket(ticketId);
		ticketModel.addAttribute("ticket", ticket);
		List<MessageEntity> messages=ticketService.getMessages(ticketId);
		ticketModel.addAttribute("messages", messages);
		return "adminViewTicket";
	}
	
	@GetMapping("/alltickets")
	public String allTickets(ModelMap ticketModel) {
		List<TicketEntity> userTickets=adminService.getAll();
		ticketModel.addAttribute("userTickets", userTickets);
		return "adminUserTickets";
	}
	
	@GetMapping("updateholder/{ticketId}")
	public String setUpdateStatus(@PathVariable("ticketId") int ticketId, ModelMap holderModel) {
	TicketEntity ticket=ticketService.getTicket(ticketId);
	String cat=ticket.getTitle();
	holderModel.addAttribute("cat", cat);
	System.out.println(cat);
	holderModel.addAttribute("holderAttribute", ticket);
	return "adminUpdateHolder";
	}

	@PostMapping("/updateholder")
	public String update(@ModelAttribute("holderAttribute") TicketEntity ticketEntity,Model model) {
	adminService.updateHolder(ticketEntity.getTicketId(),ticketEntity.getHolderName());
	//System.out.println(ticketEntity.getTicketId()+"----"+ticketEntity.getHolderName());
	return "redirect:/alltickets";
	}
	
	@GetMapping("/categories")
	public String categories(ModelMap model) {

	 List<CategoryEntity> categories=adminService.getCategories();
	model.addAttribute("categories",categories);
	return "adminCategoryView";
	}
	@GetMapping("/adminCategoryAdd")
	public String addCategory(Model model) {
	model.addAttribute("categoryAttribute",new CategoryEntity());
	return "adminCategoryAdd";
	}

	 @PostMapping("/adminCategoryAdd")
	public String addCategory(@ModelAttribute("categoryAttribute") CategoryEntity categoryEntity,BindingResult bindingResult) {
	adminService.addCategory(categoryEntity);
	return "redirect:/categories";
	}
	@GetMapping("/deleteCategory/{categoryId}")
	public String delete(@PathVariable int categoryId) {
	adminService.deleteCategory(categoryId);
	return "redirect:/categories";
	}



}
