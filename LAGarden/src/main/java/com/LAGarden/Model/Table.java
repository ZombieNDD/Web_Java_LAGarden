package com.LAGarden.Model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Table {

	public Date getNgayDB() {
		return ngayDB;
	}
	public void setNgayDB(Date ngayDB) {
		this.ngayDB = ngayDB;
	}
	public Time getGioDB() {
		return gioDB;
	}
	public void setGioDB(Time gioDB) {
		this.gioDB = gioDB;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getsLNguoiLon() {
		return sLNguoiLon;
	}
	public void setsLNguoiLon(String sLNguoiLon) {
		this.sLNguoiLon = sLNguoiLon;
	}
	public String getsLTreEm() {
		return sLTreEm;
	}
	public void setsLTreEm(String sLTreEm) {
		this.sLTreEm = sLTreEm;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date ngayDB;
	public Time gioDB;
	public String fullName;
	public String email;
	public String phone;
	public String sLNguoiLon;
	public String sLTreEm;
	public String ghiChu;
	public String username;
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
