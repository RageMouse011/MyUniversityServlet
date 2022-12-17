package com.project.web.dao;

import java.sql.*;

import com.project.util.ConnectionPool;

import static com.project.util.Resources.*;

public class FacultyDAO {
    Connection connection = null;
    ConnectionPool connectionPool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);
    public int getFacultyId(String name) {
        String createFaculty = "insert into faculty (name) values (?)";
        int facultyId = 0;
        try {
            Class.forName("org.postgresql.Driver");
            connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(createFaculty, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                facultyId = rs.getInt("id");
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
        return facultyId;
    }
}
