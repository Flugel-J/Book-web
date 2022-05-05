/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;

/**
 *
 * @author admin
 */
public class CommentServlet extends HttpServlet {

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
            out.println("<title>Servlet Comment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comment at " + request.getContextPath() + "</h1>");
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
        String i=request.getParameter("c");
        int id;
        if(i==null){
            response.sendRedirect("index");
            return;
        }
        try{
            id=Integer.parseInt(i); 
            BookDAO b=new BookDAO();
            Comment c = b.getCommentById(id);
            String user =(String)request.getSession().getAttribute("user");
        
            if(c==null||!c.getUser().equals(user)){
                response.sendRedirect("login");
            }
            else{
                b.deleteComment(id);
            }
            response.sendRedirect("read?id="+c.getRecordId());
    
        }
        catch(NumberFormatException e){
            response.sendRedirect("index");
       
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDAO b =new BookDAO();
        int id = Integer.parseInt(request.getParameter("id"));                //ahhh fuc
        if(request.getParameter("like")!=null){                               // idea:
                                                                              //Like button like facebook or twitter   
            b.Like(id, "+");                                                 
        }
        else{
            String user=(String)request.getSession().getAttribute("user");           //post comment
            String comment=request.getParameter("comment");      
            Comment c=  new Comment(user,id,comment); 
            b.addComment(c);
            
            
        }
        
        response.sendRedirect("read?id="+b.getBookIdbyCommentId(id));
       
        
        
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
