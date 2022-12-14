package com.LAGarden.Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


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
	public void datmon(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws ClassNotFoundException, SQLException, IOException {
		respone.sendRedirect("datmon-1");
		
	}
	// ==========================PH??N TRANG========================//
	@RequestMapping(value = "/datmon-{page}",method = RequestMethod.GET)
	public String datmonPhanTrang(ModelMap model, @PathVariable("page") int page) throws ClassNotFoundException, SQLException {
		
		DanhMucDAO listDanhMuc = new DanhMucDAO();
		CTMonAnDAO listDSMonAn = new CTMonAnDAO();
		int totalRecord = listDSMonAn.getListCount();
		// S??? l?????ng s??? trang trong 1 trang web
		int maxPage = 5;
		int totalPage = 0;
		// S??? l?????ng item trong 1 trang web
		int pageSize =3;
		double pagesize = pageSize;
		totalPage = (int) Math.ceil(totalRecord/pagesize);
		
		model.addAttribute("url","datmon");
		model.addAttribute("page",page);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("first",1);
		model.addAttribute("last",totalPage);
		model.addAttribute("next",page+1);
		model.addAttribute("prev",page-1);
		model.addAttribute("listMonAn",listDSMonAn.getListPhanTrang(page+pageSize, pageSize));
		model.addAttribute("listDanhMuc",listDanhMuc.getListDanhMuc());

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
	//================================PH??N TRANG===============================//
	@RequestMapping(value = "/danhmuc-{tenDanhMuc}-{danhMucID}-{page}",method = RequestMethod.GET)	
	public String listDanhMucPhanTrang(ModelMap model, @PathVariable("tenDanhMuc") String tenDanhMuc, @PathVariable("danhMucID") String danhMucID,@PathVariable("page") int page) throws ClassNotFoundException, SQLException{
		DanhMucDAO list = new DanhMucDAO();
		CTMonAnDAO listMonAn = new CTMonAnDAO();
		int totalRecord = listMonAn.getListCountDanhMuc(danhMucID);
		// S??? l?????ng s??? trang trong 1 trang web
		int maxPage = 5;
		int totalPage = 0;
		// S??? l?????ng item trong 1 trang web
		int pageSize =3;
		double pagesize = pageSize;
		totalPage = (int) Math.ceil(totalRecord/pagesize);
		String url = "danhmuc-"+tenDanhMuc+"-"+danhMucID;
		model.addAttribute("url",url);
		model.addAttribute("page",page);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("first",1);
		model.addAttribute("last",totalPage);
		model.addAttribute("next",page+1);
		model.addAttribute("prev",page-1);
		model.addAttribute("listDanhMuc",list.getListDanhMuc());
		model.addAttribute("listMonAn",listMonAn.getListByDanhMucPhanTrang(danhMucID,(page-1)*pageSize, pageSize));
		return "datmon";
	}
	
	@RequestMapping("/dangky")
    public String dangky(ModelMap model) 
    {
        return "dangky";
    }
	@PostMapping("/saveSignUpForm")
	public String saveUser(ModelMap model,HttpServletRequest request) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		List<String> message = new ArrayList<String>();
		Date date = new Date();
		DangKy dk = new DangKy();
		UserDAO user = new UserDAO();
		try {
		boolean check = true;
		Encryption mahoa = new Encryption();
		if (user.Check(request.getParameter("UserName"))>0){
			message.add("B??? tr??ng t??n t??i kho???n");
		}else {
			dk.username = request.getParameter("UserName");
		}	
		if (countString(request.getParameter("Password"))<7) {
			message.add("M???t kh???u ph???i >6 k?? t???");
			check=false;
		}else {
			dk.password = mahoa.EncryptMD5(request.getParameter("Password"));
		}
		try {
			 Double.parseDouble(request.getParameter("Phone"));
		}catch (Exception e) {
			check = false;
			message.add("Vui l??ng ??i???n ????ng s??? ??i???n tho???i!");
		}
		String s = request.getParameter("Phone").trim();
		if (s.length()!=11) {
			message.add("S??? ??i???n tho???i ph???i l?? 11 k?? t???");
			check=false;
		}
		
		if (s.charAt(0)!='0') {
			message.add("S??? ??i???n tho???i ph???i b???t ?????u l?? 0");
			check=false;
			
		}
		String repeatPass = request.getParameter("ConfirmPassword");
		if (!dk.password.equals(mahoa.EncryptMD5(repeatPass))) {
			message.add("M???t kh???u l???p l???i b??? sai!");
			check = false;
		}
		
		if(request.getParameter("Address")==""||
				request.getParameter("Name")==""||
				request.getParameter("Address")==""||
				request.getParameter("email")==""||
				request.getParameter("Phone")==""||
				request.getParameter("UserName")==""||
				request.getParameter("Password")==""||
				request.getParameter("ConfirmPassword")=="")
		{
			check = false;
			message.add("Vui l??ng ??i???n ?????y ????? th??ng tin");
		}
		if (check==true) {
		dk.fullname = request.getParameter("Name");
		dk.address = request.getParameter("Address");
		dk.email = request.getParameter("email");
		dk.phone = request.getParameter("Phone");
		dk.roles = 0;
		
		int i = user.Register(dk);
		if (i<0) {
			message.add("????ng k?? th???t b???i!");
		}else {
			message.add("????ng k?? th??nh c??ng!");
		}
		}
		} catch (Exception e) {
			message.add("L???i d??? li???u, kh??ng th??? ????ng k??!");
		}
		model.addAttribute("message",message);
		return "dangky";
	}
	public int countString(String s) {
        int count = 0;    
        for(int i = 0; i < s.length(); i++) {    
            if(s.charAt(i) != ' ')    
                count++;    
        }
        return count;
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
		if (dk==null) {
			model.addAttribute("message","????ng nh???p kh??ng th??nh c??ng");
			return "dangnhap";
		}
		if (dk.roles==0) {
		session = request.getSession();

		if (dk !=null) {
			session.setAttribute("taikhoan", dk);
			session.setAttribute("Fullname", dk.fullname);
			return "home";
		}
		}
		model.addAttribute("message","Sai t??n t??i kho???n ho???c m???t kh???u!");
		return "dangnhap";
	}
	
	
	@PostMapping("/registerDatBan")
	public String formDatBan(ModelMap model,HttpServletRequest request,HttpServletResponse respone) throws ParseException, IOException, ClassNotFoundException, SQLException {
		Table tb = new Table();
		Map<String,Object> map = new HashMap<String, Object>();
		boolean status = false;
		String message = null;
		List<String> listMess = new ArrayList<String>();
		boolean check = true;

		try {
		if (session != null)
		{
			if (request.getParameter("name") != "") {
				tb.fullName = request.getParameter("name");

			}else {
				tb.fullName = sessionUser.fullname;
			}
			String s = request.getParameter("phone").trim();
			if (s != "") {
				tb.phone = s;
				try {
					 Double.parseDouble(request.getParameter("phone"));
				}catch (Exception e) {
					check = false;
					message = ("Vui l??ng ??i???n ????ng s??? ??i???n tho???i!\n");
					listMess.add(message);
				}
				if (s.length()!=11 && s.charAt(0)!='0') {
					check = false;
					message = "S??? ??i???n tho???i ph???i 11 s??? v?? b???t ?????u t??? s??? 0\n";
					listMess.add(message);
				}
			}else {
				tb.phone = sessionUser.phone;
			}
			if (request.getParameter("email") != "") {
				tb.email = request.getParameter("email");
				if (!(request.getParameter("email").contains("@"))){
					message = "Nh???p ????ng ?????nh d???ng email\n";
					listMess.add(message);
					check = false;
				}
			}else {
				tb.email = sessionUser.email;
			}
			LocalDateTime ldt = LocalDateTime.now();
			String dateNow = ldt.toString();
			String sDate1 = request.getParameter("date");
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
			Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(dateNow);  
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatDateTime = ldt.format(formatter);
			Date date3=new SimpleDateFormat("HH:mm:ss").parse(formatDateTime);
			DateFormat dateFormat = new SimpleDateFormat("hh:mm");
			Time timeNow = new Time(date3.getTime());
			//L???y d??? li???u t??? form
			Date date =dateFormat.parse(request.getParameter("time"));
			Time time = new Time(date.getTime());

			
			if (date1.compareTo(date2)<0) {
				check=false;
				message = "Ng??y ph???i l???n h??n ng??y hi???n t???i";
				listMess.add(message);
			}else {
				tb.ngayDB = date1.toString();
			}

			if (date1.compareTo(date2)==0 && time.compareTo(timeNow)<=0) {
				check=false;
				message = "Gi??? ph???i l???n h??n gi??? hi???n t???i";
				listMess.add(message);
			}else {
				tb.gioDB =time.toString();
			}
			if (check==true) {
			tb.sLNguoiLon = request.getParameter("slnl");
			tb.sLTreEm = request.getParameter("slte");
			tb.ghiChu = request.getParameter("ghichu");
			
			TableDAO dao = new TableDAO();
			int i = dao.addItem(tb, sessionUser.username);
			if (i>0) {
				status = true;
			}else {
				
				message = "????ng k?? th???t b???i, vui l??ng th??? l???i sau\n";
				listMess.add(message);
			}
			}
		}
		else {
			status = false;
			message = "Vui l??ng ????ng nh???p";
			listMess.add(message);
		}
		}catch (Exception e) {
			System.out.println(e);
			message = "????ng k?? th???t b???i, vui l??ng th??? l???i sau\n";
			listMess.add(message);
		}
		map.put("status",status);
		map.put("message",listMess);
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
		try {
		if (session != null)
		{
			hotro.tenKH = request.getParameter("name");
			hotro.email = request.getParameter("email");
			hotro.chiTiet = request.getParameter("content");
			if (hotro.chiTiet=="" || hotro.tenKH==""||hotro.email=="") {
				status = false;
				message = "Thi???u th??ng tin, vui l??ng ??i???n ?????y ?????";
			}else {
				int i = dao.formHoTro(hotro);
				if (i>0) {
					status = true;
				}else {
					message = "????ng k?? th???t b???i, vui l??ng th??? l???i sau";
				}
			}
			
		}
		else {
			status = false;
			message = "Vui l??ng ????ng nh???p";
		}
		}catch(Exception e){
			message = "????ng k?? th???t b???i, vui l??ng th??? l???i sau";
		}
		map.put("status",status);
		map.put("message",message);
		write(respone,map);
	}
	//=======================================THANH TO??N============================================//
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
            //t???o m???i
        	CartItem item = new CartItem();
            item.ctMA = ctma;
            item.quantity = quantity;
            list = new ArrayList<CartItem>();
            list.add(item);
            //g??n
            session.setAttribute("GioHang",list);
        }
		model.addAttribute("listGioHang",list);
		return "giohang";
	}
	@PostMapping("/capnhat")
    public void Update(ModelMap model,HttpServletRequest request,HttpServletResponse respone,String cartModel) throws IOException
    {
		ObjectMapper mapper = new ObjectMapper();
    Map<String,Object> map = new HashMap<String, Object>();
    String message = null;
    boolean status = false;
		try {
    	List<CartItem> jsonCart = mapper.readValue(cartModel, new TypeReference<List<CartItem>>(){});
        sessionCart = (List<CartItem>) session.getAttribute("GioHang");
        for (CartItem item : sessionCart)
        {
        	CartItem jsonItem = getItem(jsonCart,item.ctMA.idMA);
            if (jsonItem != null)
            {
            	if (jsonItem.quantity>0) {
            		item.quantity = jsonItem.quantity;
            		 status = true;
            	}
            	else {
            		  status = false;
            		  message = "Vui l??ng nh???p ????ng s??? l?????ng!!";
            	}
            }
        }
        session.setAttribute("GioHang",sessionCart);
		}catch (Exception e) {
			message = "Vui l??ng nh???p ????ng s??? l?????ng!!";
		}
		map.put("message",message);
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
	@RequestMapping("/logout")
	public String logout(ModelMap model,HttpServletRequest request,HttpServletResponse respone) {
		session.invalidate();
		sessionUser=null;
		return "dangnhap";
	}
	
	//============================== THANH TO??N ================================//
	@RequestMapping("/thanhtoan")
	public String thanhtoan(ModelMap model,HttpServletRequest request,HttpServletResponse respone) {
		sessionCart = (List<CartItem>) session.getAttribute("GioHang");
		model.addAttribute("listThanhToan",sessionCart);
        long tienInRa = 0;
        for (CartItem item : sessionCart)
        {
            tienInRa += item.ctMA.gia * item.quantity;
        }
        model.addAttribute("tongtien",tienInRa);

		return "thanhtoan";
	}
	@RequestMapping("/formThanhToan")
	public String formThanhtoan(ModelMap model,HttpServletRequest request,HttpServletResponse respone) {
		DangKy tk = (DangKy) session.getAttribute("taikhoan");
		List<CartItem> sessionCart = (List<CartItem>) session.getAttribute("GioHang");
		long TongTien = 0;
		String NameRecieve = request.getParameter("text1");
		String AddressRecive = request.getParameter("text2");
		String EmailRecieve = request.getParameter("text3");
		String PhoneRecive = request.getParameter("text4");
		
        for (CartItem item : sessionCart)
        {
            TongTien += item.ctMA.gia * item.quantity;
        }
//        if ( NameRecieve=="")
//        {
//            hoadon.NameRecieve = userTK.FullName;
//        }
//        else
//        {
//            hoadon.NameRecieve = thanhtoan.NameRecieve;
//        }
//        hoadon.TongTien = TongTien;
//        hoadon.username = userLogin.UserName;
//        if (AddressRecive=="")
//        {
//            hoadon.AddressRecive = userTK.Address;
//        }
//        else
//        {
//            hoadon.AddressRecive = thanhtoan.AddressRecive;
//        }
//        if (EmailRecieve=="")
//        {
//            hoadon.EmailRecieve = userTK.Email;
//        }
//        else
//        {
//            hoadon.EmailRecieve = thanhtoan.EmailRecieve;
//
//        }
//        if(PhoneRecive="")
//        {
//            hoadon.Phone = userTK.Phone;
//        }
//        else
//        {
//            hoadon.Phone = thanhtoan.PhoneRecive;
//        }
        model.addAttribute("listThanhToan",sessionCart);
        
        session.setAttribute("GioHang", null);
		return "thanhtoan";
	}
    //============================== KH??C ================================//
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
	
