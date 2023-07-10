<%-- 
    Document   : signupPage
    Created on : Jul 10, 2023, 10:55:09 PM
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

        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Sign Up</span></h5>
                    <div class="bg-light p-30 mb-5">
                        <div class="row">
                            <form class="row" action="signup" method="POST">
                                <div class="col-md-6 form-group">
                                    <label>First Name</label>
                                    <input name="firstName" class="form-control" type="text" placeholder="John" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Last Name</label>
                                    <input name="lastName" class="form-control" type="text" placeholder="Doe" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input name="email" class="form-control" type="email" placeholder="example@email.com" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Mobile No</label>
                                    <input name="phone" class="form-control" type="tel" placeholder="123 456 7890" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" title="Ten digits code" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Password</label>
                                    <input name="password" class="form-control" type="password" minlength="8" required>
                                </div>
                                <div class="col-md-6 form-group">
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="row">
                                        <div class="col-md-3 form-group">
                                        </div>
                                        <div class="col-md-3 form-group">
                                            <input name="reset" class="form-control btn btn-primary" type="reset" value="Reset">
                                        </div>
                                        <div class="col-md-3 form-group">
                                            <input name="signupSubmit" class="form-control btn btn-primary" type="submit" value="Sign Up">
                                        </div>
                                        <div class="col-md-3 form-group">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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