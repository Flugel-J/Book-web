/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

import model.Book;
import model.Comment;
import model.Report;


/**
 *
 * @author admin
 */
public class BookDAO extends DBContext{
    //all info for home page
    public List<Book> getInfo(String op,String order){
        List<Book> list = new ArrayList<>();
        String sql ="select * from Record where status"+op+"0 "+order;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt("RecordID"));
                b.setUploader(rs.getString("Uploader"));
                b.setTitle(rs.getString("Title"));
                b.setTimeCreate(rs.getDate("TimeCreate"));
                b.setDescription(rs.getString("Description"));
                b.setViewed(rs.getInt("Viewed"));
                b.setCategories(getBookCategories(rs.getInt("RecordID")));
                b.setImage(rs.getString("image"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return list;
    }
    public List<Book> getTop(){
        List<Book> list = new ArrayList<>();
        String sql ="select top 3 * from Record where status != 0 order by Viewed desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt("RecordID"));
                b.setTitle(rs.getString("Title"));
                b.setTimeCreate(rs.getDate("TimeCreate"));
                b.setViewed(rs.getInt("Viewed"));
                b.setImage(rs.getString("image"));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return list;
    }
    public List<String> allCategories(String order){      //still load unavailable Record's categories out
        List<String> list= new ArrayList<>();             //im lazy
        String sql = "select distinct count(RecordID),Category from Categories group by Category "+order;
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                list.add(rs.getString("Category").trim()+"("+rs.getString(1)+")");
            }
        }
        catch(SQLException ex){
            System.out.println("sql error");
        }
        return list;
    }
    
    public List<String> getCategoryByPage(List<String> list,int start,int end){
        List<String> arr=new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    public List<Book> getListByPage(List<Book> list,int start,int end){
        List<Book> arr=new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }

     //info of a book
    public String number(String c){
        String sql="select count(RecordID),Category from Categories  where Category=? group by Category";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c);
            ResultSet rs =st.executeQuery();
            
            if(rs.next()){
                 return rs.getString(1);
            }
        }
        catch(SQLException ex){
            System.out.println("sql error");
        }
        return "0";
    }
    public List<String> getBookCategories(int id){
          String sql ="select Category from Categories where RecordID=?";
         
          List<String> categories = new ArrayList<>();
            try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            
            while(rs.next()){
                String c = rs.getString("category");
                categories.add(c+"("+number(c)+")");
            }
        } catch (SQLException ex) {
                System.out.println("sql error");
        }
            return categories;
    }
   
    
    public Book getBookById(int id){                         //still get unavailable one
        String sql ="select * from Record where RecordID=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                Book b = new Book(); 
                b.setId(rs.getInt("RecordID"));
                b.setUploader(rs.getString("Uploader"));
                b.setTitle(rs.getString("Title"));
                b.setTimeCreate(rs.getDate("TimeCreate"));
                b.setDescription(rs.getString("Description"));
                b.setViewed(rs.getInt("Viewed"));
                b.setDetail(rs.getString("Detail"));
                b.setCategories(getBookCategories(id));
                b.setImage(rs.getString("image"));
                b.setStatus(rs.getBoolean("status"));
                return b;
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return null;
    }
    
    public List<Comment> getCommentByBook(int id){
       
        List<Comment> list = new ArrayList<>();
        String sql ="select * from Comment where RecordID=? order by [Like] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Comment c = new Comment();
                c.setId(rs.getInt("CommentID"));
                c.setUser(rs.getString("Username"));
                c.setDetail(rs.getString("Detail"));
                c.setTimeCreate(rs.getDate("TimeComment"));
                c.setLike(rs.getInt("Like"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return list;
    }
    public int getBookIdbyCommentId(int id){
        String sql="select RecordID from Comment where CommentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                return rs.getInt("RecordID");
            }
        }
        catch(SQLException e){
            System.out.println("Cant get record id");
        }
        return 1;
    }
    public Comment getCommentById(int id){
        String sql ="select * from Comment where CommentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            if(rs.next()){
                Comment c = new Comment();
                c.setId(rs.getInt("CommentID"));
                c.setUser(rs.getString("Username"));
                c.setDetail(rs.getString("Detail"));
                c.setTimeCreate(rs.getDate("TimeComment"));
                c.setLike(rs.getInt("Like"));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     return null;
    }
    /////////

   
    
   //read
    public void Viewed(int id){
        String sql="update Record set Viewed=Viewed+1 where RecordId=?";
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("View not recorded");
        }
    }
    public int TotalViewed(){
        String sql="select sum(Viewed) from Record";
         try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            
            if(rs.next()){
                 return rs.getInt(1);
            }
        }
        catch(SQLException ex){
            System.out.println("sql error");
        }
         return 0;
    }
    //   
      ///read history
    public List<Book> history(String user){
        String sql="select * from Record r inner join [Read] h on r.RecordID=h.RecordID where h.Username=? and r.status != 0 order by h.TimeRead desc";
        List<Book> list=new ArrayList<>();
            try{
               PreparedStatement st= connection.prepareStatement(sql);
                st.setString(1, user);
                 ResultSet rs =st.executeQuery();
                while(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setUploader(rs.getString("Uploader"));
                b.setTitle(rs.getString("Title"));
                b.setDescription(rs.getString("Description"));
                b.setImage(rs.getString("image"));
                list.add(b);
                }
            }
            catch(SQLException e){
                System.out.println("Cant load history");
            }
            return list;
    }
    
    public void addHistory(String user,int id){
        String sql="insert into [Read] values(?,?,default)";
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, user);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("history not recorded, update instead");
            updateHistory(user,id);
        }
    }
    public void updateHistory(String user, int id){
        String sql="update [Read] set TimeRead=default where Username=? and RecordID=?";
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, user);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("history not updated");
        }
    }
    
    
    //upload ,add
    public void addBook(Book b){
        String sql="insert into Record values(?,?,default,?,0,?,?,default)";
         try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1,b.getUploader());
            st.setString(2, b.getTitle());
            st.setString(3, b.getDescription());
            st.setString(4, b.getDetail());
            st.setString(5, b.getImage());
            st.executeUpdate();
        }
        catch(SQLException e){
            
        }
    }
    public int getLastId(){
         String sql = "SELECT MAX(RecordId) from Record";
        
            try {
               
                PreparedStatement st= connection.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                   int id = rs.getInt(1);
                    return id;
                }
            }
            catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }
    public void addCategory(Book b){ 
       
        String sql="insert into Categories values(?,?)";
        for(String c:b.getCategories()){
            try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, b.getId());
            st.setString(2, c);
            st.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("add category error");
            }
        }
    }
    public void addComment(Comment c){
        String sql="insert into Comment values(?,?,default,?,default)";
          try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setString(1, c.getUser());
            st.setInt(2, c.getRecordId());
            st.setString(3, c.getDetail());
            st.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("add comment error");
            }
    }
    public void Like(int id,String op){
    String sql="update Comment set [Like]=[Like]"+op+"1 where CommentID=?";
          try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Like error");
            }
    }
    
    //search
     public List<Book> search(String type, String data,String order){                            //:vvv 
         List<Book> list = new ArrayList<>();                                              ///still get unavailable record bc i also use this to
        String sql ="select * from Record where "+type+" like ? order by "+order;         ///load library 
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, data);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt("RecordID"));
                b.setUploader(rs.getString("Uploader"));
                b.setTitle(rs.getString("Title"));
                b.setTimeCreate(rs.getDate("TimeCreate"));
                b.setDescription(rs.getString("Description"));
                b.setViewed(rs.getInt("Viewed"));
                b.setCategories(getBookCategories(rs.getInt("RecordID")));
                b.setDetail(rs.getString("Detail"));
                b.setImage(rs.getString("image"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return list;
     }
      public List<Book> searchCategory(String data ,String order){  //dont search for unavailable record
         List<Book> list = new ArrayList<>();
        String sql ="select * from Categories c inner join Record r on c.RecordID=r.RecordID where c.Category=? and r.status!=0 order by r."+order;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            String[] d= data.split("[(]");
            st.setString(1, d[0]);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Book b=new Book();
                b.setId(rs.getInt(1));
                b.setCategories(getBookCategories(rs.getInt(1)));
                b.setUploader(rs.getString((4)));
                b.setTitle(rs.getString(5));
                b.setTimeCreate(rs.getDate(6));
                b.setDescription(rs.getString(7));
                b.setViewed(rs.getInt(8));
                b.setDetail(rs.getString(9));
                b.setImage(rs.getString(10));
                list.add(b);
            }
        } catch (SQLException ex) {
            System.out.println("sql error");
        }
     
     return list;
     }
    ///
    //update
      public void updateBook(Book b){
          String sql="update Record set Title=?, TimeCreate=default, Description=?, image=? where RecordID=?";
           try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, b.getTitle());
            st.setString(2, b.getDescription());
            st.setString(3, b.getImage());
            st.setInt(4, b.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      //delete
      public void delete(String pos,int id){    ///delete by recordID ////this is for delete a record
        String sql="delete from "+pos+" where RecordID=?";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            
        }
        
        
    }
    public void deleteComment(int id){    //delete comment
       String sql="delete from Comment where CommentID=?";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant delete comment");
        }
    }
    public void deleteHistory(String user,int id){    //delete history
       String sql="delete from [Read] where Username=? and RecordID=?";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setString(1, user);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant delete history");
        }
    }
    public void deleteReportComment(int id){    //delete cmtReport
       String sql="delete from ReportComment ";
       if(id!=0){
           sql+="where CommentID=?";
       }
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            if(id!=0){
                st.setInt(1, id);
            }
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant delete  comment report");
        }
    }
     public void deleteReportRecord(int id){    //delete record Report
       String sql="delete from ReportRecord";
       if(id!=0){
           sql+="where RecordID=?";
       }
        try{
            PreparedStatement st =connection.prepareStatement(sql);
              if(id!=0){
                st.setInt(1, id);
            }
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant delete all record report");
        }
    }
      public void deleteFile(String path){
          File f = new File("C:\\Users\\admin\\OneDrive\\Desktop\\java\\Book web project\\web\\"+path);
          if(f.delete()){
              System.out.println("File "+path+" deleted");   
          }
      }
      ////report
      public void addReport(int id, String user, String reason){
          String sql="insert into ReportRecord values(?,?,?)";
          try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, user);
            st.setString(3, reason);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant report");
        }
      }
      public void markComment(int id,String user){
          String sql="insert into ReportComment values(?,?)";
          try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, user);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("cant report");
        }
     }
      public List<Integer> bookReported(){
          List<Integer> rp=new ArrayList<>();
          String sql ="select distinct RecordID from ReportRecord";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                rp.add(rs.getInt(1));
            }
        }
        catch(SQLException e){
                    
         }
        return rp;
      }
      
      public List<Report> listBookReport(int id){
          List<Report> rp=new ArrayList<>();
          String sql ="select * from ReportRecord where RecordID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Report r =new Report();
                r.setId(rs.getInt(1));
                r.setUsername(rs.getString(2));
                r.setDetail(rs.getString(3));
                rp.add(r);
            }
        }
        catch(SQLException e){
                    
         }
        return rp;
      }
      public void flag(int id,boolean s){
           String sql="update Record set status=? where RecordID=?";
       try {
            
            PreparedStatement st = connection.prepareStatement(sql);
           
            st.setBoolean(1, s);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Cant flag book");
        }
      }
      public List<Integer> CommentReported(){
         List<Integer> rp=new ArrayList<>();
          String sql ="select distinct * from ReportComment";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
         
            ResultSet rs =st.executeQuery();
            while(rs.next()){
              rp.add(rs.getInt(1));
            }
        }
        catch(SQLException e){
                    
         }
        return rp;
      }
    public static void main(String[] args) {
       BookDAO b = new BookDAO();
        System.out.println(b.TotalViewed());
       
    }
    
}
