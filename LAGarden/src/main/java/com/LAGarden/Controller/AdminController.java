package com.LAGarden.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Admin.DAO.AdminLoginDAO;


@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@RequestMapping(value="/")
	public String adminform(ModelMap model) {
		return "admin";
	}	
	
	@RequestMapping("/adminDashBoard")
	public String adminDashBoard(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		AdminLoginDAO listTK = new AdminLoginDAO();
		model.addAttribute("listTK",listTK.getListTaiKhoan());
		
		if (id.equals("") && pw.equals("123")) {
			return "adminDashBoard";
		}
		return "admin";
	}
	
	@RequestMapping("/adminDanhMuc")
	public String adminDanhMuc(ModelMap model, HttpServletRequest request) {

		return "adminDanhMuc";
	}	
	@RequestMapping("/adminMonAn")
	public String adminMonAn(ModelMap model, HttpServletRequest request) {

		return "adminMonAn";
	}
	@RequestMapping("/adminDatBan")
	public String adminDatBan(ModelMap model, HttpServletRequest request) {

		return "adminDatBan";
	}
	@RequestMapping("/adminHoTro")
	public String adminHoTro(ModelMap model, HttpServletRequest request) {

		return "adminHoTro";
	}
	@RequestMapping("/adminTaiKhoan")
	public String adminTaiKhoan(ModelMap model, HttpServletRequest request) {

		return "adminTaiKhoan";
	}
	@RequestMapping("/adminHinhAnh")
	public String adminHinhAnh(ModelMap model, HttpServletRequest request) {

		return "adminHinhAnh";
	}
	@RequestMapping("/adminHoaDon")
	public String adminHoaDon(ModelMap model, HttpServletRequest request) {

		return "adminHoaDon";
	}
	
}