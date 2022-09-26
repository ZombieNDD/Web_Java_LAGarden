package com.LAGarden.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LAGarden.DAO.CTMonAnDAO;
import com.LAGarden.DAO.DanhMucDAO;
import com.LAGarden.DAO.ImageDatBanDAO;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@RequestMapping(value="/")
	public String adminform(ModelMap model) {
		return "admin";
	}
	
	
	@RequestMapping("/adminDashBoard")
	public String adminDashBoard(ModelMap model, HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("password");
//
//		if (id.equals("hutech") && pw.equals("123")) {
//			return "adminedit";
//		}
		return "adminDashBoard";
	}
	@RequestMapping("/adminDanhMuc")
	public String adminDanhMuc(ModelMap model, HttpServletRequest request) {

		return "adminDanhMuc";
	}
}
