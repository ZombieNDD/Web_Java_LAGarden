package com.LAGarden.Config;

import java.sql.*;

public class MyConnection {
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url ="jdbc:sqlserver://localhost:1433;Database=LAGarden;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}
