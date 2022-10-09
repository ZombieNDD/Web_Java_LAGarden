package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DangKy;
import com.LAGarden.Model.DanhMuc;

public class UserDAO {

	Connection conn = null;
	ResultSet rs = null;
	Statement stm = null;
	ArrayList<DangKy> list = new ArrayList<DangKy>();

	public int Register(DangKy resgister) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "Insert into TAIKHOAN values ('" + resgister.fullname + "','" + resgister.username + "','"
				+ resgister.password + "','" + resgister.email + "','" + resgister.phone + "','" + resgister.address
				+ "',null,null," + resgister.roles + ",null,null,null,null,null)";

		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}

	public DangKy Login(String user, String password) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "Select * from taikhoan where username = '" + user + "' and password = '" + password + "'";
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		DangKy item = new DangKy();
		if (rs.next()) {
			item.fullname = rs.getString("FullName");
			item.username = rs.getString("UserName");
			item.password = rs.getString("Password");
			item.email = rs.getString("Email");
			item.phone = rs.getString("Phone");
			item.address = rs.getString("Address");
			item.roles = rs.getInt("Roles");
			return item;
		} else {
			return null;
		}
	}

	public ArrayList<DangKy> getListUser() throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM taikhoan";

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				DangKy item = new DangKy();
				item.fullname = rs.getString("FullName");
				item.username = rs.getString("UserName");
				item.password = rs.getString("Password");
				item.email = rs.getString("Email");
				item.phone = rs.getString("Phone");
				item.address = rs.getString("Address");
				item.roles = rs.getInt("Roles");
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int DELETE(DangKy dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "DELETE FROM TAIKHOAN Where UserName="+dele.username;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
}
