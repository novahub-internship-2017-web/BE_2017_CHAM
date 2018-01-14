package com.cham.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;
	public static Connection getConnecttion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.print("db1");
            String connectionURL = "jdbc:mysql://localhost:3306/QuanLyNhanVien?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(connectionURL,"root","root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
	
	public static void main(String arvg[])
	{
		System.out.print(DBConnect.getConnecttion());
	}

}