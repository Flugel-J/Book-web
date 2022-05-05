/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;

/**
 *
 * @author admin
 */
public class IndexServlet extends HttpServlet {

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
        String filter = request.getParameter("filter");          //filter
        String xpage = request.getParameter("page");              //paging
        int page,size, limit=5, start, end;
        if(xpage==null) page=1;
        else page=Integer.parseInt(xpage);
        BookDAO b= new BookDAO(); 
        String order;
       
             
        if("O".equals(filter))
                order="order by TimeCreate asc";
         
        else if("P".equals(filter))
                order="order by Viewed desc";
        else
            order="order by TimeCreate desc";
        
        List<Book> list = b.getInfo("!=",order);
        
        size=list.size();
        int numpage=size/limit+(size%limit==0?0:1);
        start=(page-1)*limit;
        if(page*limit>size){
            end=size;
        }
        else{
            end=page*limit;
        }
        //cookies
        
        request.setAttribute("filter", filter);
        request.setAttribute("page", page);
        request.setAttribute("numpage", numpage);
        request.setAttribute("book", b.getListByPage(list, start, end));
       
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
       doGet(request,response);
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
