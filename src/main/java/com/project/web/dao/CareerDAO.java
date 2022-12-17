package com.project.web.dao;

import com.project.util.ConnectionPool;

import java.sql.*;

import static com.project.util.Resources.*;

public class CareerDAO {
    Connection connection = null;
    ConnectionPool connectionPool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);

    public int getCareerId(String name) {
        String createCareer = "insert into career (name) values (?)";
        int careerId = 0;

        try {
            Class.forName("org.postgresql.Driver");
            connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(createCareer, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                careerId = rs.getInt("id");
            }

            ps.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connectionPool.returnConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return careerId;
    }
}
