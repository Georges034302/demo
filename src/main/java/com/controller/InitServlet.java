/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.AdminSqlDAO;
import com.model.dao.BlogSqlDAO;
import com.model.dao.SqlDBConnector;
import com.model.dao.UserSqlDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class InitServlet extends HttpServlet {

    private UserSqlDAO userSqlDAO;
    private AdminSqlDAO adminSqlDAO;
    private BlogSqlDAO blogSqlDAO;
    private SqlDBConnector dBConnector;
    private Connection connection;

    @Override
    public void init() {
        try {
            dBConnector = new SqlDBConnector();
            connection = dBConnector.connection(); //opening connection with the db
            userSqlDAO = new UserSqlDAO(connection);
            adminSqlDAO = new AdminSqlDAO(connection);
            blogSqlDAO = new BlogSqlDAO(connection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("adminSqlDAO", adminSqlDAO);
        session.setAttribute("userSqlDAO", userSqlDAO);
        session.setAttribute("blogSqlDAO", blogSqlDAO);
    }
    
    @Override
    public void destroy(){
        try {
            dBConnector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
