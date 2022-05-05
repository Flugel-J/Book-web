/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author admin
 */
public class BookControlServlet extends HttpServlet {

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
            out.println("<title>Servlet BookControlServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookControlServlet at " + request.getContextPath() + "</h1>");
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
          if(request.getSession().getAttribute("isAdmin")==null){
            response.sendRedirect("admin");
            return;
        }
      
        BookDAO b= new BookDAO();
        
        
            List<Book> book =b.getInfo("=0 or status!=", "order by TimeCreate desc");
            request.setAttribute("book", book);
           List<Integer> brp= b.bookReported();
           for(int i:brp){
               for(Book b1:book){
                   if(b1.getId()==i){
                       b1.setDescription("report");                //hah
                   }
               }
           }
            request.getRequestDispatcher("BookControl.jsp").forward(request, response);
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
        if(request.getSession().getAttribute("isAdmin")==null){
            response.sendRedirect("admin");
            return;
        }
        BookDAO b= new BookDAO();
        int id= Integer.parseInt(request.getParameter("id"));
        boolean s = Boolean.parseBoolean(request.getParameter("status"));
        s=!s;                                          //if flagged then unflag, unflag then flag
        b.flag(id, s);
        response.sendRedirect("bookcontrol");
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
