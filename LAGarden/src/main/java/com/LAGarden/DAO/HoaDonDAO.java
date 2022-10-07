package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.DanhMuc;
import com.LAGarden.Model.HoaDon;

public class HoaDonDAO {
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<HoaDon> list = new ArrayList<HoaDon>();
	public ArrayList<HoaDon> getListHoaDon() throws ClassNotFoundException, SQLException{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM HoaDon";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			HoaDon item = new HoaDon();

			item.username= rs.getString("username");
			item.NameRecieve= rs.getString("NameRecieve");
			item.AddressRecive = rs.getString("AddressRecive");
			item.Phone = rs.getString("Phone");
			item.EmailRecieve = rs.getString("EmailRecieve");
			item.TongTien = rs.getBigDecimal("TongTien");
			item.NgayLap = rs.getDate("NgayLap");			
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	
	public int DELETE(HoaDon dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "DELETE FROM HoaDon Where Phone =" + dele.Phone ;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
}
