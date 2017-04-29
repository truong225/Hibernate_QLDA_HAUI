<%-- 
    Document   : admin-Home
    Created on : Apr 24, 2017, 1:49:05 PM
    Author     : we
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Trang chủ</title>
		<link rel="stylesheet" href="../css/back-end-index.css">
	</head>
	<script src="../js/customer.js">
	
	</script>
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
						<li onClick="location.href='Login.html'">Đăng xuất</li>
					</ul>
				</div>
			</header>

			<section class="main-contents">
				
				<!-- thanh menu -->
				<section class="left-menu">
					<div id="menu">
						<ul>
							<li><a href="home.html" target="test">Trang chủ</a></li>
							<li><a href="tksv.html" target="test">Quản lý tài khoản</a>
							<ul class="sub-menu">
								<li><a href="tksv.html" target="test">Tài khoản sinh viên</a></li>
								<li><a href="tkgv.html" target="test">Tài khoản giảng viên</a></li>
								<li><a href="tkqt.html" target="test">Tài khoản quản trị</a></li>
							</ul>
						</li>
						<li><a href="dt(1).html" target="test">Quản lý đề tài</a>
							<ul class="sub-menu">
								<li><a href="dt(1).html" target="test">Đề tài đang thực hiện</a></li>
								<li><a href="dt(2).html" target="test">Đề tài đã hoàn thành</a></li>
							</ul>
						</li>
						<li><a href="dsgvhd.html" target="test">Thông tin hội đồng</a>
							<ul class="sub-menu">
								<li><a href="dsgvhd.html" target="test">Giảng viên hướng dẫn</a></li>
								<li><a href="dshdpb.html" target="test">DS hội đồng phản biện</a></li>
								<li><a href="dshdc.html" target="test">DS hội đồng chấm</a></li>
							</ul>
						</li>
                                                <li><a href="" >Đăng xuất</a></li>
					</ul>
				</div>
			</section>

			<!-- Noi dung -->
				<section class="right-content" style="height: 1000px;">
					<iframe name="test" frameborder="0" width="100%" height="100%"  style="overflow: scroll;overflow-y: hidden;" ></iframe>
				</section>
			
			
		</section>
		<footer class="footer">
			
		</footer>
	</div>
</body>

</html>