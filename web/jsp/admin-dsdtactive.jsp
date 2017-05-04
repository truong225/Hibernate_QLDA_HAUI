<%-- 
    Document   : tksv
    Created on : Apr 29, 2017, 2:35:58 PM
    Author     : we
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<li onClick="location.href='initLogin.htm'">Đăng xuất</li>
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
							</ul>
						</li>
						<li><a href="initDSDTActive.htm" >Quản lý đề tài</a>
							<ul class="sub-menu">
								<li><a href="initDSDTActive.htm" >Đề tài đang thực hiện</a></li>
								<li><a href="initDSDTNonActive.htm" >Đề tài đã hoàn thành</a></li>
							</ul>
						</li>
						<li><a href="dsgvhd.html" >Thông tin hội đồng</a>
							<ul class="sub-menu">
								<li><a href="dsgvhd.html" >Giảng viên hướng dẫn</a></li>
								<li><a href="dshdpb.html" >DS hội đồng phản biện</a></li>
								<li><a href="dshdc.html" >DS hội đồng chấm</a></li>
							</ul>
						</li>
						<li><a href="initLogin.htm" >Đăng xuất</a></li>
					</ul>
				</div>
			</section>

			<!-- Noi dung -->
				<section class="right-content" style="height: auto;"><!-- InstanceBeginEditable name="Noidung" -->
      <div> DANH SÁCH SINH VIÊN </div>
      <div>
          <input id="btn_add" value="Thêm" type="button"/>
      </div>
      <div>
         <table id="myTable" class="table table-striped table-bordered" style="width: 100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên đề tài</th>
                        <th>SV Thực hiện</th>
                        <th>Giảng viên HD</th>
                        <th>Ngày bắt đầu</th>
                        <th>Số lần báo cáo</th>
                        <th>Trạng thái</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="x" items="${lsDT}" >
                    <tr>
                        <td>${x.getProjectId()}</td>
                        <td>${x.getProjectName()}</td>
                        <td>${x.getUsers().getUserId()}</td>
                        <td>${x.getProjectInstructorid()}</td>
                        <td>${x.getProjectStartdate()}</td>
                        <td>${x.getProjectViewcount()}</td>
                        <td>${x.getProjectStatus()}</td>
                        <td><a href="#" style="color: blue">Update</a></td>
                        <td><a href="#" style="color: blue">Xóa</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
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

