<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<!--I have checked the website with the following browsers:
      IE11, Firefox, Chrome-->
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, inital-scale=1.0">
        <title>My Bookself</title>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
        <link href="css/normalize.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="img/favicon_site.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://unpkg.com/lookforward@0.1.1/css/lookforward.min.css">
        <!--        import JQuery from CDN-->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <!--        import jquery msgbox and other plugins-->
        <script src="js/jquery.msgbox.min.js"></script>
        <script src="https://unpkg.com/lookforward@0.1.1/js/lookforward.min.js"></script>
        <!--        import main javascript file-->
        <script src="js/app.js"></script>
    </head>

    <body>

        <header class="main-header clearfix">
            <div class="container">

                <div class="clearfix">
                    <h1 class="name"><a href="${pageContext.request.contextPath}/">My Bookself</a></h1>
                    <nav class="main-nav">
                        <ul>

                            <c:forEach items="${listCategory }" var="list">
                                <li><a href="${pageContext.request.contextPath}/livreC?idCategory=${list.id}"><strong>${list.description}</strong></a></li>
                                        </c:forEach>




                        </ul>
                    </nav>
                </div>

                <div class="clearfix">
                    <ul class="sign_in_out">



                        <c:if test="${not empty sessionScope.user}">
                            <li><a ><strong>Welcome, ${sessionScope.user.prenom }  ${sessionScope.user.nom }</strong></a></li>
                            <li><a href="${pageContext.request.contextPath}/UserLoginOut"><strong>logout</strong></a></li>
                            </c:if>
                            <c:if test="${empty sessionScope.user}">
                            <li><a href="${pageContext.request.contextPath}/signin.jsp"><strong>Login</strong></a></li>
                            <li><a href="${pageContext.request.contextPath}/signup.jsp"><strong>Sign Up</strong></a></li>
                            </c:if>
                        <!-- show cart -->
                        <li><a href="${pageContext.request.contextPath}/cart.jsp"><strong>My Cart</strong></a></li>

                    </ul>
                </div>


            </div>
        </header>

        <div class="container clearfix">