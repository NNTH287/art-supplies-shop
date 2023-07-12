<%-- 
    Document   : orderDetailPage
    Created on : Jul 12, 2023, 10:16:01 AM
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
                    <fmt:setLocale value="vi_VN"/>
                    <div class="row px-xl-5">
                        <div class="col-lg-8 table-responsive mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Details Of Order ${orderDetails.get(0).orderId}</span></h5>
                            <table class="table table-light table-borderless table-hover text-center mb-0">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Product Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody class="align-middle">
                                    <c:set var="orderSubtotal" value="${0}"></c:set>
                                    <c:set var="orderShippingFee" value="${0}"></c:set>
                                    <c:forEach items="${orderDetails}" var="orderDetail">
                                        <tr>
                                            <td class="align-middle">${orderDetail.id}</td>
                                            <td class="align-middle container-fluid" style="display: flex; align-items: center;">
                                                <img src="img/product-${orderDetail.productId}.jpg" alt="" style="width: 50px;">
                                                <a href="${pageContext.request.contextPath}/details?proId=${orderDetail.productId}" title="${orderDetail.productName}" class="product-name-in-cart text-truncate ml-2"> ${orderDetail.productName}
                                                </a>
                                            </td>
                                            <td class="align-middle"><fmt:formatNumber type="currency" pattern="###,###¤">${orderDetail.price}</fmt:formatNumber></td>
                                            <td class="align-middle">${orderDetail.quantity}</td>
                                            <td class="align-middle"><fmt:formatNumber type="currency" pattern="###,###¤">${orderDetail.price * orderDetail.quantity}</fmt:formatNumber></td>
                                        </tr>
                                        <c:set var="orderSubtotal" value="${orderSubtotal + (orderDetail.price*orderDetail.quantity)}"></c:set>
                                        <c:set var="orderShippingFee" value="${orderShippingFee + orderDetail.quantity}"></c:set>
                                    </c:forEach>
                                    <c:set var="orderShippingFee" value="${orderShippingFee * 5000}"></c:set>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-lg-4">
                                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Summary</span></h5>
                                <div class="bg-light p-30 mb-5">
                                    <div class="border-bottom pb-2">
                                        <div class="d-flex justify-content-between mb-3">
                                            <h6>Subtotal</h6>
                                            <h6 id="subtotalText">
                                            <fmt:formatNumber type="currency" pattern="###,###¤">
                                                <c:choose>
                                                    <c:when test="${orderSubtotal == null || orderSubtotal == 0}">0</c:when>
                                                    <c:otherwise>${orderSubtotal}</c:otherwise>
                                                </c:choose>
                                            </fmt:formatNumber>
                                        </h6>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <h6 class="font-weight-medium">Shipping</h6>
                                        <h6 class="font-weight-medium" id="shippingText">
                                            <fmt:formatNumber type="currency" pattern="###,###¤">
                                                <c:choose>
                                                    <c:when test="${orderShippingFee == null || orderShippingFee == 0}">0</c:when>
                                                    <c:otherwise>${orderShippingFee}</c:otherwise>
                                                </c:choose>
                                            </fmt:formatNumber>
                                        </h6>
                                    </div>
                                </div>
                                <div class="pt-2">
                                    <div class="d-flex justify-content-between mt-2">
                                        <h5>Total</h5>
                                        <h5 id="totalText">
                                            <fmt:formatNumber type="currency" pattern="###,###¤">
                                                ${orderShippingFee + orderSubtotal}
                                            </fmt:formatNumber>
                                        </h5>
                                    </div>
                                </div>
                            </div>
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
