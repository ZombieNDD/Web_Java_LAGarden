package com.LAGarden.Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;

public class HoaDon {

	public int getId() {
		return id;
	}
	public void setIdMA(int id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getNameRecieve() {
		return NameRecieve;
	}
	public void setNameRecieve(String NameRecieve) {
		this.NameRecieve = NameRecieve;
	}
	
	public String getAddressRecive() {
		return AddressRecive;
	}
	public void setAddressRecive(String AddressRecive) {
		this.AddressRecive =AddressRecive;
	}
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getEmailRecieve() {
		return EmailRecieve;
	}
	public void setEmailRecieve(String EmailRecieve) {
		this.EmailRecieve = EmailRecieve;
	}
	
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date NgayLap) {
		this.NgayLap = NgayLap;		
	}
	public BigDecimal getTongTien() {
		return TongTien;
	}
	public void setTongTien (BigDecimal TongTien) {
		this.TongTien = TongTien;
	}
	
	public int id;
	public String username;
	public String NameRecieve;
	public String AddressRecive;
	public String Phone;
	public String EmailRecieve;
	public Date NgayLap;
	public BigDecimal TongTien;
}
