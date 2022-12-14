package com.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author George
 */
public class SqlDB {
//    protected String URL = "jdbc:mysql://localhost:1433/mydb?useSSL=false&serverTimezone=UTC";
//    protected String driver = "com.mysql.cj.jdbc.Driver";
//    protected String db = "mydb";
//    protected String dbuser = "root";
//    protected String dbpassword = "<Your password goes here>";
    protected Connection connection;
    
    protected Connection openConnection() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException{
        Map<String,String> variables = System.getenv();
        String password = variables.get("dbpassword");
        
        InputStream propsInputStream = new FileInputStream("D:\\GitHub\\demo\\src\\resources\\db.properties");
        Properties properties = new Properties();
        properties.load(propsInputStream);
        
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String dbuser = properties.getProperty("dbuser");
        
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url, dbuser, password);
        propsInputStream.close();
        return connection;
    }
}
