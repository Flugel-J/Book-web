package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book web login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        <form action =\"login\" method=\"post\">\n");
      out.write("           \n");
      out.write("               \n");
      out.write("        \n");
      out.write("                <section class=\"vh-100\" style=\"background-color: #2875b2;\">\n");
      out.write("  <div class=\"container py-5 h-100\">\n");
      out.write("    <div class=\"row d-flex justify-content-center align-items-center h-100\">\n");
      out.write("      <div class=\"col-12 col-md-8 col-lg-6 col-xl-5\">\n");
      out.write("        <div class=\"card shadow-2-strong\" style=\"border-radius: 1rem;\">\n");
      out.write("          <div class=\"card-body p-5 text-center\">\n");
      out.write("\n");
      out.write("            <h3 class=\"mb-5\">Sign in</h3>\n");
      out.write("            <h4 style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("            <div class=\"form-outline mb-4\">\n");
      out.write("              <input type=\"text\" id=\"typeEmailX-2\" class=\"form-control form-control-lg\" name=\"user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.user.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required/>\n");
      out.write("              <label class=\"form-label\" for=\"typeEmailX-2\">Username</label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-outline mb-4\">\n");
      out.write("              <input type=\"password\" id=\"typePasswordX-2\" class=\"form-control form-control-lg\" name=\"pass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.pass.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required/>\n");
      out.write("              <label class=\"form-label\" for=\"typePasswordX-2\">Password</label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Checkbox -->\n");
      out.write("            <div class=\"form-check d-flex justify-content-start mb-4\">\n");
      out.write("              <input\n");
      out.write("                class=\"form-check-input\"\n");
      out.write("                type=\"checkbox\"\n");
      out.write("                name=\"rem\"\n");
      out.write("                id=\"form1Example3\" checked\n");
      out.write("              />\n");
      out.write("              <label class=\"form-check-label\" for=\"form1Example3\"> Remember password </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">Login</button>\n");
      out.write("            \n");
      out.write("            <a href=\"register\">Create new account</a>\n");
      out.write("            <input type=\"text\" name=\"position\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${position}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden>\n");
      out.write("           \n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
