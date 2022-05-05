/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.Report;
import model.User;

/**
 *
 * @author admin
 */
public class AdminServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
           request.getRequestDispatcher("admin.jsp").forward(request, response);
        
        }
         else{
                BookDAO b= new BookDAO();
            List<Book> book =b.getInfo("!=", "order by Viewed desc");
            
      
            request.setAttribute("book", book.size());
            UserDAO u= new UserDAO();
            List<User> user=u.getAll();
            request.setAttribute("user", user.size());
            request.setAttribute("viewed", b.TotalViewed());
          
            request.getRequestDispatcher("adminControl.jsp").forward(request, response);
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
        String id=request.getParameter("id");
        if("konami".equals(id)){                                         //fixed admin
            HttpSession session = request.getSession();
            session.setAttribute("isAdmin", "y");
            BookDAO b= new BookDAO();
            List<Book> book =b.getInfo("!=", "order by Viewed desc");          //whaterver order
            
      
            request.setAttribute("book", book.size());
            UserDAO u= new UserDAO();
            List<User> user=u.getAll();
            request.setAttribute("user", user.size());
            request.setAttribute("viewed", b.TotalViewed());
            request.getRequestDispatcher("adminControl.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("index");
        }
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
