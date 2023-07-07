<%-- 
    Document   : shopPage
    Created on : Jul 5, 2023, 5:03:41 PM
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
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!<!-- Favicon -->
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo.ico" type="image/icon type">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/lib/animate/animate.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="${pageContext.request.contextPath}/css/style.css?version=1" rel="stylesheet">
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

        <!-- Shop Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <!-- Shop Sidebar Start -->
                <div class="col-lg-3 col-md-4">
                    <form action="shop" method="GET">
                        <!-- Categories Start -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Categories</span></h5>
                        <div class="bg-light p-4 mb-30">
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" id="cate-all" name="cateId" value="-1" onclick="this.form.submit()" <c:if test="${param.cateId == -1 || param.cateId == null}">checked</c:if>>
                                    <label class="custom-control-label" for="cate-all">All</label>
                            </div>
                            <c:forEach items="${categories}" var="cate">
                                <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                    <input type="radio" class="custom-control-input" id="cate-${cate.key.id}" name="cateId" value="${cate.key.id}" onclick="this.form.submit()" <c:if test="${param.cateId == cate.key.id}">checked</c:if>>
                                    <label class="custom-control-label" for="cate-${cate.key.id}">${cate.key.name}</label>
                                </div>
                            </c:forEach>
                        </div>
                        <!-- Categories End -->
                        
                        <!-- Price Start -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Price</span></h5>
                        <div class="bg-light p-4 mb-30">
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" name="price" id="priceAll" value="" onclick="this.form.submit()" <c:if test="${param.price == null || param.price == ''}">checked</c:if>>
                                <label class="custom-control-label" for="priceAll">All</label>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" name="price" id="price1" value="0-100000" onclick="this.form.submit()" <c:if test="${param.price == '0-100000'}">checked</c:if>>
                                <label class="custom-control-label" for="price1">Below 100.000đ</label>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" name="price" id="price2" value="100000-200000" onclick="this.form.submit()" <c:if test="${param.price == '100000-200000'}">checked</c:if>>
                                <label class="custom-control-label" for="price2">100.000đ - 200.000đ</label>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" name="price" id="price3" value="200000-500000" onclick="this.form.submit()" <c:if test="${param.price == '200000-500000'}">checked</c:if>>
                                <label class="custom-control-label" for="price3">200.000đ - 500.000đ</label>
                            </div>
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" name="price" id="price4" value="500000-100000000" onclick="this.form.submit()" <c:if test="${param.price == '500000-100000000'}">checked</c:if>>
                                <label class="custom-control-label" for="price4">Above 500.000đ</label>
                            </div>
                        </div>
                        <!-- Price End -->

                        <!-- Brand Start -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Brands</span></h5>
                        <div class="bg-light p-4 mb-30">
                            <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="radio" class="custom-control-input" id="brand-all" name="brandId" value="-1" onclick="this.form.submit()" <c:if test="${(param.brandId == -1) || (param.brandId == null)}">checked</c:if>>
                                    <label class="custom-control-label" for="brand-all">All</label>
                            </div>
                            <c:forEach items="${brands}" var="brand">
                                <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                    <input type="radio" class="custom-control-input" id="brand-${brand.key.id}" name="brandId" value="${brand.key.id}" onclick="this.form.submit()" <c:if test="${param.brandId == brand.key.id}">checked</c:if>>
                                    <label class="custom-control-label" for="brand-${brand.key.id}">${brand.key.name}</label>
                                </div>
                            </c:forEach>
                        </div>
                    </form>
                    <!-- Brand End -->
                </div>
                <!-- Shop Sidebar End -->

                <!-- Shop Product Start -->
                <div class="col-lg-9 col-md-8">
                    <div class="row pb-3">
                        <div class="col-12 pb-1">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <div>
                                    <!--                                    <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                                                        <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>-->
                                </div>
                                <div class="ml-2">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">Latest</a>
                                            <a class="dropdown-item" href="#">Popularity</a>
                                            <a class="dropdown-item" href="#">Best Rating</a>
                                        </div>
                                    </div>
                                    <div class="btn-group ml-2">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">10</a>
                                            <a class="dropdown-item" href="#">20</a>
                                            <a class="dropdown-item" href="#">30</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <c:if test="${products.size() == 0}">
                        <div class="col-12 pb-1">
                            <p style="text-align: center;
                                       font-weight: 500;
                                       font-size: 24px
                               ">No matching products found</p>
                        </div>
                    </c:if>
                        <c:forEach items="${products}" var="pro">
                            <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                                <div class="product-item bg-light mb-4">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="${pageContext.request.contextPath}/img/product-${pro.id}.jpg" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a title="${pro.name}" class="h6 text-decoration-none text-truncate" href="">${pro.name}</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <c:set var="currentPrice" value="${pro.price * (1-pro.discount)}"/>
                                            <fmt:setLocale value="vi_VN"/>
                                            <h5 class="text-primary"><fmt:formatNumber type="currency" pattern="###,###¤">${currentPrice}</fmt:formatNumber></h5>
                                            <c:if test="${currentPrice < pro.price}">
                                                <h6 class="text-muted ml-2">
                                                    <del><fmt:formatNumber type="currency" pattern="###,###¤">${pro.price}</fmt:formatNumber></del>
                                                    </h6>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-12">
                            <nav>
                                <ul class="pagination justify-content-center">
                                    <li class="page-item disabled"><a class="page-link" href="#">Previous</span></a></li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- Shop Product End -->
            </div>
        </div>
        <!-- Shop End -->

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
