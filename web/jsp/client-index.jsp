<%-- 
    Document   : client-index
    Created on : May 26, 2017, 4:33:42 PM
    Author     : we
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Hệ thống quản lý đồ án tốt nghiệp</title>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/custom.css">
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
        <div class="row col-md-12" style="height: 300px; background: #eee; margin-top: 60px; color: black">
            <div class="container" >
                <h1 style="font-size: 65px; font-weight: bold">Xin chào!</h1>
                <p>Chào mừng bạn đến với hệ thống hỗ trợ làm đồ án tốt nghiệp!
                    <br>Hệ thống được thiết kế nhằm hỗ trợ sinh tra cứu, đăng kí, đề xuất đề tài đồ án tốt nghiệp. Hỗ trợ tương tác giữa sinh viên và giảng viên trong quá trình làm đồ án. Được phát triển bởi khoa CNTT trường ĐH Công Nghiệp Hà Nội..!
                </p>
                <p><button class="btn btn-success">Chi tiết</button></p>
            </div>

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2 style="font-size: 20px; font-weight: bold">Danh sách giảng viên hướng dẫn</h2>
                    <p>Tra cứu danh sách giảng viên hướng dẫn theo từng khoa...</p>
                    <p>
                        <a href="initDSGVHD.htm"><button class="btn btn-default">Chi tiết</button></a>
                    </p>
                </div>
                <div class="col-md-4">
                    <h2 style="font-size: 20px;font-weight: bold">Đăng kí đề tài đồ án tốt nghiệp</h2>
                    <p>Đăng kí đề tài đồ án tốt nghiệp...</p>
                    <p>
                        <button class="btn btn-default">Đăng kí</button>
                    </p>
                </div>
                <div class="col-md-4">
                    <h2 style="font-size: 20px;font-weight: bold">Quản lý tiến độ dự án</h2>
                    <p>Vào hệ thống quản lý đồ án...</p>
                    <p>
                        <button class="btn btn-default">Đăng nhập</button>
                    </p>
                </div>
            </div>		
        </div>
    </body>

    <script src="../bootstrap/js/bootstrap.min.js"></script>
</html>