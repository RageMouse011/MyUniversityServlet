package com.project.web.dao;

import com.project.util.ConnectionPool;

import java.sql.*;

import static com.project.util.Resources.*;

public class SalaryDAO {
    Connection connection = null;
    ConnectionPool connectionPool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);

    public int getSalaryId(Double salary) {
        String createSalary = "insert into salary (salary) values (?)";
        int salaryId = 0;

        try {
            Class.forName("org.postgresql.Driver");
            connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(createSalary, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, salary);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                salaryId = rs.getInt("id");
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
        return salaryId;
    }
}
