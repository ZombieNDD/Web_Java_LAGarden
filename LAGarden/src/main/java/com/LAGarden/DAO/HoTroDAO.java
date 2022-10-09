package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.DanhMuc;
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
			item.tenKH = rs.getString("tenKH");
			
			item.email = rs.getString("email");
			item.chiTiet = rs.getString("chiTiet");
			item.status = rs.getBoolean("status");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	public int formHoTro(HoTro ht) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "Insert into Table values ('"+ht.tenKH+"','"+ht.email+"',,'"+ht.chiTiet+")";
		stm = conn.createStatement();
		int i = stm.executeUpdate(query);
		return i;
	}
	
	public int DELETE(HoTro dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		
		String query = "DELETE FROM LIENHE Where email ='" + dele.email+"'" ;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;

	}
}
