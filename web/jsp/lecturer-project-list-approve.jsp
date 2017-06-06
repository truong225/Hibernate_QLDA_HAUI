<%-- 
    Document   : client-Homepage
    Created on : May 31, 2017, 2:53:22 PM
    Author     : we
--%>


<%@page import="hibernate.entity.Message"%>
<%@page import="hibernate.entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="hibernate.entity.Detai"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Đồ án tốt nghiệp</title>

        <link rel="stylesheet" href="../resources/css/jquery-ui.css">
        <!-- Bootstrap -->
        <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <link href="../build/css/list.css" rel="stylesheet" />
        <!-- bootstrap-progressbar -->
        <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
        <!-- bootstrap-daterangepicker -->
        <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

        <!-- Datatables -->
        <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../build/css/custom.min_1.css" rel="stylesheet">
        <link rel="stylesheet" href="../resources/css/custom.css">
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;"> <a href="initClientHompage.htm" class="site_title"><img src="../images/haui_lg.png" width="45px" height="45px" alt=""><span> Đồ án tốt nghiệp</span></a> </div>
                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix">
                            <div class="profile_pic"> <img src="../images/${sessionScope.avatar}" alt="..." class="img-circle profile_img"> </div>
                            <div class="profile_info"> <span>Xin chào,</span>
                                <h2>${sessionScope.Username}</h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info --> 

                        <br />

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            <div class="menu_section">
                                <h3>Chung</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-home"></i> Trang chủ <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="initClientHompage.htm">Trang chủ</a></li>
                                            <li><a href="notify.html">Thông báo</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-user"></i> Sinh viên <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="initlecturer_Project_List_Ongoing.htm">Danh sách sinh viên đang hướng dẫn</a></li>
                                            <li><a href="lecturerProjectListApprove.htm">Phê duyệt đề tài</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-book"></i> Đề tài <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="lecturer_ListProject.htm">Danh sách đề tài</a></li>
                                        </ul>
                                    </li>

                                </ul>
                            </div>
                            <div class="menu_section">
                                <h3>Cá nhân</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-bug"></i> Thông tin cá nhân <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="person information.html">Xem thông tin cá nhân</a></li>
                                            <li><a href="change_Password.html">Đổi mật khẩu</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="contact.html"><i class="fa fa-comments-o"></i><span class="fa fa-chevron-down"></span>Liên hệ</a></li>
                                    <li><a href="logout.html"><i class="fa fa-sign-out"></i> Đăng xuất <span class="fa fa-chevron-down"></span></a> </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /sidebar menu --> 

                        <!-- /menu footer buttons -->
                        <div class="sidebar-footer hidden-small"> <a data-toggle="tooltip" data-placement="top" title="Settings"> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> </a> <a data-toggle="tooltip" data-placement="top" title="FullScreen"> <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span> </a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span> </a> <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> </div>
                        <!-- /menu footer buttons --> 
                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle"> <a id="menu_toggle"><i class="fa fa-bars"></i></a> </div>
                            <ul class="nav navbar-nav navbar-right">
                                <li class=""> <a href="index.html" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <img src="../images/${sessionScope.avatar}" alt="">${sessionScope.Username} <span class=" fa fa-angle-down"></span> </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a href="person information.html"> Thông tin cá nhân</a></li>
                                        <li> <a href="setting.html"> <span class="badge bg-red pull-right">50%</span> <span>Cài đặt</span> </a> </li>
                                        <li><a href="contact.html">Trợ giúp</a></li>
                                        <li><a href="logout.htm"><i class="fa fa-sign-out pull-right"></i> Đăng xuất</a></li>
                                    </ul>
                                </li>
                                <li role="presentation" class="dropdown"> <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span> </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                        <li> <a> <span class="image"><img src="../images/${sessionScope.avatar}" alt="Profile Image" /></span> <span> <span>${sessionScope.Username}</span> <span class="time">3 mins ago</span> </span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span> </a> </li>
                                        <li> <a> <span class="image"><img src="../images/${sessionScope.avatar}" alt="Profile Image" /></span> <span> <span>${sessionScope.Username}</span> <span class="time">3 mins ago</span> </span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span> </a> </li>
                                        <li> <a> <span class="image"><img src="../images/${sessionScope.avatar}" alt="Profile Image" /></span> <span> <span>${sessionScope.Username}</span> <span class="time">3 mins ago</span> </span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span> </a> </li>
                                        <li> <a> <span class="image"><img src="../images/${sessionScope.avatar}" alt="Profile Image" /></span> <span> <span>${sessionScope.Username}</span> <span class="time">3 mins ago</span> </span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span> </a> </li>
                                        <li>
                                            <div class="text-center"> <a> <strong>See All Alerts</strong> <i class="fa fa-angle-right"></i> </a> </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation --> 

                <!-- page content -->


                <div class="right_col" role="main">
                    <div class="clearfix"></div>
                    <!-- end page title -->
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_title">
                                <h2>Phê duyệt yêu cầu</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_panel">
                                <div class="x_content">
                                   
                                    
                                    <div class="x_panel" style="margin-top: 10px; position: relative">
                                        <table id="myTable" class="table table-striped table-bordered" style="width: 99%; position: relative; z-index: 0">
                                            <thead style="position: relative">
                                                <tr>
                                                    <th style="text-align: center">STT</th>
                                                    <th style="text-align: center">Tên đề tài</th>
                                                    <th style="text-align: center">Thông tin đề tài</th>
                                                    <th style="text-align: center">Sinh viên</th>
                                                    <th style="text-align: center">Loại</th>
                                                    <th style="text-align: center">Phê duyệt</th>
                                                </tr>
                                            </thead>
                                            <tbody style="position: relative">
                                                <%
                                                    int x = 1;
                                                    List<Message> lsMes = (List<Message>) request.getAttribute("lsMes");
                                                    List<Users> lsUsers = (List<Users>) request.getAttribute("lsUsers");
                                                    List<Detai> lsProject = (List<Detai>) request.getAttribute("lsProject");
                                                    for (int i = 0; i < lsMes.size(); i++) {
                                                        out.print("<tr>");
                                                        out.print("   <td style=\"text-align: center\">" + x + "</td>");
                                                        out.print("    <td style=\"text-align: center\">" + lsProject.get(i).getProjectName()+ "</td>");
                                                        out.print("    <td style=\"text-align: center\">" + lsProject.get(i).getProjectDescription()+ "</td>");
                                                        out.print("   <td style=\"text-align: center\">");
                                                        out.print("       <div class=\"tooltip-a\">");
                                                        out.print("           <a href=\"#\">" +lsUsers.get(i).getUserFullname() + "</a>");
                                                        out.print("          <div class=\"tooltiptext-a\">");
                                                        out.print("               <img src=\"../images/" + lsUsers.get(i).getUserAvatar() + "\" style=\"width:150px;height:200px;margin-top:10px\" />");
                                                        out.print("              <hr style=\"width: 80%\" />");
                                                        out.print("               <div style=\"font-family:Cambria; text-align:center; margin-top:-10px\">");
                                                        out.print("                 ★ Họ tên: " + lsUsers.get(i).getUserFullname() + " <br />");
                                                        out.print("                 ★ Lớp: " + lsUsers.get(i).getUserClass() + "<br />");
                                                        out.print("                 ★ Email: " + lsUsers.get(i).getUserEmail() + "<br />");
                                                        out.print("                 ★ SDT: " + lsUsers.get(i).getUserMobile());
                                                        out.print("              </div>");
                                                        out.print("          </div>");
                                                        out.print("      </div>");
                                                        out.print("  </td>");
                                                        if(lsMes.get(i).getMessageType()==1){
                                                            out.print("    <td style=\"text-align: center; color: green; font-weight:bold\">Đăng kí đề tài</td>");
                                                        }
                                                        else if(lsMes.get(i).getMessageType()==2){
                                                            out.print("    <td style=\"text-align: center; color: red; font-weight:bold\">Hủy đề tài</td>");
                                                        }
                                                        out.print("  <td>");
                                                        out.print("<div>"
                                                                + "<a href=\"approveProject.htm?mesId="+lsMes.get(i).getMessageId()+"\"><button class=\"btn btn-success new-btn\"  >Duyệt❯</button></a>"
                                                                + "<a href=\"\"><button class=\"btn btn-danger new-btn\"  >Hủy❯</button></a>"
                                                                + "</div>");
                                                        out.print(" </td>");
                                                        out.print(" </tr>");
                                                        x++;
                                                    }

                                                %>


                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <!-- /page content -->

            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Hệ thống quản lý đồ án tốt nghiệp Đại học Công Nghiệp Hà Nội • Nhóm 4
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
    </div>



</body>

<!-- jQuery -->
<script src="../vendors/jquery/dist/jquery.min.js"></script>

<script src="../resources/js/jquery-1.12.4.js"></script>
<script src="../resources/js/jquery-ui.js"></script>

<!-- Bootstrap -->
<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="../vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="../vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="../vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="../vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="../vendors/Flot/jquery.flot.js"></script>
<script src="../vendors/Flot/jquery.flot.pie.js"></script>
<script src="../vendors/Flot/jquery.flot.time.js"></script>
<script src="../vendors/Flot/jquery.flot.stack.js"></script>
<script src="../vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="../vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="../vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="../vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="../vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="../vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="../vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="../vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="../vendors/moment/min/moment.min.js"></script>
<script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Datatables -->
<script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../vendors/jszip/dist/jszip.min.js"></script>
<script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="../vendors/pdfmake/build/vfs_fonts.js"></script>
<!-- Custom Theme Scripts -->
<script src="../build/js/custom.min.js"></script>
<script type="text/javascript" src="../resources/js/custom.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#myTable").DataTable();
    });

</script>
</html>
