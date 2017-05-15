<%-- 
    Document   : admin-formadsv
    Created on : May 6, 2017, 10:36:43 PM
    Author     : we
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html><html><!-- InstanceBegin template="/Templates/backend-hibernate.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta charset="utf-8">
        <!-- InstanceBeginEditable name="doctitle" -->
        <title>Untitled Document</title>
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
                                    <li><a href="intkad.htm.htm" >Tài khoản quản trị</a></li>
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
                    <div class="title"> Thêm Tài Khoản </div>

                    <div>
                        <f:form action="insertDSSV.htm" method="GET" commandName="sv">
                            <table class="form-add">
                                <tr>
                                    <td>
                                        <td>Tên đăng nhập <span style="color: red;">(*)</span>: </td>
                                        <td>
                                            <f:input path="userName"/>
                                        </td>
                                    </td>
                                    <td>
                                    <td>Mật khẩu <span style="color: red;">(*)</span>: </td>
                                    <td><f:input path="userPassword" /></td>
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                    <td>Họ tên: </td>
                                    <td>
                                        <f:input path="userFullname" />
                                    </td>
                                    </td>
                                    <td>
                                    <td>Ngày sinh: </td>
                                    <td><f:input type="date" path="userDateofbirth"/></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <td>Giới tính: </td>
                                    <td>
                                        <f:select path="userGender">
                                            <f:option value="1">Nam</f:option>
                                            <f:option value="0">Nữ  </f:option>
                                        </f:select>
                                        
                                    </td>
                                    <td></td>
                                    </td>
                                    <td>Khoa: </td>
                                    <td><f:input path="userFaculty" /></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <td>Lớp: </td>
                                    <td>
                                        <f:input path="" />
                                    </td>
                                    </td>
                                    <td>
                                    <td>Email: </td>
                                    <td><f:input path="userClass" /></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <td>Điện thoại: </td>
                                    <td>
                                        <f:input path="userMobile" />
                                    </td>
                                    </td>
                                    <td>
                                    <td>Địa chỉ: </td>
                                    <td>
                                        <f:input path="userAddress" />
                                    </td>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>
                                    <td>Loại TK: </td>
                                    <td>
                                        <f:select path="userType">
                                            <f:option value="0">Quản trị</f:option>
                                            <f:option value="1">Sinh Viên</f:option>
                                            <f:option value="2">Giảng Viên</f:option>

                                        </f:select>
                                        
                                    </td>
                                    <td></td>
                                    </td>
                                    <td> </td>
                                    <td></td>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>
                                    <td>HKTT: </td>
                                    <td>
                                        <f:textarea path="userReligion" cols="25" rows="5"></f:textarea>
                                        
                                    </td>
                                    </td>
                                </tr>
                            </table>
                            <div class="btn">
                                <div style="width: 310px; margin: 0 auto">
                                    <input class="btn_add1" type="button" value="Thêm">
                                    <input class="btn_add1" type="submit" value="Lưu">
                                    <input class="btn_add1" type="button" value="Hủy">
                                </div>
                            </div>
                        </f:form>
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