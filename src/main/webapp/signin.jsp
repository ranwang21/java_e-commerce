<%@include file="inc/header.jsp" %>

<form id="msform" method="post" action="${pageContext.request.contextPath}/UserC">
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Sign in</h2>
        <!--<h3 class="fs-subtitle">This error message</h3>-->
        <span style="color:red">${msg}</span>
        <input type="hidden" name="method" value="signin"/>
        <input type="text" name="email" placeholder="Email" />
        <input type="password" name="password" placeholder="Password" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>

<%@include file="inc/footer.jsp" %>