/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-02-16 09:00:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pages.module_002dsalaryList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class salaryList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("       <!-- Masthead-->\r\n");
      out.write("        <header class=\"masthead bg-primary text-white text-center\">\r\n");
      out.write("            <div class=\"container d-flex align-items-center flex-column\">\r\n");
      out.write("                <!-- Masthead Avatar Image-->\r\n");
      out.write("                <img class=\"masthead-avatar mb-5\" src=\"assets/img/kdrl.png\" alt=\"\" />\r\n");
      out.write("                <!-- Masthead Heading-->\r\n");
      out.write("                <h2 class=\"masthead-heading text-uppercase mb-0\">King Digital Recharge Limited.</h2>\r\n");
      out.write("                <!-- Icon Divider-->\r\n");
      out.write("                <div class=\"divider-custom divider-light\">\r\n");
      out.write("                    <div class=\"divider-custom-line\"></div>\r\n");
      out.write("                    <div class=\"divider-custom-icon\"><i class=\"fas fa-star\"></i></div>\r\n");
      out.write("                    <div class=\"divider-custom-line\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Masthead Subheading-->\r\n");
      out.write("                <p class=\"masthead-subheading font-weight-light mb-0\">We Think & Work Digitally</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("            <!-- Application-->\r\n");
      out.write("  <div class=\"page-wrapper bg-gra-03 p-t-45 p-b-50\">\r\n");
      out.write("                <div class=\"wrapper wrapper--w790\">\r\n");
      out.write("                    <div class=\"card card-5\">\r\n");
      out.write("                    \r\n");
      out.write("                    <!--------------- logo ---------------------> \r\n");
      out.write("                        <div class=\"row center\">\r\n");
      out.write("                     <div class=\"col-12\">\r\n");
      out.write("                          <div class=\"card-heading\">\r\n");
      out.write("                            <h2 class=\"title\">Salary List</h2>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <div id=\"salaryListGrid\" class=\"ag-theme-balham grid-60-vh\" ></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
