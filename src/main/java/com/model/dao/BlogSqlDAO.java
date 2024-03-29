package com.model.dao;

import com.model.Blog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class BlogSqlDAO {
    private Statement st;
    
    public BlogSqlDAO(Connection connection) throws SQLException{
        this.st = connection.createStatement();
    }
    
    //Create Blog for a User by ID
    public void create(int ID, String text, String table) throws SQLException{
        String columns = "INSERT INTO "+table+"(ID,TEXT)";
        String values = "VALUES('"+ID+"','"+text+"')";
        st.executeUpdate(columns+values);
    }
    
    //Read All Blogs for a User
    public List<Blog> getBlogs() throws SQLException{
        String fetch = "SELECT * FROM mydb.blogs";
        ResultSet rs = st.executeQuery(fetch);
        
        List<Blog> temp = new ArrayList<>();
        
        while(rs.next()){
            int blogID = Integer.parseInt(rs.getString(1));
            int userID = Integer.parseInt(rs.getString(2));
            String text = rs.getString(3);
            temp.add(new Blog(blogID, userID, text));
        }
        return temp;
    }
    
    //Read a blog by user ID
    public List<Blog> getBlogs(int ID) throws SQLException{
        String fetch = "SELECT * FROM mydb.blogs WHERE ID="+ID;
        ResultSet rs = st.executeQuery(fetch);
        
        List<Blog> temp = new ArrayList<>();
        
        while(rs.next()){
            int blogID = Integer.parseInt(rs.getString(1));
            int userID = Integer.parseInt(rs.getString(2));
            String text = rs.getString(3);
            temp.add(new Blog(blogID, userID, text));
        }
        return temp;
    } 
       
    //archive blog
    public void archive(int ID) throws SQLException{
        List<Blog> blogs = getBlogs(ID);
        
        for(Blog blog:blogs)
            create(ID, blog.getText(), "mydb.blogshistory");
    }
}
