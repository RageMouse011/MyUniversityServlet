package com.project.web.dao;

import com.project.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.project.util.Resources.*;

public class LoginDAO {
    Connection connection = null;
    ConnectionPool connectionPool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);
    String sql = "select * from login where uname=? and pass=?";
    public boolean check(String uname, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
