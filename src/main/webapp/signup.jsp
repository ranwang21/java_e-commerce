<%@include file="inc/header.jsp" %>

<form id="msform" onsubmit="return validate_form()" method="post" action="${pageContext.request.contextPath}/UserC">
    <!-- fieldsets -->
    <fieldset>

        <h2 class="fs-title">Create your account</h2>
        <!--<h3 class="fs-subtitle">This error message</h3>-->
        <input type="hidden" name="method" value="signup"/>
        <input id="signup_email" type="text" name="email" placeholder="Email" />
        <input id="signup_password" type="password" name="password" placeholder="Password" />
        <input id="signup_confirm_password" type="password" name="cpass" placeholder="Confirm Password" />
        <input id="prenom" type="text" name="prenom" placeholder="Firstname" />
        <input id="nom" type="text" name="nom" placeholder="Lastname" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>

<%@include file="inc/footer.jsp" %>