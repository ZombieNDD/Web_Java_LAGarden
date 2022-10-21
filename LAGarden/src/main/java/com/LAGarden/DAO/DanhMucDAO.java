package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.DangKy;
import com.LAGarden.Model.DanhMuc;

public class DanhMucDAO {
	Connection conn = null;
	ResultSet rs = null;
	Statement stm = null;

	ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
	ArrayList<DanhMuc> listSort = new ArrayList<DanhMuc>();
	public ArrayList<DanhMuc> getListDanhMuc() throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM DanhMuc ORDER BY ThuTu ASC";

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				DanhMuc item = new DanhMuc();
				item.danhMucID = rs.getInt("DanhMucID");
				item.danhMucName = rs.getString("DanhMucName");
				item.thuTu = rs.getInt("ThuTu");
				item.tags = rs.getString("Tags");
				list.add(item);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkThuTu(int n) throws ClassNotFoundException, SQLException {
		ArrayList<DanhMuc> listDanhMuc = getListDanhMuc();
		for (DanhMuc dm : listDanhMuc) {
			if (dm.thuTu==n) 
				return true;
		}
		return false;	
	}
	public int ADD(DanhMuc resgister) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "Insert into DanhMuc values (" + resgister.danhMucID + ",'" + resgister.danhMucName + "',"
				+ resgister.thuTu + ",'" + resgister.tags + "')" ;

		stm = conn.createStatement();
		int result = stm.executeUpdate(query);
		return result;
	}
	
	public int DELETE(DanhMuc dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "DELETE FROM DanhMuc Where DanhMucID =" + dele.danhMucID ;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
}
