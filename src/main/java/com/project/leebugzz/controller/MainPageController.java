package com.project.leebugzz.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.leebugzz.model.UserEntity;
import com.project.leebugzz.service.UserService;

@Controller
public class MainPageController {

	@Autowired
	UserService userService;

	@GetMapping
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new UserEntity());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") UserEntity userEntity, BindingResult bindingResult) {

		// TODO: 11.01.2020 userValidator

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.addUser(userEntity);
		// securityService.autoLogin(userEntity.getEmail(),
		// userEntity.getPasswordConfirm());

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {

		if (error != null) {
			model.addAttribute("error", "Invalid username or  password");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out");
		}
		model.addAttribute("signinForm", new UserEntity());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("signinForm") UserEntity userEntity, BindingResult bindingResult) {

		// model attribute gets details from sign in form and stores in user entity
		// passing those values to logged user service
		String userRole = "";
		userService.loggedUser(userEntity);
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");

			PreparedStatement st = conn.prepareStatement(
					"Select user.category from user,loggeduser where loggeduser.email=user.email and loggeduser.password=user.password order by id desc limit 1");
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				userRole = rs.getString(1);
				System.out.println(userRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userRole.equals("User")) {
			return "redirect:/userdashboard";
		} else if (userRole.equals("ADMIN"))
			return "admindashboard";
		else if (userRole.equals("Category Rep")) {
			return "redirect:/categoryRepdashboard";
		}
		return "loginerror";

	}

	@GetMapping("/loginerror")
	public String errorMsg() {
		return "loginerror";
	}

	@PostMapping("/logout")
	public String logout() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");

			PreparedStatement st = conn.prepareStatement("delete from loggeduser");
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/login";
	}

	@GetMapping("resetPassword")
	public String reset(Model model) {
		model.addAttribute("user", new UserEntity());
		return "resetPassword";
	}

	@PostMapping("/resetPassword")
	public String newPass(@ModelAttribute("user") UserEntity user) {
		String q1 = user.getQ1();
		String q2 = user.getQ2();
		String q3 = user.getQ3();
		System.out.println(q1+q2+q3);
		String qa=null,qb=null,qc=null;
		Connection conn;
		ResultSet rs=null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");

			PreparedStatement st = conn.prepareStatement("select q1,q2,q3 from user where email=?");
			st.setString(1, user.getEmail());
			rs = st.executeQuery();
			while (rs.next()) {
				qa=rs.getString(1);
				qb=rs.getString(2);
				qc=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(qa+qb+qc);
		if(q1.equals(qa) && q2.equals(qb) && q3.equals(qc)) {

			userService.reset(user);
			return "redirect:/login";
		}
		return "resetFailure";
	}
}