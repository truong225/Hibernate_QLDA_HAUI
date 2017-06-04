<%-- 
    Document   : client-index
    Created on : May 26, 2017, 4:33:42 PM
    Author     : we
--%>

<%@page import="hibernate.entity.Users"%>
<%@page import="hibernate.entity.Detai"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html><!-- InstanceBegin template="/Templates/client-template.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta charset="utf-8">
        <!-- InstanceBeginEditable name="doctitle" -->
        <title>Hệ thống quản lý đồ án tốt nghiệp Đại Học Công Nghiệp Hà Nội</title>
        <!-- InstanceBeginEditable name="doctitle" -->
        <title>Hệ thống quản lý đồ án tốt nghiệp Đại Học Công Nghiệp Hà Nội</title>
        <link rel="stylesheet" type="text/css" href="build/css/jquery.dataTables.min.css" />
        <!-- Bootstrap -->
        <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Datatables -->
        <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" />
        <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet" />
        <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet" />
        <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet" />
        <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet" />
        <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- Font Awesome -->
        <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
        <!-- NProgress -->
        <link href="../vendors/nprogress/nprogress.css" rel="stylesheet" />
        <!-- iCheck -->
        <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet" />

        <!-- bootstrap-progressbar -->
        <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" />
        <!-- JQVMap -->
        <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet" />
        <!-- bootstrap-daterangepicker -->
        <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" />
        <!-- Custom Theme Style -->
        <link href="../build/css/custom.min.css" rel="stylesheet" />
        <link href="../css/custom.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="../build/css/bootstrap.min.css" />
        <link rel="stylesheet" href="../build/css/hompage-custom.css" />
        <link href="../build/css/list.css" rel="stylesheet" />
        <link href="../build/css/back-end-index.css" rel="stylesheet" type="text/css" />

        <link href="../build/js/Tooltip-css.css" rel="stylesheet" />

    </head>

    <body style="background: #FFF">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container" style="">
                <div class="logo">
                    <div>
                        <a href="initHomePage.htm">
                            <img src="../images/haui_lg.png" width="40px" alt="Đại học công nghiệp hà nội">
                            <span style="color: white; font-weight: bold" >HỆ THỐNG QUẢN LÝ ĐỒ ÁN TỐT NGHIỆP</span>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- InstanceBeginEditable name="Content" -->
        <div class="container" >
            <div class="row" Style="margin-top: 60px;">
                <div style="margin-top: 20px; margin-left: 20px">
                    <a href="initHomePage.htm"><button  OnClick="" class="btn btn-default new-btn" />❮ Trang chủ</button></a>

                </div>
                <div style="margin-top: -35px; float: right; margin-right: 30px">
                    <button Text="Đăng nhập ❯" OnClick="" class="btn btn-success new-btn" >Đăng nhập ❯</button>
                </div>
                <hr />

            </div>

            <div class="row" >
                <div class="">
                    <h2>Danh sách đề tài</h2>
                </div>
                <f:form action="loadHomepageDSDT.htm" method="GET">
                    <div class="col-md-4 col-sm-12">
                        <h3>Chọn khoa: </h3>

                        <select class="form-control" name="faculty">
                            <c:forEach var="x" items="${listFaculty}">
                                <option>${x}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <input type="submit" value="Chọn" style="margin-top: 40px; padding: 10px"/>
                    </div>
                </f:form>
                
                <div class="x_panel" style="margin-top: 10px; position: relative">
                    <table id="myTable" class="table table-striped table-bordered" style="width: 99%; position: relative; z-index: 0">
                        <thead style="position: relative">
                            <tr>
                                <th style="text-align: center">Mã ĐT</th>
                                <th style="text-align: center">Tên đề tài</th>
                                <th style="text-align: center">Thông tin đề tài</th>
                                <th style="text-align: center">Giảng viên hướng dẫn</th>
                                <th style="text-align: center">Thông tin giảng viên</th>
                                <th style="text-align: center">Đăng ký</th>
                            </tr>
                        </thead>
                        <tbody style="position: relative">
                            <%
                                List<Detai> lsDT = (List<Detai>) request.getAttribute("listDT");
                                List<Users> lsUser = (List<Users>) request.getAttribute("listUsers");
                                for (int i = 0; i < lsDT.size(); i++) {
                                    String hv;
                                    if (lsUser.get(i).getUserDegree() == "T.S") {
                                        hv = "Tiến sĩ";
                                    } else {
                                        hv = "Thạc sĩ";
                                    }
                                    out.print("<tr>");
                                    out.print("<td style=\"text-align: center; \">" + lsDT.get(i).getProjectId() + "</td>");
                                    out.print("   <td style=\"text-align: center\">" + lsDT.get(i).getProjectName() + "</td>");
                                    out.print("    <td style=\"text-align: center\">" + lsDT.get(i).getProjectDescription() + "</td>");
                                    out.print("   <td style=\"text-align: center\">" + lsUser.get(i).getUserDegree() + " " + lsUser.get(i).getUserFullname() + "</td>");
                                    out.print("   <td style=\"text-align: center\">");
                                    out.print("       <div class=\"tooltip-a\">");
                                    out.print("           <a href=\"#\">Xem thông tin</a>");
                                    out.print("          <div class=\"tooltiptext-a\">");
                                    out.print("               <img src=\"../images/" + lsUser.get(i).getUserAvatar() + "\" style=\"width:150px;height:200px;margin-top:10px\" />");
                                    out.print("              <hr style=\"width: 80%\" />");
                                    out.print("               <div style=\"font-family:Cambria; text-align:center; margin-top:-10px\">");
                                    out.print("                 ★ Họ tên: " + lsUser.get(i).getUserFullname() + " <br />");
                                    out.print("                 ★ Học vị: " + hv + "<br />");
                                    out.print("                 ★ Email: " + lsUser.get(i).getUserEmail() + "<br />");
                                    out.print("                 ★ SDT: " + lsUser.get(i).getUserMobile());
                                    out.print("              </div>");
                                    out.print("          </div>");
                                    out.print("      </div>");
                                    out.print("  </td>");
                                    out.print("  <td>");
                                    out.print("<button class=\"btn btn-success new-btn\"  >Đăng ký ❯</button>"
                                    );
                                    out.print(" </td>");
                                    out.print(" </tr>");
                                }
                                
                            %>
                            

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>  

<script>
    $().DataTable();
    $(document).ready(function () {
        $('#datatable').DataTable();
    });
</script>
<!-- InstanceEndEditable -->
</body>


<!-- Custom Theme Scripts -->
<script src="../build/js/jquery.min.js"></script>
<script src="../build/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#myTable").DataTable();
    });
    
</script>
<!-- InstanceEnd --></html>
