package com.project.web.dao;

import com.project.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.project.util.Resources.*;

public class SigninDAO {
    Connection connection = null;
    ConnectionPool connectionPool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);


    public boolean register(String uname, String pass) {
        String sql = "insert into login (uname, pass) values (?, ?)";
        try {
            Class.forName("org.postgresql.Driver");
            connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
