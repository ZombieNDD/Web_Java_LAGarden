package com.LAGarden.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LAGarden.Config.MyConnection;
import com.LAGarden.Model.ImageDatBan;

public class ImageDatBanDAO {
	Connection conn = null;
	ResultSet rs =null;
	Statement stm = null;
	
	ArrayList<ImageDatBan> list = new ArrayList<ImageDatBan>();

	public ArrayList<ImageDatBan> getList() throws SQLException, ClassNotFoundException
	{
		conn = new MyConnection().getConnection();

		String query = "SELECT * FROM ImageDatBan";
		
        try {
		stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()){
			ImageDatBan item = new ImageDatBan();
			item.ID = rs.getInt("ID");
			item.imgsource= rs.getString("imgsource");
			list.add(item);
			}
		return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

}
