package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {

    private final String databaseUrl;
    private final String userName;
    private final String password;

    private int maxPoolSize;
    private int connNum = 0;

    private static final String SQL_VERIFYCONN = "select 1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    public ConnectionPool(String databaseUrl, String userName, String password, int maxPoolSize) {
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
        this.maxPoolSize = maxPoolSize;
    }

    public Connection getConnection() throws SQLException {
        Connection conn;
        if (isFull()) {
            throw new SQLException("The connection pool is full.");
        }
        conn = getConnectionFromPool();
        if (conn == null) {
            conn = createNewConnectionForPool();
        }
        conn = makeAvailable(conn);
        return conn;
    }

    public void returnConnection(Connection conn) throws SQLException {
        if (conn == null) {
            throw new NullPointerException();
        }
        if (!occupiedPool.remove(conn)) {
            throw new SQLException(
                    "The connection is returned already or it isn't for this pool");
        }
        freePool.push(conn);
    }

    private boolean isFull() {
        return ((freePool.size() == 0) && (connNum >= maxPoolSize));
    }

    private synchronized Connection createNewConnectionForPool() throws SQLException {
        Connection conn = createNewConnection();
        connNum++;
        occupiedPool.add(conn);
        return conn;
    }

    private synchronized Connection createNewConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(databaseUrl, userName, password);
        return conn;
    }

    private synchronized Connection getConnectionFromPool() {
        Connection conn = null;
        if (freePool.size() > 0) {
            conn = freePool.pop();
            occupiedPool.add(conn);
        }
        return conn;
    }

    private synchronized Connection makeAvailable(Connection conn) throws SQLException {
        if (isConnectionAvailable(conn)) {
            return conn;
        }
        occupiedPool.remove(conn);
        connNum--;
        conn.close();

        conn = createNewConnection();
        occupiedPool.add(conn);
        connNum++;
        return conn;

    }

    private synchronized boolean isConnectionAvailable(Connection conn) {
        try (Statement st = conn.createStatement()) {
            st.executeQuery(SQL_VERIFYCONN);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
