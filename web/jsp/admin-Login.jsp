<%-- 
    Document   : admin-Login
    Created on : Apr 24, 2017, 10:13:15 AM
    Author     : we
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Hệ thống quản lý đồ án tốt nghiệp</title>
        <link rel="stylesheet" href="../css/back-end-login.css">
    </head>
    <body>
        <div class="content">
            <h2>Đăng nhập</h2>
            <f:form action="Login.htm" method="GET" commandName="User">
                <div class="loginContent">
                    <table class="tbLogin">
                        <tr>
                            <td><input id="userName" name="userName" type="input" placeholder="Tên đăng nhập"></td>
                        </tr>
                        <tr>
                            <td><input id="userPassword" name="userPassword" type="Password" placeholder="Mật khẩu"></td>
                        </tr>
                        <tr>

                            <td>
                                <input type="submit" value="Dang nhap"/>
                        </tr>
                    </table>
                </div>
            </f:form>
        </div>

    </body>
</html>