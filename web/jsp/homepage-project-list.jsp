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
                    <button  OnClick="Unnamed_Click" class="btn btn-default new-btn" />❮ Trang chủ</button>
                </div>
                <div style="margin-top: -35px; float: right; margin-right: 30px">
                    <Button Text="Đăng nhập ❯" OnClick="Unnamed_Click1" class="btn btn-success new-btn" >Đăng nhập ❯</button>
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
<script src="../build/js/jquery.min.js"></script>
<script src="../build/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#myTable").DataTable();
    });
    function redirect_to_login(id) {
        window.location.href = "User_Login.aspx?pjid=" + id;
    }
</script>
<script src="../build/js/custom.min.js"></script>

<!-- InstanceEnd --></html>
