package com.LAGarden.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LAGarden.DAO.CTMonAnDAO;
import com.LAGarden.DAO.DanhMucDAO;
import com.LAGarden.DAO.ImageDatBanDAO;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DANGKY;
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
}
	
