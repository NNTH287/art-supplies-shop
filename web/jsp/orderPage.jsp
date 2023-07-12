<%-- 
    Document   : orderPage
    Created on : Jul 11, 2023, 4:19:57 PM
    Author     : Huy Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Elj Shop - Online Art Supplies Shop</title>
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo.ico" type="image/icon type">
    </head>

    <body>
        <%@include file="header.jsp" %>

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item active">Shop List</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Order Start -->
        <div class="container-fluid">
            <c:choose>
                <c:when test="${userId == null}">
                    <div class="col-12 pb-1">
                        <p style="
                           text-align: center;
                           font-weight: 500;
                           font-size: 24px
                           ">You havn't login yet!</p>
                    </div>
                </c:when>
                <c:when test="${orders == null || orders.size() == 0}">
                    <div class="col-12 pb-1">
                        <p style="
                           text-align: center;
                           font-weight: 500;
                           font-size: 24px
                           ">You havn't buy any product yet!</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row px-xl-5">
                        <div class="col-lg-12 table-responsive mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Your Orders</span></h5> 
                            <table class="table table-light table-borderless table-hover text-center mb-0">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Receiver</th>
                                        <th>Ship Address</th>
                                        <th>Contact Email</th>
                                        <th>Contact Phone</th>
                                        <th>Created Time</th>
                                        <th>Status</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody class="align-middle">
                                    <c:forEach items="${orders}" var="order">
                                        <tr>
                                            <td class="align-middle">${order.id}</td>
                                            <td class="align-middle">${order.receiver}</td>
                                            <td class="align-middle">${order.shipStreet}, ${order.shipCity}, ${order.shipProvince}, ${order.shipCountry}</td>
                                            <td class="align-middle">${order.shipEmail}</td>
                                            <td class="align-middle">${order.shipPhone}</td>
                                            <td class="align-middle">${order.createdTime}</td>
                                            <td class="align-middle">${order.status}</td>
                                            <td class="align-middle"><a class="text-dark" href="${pageContext.request.contextPath}/order-detail?orderId=${order.id}">Details</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Order End -->

        <%@include file="footer.jsp" %>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/lib/easing/easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="${pageContext.request.contextPath}/mail/jqBootstrapValidation.min.js"></script>
        <script src="${pageContext.request.contextPath}/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
