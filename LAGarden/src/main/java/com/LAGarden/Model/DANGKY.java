package com.LAGarden.Model;

import java.util.Date;

public class DANGKY {
	private String TenDangNhap;
	private String MatKhau;
	private String EmailDK;
	private String DiaChiDK;
	private String TenDayDu;
	private String CauHoiBaoMat;
	private Date NgaySinh;
	private String GioiTinhDK;
	private int MaQuyen;
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tendangnhap) {
		TenDangNhap = tendangnhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matkhau) {
		MatKhau = matkhau;
	}
	public String getEmailDK() {
		return EmailDK;
	}
	public void setEmailDK(String emailDK) {
		EmailDK = emailDK;
	}
	public String getDiaChiDK() {
		return DiaChiDK;
	}
	public void setDiaChiDK(String diachiDK) {
		DiaChiDK = diachiDK;
	}
	public String getTenDayDu() {
		return TenDayDu;
	}
	public void setTenDayDu(String tendaydu) {
		TenDayDu = tendaydu;
	}
	public String getCauHoiBaoMat() {
		return CauHoiBaoMat;
	}
	public void setCauHoiBaoMat(String cauhoibaomat) {
		CauHoiBaoMat = cauhoibaomat ;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaysinh) {
		NgaySinh = ngaysinh;
	}
	public String getGioiTinhDK() {
		return GioiTinhDK;
	}
	public void setGioiTinhDK(String gioitinhDK) {
		GioiTinhDK = gioitinhDK;
	}
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maquyen) {
		MaQuyen = maquyen;
	}
	public DANGKY(String TenDangNhap, String MatKhau, String EmailDK, String DiaChiDK, String TenDayDu, String CauHoiBaoMat, Date NgaySinh, String GioiTinhDK, int MaQuyen) {
	        this.TenDangNhap = TenDangNhap;
	        this.MatKhau = MatKhau;
	        this.EmailDK = EmailDK;
	        this.DiaChiDK = DiaChiDK;
	        this.TenDayDu = TenDayDu;
	        this.CauHoiBaoMat = CauHoiBaoMat;
	        this.NgaySinh = NgaySinh;
	        this.GioiTinhDK = GioiTinhDK;
	        this.MaQuyen = MaQuyen;
	    }
	public DANGKY(){}
}
