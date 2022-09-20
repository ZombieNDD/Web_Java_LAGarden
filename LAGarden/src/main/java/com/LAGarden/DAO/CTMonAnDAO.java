package com.LAGarden.DAO;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.CTMonAn;

public class CTMonAnDAO {
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<CTMonAn> list = new ArrayList<CTMonAn>();
	public ArrayList<CTMonAn> getListCTMonAN() throws ClassNotFoundException, SQLException{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM CTMONAN";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			CTMonAn item = new CTMonAn();
			item.idMA = rs.getInt("IDMA");
			item.tenMonAn= rs.getString("TenMonAn");
			item.soLuong = rs.getInt("SoLuong");
			item.chiTietMA = rs.getString("ChiTietMA");
			item.gia = rs.getDouble("Gia");
			item.imgMA = rs.getString("ImgMA");
			item.giaSale = rs.getDouble("GiaSale");
			item.slug = rs.getString("slug");
			item.title = rs.getString("title");
			item.danhMucID = rs.getInt("DanhMucID");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
}
