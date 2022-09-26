package com.Admin.Model;

public class LoginAdmin {
	
public int UserID;
public String UserName;
public int GroupID;
    
    public int getUserID() {
		return UserID;
	}
	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	public int getGroupID() {
		return GroupID;
	}
	public void setGroupID(int GroupID) {
		this.GroupID = GroupID;
	}
}
