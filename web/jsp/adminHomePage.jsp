<%-- 
    Document   : adminHome
    Created on : Jul 12, 2023, 9:08:16 PM
    Author     : Huy Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Elj Shop - Online Art Supplies Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!<!-- Favicon -->
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo.ico" type="image/icon type">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="${pageContext.request.contextPath}/css/font-awesome_5.10.0_css_all.min.css?version=1" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/lib/animate/animate.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="${pageContext.request.contextPath}/css/style.css?version=1" rel="stylesheet">
    </head>
    <body>
        <div class="row">
            <div class="side-bar d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="height: 100vh;">
                <a href="/" class="d-flex align-items-center mb-md-0 me-md-auto text-white text-decoration-none">
                    <div class="text-center col-lg-12 d-xs-none d-sm-none d-lg-block">
                        <span class="h1 text-primary bg-dark px-2">Elj</span>
                        <span class="h1 text-dark bg-primary px-2 ml-n1">Shop</span>
                    </div>

                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="home" class="nav-link active" aria-current="page">
                            Admin Home
                        </a>
                    </li>
                    <li>
                        <a href="customer-manager?go=displayAll" class="nav-link">
                            Customer Manager
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link">
                            Order Manager
                        </a>
                    </li>
                    <li>
                        <a href="product-manager?go=displayAll" class="nav-link">
                            Product Manager
                        </a>
                    </li>
                </ul>
            </div>
            <div style="margin-left: 20%;" class="p-3 table-responsive mb-5">
                <div class="col">
                    <div class="row mt-3 mb-3">
                        <div class="col-4 text-left">
                            <h6>Welcome Admin: ${adminName}</h6>
                        </div>
                        <div class="col-4">
                        </div>
                        <div class="col-4 text-right">
                            <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Log out</a>
                        </div>
                    </div>
                    </div>
                </div>
            </div>

            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <script src="${pageContext.request.contextPath}/lib/easing/easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
