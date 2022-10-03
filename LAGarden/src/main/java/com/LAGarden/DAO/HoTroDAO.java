package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.HoTro;
import com.LAGarden.Model.Table;

public class HoTroDAO {
	
	
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<HoTro> list = new ArrayList<HoTro>();
	public ArrayList<HoTro> getListHoTro() throws ClassNotFoundException, SQLException{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM LIENHE";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			HoTro item = new HoTro();
			item.TenKH = rs.getString("TenKH");
			
			item.Email = rs.getString("Email");
			item.ChiTiet = rs.getString("ChiTiet");
			item.status = rs.getBoolean("status");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
}