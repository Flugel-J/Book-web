/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author admin
 */
public class LoginServlet extends HttpServlet {

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
        
         HttpSession session = request.getSession();
         Object user = session.getAttribute("user");
         String position=request.getParameter("position");
         String id=request.getParameter("id");
        if(id!=null){
            position+="?id="+id;
        }
         if(position==null) 
             position="index";
        
        if(user!=null){
            response.sendRedirect(position);
            return;
        }
        else{
            request.setAttribute("position", position);
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        UserDAO ud = new UserDAO();
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        User u =ud.getUser(user);
        String position =request.getParameter("position");
        if(u==null){
            String err="Cant find user!";
            request.setAttribute("error", err);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else if(!u.getStatus()){
            String err="Account disable! Contact hoangvmhe161059@fpt.edu.vn for more info";
            request.setAttribute("error", err);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else{
            if(u.getPassword().equals(pass)){
                
                request.getSession(true).setAttribute("user",user);
                if(request.getParameter("rem")!=null){
                    Cookie cu = new Cookie("user",user);
                    Cookie cp = new Cookie("pass",pass);
                   cu.setMaxAge(7*24*60*60);
                   cp.setMaxAge(7*24*60*60);
                   cu.setPath("/book_web_project");
                   cp.setPath("/book_web_project");
                   response.addCookie(cu);
                   response.addCookie(cp);
                }
                else{
                    Cookie cu = new Cookie("user","");
                    Cookie cp = new Cookie("pass","");
                   cu.setMaxAge(0);
                   cp.setMaxAge(0);
                   cu.setPath("/book_web_project");
                   cp.setPath("/book_web_project");
                   response.addCookie(cu);
                   response.addCookie(cp);

                }
                doGet(request,response);
                
            }
            else{
                String err="Incorrect password!";
                request.setAttribute("error", err);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
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
