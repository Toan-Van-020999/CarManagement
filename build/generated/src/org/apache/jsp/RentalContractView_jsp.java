package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.EmployeeDAO;
import model.Employee;

public final class RentalContractView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!------ Include the above in your HEAD tag ---------->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Employee e = (Employee) session.getAttribute("employee");
        
            if (e == null) {
                response.sendRedirect("Login.jsp?err=timeout");
            }
            
            String idCustomer = String.valueOf(session.getAttribute("idCustomer"));
            String idSelectedCar = String.valueOf(session.getAttribute("idSelectedCar"));
            
            EmployeeDAO employeeDAO = new EmployeeDAO();
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"main container\">\n");
      out.write("        <h3 class=\"align\">Hợp đồng cho khách thuê xe</h3>\n");
      out.write("        <h5 class=\"info\">\n");
      out.write("            Anh: Nguyễn Văn A<br>\n");
      out.write("            Địa chỉ: số nhà x<br>\n");
      out.write("            Số CCCD: 9999999xxx<br>\n");
      out.write("            Số điện thoại: 0123<br>\n");
      out.write("            Bằng lái xe: B1\n");
      out.write("        </h5>\n");
      out.write("        <div>\n");
      out.write("            <h5>Bảng xe khách chọn</h5>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead class=\"table-light\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>STT</th>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Tên</th>\n");
      out.write("                        <th>Loại</th>\n");
      out.write("                        <th>Phân khúc</th>\n");
      out.write("                        <th>Giá</th>\n");
      out.write("                        <th>Tình trạng</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"flex\">\n");
      out.write("                <h5>Tiền đặt cọc</h5>\n");
      out.write("                <input class=\"mx-3\">\n");
      out.write("            </div>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead class=\"table-light\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>STT</th>\n");
      out.write("                        <th>Tên tài sản</th>\n");
      out.write("                        <th>Số lượng</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"align\">\n");
      out.write("                <button class=\"btn btn-outline-success\" type=\"button\">Thêm thế chấp</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"justi flex\">\n");
      out.write("                <button class=\"btn btn-outline-success\" type=\"button\">Hủy bỏ</button>\n");
      out.write("                <button class=\"btn btn-outline-success\" type=\"button\">Tạo hợp đồng</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
