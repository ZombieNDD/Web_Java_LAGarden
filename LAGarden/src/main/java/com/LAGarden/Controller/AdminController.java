package com.LAGarden.Controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LAGarden.Common.Encryption;
import com.LAGarden.DAO.CTMonAnDAO;
import com.LAGarden.DAO.DanhMucDAO;
import com.LAGarden.DAO.HoTroDAO;
import com.LAGarden.DAO.HoaDonDAO;
import com.LAGarden.DAO.TableDAO;
import com.LAGarden.DAO.UserDAO;
import com.LAGarden.Model.DangKy;


@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@RequestMapping(value="/")
	public String adminform(ModelMap model) {
		return "admin";
	}	
	
	@RequestMapping("/adminDashBoard")
	public String adminDashBoard(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		
		Encryption mahoa = new Encryption();
		String username = request.getParameter("id");
		String password = mahoa.EncryptMD5(request.getParameter("password"));
		UserDAO dao = new UserDAO();
		DangKy dk =new DangKy();
		dk= dao.Login(username, password);
		HttpSession session = request.getSession();
		
		if (dk !=null) {
			session.setAttribute("Fullname", dk.fullname);
			return "adminDashBoard";
		}
		return "admin";
	}
	
	@RequestMapping("/adminDanhMuc")
	public String adminDanhMuc(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		DanhMucDAO listDanhMuc = new DanhMucDAO();		
		model.addAttribute("listDanhMuc",listDanhMuc.getListDanhMuc());
		return "adminDanhMuc";
	}		
	
	@RequestMapping("/adminMonAn")
	public String adminMonAn(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		CTMonAnDAO listMonAn = new CTMonAnDAO();		
		model.addAttribute("listMonAn",listMonAn.getListCTMonAN());
		return "adminMonAn";
	}
	
	@RequestMapping("/adminDatBan")
	public String adminDatBan(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		TableDAO listTable = new TableDAO();		
		//model.addAttribute("listTable",listTable.getListTable());
		//call data k dc? do nhieu qua nen no tran`?
		return "adminDatBan";
	}
	
	@RequestMapping("/adminHoaDon")
	public String adminHoaDon(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HoaDonDAO listHoaDon = new HoaDonDAO();		
		//model.addAttribute("listHoaDon",listHoaDon.getListHoaDon());			
		return "adminHoaDon";
	}
	
	@RequestMapping("/adminHoTro")
	public String adminHoTro(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HoTroDAO listHoTro = new HoTroDAO();		
		//model.addAttribute("listHoTro",listHoTro.getListHoTro());
		return "adminHoTro";
	}
	@RequestMapping("/adminTaiKhoan")
	public String adminTaiKhoan(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		UserDAO listUser = new UserDAO();		
		model.addAttribute("listUser",listUser.getListUser());	
		return "adminTaiKhoan";
	}
	
	@RequestMapping("/adminHinhAnh")
	public String adminHinhAnh(ModelMap model, HttpServletRequest request) {

		return "adminHinhAnh";
	}
	
	@RequestMapping("/adminExit")
	public String adminExit(ModelMap model, HttpServletRequest request) {

		return "admin";
	}
	
	
	
	
	/* ========================Them DashBoard=============================== */
	@RequestMapping("/CreateDanhMuc")
	public String DanhMucCreate(ModelMap model, HttpServletRequest request) {

		return "adminDanhMucCreate";
	}
	
	@RequestMapping("/CreateMonAn")
	public String MonAnCreate(ModelMap model, HttpServletRequest request) {

		return "adminMonAnCreate";
	}
	
	@RequestMapping("/CreateTaiKhoan")
	public String TaiKhoanCreate(ModelMap model, HttpServletRequest request) {

		return "adminTaiKhoanCreate";
	}
	
}
