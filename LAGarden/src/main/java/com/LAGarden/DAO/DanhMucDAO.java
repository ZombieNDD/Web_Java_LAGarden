package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.DanhMuc;

public class DanhMucDAO {
	Connection conn = null;
	ResultSet rs = null;
	Statement stm = null;

	ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();

	public ArrayList<DanhMuc> getListDanhMuc() throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM DanhMuc";

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

	public int ADD(DanhMuc resgister) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "Insert into  DanhMuc (" + resgister.danhMucID + ",'" + resgister.danhMucName + "',"
				+ resgister.thuTu + ",'" + resgister.tags + "')" ;

		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
}
