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
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DangKy;
import com.LAGarden.Model.DanhMuc;
import com.LAGarden.Model.HoTro;
import com.LAGarden.Model.HoaDon;
import com.LAGarden.Model.Table;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@RequestMapping(value = "/")
	public String adminform(ModelMap model) {
		return "admin";
	}

	@RequestMapping("/adminDashBoard")
	public String adminDashBoard(ModelMap model, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {

		Encryption mahoa = new Encryption();
		String username = request.getParameter("id");
		String password = mahoa.EncryptMD5(request.getParameter("password"));
		UserDAO dao = new UserDAO();
		DangKy dk = new DangKy();
		dk = dao.Login(username, password);
		HttpSession session = request.getSession();

		if (dk != null) {
			session.setAttribute("Fullname", dk.fullname);
			return "adminDashBoard";
		}
		return "admin";
	}

	@RequestMapping("/adminDanhMuc")
	public String adminDanhMuc(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		DanhMucDAO listDanhMuc = new DanhMucDAO();
		model.addAttribute("listDanhMuc", listDanhMuc.getListDanhMuc());
		return "adminDanhMuc";
	}

	@RequestMapping("/adminMonAn")
	public String adminMonAn(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		CTMonAnDAO listMonAn = new CTMonAnDAO();
		model.addAttribute("listMonAn", listMonAn.getListCTMonAN());
		return "adminMonAn";
	}

	@RequestMapping("/adminDatBan")
	public String adminDatBan(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		TableDAO listTable = new TableDAO();
		// model.addAttribute("listTable",listTable.getListTable());
		// call data k dc? do nhieu qua nen no tran`?
		return "adminDatBan";
	}

	@RequestMapping("/adminHoaDon")
	public String adminHoaDon(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HoaDonDAO listHoaDon = new HoaDonDAO();
		// model.addAttribute("listHoaDon",listHoaDon.getListHoaDon());
		return "adminHoaDon";
	}

	@RequestMapping("/adminHoTro")
	public String adminHoTro(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HoTroDAO listHoTro = new HoTroDAO();
		// model.addAttribute("listHoTro",listHoTro.getListHoTro());
		return "adminHoTro";
	}

	@RequestMapping("/adminTaiKhoan")
	public String adminTaiKhoan(ModelMap model, HttpServletRequest request)
			throws ClassNotFoundException, SQLException {
		UserDAO listUser = new UserDAO();
		model.addAttribute("listUser", listUser.getListUser());
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
	@RequestMapping("/CreateDanhMucSuccess")
	public String DanhMucCreate2(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
					
		DanhMuc dk = new DanhMuc();					
		if (request.getParameter("input1")==""||
			request.getParameter("input2")==""||
			request.getParameter("input3")==""||
			request.getParameter("input4")=="")
				{
			model.addAttribute("thongbao","Vui lòng nhập đầy đủ thông tin!");
			return "adminDanhMucCreate";
				}
		dk.danhMucID = Integer.parseInt(request.getParameter("input1"));
		dk.danhMucName = request.getParameter("input2");
		dk.thuTu = Integer.parseInt(request.getParameter("input3"));
		dk.tags = request.getParameter("input4");		
		DanhMucDAO danhmuc = new DanhMucDAO();
		danhmuc.ADD(dk);
		model.addAttribute("thongbao2","Thêm thành công!");
		return "adminDanhMucCreate";
	}

	
	
	
	
	@RequestMapping("/CreateMonAn")
	public String MonAnCreate(ModelMap model, HttpServletRequest request) {
		return "adminMonAnCreate";
	}
	@RequestMapping("/CreateMonAnSuccess")
	public String MonAnCreate2(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		CTMonAn dk = new CTMonAn();			
		if (request.getParameter("input1")==""||
			request.getParameter("input2")==""||
			request.getParameter("input3")==""||
			request.getParameter("input4")==""||
			request.getParameter("input5")==""||
			request.getParameter("input6")==""||
			request.getParameter("input7")==""||
			request.getParameter("input8")==""||
			request.getParameter("input9")=="")
				{
			model.addAttribute("thongbao","Vui lòng nhập đầy đủ thông tin!");
			return "adminMonAnCreate";
				}		
		dk.danhMucID = Integer.parseInt(request.getParameter("input1"));
		dk.tenMonAn = request.getParameter("input2");
		dk.soLuong = Integer.parseInt(request.getParameter("input3"));
		dk.chiTietMA = request.getParameter("input4");
		dk.gia = Double.parseDouble(request.getParameter("input5"));
		dk.giaSale = Double.parseDouble(request.getParameter("input6"));
		dk.imgMA = request.getParameter("input7");
		dk.slug = request.getParameter("input8");
		dk.title = request.getParameter("input9");		
		CTMonAnDAO monan = new CTMonAnDAO();
		monan.ADD(dk);
		model.addAttribute("thongbao2","Thêm thành công!");
		return "adminMonAnCreate";
	}

	
	
	
	
	
	@RequestMapping("/CreateTaiKhoan")
	public String TaiKhoanCreate(ModelMap model, HttpServletRequest request) {
		return "adminTaiKhoanCreate";
	}
	@RequestMapping("/CreateTaiKhoanSuccess")
	public String taiKhoanCreate2(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {

		DangKy dk = new DangKy();		
		Encryption mahoa = new Encryption();
		
		if (request.getParameter("input1")==""||
				request.getParameter("input2")==""||
				request.getParameter("input3")==""||
				request.getParameter("input4")==""||
				request.getParameter("input5")==""||
				request.getParameter("input6")==""||
				request.getParameter("input7")=="")
					{
				model.addAttribute("thongbao","Vui lòng nhập đầy đủ thông tin!");
				return "adminTaiKhoanCreate";
					}						
		dk.fullname = request.getParameter("input1");
		dk.username = request.getParameter("input2");
		dk.password = mahoa.EncryptMD5(request.getParameter("input3"));
		dk.email = request.getParameter("input4");
		dk.phone = request.getParameter("input5");
		dk.address = request.getParameter("input6");
		dk.roles = Integer.parseInt(request.getParameter("input7"));
		
		UserDAO user = new UserDAO();
		user.Register(dk);		
		
		model.addAttribute("thongbao2","Thêm thành công!");
		return "adminTaiKhoanCreate";
	}
	
	/* ========================Xoa DashBoard=============================== */
	
	@RequestMapping("adminDeleteDanhMuc")
	public String DanhMucDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		DanhMuc dk = new DanhMuc();			
		dk.danhMucID = Integer.parseInt(request.getParameter("dele"));			
		DanhMucDAO danhmuc = new DanhMucDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		DanhMucDAO listDanhMuc = new DanhMucDAO();
		model.addAttribute("listDanhMuc", listDanhMuc.getListDanhMuc());
		return "adminDanhMuc";
	}
	
	@RequestMapping("adminDeleteMonAn")
	public String MonAnDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		CTMonAn dk = new CTMonAn();			
		dk.danhMucID = Integer.parseInt(request.getParameter("dele"));			
		CTMonAnDAO danhmuc = new CTMonAnDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		CTMonAnDAO listMonAn = new CTMonAnDAO();
		model.addAttribute("listMonAn", listMonAn.getListCTMonAN());
		return "adminMonAn";
	}
	
	@RequestMapping("adminDeleteTaiKhoan")
	public String TKDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		DangKy dk = new DangKy();			
		dk.username = request.getParameter("dele").toString().trim();			
		UserDAO danhmuc = new UserDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		UserDAO listUser = new UserDAO();
		model.addAttribute("listUser", listUser.getListUser());
		return "adminTaiKhoan";
		
	}
	
	@RequestMapping("adminDeleteDatBan")
	public String DatBanDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		Table dk = new Table();			
		dk.Phone = request.getParameter("dele").toString().trim();			
		TableDAO danhmuc = new TableDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		
		TableDAO listTable = new TableDAO();
		// model.addAttribute("listTable",listTable.getListTable());
		// call data k dc? do nhieu qua nen no tran`?
		return "adminDatBan";
	}
	
	@RequestMapping("adminDeleteHoaDon")
	public String HoaDonDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		HoaDon dk = new HoaDon();			
		dk.Phone = request.getParameter("dele").toString().trim();			
		HoaDonDAO danhmuc = new HoaDonDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		HoaDonDAO listHoaDon = new HoaDonDAO();
		// model.addAttribute("listHoaDon",listHoaDon.getListHoaDon());
		return "adminHoaDon";
	}
	
	@RequestMapping("adminDeleteHoTro")
	public String HoTroDelete(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			
		HoTro dk = new HoTro();			
		dk.Email = request.getParameter("dele").toString().trim();			
		HoTroDAO danhmuc = new HoTroDAO();
		danhmuc.DELETE(dk);		
		
		model.addAttribute("thongbao3","Xóa thành công!");

		HoTroDAO listHoTro = new HoTroDAO();
		// model.addAttribute("listHoTro",listHoTro.getListHoTro());
		return "adminHoTro";		
	}

}
