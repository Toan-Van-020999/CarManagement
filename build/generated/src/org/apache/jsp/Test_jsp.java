package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <title>jQuery UI Dialog - Modal confirmation</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script>\n");
      out.write("  <script src=\"https://code.jquery.com/ui/1.13.0/jquery-ui.js\"></script>\n");
      out.write("  <script>\n");
      out.write("  $( function() {\n");
      out.write("    $( \"#dialog-confirm\" ).dialog({\n");
      out.write("      resizable: false,\n");
      out.write("      height: \"auto\",\n");
      out.write("      width: 400,\n");
      out.write("      modal: true,\n");
      out.write("      buttons: {\n");
      out.write("        \"Delete all items\": function() {\n");
      out.write("          $( this ).dialog( \"close\" );\n");
      out.write("        },\n");
      out.write("        Cancel: function() {\n");
      out.write("          $( this ).dialog( \"close\" );\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    });\n");
      out.write("  } );\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" \n");
      out.write("<div id=\"dialog-confirm\" title=\"Empty the recycle bin?\">\n");
      out.write("  <p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:12px 12px 20px 0;\"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("<p>Sed vel diam id libero <a href=\"http://example.com\">rutrum convallis</a>. Donec aliquet leo vel magna. Phasellus rhoncus faucibus ante. Etiam bibendum, enim faucibus aliquet rhoncus, arcu felis ultricies neque, sit amet auctor elit eros a lectus.</p>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("</body>\n");
      out.write("</html>");
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
