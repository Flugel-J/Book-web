/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author admin
 */
public class UserDAO extends DBContext{
    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String sql ="select * from Users";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUsername(rs.getString("Username"));
                u.setStatus(rs.getBoolean("Status"));
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return list;
    }
    
    public User getUser(String user){
       String sql ="select * from Users where Username=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setStatus(rs.getBoolean("Status"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public User getInfo(String user){
        String sql ="select * from UserInfo u inner join Users s on u.Username=s.Username where u.username=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setUsername(rs.getString(1));
                u.setName(rs.getString(2));
                u.setDob(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setGender(rs.getBoolean(5));
                u.setIntro(rs.getString(6));
                u.setPassword(rs.getString(7));
                u.setStatus(rs.getBoolean(8));
                
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //new
   public void insert(User u){
       String sql="insert into Users values(?,?,?)";
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());
            st.setBoolean(3, u.getStatus());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertInfo(u.getUsername());
   }
   public void insertInfo(String u){     //user already have a null info field when create new account
       String sql="insert into UserInfo(Username) values(?)";
       try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void updateInfo(User u){     
       String sql="update UserInfo set [Name]= ?,Birthday=?,Email=?,Gender=?,Intro=? where Username=?";
       try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getName());
            st.setString(2, u.getDob());
            st.setString(3, u.getEmail());
            st.setBoolean(4, u.getGender());
            st.setString(5, u.getIntro());
            st.setString(6, u.getUsername());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cant update profile");
        }
   }
   public void flag(String u, boolean s){     
       String sql="update Users set Status=? where Username=?";
       try {
            
            PreparedStatement st = connection.prepareStatement(sql);
           
            st.setBoolean(1, s);
            st.setString(2, u);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cant flag");
        }
   }
   public static void main(String arg[]){
        UserDAO c= new UserDAO();
        User u=c.getUser("s");
        u.setEmail("damn@gmail.com");
        c.updateInfo(u);
        
    }
}

