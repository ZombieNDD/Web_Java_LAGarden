package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.DanhMuc;
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
			item.ngayDB= rs.getDate("NgayDB");
			item.gioDB = rs.getTime("GioDB");
			item.fullName = rs.getString("FullName");
			item.email = rs.getString("email");
			item.phone = rs.getString("Phone");
			item.sLNguoiLon = rs.getString("SLNguoiLon");
			item.sLTreEm = rs.getString("SLTreEm");
			item.ghiChu = rs.getString("GhiChu");
			item.id = rs.getInt("DatBanID");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	public int addItem(Table tb,String username) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();
		String query = "Insert into Datban values (N'"+tb.ngayDB+"',N'"+tb.gioDB+"',N'"+ tb.fullName+"','"+tb.email+"','"+tb.phone+"',N'"+tb.sLNguoiLon+"',N'"+tb.sLTreEm+"',N'"+tb.ghiChu+"',N'"+username+"' )";
		System.out.println(query);
		stm = conn.createStatement();
		int i = stm.executeUpdate(query);
		return i;
	}
	
	
	public int DELETE(Table dele) throws ClassNotFoundException, SQLException {
		conn = new MyConnection().getConnection();

		String query = "DELETE FROM DatBan Where DatBanID =" + dele.id ;
		stm = conn.createStatement();
		int result = stm.executeUpdate(query);

		return result;

	}
}
