package com.LAGarden.Model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Table {
	public Date getNgayDB() {
		return NgayDB;
	}
	public void setNgayDB(Date ngayDB) {
		NgayDB = ngayDB;
	}
	public Time getGioDB() {
		return GioDB;
	}
	public void setGioDB(Time gioDB) {
		GioDB = gioDB;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getSLNguoiLon() {
		return SLNguoiLon;
	}
	public void setSLNguoiLon(String sLNguoiLon) {
		SLNguoiLon = sLNguoiLon;
	}
	public String getSLTreEm() {
		return SLTreEm;
	}
	public void setSLTreEm(String sLTreEm) {
		SLTreEm = sLTreEm;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date NgayDB;
	public Time GioDB;
	public String FullName;
	public String Email;
	public String Phone;
	public String SLNguoiLon;
	public String SLTreEm;
	public String GhiChu;
	public String username;
}
