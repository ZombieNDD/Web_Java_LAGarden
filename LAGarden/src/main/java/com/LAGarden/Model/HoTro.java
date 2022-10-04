package com.LAGarden.Model;

import java.util.BitSet;

public class HoTro {

	public int getID() {
		return ID;
	}
	public void setDID(int ID) {
		this.ID = ID;
	}
	
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String TenKH) {
		this.TenKH = TenKH;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getChiTiet() {
		return ChiTiet;
	}
	public void setChiTiet(String ChiTiet) {
		this.ChiTiet = ChiTiet;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int ID;
	public String TenKH;
	public String Email;
	public String ChiTiet;
	public boolean status;
}
