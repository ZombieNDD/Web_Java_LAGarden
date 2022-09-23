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

	
	
	
	
	
	@RequestMapping("/admin")
	public String admin(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("tendangnhap");
		String pw = request.getParameter("password");
		
		if (id.equals("hutech") && pw.equals("123")) {
			model.addAttribute("uid", id);
			model.addAttribute("pwd", pw);
			
			return "admin";
		}
		model.addAttribute("thongbao", "Sai thông tin đăng nhập!");
		return "admin";
	}
}
