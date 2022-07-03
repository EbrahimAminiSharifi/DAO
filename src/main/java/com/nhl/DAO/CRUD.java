/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhl.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moghaleb
 */
public interface CRUD {

    Connection connect(String serverIP, String user, String password) throws ClassNotFoundException, SQLException;

    int delete(String query) throws SQLException;

    Boolean insert(String query) throws SQLException;

    ResultSet select(String query) throws SQLException;

    void setAutoCommit(Boolean status) throws SQLException;

    void setFetchSize(int fetchSize);

    int update(String query) throws SQLException;
    
}
