/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;


import java.io.IOException;


import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.Comment;

/**
 *
 * @author admin
 */
public class ReadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
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
        String id=request.getParameter("id");                      //book id
        if(id==null){
            response.sendRedirect("index");
            return;
        }
        BookDAO ba =new BookDAO();
        Book b = ba.getBookById(Integer.parseInt(id));
        List<Comment> c= ba.getCommentByBook(Integer.parseInt(id));
        Cookie cp = new Cookie("continue",id);                                //set to cookie to continue read func
            cp.setMaxAge(7*24*60*60);
            cp.setPath("/book_web_project");
            response.addCookie(cp);
        request.setAttribute("record", b);
        request.setAttribute("r", request.getParameter("r"));
        request.setAttribute("comment", c);
        request.getRequestDispatcher("Read.jsp").forward(request,response);
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
        BookDAO b= new BookDAO();
        int id=Integer.parseInt(request.getParameter("id"));
        b.Viewed(id);
        String user=(String)request.getSession(false).getAttribute("user");
        if(user!=null)
            b.addHistory(user, id);
        
        String path ="Material\\"+request.getParameter("path");
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("path", path);
        request.getRequestDispatcher("View.jsp").forward(request, response);
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
