<%-- 
    Document   : adminCustomerManagerPage
    Created on : Jul 13, 2023, 8:57:01 PM
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
            <div class="side-bar d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
                <a href="/" class="d-flex align-items-center mb-md-0 me-md-auto text-white text-decoration-none">
                    <div class="text-center col-lg-12 d-xs-none d-sm-none d-lg-block">
                        <span class="h1 text-primary bg-dark px-2">Elj</span>
                        <span class="h1 text-dark bg-primary px-2 ml-n1">Shop</span>
                    </div>

                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="home" class="nav-link" aria-current="page">
                            Admin Home
                        </a>
                    </li>
                    <li>
                        <a href="customer-manager?go=displayAll" class="nav-link active">
                            Customer Manager
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link">
                            Order Manager
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link">
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
                    <div class="row mb-3">
                        <div class="col-4">
                        </div>
                        <div class="col-4 text-center">
                            <form action="customer-manager" method="POST">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="searchName" placeholder="Search by name">
                                    <div class="input-group-append">
                                        <button type="submit" class="input-group-text bg-transparent text-primary" title="Search" name="adminSearchCustomerSubmit">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-4 text-right">
                        </div>
                    </div>
                    <%@include file="notification.jsp" %>
                    <c:choose>
                        <c:when test="${param.go == null || param.go == 'displayAll'}">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">List Of Customers</span></h5>
                            <table class="table table-light table-borderless table-hover text-center mb-0">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Role</th>
                                        <th>Name</th>
                                        <th>Address</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Update</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody class="align-middle">
                                    <c:forEach items="${users}" var="user">
                                        <tr>
                                            <td class="align-middle">${user.id}</td>
                                            <td class="align-middle">${user.role}</td>
                                            <td class="align-middle text-left" style="text-wrap: nowrap;">${user.firstName} ${user.lastName}</td>
                                            <td class="align-middle text-left">${user.street}, ${user.city}, ${user.province}, ${user.country}</td>
                                            <td class="align-middle">${user.email}</td>
                                            <td class="align-middle">${user.phone}</td>
                                            <td class="align-middle"><a class="product-name-in-cart" href="customer-manager?go=update&id=${user.id}">Update</a></td>
                                            <td class="align-middle">Delete</td>
                                        </tr>
                                    </c:forEach>
                                    <c:set var="orderShippingFee" value="${orderShippingFee * 5000}"></c:set>
                                    </tbody>
                                </table>
                        </c:when>
                        <c:when test="${param.go == 'update' && userToUpdate != null}">
                            <div class="col-10">
                                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Sign Up</span></h5>
                                <div class="bg-light p-30 mb-5">
                                    <div class="row">
                                        <form class="row" action="customer-manager" method="POST">
                                            <div class="col-md-6 form-group">
                                                <input type="hidden" name="userToUpdateId" value="${userToUpdate.id}">
                                                <input type="hidden" name="role" value="${userToUpdate.role}">
                                                <label>First Name</label>
                                                <input name="firstName" class="form-control" type="text" placeholder="John" value="${userToUpdate.firstName}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>Last Name</label>
                                                    <input name="lastName" class="form-control" type="text" placeholder="Doe" value="${userToUpdate.lastName}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>Street</label>
                                                    <input name="street" class="form-control" type="text" placeholder="Street" value="${userToUpdate.street}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>City</label>
                                                    <input name="city" class="form-control" type="text" placeholder="City" value="${userToUpdate.city}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>Province</label>
                                                    <input name="province" class="form-control" type="text" placeholder="Province" value="${userToUpdate.province}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>Country</label>
                                                    <input name="country" class="form-control" type="text" placeholder="Country" value="${userToUpdate.country}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>E-mail</label>
                                                    <input name="email" class="form-control" type="email" placeholder="example@email.com" value="${userToUpdate.email}" required>
                                                </div>
                                                <div class="col-md-6 form-group">
                                                    <label>Mobile No</label>
                                                    <input name="phone" class="form-control" type="tel" placeholder="123 456 7890" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" title="Ten digits code" value="${userToUpdate.phone}" required>
                                                </div>
                                                <div class="col-md-12 form-group">
                                                    <div class="row">
                                                        <div class="col-md-3 form-group">
                                                        </div>
                                                        <div class="col-md-3 form-group">
                                                            <input name="reset" class="form-control btn btn-primary" type="reset" value="Reset">
                                                        </div>
                                                        <div class="col-md-3 form-group">
                                                            <input name="adminCustomerUpdateSubmit" class="form-control btn btn-primary" type="submit" value="Update">
                                                        </div>
                                                        <div class="col-md-3 form-group">
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                        </c:when>
                    </c:choose>
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

