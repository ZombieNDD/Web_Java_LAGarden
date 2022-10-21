package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.CTMonAn;
import com.LAGarden.Model.DanhMuc;

public class CTMonAnDAO {
	Connection conn = null;
	ResultSet rs = null;
	Statement stm = null;

	ArrayList<CTMonAn> list = new ArrayList<CTMonAn>();

	public ArrayList<CTMonAn> getListCTMonAN() throws ClassNotFoundException, SQLException {
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
	public CTMonAn chiTietMonAn(int id) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "SELECT * FROM CTMONAN WHERE IDMA = " + id;

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			CTMonAn item = new CTMonAn();
			while (rs.next()) {
				item.idMA = rs.getInt("IDMA");
				item.tenMonAn = rs.getString("TenMonAn");
				item.soLuong = rs.getInt("SoLuong");
				item.chiTietMA = rs.getString("ChiTietMA");
				item.gia = rs.getDouble("Gia");
				item.imgMA = rs.getString("ImgMA");
				item.giaSale = rs.getDouble("GiaSale");
				item.slug = rs.getString("slug");
				item.title = rs.getString("title");
				item.danhMucID = rs.getInt("DanhMucID");
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CTMonAn> getListByDanhMuc(String id) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "SELECT * FROM CTMONAN WHERE DanhMucID = " + id;

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				CTMonAn item = new CTMonAn();
				item.idMA = rs.getInt("IDMA");
				item.tenMonAn = rs.getString("TenMonAn");
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

	public int ADD(CTMonAn resgister) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "Insert into CTMONAN values (" + resgister.danhMucID + ",'" + resgister.tenMonAn + "',"
				+ resgister.soLuong + ",'" + resgister.chiTietMA + "'," + resgister.gia + ",'" 
				+ resgister.imgMA + "','" + resgister.slug + "','" + resgister.title + "','" + resgister.giaSale +  "')";

		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
	public int DELETE(CTMonAn dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "DELETE FROM CTMONAN Where DanhMucID =" + dele.danhMucID ;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;
	}
	//============================== PHÂN TRANG ==============================//
	public ArrayList<CTMonAn> getListPhanTrang(int a, int b) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM CTMONAN ORDER BY IDMA OFFSET  "+a+" ROWS FETCH NEXT "+b+" ROWS ONLY";
		
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}
	public int getListCount() throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "SELECT count(idMA) FROM CTMONAN";
		int count = 0;
        try {
        stm = conn.createStatement();
        rs = stm.executeQuery(query);
		while (rs.next()){
			count =rs.getInt(1);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
	}
	
	public ArrayList<CTMonAn> getListByDanhMucPhanTrang(String id,int a,int b) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "SELECT * FROM CTMONAN WHERE DanhMucID = " + id+"ORDER BY IDMA OFFSET  "+a+" ROWS FETCH NEXT "+b+" ROWS ONLY";

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				CTMonAn item = new CTMonAn();
				item.idMA = rs.getInt("IDMA");
				item.tenMonAn = rs.getString("TenMonAn");
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
	public int getListCountDanhMuc(String id) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		
		String query = "SELECT count(idMA) FROM CTMONAN Where DanhMucID="+id;
		int count = 0;
        try {
        stm = conn.createStatement();
        rs = stm.executeQuery(query);
		while (rs.next()){
			count =rs.getInt(1);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
	}
}
