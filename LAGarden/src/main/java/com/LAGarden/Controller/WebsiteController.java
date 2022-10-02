package com.LAGarden.Controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LAGarden.Common.Encryption;
import com.LAGarden.DAO.CTMonAnDAO;
import com.LAGarden.DAO.DanhMucDAO;
import com.LAGarden.DAO.ImageDatBanDAO;
import com.LAGarden.DAO.UserDAO;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DangKy;
@Controller
public class WebsiteController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}
	@RequestMapping("/tintuc")
    public String tintuc(ModelMap model)
    {
        return "tintuc";
    }
	@RequestMapping("/hotro")
    public String hotro(ModelMap model)
    {
        return "hotro";
    }
	@RequestMapping("/thongtin")
    public String thongtin(ModelMap model)
    {
        return "thongtin";
    }
	@RequestMapping("/datban")
    public String datban(ModelMap model) throws SQLException, ClassNotFoundException
    {
		ImageDatBanDAO list = new ImageDatBanDAO();
		model.addAttribute("list",list.getList());
        return "datban";
    }
	@RequestMapping("/datmon")
	public String datmon(ModelMap model) throws ClassNotFoundException, SQLException {
		DanhMucDAO listDanhMuc = new DanhMucDAO();
		CTMonAnDAO listDSMonAn = new CTMonAnDAO();
		model.addAttribute("listDanhMuc",listDanhMuc.getListDanhMuc());
		model.addAttribute("listMonAn",listDSMonAn.getListCTMonAN());
		return "datmon";
	}
	@RequestMapping(value = "/sanpham-{tensp}-{idsp}",method = RequestMethod.GET)
	public String viewProduct(ModelMap model, @PathVariable("tensp") String tensp, @PathVariable("idsp") String idsp) throws ClassNotFoundException, SQLException{
		DanhMucDAO listDanhMuc = new DanhMucDAO();
		model.addAttribute("listDanhMuc",listDanhMuc.getListDanhMuc());
		CTMonAnDAO ct = new CTMonAnDAO();
		CTMonAn monAn = ct.chiTietMonAn(idsp);
		model.addAttribute("monAn",monAn);
		return "chitietsp";
	}
	@RequestMapping(value = "/danhmuc-{tenDanhMuc}-{danhMucID}",method = RequestMethod.GET)
	public String listDanhMuc(ModelMap model, @PathVariable("tenDanhMuc") String tenDanhMuc, @PathVariable("danhMucID") String danhMucID) throws ClassNotFoundException, SQLException{
		DanhMucDAO list = new DanhMucDAO();
		CTMonAnDAO listMonAn = new  CTMonAnDAO();
		model.addAttribute("listDanhMuc",list.getListDanhMuc());
		model.addAttribute("listMonAn",listMonAn.getListByDanhMuc(danhMucID));
		return "datmon";
	}
	
	@RequestMapping("/dangky")
    public String dangky(ModelMap model) 
    {
        return "dangky";
    }
	@PostMapping("/saveSignUpForm")
	public String saveUser(ModelMap model,HttpServletRequest request) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Date date = new Date();
		DangKy dk = new DangKy();
		Encryption mahoa = new Encryption();
		dk.username = request.getParameter("UserName");
		dk.password = mahoa.EncryptMD5(request.getParameter("Password"));
		
		String repeatPass = request.getParameter("ConfirmPassword");
		if (!dk.password.equals(repeatPass)) {
			model.addAttribute("Thông báo","Mật khẩu lặp lại bị sai!");
			return "dangky";
		}
		dk.fullname = request.getParameter("Name");
		dk.address = request.getParameter("Address");
		dk.email = request.getParameter("Email");
		dk.phone = request.getParameter("Phone");
		dk.createAt = date;
		UserDAO user = new UserDAO();
		user.Register(dk);
		
		return "dangky";
	}
	@RequestMapping("/dangnhap")
	public String dangnhap(ModelMap model) {
		return "dangnhap";
	}
	@PostMapping("/loginuser")
	public String login(ModelMap model,HttpServletRequest request) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Encryption mahoa = new Encryption();
		String username = request.getParameter("username");
		String password = mahoa.EncryptMD5(request.getParameter("password"));
		UserDAO dao = new UserDAO();
		DangKy dk =new DangKy();
		dk= dao.Login(username, password);
		HttpSession session = request.getSession();
		
		if (dk !=null) {
			session.setAttribute("Fullname", dk.fullname);
			return "home";
		}
		return "false";
	}
}
	

