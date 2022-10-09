package com.LAGarden.Model;

import java.util.BitSet;

public class HoTro {

	public int getID() {
		return id;
	}
	public void setDID(int ID) {
		this.id = ID;
	}
	
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String TenKH) {
		this.tenKH = TenKH;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public String getChiTiet() {
		return chiTiet;
	}
	public void setChiTiet(String ChiTiet) {
		this.chiTiet = ChiTiet;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int id;
	public String tenKH;
	public String email;
	public String chiTiet;
	public boolean status;
}
