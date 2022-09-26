package com.Admin.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Admin.Model.LoginAdmin;
import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DanhMuc;

public class AdminLoginDAO {
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<LoginAdmin> list = new ArrayList<LoginAdmin>();
	
	
	public ArrayList<LoginAdmin> getListTaiKhoan() throws ClassNotFoundException, SQLException{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM TAIKHOAN";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			LoginAdmin item = new LoginAdmin();
			item.UserID = rs.getInt("IDKH");
			item.UserName= rs.getString("UserName");
			item.GroupID = rs.getInt("Roles");
			
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	
}
