package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.Table;

public class TableDAO {
	
	
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<Table> list = new ArrayList<Table>();
	public ArrayList<Table> getListTable() throws ClassNotFoundException, SQLException{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM DatBan";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			Table item = new Table();
			item.username = rs.getString("username");
			item.NgayDB= rs.getTime("NgayDB").toLocalTime();
			item.GioDB = rs.getTime("GioDB");
			item.FullName = rs.getString("FullName");
			item.Email = rs.getString("Email");
			item.Phone = rs.getString("Phone");
			item.SLNguoiLon = rs.getString("SLNguoiLon");
			item.SLTreEm = rs.getString("SLTreEm");
			item.GhiChu = rs.getString("GhiChu");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
}
