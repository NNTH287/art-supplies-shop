<%-- 
    Document   : cartPage
    Created on : Jul 8, 2023, 3:03:38 PM
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
                        <span class="breadcrumb-item active">Shopping Cart</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Cart Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-light table-borderless table-hover text-center mb-0">
                        <thead class="thead-dark">
                            <tr>
                                <th>Products</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                            <fmt:setLocale value="vi_VN"/>
                            
                            <c:forEach items="${cart.getItems()}" var="cartItem">
                                <tr>
                                    <td class="align-middle container-fluid" style="display: flex; align-items: center;">
                                        <img src="img/product-${cartItem.productId}.jpg" alt="" style="width: 50px;">
                                        <a href="details?proId=${cartItem.productId}" title="${cartItem.productName}" class="product-name-in-cart text-truncate ml-2"> ${cartItem.productName}
                                        </a>
                                    </td>
                                    <td class="align-middle"><fmt:formatNumber type="currency" pattern="###,###¤">${cartItem.price}</fmt:formatNumber></td>
                                        <td class="align-middle">
                                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                                <div class="input-group-btn">
                                                    <button type="button" class="btn btn-sm btn-primary btn-minus" >
                                                        <i class="fa fa-minus"></i>
                                                    </button>
                                                </div>
                                                <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${cartItem.quantity}">
                                                <div class="input-group-btn">
                                                    <button type="button" class="btn btn-sm btn-primary btn-plus">
                                                        <i class="fa fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="align-middle"><fmt:formatNumber type="currency" pattern="###,###¤">${cartItem.price * cartItem.quantity}</fmt:formatNumber></td>
                                        <td class="align-middle">
                                            <button type="button" class="btn btn-sm btn-danger"><i class="fa fa-times"></i>
                                        </button></td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
                    <div class="bg-light p-30 mb-5">
                        <div class="border-bottom pb-2">
                            <div class="d-flex justify-content-between mb-3">
                                <h6>Subtotal</h6>
                                <h6 id="subtotalText">
                                    <fmt:formatNumber type="currency" pattern="###,###¤">
                                        <c:choose>
                                            <c:when test="${subtotal == null || subtotal == 0}">0</c:when>
                                            <c:otherwise>${subtotal}</c:otherwise>
                                        </c:choose>
                                    </fmt:formatNumber>
                                </h6>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <h6 class="font-weight-medium" id="shippingText">
                                    <fmt:formatNumber type="currency" pattern="###,###¤">
                                        <c:choose>
                                            <c:when test="${shippingFee == null || shippingFee == 0}">0</c:when>
                                            <c:otherwise>${shippingFee}</c:otherwise>
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
                                        ${shippingFee + subtotal}
                                    </fmt:formatNumber>
                                </h5>
                            </div>
                            <a href="checkout"><button class="btn btn-block btn-primary font-weight-bold my-3 py-3" onclick="home">Proceed To Checkout</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->

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