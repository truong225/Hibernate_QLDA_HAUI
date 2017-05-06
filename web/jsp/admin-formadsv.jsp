<%-- 
    Document   : admin-formadsv
    Created on : May 6, 2017, 10:36:43 PM
    Author     : we
--%>

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
			<li><a href="Login.html" >Đăng xuất</a></li>
		</ul>
	</div>
</section>
<!-- Noi dung -->
<section class="right-content" style="height: auto;"><!-- InstanceBeginEditable name="Noidung" -->
<div> Thêm Sinh Viên </div>

<div>
	<table class="form-add">
		<tr>
			<td>
				<td>Tên đăng nhập (*): </td>
				<td>
					<input type="text" >
				</td>
			</td>
			<td>
				<td>Mật khẩu (*): </td>
				<td><input type="password"></td>
			</td>
			
		</tr>
		<tr>
			<td>
				<td>Họ tên: </td>
				<td>
					<input type="text" >
				</td>
			</td>
			<td>
				<td>Ngày sinh: </td>
				<td><input type="date"></td>
			</td>
		</tr>
		<tr>
			<td>
				<td>Giới tính: </td>
				<td>
					<input type="radio" name="gender" value="0" checked>Nam
					<input type="radio" name="gender" value="0" >Nữ
				</td>
			</td>
			<td>
				<td>Khoa: </td>
				<td><input type="text"></td>
			</td>
		</tr>
		<tr>
			<td>
				<td>Email: </td>
				<td>
					<input type="text">
				</td>
			</td>
			<td>
				<td>Số điện thoại: </td>
				<td><input type="text"></td>
			</td>
		</tr>
		<tr>
			<td>
				<td>Địa chỉ: </td>
				<td>
					<input type="text">
				</td>
			</td>
		</tr>
		<tr>
			<td>
				<td>Ghi chú: </td>
				<td>
					<textarea name="" id="" cols="25" rows="5"></textarea>
				</td>
			</td>
		</tr>
	</table>
	<div class="btn">
		<div style="width: 310px; margin: 0 auto">
			<input class="btn_add1" type="button" value="Thêm">
			<input class="btn_add1" type="button" value="Lưu">
			<input class="btn_add1" type="button" value="Hủy">
		</div>
	</div>
	
</div>

<!-- InstanceEndEditable -->

</section>


</section>
<footer class="footer">

</footer>
<div style="clear: both"></div>
</div>
</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<script>
		$(document).ready(function(){
			$("#myTable").DataTable();
		});
</script>
<!-- InstanceEnd --></html>