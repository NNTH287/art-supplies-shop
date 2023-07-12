<%-- 
    Document   : checkoutPage
    Created on : Jul 9, 2023, 6:45:32 AM
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

        <fmt:setLocale value="vi_VN"/>
        <!-- Checkout Start -->
        <form action="order" method="POST">
            <div class="container-fluid">
                <div class="row px-xl-5">
                    <div class="col-lg-8">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label>First Name</label>
                                    <input name="firstName" class="form-control" type="text" placeholder="John" <c:if test="${userId != null}">value="${firstName}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Last Name</label>
                                        <input name="lastName" class="form-control" type="text" placeholder="Doe" <c:if test="${userId != null}">value="${lastName}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Street</label>
                                        <input name="street" class="form-control" type="text" placeholder="Street" <c:if test="${userId != null}">value="${street}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>City</label>
                                        <input name="city" class="form-control" type="text" placeholder="City" <c:if test="${userId != null}">value="${city}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Province</label>
                                        <input name="province" class="form-control" type="text" placeholder="Province" <c:if test="${userId != null}">value="${province}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Country</label>
                                        <input name="country" class="form-control" type="text" placeholder="Country" <c:if test="${userId != null}">value="${country}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>E-mail</label>
                                        <input name="email" class="form-control" type="email" placeholder="example@email.com" <c:if test="${userId != null}">value="${email}"</c:if> required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Mobile No</label>
                                        <input name="phone" class="form-control" type="tel" placeholder="123 456 7890" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" title="Ten digits code" <c:if test="${userId != null}">value="${phone}"</c:if> required>
                                    </div>
                                <c:if test="${userId == null}">
                                    <div class="collapse col-md-6 form-group"  id="passwordSection">
                                        <label>Password</label>
                                        <input name="password" class="form-control" type="password" minlength="8">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="newAccount">
                                            <label class="custom-control-label" for="newAccount" data-toggle="collapse" data-target="#passwordSection">Create an account</label>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div class="collapse mb-5" id="creditCard-info">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Credit Card Information</span></h5>
                            <div class="bg-light p-30">
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label>Card Number</label>
                                        <input class="credit-card-info form-control" type="text" <c:if test="${cardNumber != null}">value="${cardNumber}"</c:if> placeholder="0000000000000000">
                                        </div>
                                        <div class="col-md-6 form-group">
                                            <label>Expiration Date</label>
                                            <input class="credit-card-info form-control" type="month" <c:if test="${cardNumber != null}">value="${expirationYear}-${expirationDate}"</c:if> placeholder="mm-yy" pattern="[0-9]{2}-[0-9]{2}">
                                        </div>
                                        <div class="col-md-6 form-group">
                                            <label>CVV</label>
                                            <input class="credit-card-info form-control" type="text" <c:if test="${cardNumber != null}">value="${cvv}"</c:if> placeholder="123">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                            <div class="bg-light p-30 mb-5">
                                <div class="border-bottom">
                                    <h6 class="mb-3">Products</h6>
                                <c:forEach items="${cart.getItems()}" var="cartItem">
                                    <div class="d-flex justify-content-between">
                                        <p>${cartItem.productName}</p>
                                        <p><fmt:formatNumber type="currency" pattern="###,###¤">${cartItem.price}</fmt:formatNumber></p>
                                        </div>
                                </c:forEach>
                            </div>
                            <div class="border-bottom pt-3 pb-2">
                                <div class="d-flex justify-content-between mb-3">
                                    <h6>Subtotal</h6>
                                    <h6>
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
                                    <h6 class="font-weight-medium">
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
                                    <h5>
                                        <fmt:formatNumber type="currency" pattern="###,###¤">
                                            ${shippingFee + subtotal}
                                        </fmt:formatNumber>
                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                            <div class="bg-light p-30">
                                <div class="form-group">
                                    <div class="custom-control custom-radio" data-toggle="collapse" data-target="#creditCard-info:not(.show)">
                                        <input type="radio" class="custom-control-input" name="payment" id="creditCard">
                                        <label class="custom-control-label" for="creditCard">Credit Card</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-radio" data-toggle="collapse" data-target="#creditCard-info.show">
                                        <input type="radio" class="custom-control-input" name="payment" id="cod" checked>
                                        <label class="custom-control-label" for="cod">Cash On Delivery</label>
                                    </div>
                                </div>
                                <input type="submit" class="btn btn-block btn-primary font-weight-bold py-3" value="Place Order">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Checkout End -->

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
