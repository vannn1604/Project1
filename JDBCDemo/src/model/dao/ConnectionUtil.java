/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectionUtil {
    private static final String hostName = "localhost";
    private static final String userName = "root";
    private static final String password = "";
    private static final String dbName = "gmail_demo";
    private static final String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("kết nối đến database thành công");
            return conn;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tới database" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection conn = ConnectionUtil.getConnection();
        //Lấy dữ liệu = câu lệnh sql
        String sql = "select * from user where account =? and password = ?";
        try {
            PreparedStatement pstm =  conn.prepareStatement(sql);
            pstm.setString(1, "hlinh@yahoo.com");
            pstm.setString(2, "321");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String account = rs.getString("account");
                String password = rs.getString("password");
                
                System.out.println("Id: "+id+" name: "+name+
                        " account: "+account+" password: "+password);
            }
        } catch (Exception e) {
        }
    }
}













