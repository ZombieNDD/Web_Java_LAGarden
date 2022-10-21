package com.LAGarden.Model;

public class DanhMuc implements Comparable<DanhMuc>{

	public int getDanhMucID() {
		return danhMucID;
	}
	public void setDanhMucID(int danhMucID) {
		this.danhMucID = danhMucID;
	}
	public String getDanhMucName() {
		return danhMucName;
	}
	public void setDanhMucName(String danhMucName) {
		this.danhMucName = danhMucName;
	}
	public int getThuTu() {
		return thuTu;
	}
	public void setThuTu(int thuTu) {
		this.thuTu = thuTu;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int danhMucID;
	public String danhMucName;
	public int thuTu;
	public String tags;
	
	public int compareTo(DanhMuc dm) {
		return this.thuTu - dm.thuTu;
	}
}
