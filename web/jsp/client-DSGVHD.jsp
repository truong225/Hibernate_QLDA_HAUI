<%-- 
    Document   : client-index
    Created on : May 26, 2017, 4:33:42 PM
    Author     : we
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html><!-- InstanceBegin template="/Templates/client-template.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta charset="utf-8">
        <!-- InstanceBeginEditable name="doctitle" -->
        <title>Hệ thống quản lý đồ án tốt nghiệp Đại Học Công Nghiệp Hà Nội</title>
        <!-- InstanceEndEditable -->
        <!-- InstanceBeginEditable name="head" -->
        <!-- InstanceEndEditable -->

        <!-- Bootstrap -->
        <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- Datatables -->
        <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../build/css/custom.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet" type="text/css">
    </head>

    <body style="background: #FFF">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container" style="">
                <div class="logo">
                    <div> <img src="../images/haui_lg.png" width="40px" alt="Đại học công nghiệp hà nội"> <span style="color: white; font-weight: bold" >HỆ THỐNG QUẢN LÝ ĐỒ ÁN TỐT NGHIỆP</span> </div>
                </div>
            </div>
        </nav>
        <!-- InstanceBeginEditable name="Content" -->
        <div class="container" >
            <div class="row" style="margin-top:60px ">
                <div class="">
                    <h2>Danh sách giảng viên hướng dẫn</h2>
                </div>
                <f:form action="loadDSGVHD.htm" method="GET">
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
            </div>
            <div class="x_panel" style="margin-top: 30px">
                <c:forEach var="x" items="${listGVHD}">
                    <div class="col-md-55">
                        <div class="thumbnail">
                            <div class="image view view-first">
                                <img style="width: 100%; display: block;" src="../images/${x.userAvatar}" alt="image">
                                <div class="mask no-caption">
                                    <div class="tools tools-bottom">
                                        <a href="#"><i class="fa fa-link"></i></a>
                                        <a href="#"><i class="fa fa-pencil"></i></a>
                                        <a href="#"><i class="fa fa-times"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="caption">
                                <p><strong>${x.userDegree} ${x.userFullname}</strong>
                                </p>
                                <p>${x.userEmail}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

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

<!-- jQuery -->
<script src="../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../vendors/iCheck/icheck.min.js"></script>
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
<!-- InstanceEnd --></html>
