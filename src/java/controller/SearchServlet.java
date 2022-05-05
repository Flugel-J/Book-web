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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author admin
 */
public class SearchServlet extends HttpServlet {

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
       String data = request.getParameter("search");
       String filter=request.getParameter("filter");
 
       if(data==null){
           doPost(request,response);
       }
       request.setAttribute("se", data);
       String order;
       
             
        if("O".equals(filter))
                order="TimeCreate asc";
         
        else if("P".equals(filter))
                order="Viewed desc";
        else
            order="TimeCreate desc";
       String xpage = request.getParameter("page");
        int page,size, limit=5, start, end;
        if(xpage==null) page=1;
        else page=Integer.parseInt(xpage);
        BookDAO b =new BookDAO();
        List<Book> listU= b.search("Uploader", data.trim(),order);
        if(listU.isEmpty()){
            List<Book> listT= b.search("Title", "%"+data.trim()+"%",order);
            size=listT.size();
            int numpage=size/limit+(size%limit==0?0:1);
            start=(page-1)*limit;
            if(page*limit>size){
                end=size;
            }
           else{
                end=page*limit;
            } 
            request.setAttribute("search", b.getListByPage(listT, start, end));
            request.setAttribute("numpage", numpage);
        }
        else{
            size=listU.size();
            int numpage=size/limit+(size%limit==0?0:1);
            start=(page-1)*limit;
            if(page*limit>size){
                end=size;
            }
           else{
            end=page*limit;
            } 
            request.setAttribute("search", b.getListByPage(listU, start, end));
            request.setAttribute("numpage", numpage);
        }
        
        request.setAttribute("page", page);
        request.setAttribute("filter", filter);
      
       request.getRequestDispatcher("Search.jsp").forward(request, response);
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
        String category= request.getParameter("category");
        String xpage = request.getParameter("page");
        String filter=request.getParameter("filter");
        String order;
      
        if("O".equals(filter))
                order="TimeCreate asc";
         
        else if("P".equals(filter))
                order="Viewed desc";
        else
            order="TimeCreate desc";
        int page,size, limit=5, start, end;
         if(xpage==null) page=1;
        else page=Integer.parseInt(xpage);
         
        if(category!=null){
            BookDAO b= new BookDAO();
            
                List<Book> list= b.searchCategory(category, order);
                
                
                size=list.size();
                int numpage=size/limit+(size%limit==0?0:1);
                start=(page-1)*limit;
                if(page*limit>size){
                    end=size;
                }
                else{
                    end=page*limit;
                } 
                request.setAttribute("cate", category);
                request.setAttribute("category", b.getListByPage(list, start, end));
                request.setAttribute("numpage", numpage);
                request.setAttribute("page", page);
            }
           
        request.getRequestDispatcher("Search.jsp").forward(request, response);
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
