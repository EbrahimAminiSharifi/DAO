package com.nhl.DAO;

import java.sql.*;

public class CRUDImp implements CRUD {

    Connection _con;
    int fetchSize;

    @Override
    public Connection connect(String serverIP, String user, String password) throws ClassNotFoundException, SQLException {
        //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbURL = String.format("jdbc:sqlserver://%s;user=$s;password=%s", serverIP, user, password);
        _con = DriverManager.getConnection(dbURL);
        if (_con != null) {
            System.out.println("Connected");
        }
        return _con;

    }

    @Override
    public ResultSet select(String query) throws SQLException {
        PreparedStatement prepareStatement = _con.prepareStatement(query);
        prepareStatement.setFetchSize(fetchSize);
        ResultSet RS = prepareStatement.executeQuery();

        return RS;
    }

    @Override
    public Boolean insert(String query) throws SQLException {
        PreparedStatement prepareStatement = _con.prepareStatement(query);
        return prepareStatement.execute();

    }

    @Override
    public int update(String query) throws SQLException {
        PreparedStatement prepareStatement = _con.prepareStatement(query);
        return prepareStatement.executeUpdate(query);
    }

    @Override
    public int delete(String query) throws SQLException {
        PreparedStatement prepareStatement = _con.prepareStatement(query);
        return prepareStatement.executeUpdate(query);
    }

    @Override
    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }

    @Override
    public void setAutoCommit(Boolean status) throws SQLException {
        _con.setAutoCommit(status);
    }

}
