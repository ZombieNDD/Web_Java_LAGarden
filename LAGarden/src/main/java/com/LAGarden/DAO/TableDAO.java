package com.LAGarden.DAO;

import java.sql.*;

import com.LAGarden.Config.MyConnection;

public class TableDAO {
	public void ConnectionToDatabase()  {
		try {
			MyConnection connect = new MyConnection();
			Connection conn = connect.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
