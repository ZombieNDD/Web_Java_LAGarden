package com.LAGarden.Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LAGarden.Common.Encryption;
import com.LAGarden.DAO.CTMonAnDAO;
import com.LAGarden.DAO.DanhMucDAO;
import com.LAGarden.DAO.HoTroDAO;
import com.LAGarden.DAO.ImageDatBanDAO;
import com.LAGarden.DAO.TableDAO;
import com.LAGarden.DAO.UserDAO;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.CartItem;
import com.LAGarden.Model.DangKy;
import com.LAGarden.Model.HoTro;
import com.LAGarden.Model.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.nimbusds.jose.shaded.json.JSONObject;

@Controller
public class WebsiteController {

	HttpSession session = null;
	DangKy sessionUser = new DangKy();
	List<CartItem> sessionCart = null;
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
	public String viewProduct(ModelMap model, @PathVariable("tensp") String tensp, @PathVariable("idsp") int idsp) throws ClassNotFoundException, SQLException{
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
		this.sessionUser = dk;
		
		if (dk.roles==0) {
		session = request.getSession();

		if (dk !=null) {
			session.setAttribute("taikhoan", dk);
			session.setAttribute("Fullname", dk.fullname);
			return "home";
		}
		}
		model.addAttribute("message","Sai tên tài khoản hoặc mật khẩu!");
		return "dangnhap";
	}
	@PostMapping("/registerDatBan")
	public String formDatBan(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws ParseException, IOException, ClassNotFoundException, SQLException {
		Table tb = new Table();
		Map<String,Object> map = new HashMap<String, Object>();
		boolean status = false;
		String message = null;
		if (session != null)
		{
			tb.FullName = sessionUser.fullname;
			tb.Phone = sessionUser.phone;
			tb.Email = sessionUser.email;
			String sDate1 = request.getParameter("date");
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
			tb.NgayDB = date1;
			DateFormat dateFormat = new SimpleDateFormat("hh:mm");
			Date date =dateFormat.parse(request.getParameter("time"));
			Time time = new Time(date.getTime());
			tb.GioDB =time;
			tb.SLNguoiLon = request.getParameter("slnl");
			tb.SLTreEm = request.getParameter("slte");
			tb.GhiChu = request.getParameter("ghichu");
			
			TableDAO dao = new TableDAO();
			int i = dao.addItem(tb, sessionUser.username);
			if (i>0) {
				status = true;
			}else {
				message = "Đăng ký thất bại, vui lòng thử lại sau";
			}
		}
		else {
			status = false;
			message = "Vui lòng đăng nhập";
		}
		map.put("status",status);
		map.put("message",message);
		write(respone,map);
		return null;
	}
	
	
	@PostMapping("/formhotro")
	public void FormHoTro(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws IOException, ClassNotFoundException, SQLException {
		HoTro hotro = new HoTro();
		HoTroDAO dao = new HoTroDAO();
		Map<String,Object> map = new HashMap<String, Object>();
		boolean status = false;
		String message = null;
		if (session != null)
		{
			hotro.TenKH = request.getParameter("name");
			hotro.Email = request.getParameter("email");
			hotro.ChiTiet = request.getParameter("content");
			if (hotro.ChiTiet=="" || hotro.TenKH==""||hotro.Email=="") {
				status = false;
				message = "Thiếu thông tin, vui lòng điền đầy đủ";
			}else {
				int i = dao.formHoTro(hotro);
				if (i>0) {
					status = true;
				}else {
					message = "Đăng ký thất bại, vui lòng thử lại sau";
				}
			}
			
		}
		else {
			status = false;
			message = "Vui lòng đăng nhập";
		}
		map.put("status",status);
		map.put("message",message);
		write(respone,map);
	}
	//=======================================THANH TOÁN============================================//
	@RequestMapping(value="/them-gio-hang-{idma}",method = RequestMethod.GET)
	 public String AddItem(ModelMap model,HttpServletRequest request,HttpServletResponse respone,@PathVariable("idma") int idma) throws ClassNotFoundException, SQLException {
		if (session == null) {
			return "dangnhap";
		}
		int quantity = 1;
		List<CartItem> list;
		CTMonAn ctma = new CTMonAnDAO().chiTietMonAn(idma);
		List<CartItem> sessionCart = (List<CartItem>) session.getAttribute("GioHang");
		if (sessionCart!=null) {
			list = (List<CartItem>)sessionCart;
			boolean check = checkContains(list,ctma);
            if (check)
            {
                for (CartItem item : list)
                {
                    if (item.ctMA.idMA == idma)
                    {
                        item.quantity += quantity;
                    }
                }
            }
            else
            {
            	CartItem item = new CartItem();
                item.ctMA = ctma;
                item.quantity = quantity;
                list.add(item);
            }
            session.setAttribute("GioHang",list);
        }
        else
        {
            //tạo mới
        	CartItem item = new CartItem();
            item.ctMA = ctma;
            item.quantity = quantity;
            list = new ArrayList<CartItem>();
            list.add(item);
            //gán
            session.setAttribute("GioHang",list);
        }
		model.addAttribute("listGioHang",list);
		System.out.println(list);
		return "giohang";
	}
	@PostMapping("/capnhat")
    public void Update(ModelMap model,HttpServletRequest request,HttpServletResponse respone,String cartModel) throws IOException
    {
    	ObjectMapper mapper = new ObjectMapper();
    	List<CartItem> jsonCart = mapper.readValue(cartModel, new TypeReference<List<CartItem>>(){});
        sessionCart = (List<CartItem>) session.getAttribute("GioHang");
        Map<String,Object> map = new HashMap<String, Object>();
        for (CartItem item : sessionCart)
        {
        	CartItem jsonItem = getItem(jsonCart,item.ctMA.idMA);
            if (jsonItem != null)
            {
                item.quantity = jsonItem.quantity;
            }
        }
        session.setAttribute("GioHang",sessionCart);

        boolean status = true;
        map.put("status",status);
        write(respone,map);
    }
	@PostMapping("/deleteall")
    public void DeleteAll(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws IOException
    {
		Map<String,Object> map = new HashMap<String, Object>();
		session.setAttribute("GioHang",null);
		boolean status = true;
        map.put("status", status);
        write(respone,map);
    }
	@PostMapping("/delete")
    public void Delete(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws IOException
    {
		int id =  Integer.parseInt( request.getParameter("id"));
		boolean status = false;
		Map<String,Object> map = new HashMap<String, Object>();
        List<CartItem> sessionCart = (List<CartItem>) session.getAttribute("GioHang");
        
        CartItem item = getItem(sessionCart, id);
        sessionCart.remove(item);
        session.setAttribute("GioHang",sessionCart);
        status = true;
        map.put("status", status);
        write(respone,map);
        
    }
	@RequestMapping("/giohang")
	public String giohang(ModelMap model,HttpServletRequest request,HttpServletResponse respone) {
		List<CartItem> sessionCart = (List<CartItem>) session.getAttribute("GioHang");
		model.addAttribute("listGioHang",sessionCart);
		return "giohang";
	}
    //============================== KHÁC ================================//
	private void write(HttpServletResponse respone, Map<String, Object> map) throws IOException {
		respone.setContentType("application/json");
		respone.setCharacterEncoding("UTF-8");
		respone.getWriter().write(new Gson().toJson(map));
	}
	private boolean checkContains(List<CartItem> list,CTMonAn cart) {
		for(CartItem item: list) {
			if (item.ctMA.idMA == cart.idMA) return true;
		}
		return false;
	}
	
	private CartItem getItem(List<CartItem> list,int id) {
		for(CartItem item: list) {
			if (item.ctMA.idMA ==id) return item;
		}
		return null;
	}
	
	
}
	
