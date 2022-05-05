/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Book;
 @MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 50,      // 50 MB
  maxRequestSize = 1024 * 1024 * 200   // 200 MB
)
/**
 *
 * @author admin
 */
public class ManageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=0;
        try{
            id=Integer.parseInt(request.getParameter("id"));
        }
        catch(Exception e){
            response.sendRedirect("index");
            return;
        }
        String action=request.getParameter("a");
        String categories="";
        HttpSession session= request.getSession();
        String user= (String)session.getAttribute("user");
        BookDAO b =new BookDAO();
        Book book = b.getBookById(id);
        if(book==null){
            response.sendRedirect("index");
            return;
        }
        if(!book.getUploader().equals(user)){
            String position="manage?id="+id;
            request.setAttribute("position", position);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(action==null){
            request.setAttribute("book", book);
        
            List<String> c= book.getCategories();
            if(c.isEmpty()){
                request.setAttribute("categories", "");
            }
            else{
                for(String i:c){
                    String[]cate=i.split("[(]");
                    categories+=cate[0]+", ";
            
                }
                request.setAttribute("categories", categories.substring(0, categories.length()-2));
                
            }
            request.getRequestDispatcher("Manage.jsp").forward(request, response);
        }
        else if("book".equals(action)){
            b.delete("Categories",id);
            b.deleteReportComment(id);
             b.delete("Comment",id);
            b.delete("Read", id); 
            b.deleteReportRecord(id);
             b.delete("Record", id);
             b.deleteFile("Material//"+book.getDetail());
             b.deleteFile("image//"+book.getImage());              //delete a hell lot constrain
        }
      
        
        response.sendRedirect("index");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String fileName(String title){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        
        
        timeStamp = timeStamp.replace(" ", "");
        timeStamp = timeStamp.replace(":", "");
         timeStamp = timeStamp.replace("-", "");
        return  timeStamp+title;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");                                                                    ///ahhh this shit waste my whole week
        int id =Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String category=request.getParameter("category");
        String description=request.getParameter("description")==null?"None":request.getParameter("description");
        String uploader=request.getParameter("uploader");
        BookDAO b= new BookDAO();
        Book book = new Book(); 
        book.setId(id);
        if(request.getParameter("update")!=null){
            
            if(!"default.png".equals(request.getParameter("cover"))){ //if not default pic then delete
                
                b.deleteFile("image\\"+request.getParameter("cover"));
            }
            Part imagePart =request.getPart("image");
            String name=fileName(imagePart.getSubmittedFileName());
            String imageName=fileName(name);
            book.setImage(imageName);
        String path = "C:\\Users\\admin\\OneDrive\\Desktop\\java\\Book web project\\web\\image";           //some how f.getAbsolutePath() always point wrong
        File f = new File(path);                                                                           //where tf is User/Appdata/Netbeans??? 
        if(!f.exists()){
            f.mkdirs();
        }
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        
        try {
            out = new FileOutputStream(new File(path + File.separator
                    + imageName));
            filecontent = imagePart.getInputStream();

            int read=0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
        
            writer.println("<br/> ERROR: " + fne.getMessage()+"<br>"+path);
            
            
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        
        }
    } 
        if(category!=null){
            String[] categories=category.split("\\s*,\\s*");
            List<String> c = Arrays.asList(categories);
            book.setCategories(c);
            b.delete("Categories",id);
            b.addCategory(book);
        }
	else{
            b.delete("Categories",id);
        }
        book.setTitle(title);
        book.setDescription(description);
        b.updateBook(book);
     
        response.sendRedirect("index");
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
