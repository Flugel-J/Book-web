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

/**
 *
 * @author admin
 */
 @MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 50,      // 50 MB
  maxRequestSize = 1024 * 1024 * 200   // 200 MB
)
public class UploadServlet extends HttpServlet {

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
            out.println("<title>Servlet UploadSevlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadSevlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            if(request.getParameter("user")==null)
                request.getRequestDispatcher("Upload.jsp").forward(request, response);
            BookDAO b= new BookDAO();
            request.setAttribute("library", b.search("Uploader",request.getParameter("user"),"TimeCreate desc"));
            request.getRequestDispatcher("Library.jsp").forward(request, response);
        }
        else{
            request.setAttribute("position", "upload");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
       
      
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
        response.setContentType("text/html;charset=UTF-8");
        String uploader=request.getParameter("uploader");
        String title=request.getParameter("title");
        String categories= request.getParameter("categories");
        String description=request.getParameter("description")==null?"None":request.getParameter("description");
        
        BookDAO b= new BookDAO();
    Part filePart = request.getPart("file");
    String fileName = fileName(title)+".pdf";
    Book b1 = new Book(b.getLastId()+1,uploader,title,description,fileName);
    if(request.getParameter("update")!=null){
        Part imagePart =request.getPart("image");
        String name=fileName(imagePart.getSubmittedFileName());
        String imageName=fileName(name);
        b1.setImage(imageName);
        String path = "C:\\Users\\admin\\OneDrive\\Desktop\\java\\Book web project\\web\\image";//somehow f.getAbsolutePath() always point wrong                                                                   
      File f = new File(path);                                                                  //where tf is User/Appdata/Netbeans???
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
    b.addBook(b1);
    if(categories!=null){
            List<String> category= Arrays.asList(categories.trim().split("\\s*,\\s*"));
            
            b1.setCategories(category);
        b.addCategory(b1);
    }
    
    String path = "C:\\Users\\admin\\OneDrive\\Desktop\\java\\Book web project\\web\\Material";
    File f = new File(path);
    if(!f.exists()){
        f.mkdirs();
    }
  

    // Create path components to save the file
    

    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();

    try {
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

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
