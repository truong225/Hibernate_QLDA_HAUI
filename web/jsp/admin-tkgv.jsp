<%-- 
    Document   : tksv
    Created on : Apr 29, 2017, 2:35:58 PM
    Author     : we
--%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html><html><!-- InstanceBegin template="/Templates/backend-hibernate.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta charset="utf-8">
        <!-- InstanceBeginEditable name="doctitle" -->
        <title>Hệ thống quản lý đồ án tốt nghiệp</title>
        <link rel="stylesheet" type="text/css" href="../css/jquery.dataTables.min.css">
        <!-- InstanceEndEditable -->
        <!-- InstanceBeginEditable name="head" -->
        <!-- InstanceEndEditable -->
        <link href="../css/back-end-index.css" rel="stylesheet" type="text/css">
    </head>
    <script src="../js/customer.js"></script>

    <body style="background: gray;  ">
        <div class="contain" style="background: #FFF">
            <header class="header">
                <div class="header-logo" style="float: left;">
                    <a href="#">HỆ THỐNG QUẢN LÝ ĐỒ ÁN TỐT NGHIỆP</a>
                </div>
                <div class="dropdown" style="float: right;">

                    <div class="header-user" >
                        <img src="../images/avatar.jpg" alt="" id="header-avatar">
                        <span id="header-userName">Trường DX</span>
                    </div>
                    <ul class="dropdown-content" >
                        <li>Thông tin cá nhân</li>
                        <li onClick="location.href = 'initLogin.htm'">Đăng xuất</li>
                    </ul>
                </div>
            </header>

            <section class="main-contents">

                <!-- thanh menu -->
                <section class="left-menu">
                    <div id="menu">
                        <ul>
                            <li><a href="Home.htm" >Trang chủ</a></li>
                            <li><a href="inittksv.htm" >Quản lý tài khoản</a>
                                <ul class="sub-menu">
                                    <li><a href="inittksv.htm" >Tài khoản sinh viên</a></li>
                                    <li><a href="inittkgv.htm" >Tài khoản giảng viên</a></li>
                                    <li><a href="intkad.htm" >Tài khoản quản trị</a></li>
                                    <li><a href="intknotactive.htm" >Tài khoản không kích hoạt</a></li>
                                </ul>
                            </li>
                            <li><a href="initDSDTActive.htm" >Quản lý đề tài</a>
                                <ul class="sub-menu">
                                    <li><a href="initDSDTActive.htm" >Đề tài đang thực hiện</a></li>
                                    <li><a href="initDSDTNonActive.htm" >Đề tài đã hoàn thành</a></li>
                                </ul>
                            </li>
                            <li><a href="initDSGVHD.htm" >Thông tin hội đồng</a>
                                <ul class="sub-menu">
                                    <li><a href="initDSGVHD.htm" >Giảng viên hướng dẫn</a></li>
                                    <li><a href="initDSGVPB.htm" >DS hội đồng phản biện</a></li>
                                    <li><a href="initDSHDC.htm" >DS hội đồng chấm</a></li>
                                </ul>
                            </li>
                            <li><a href="initLogin.htm" >Đăng xuất</a></li>
                        </ul>
                    </div>
                </section>

                <!-- Noi dung -->
                <section class="right-content" style="height: auto;"><!-- InstanceBeginEditable name="Noidung" -->
                    <div class="title"> DANH SÁCH GIẢNG VIÊN </div>
                    <div>
                        <div>
                        <f:form action="initFormAdaGV.htm" >
                            <input id="btn_add" value="Thêm" type="submit"/>
                        </f:form>
                    </div>
                    </div>
                    <div>
                        <table id="myTable" class="table table-striped table-bordered" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>MSV</th>
                                    <th>Họ Tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Khoa</th>
                                    <th>Email</th>
                                    <th>Số SVHD</th>
                                    <th>Số ĐTHD</th>
                                    <th>Số lần Truy cập</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="x" items="${lsSV}" >
                                    <tr>
                                        <td>${x.getUserName()}</td>
                                        <td>${x.getUserFullname()}</td>
                                        <td>${x.getUserDateofbirth()}</td>
                                        <td>${x.getUserFaculty()}</td>
                                        <td>${x.getUserEmail()}</td>
                                        <td>${x.getUserNumDthd()}</td>
                                        <td>${x.getUserNumSvdhd()}</td>
                                        <td>${x.getUserCountLogin()}</td>
                                        <td><a href="initUpdateUserGV.htm?userId=${x.getUserId()}" style="color: blue">Update</a></td>
                                        <td><a href="delete.htm?userId=${x.getUserId()}&model=inittkgv.htm" style="color: blue">Xóa</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <!-- InstanceEndEditable -->

                </section>


            </section>
            <footer class="footer">
                 <div>
                    <p>Copyright 2017 © HaUI</p>
                    <p>Phát triển hệ thống bởi nhóm 4 - KTPMCLCK9</p>
                </div>
            </footer>
            <div style="clear: both"></div>
        </div>
    </body>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.dataTables.min.js"></script>
    <script>
                            $(document).ready(function () {
                                $("#myTable").DataTable();
                            });
    </script>
    <!-- InstanceEnd --></html>

