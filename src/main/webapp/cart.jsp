<%@include file="inc/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container cart">
    <c:if test="${fn:length(sessionScope.cart.cartItems) != 0 }">
        <div class="span24">
            <table>
                <tbody>
                    <tr>
                        <th>Image</th>
                        <th>product</th>
                        <th>price</th>
                        <th>count</th>
                        <th>subtotal</th>
                        <th>option</th>
                    </tr>

                    <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                        <tr>
                            <td width="60">
                                <a href="${pageContext.request.contextPath }/livreC?idLivre=<c:out value="${cartItem.livre.id}"/>">
                                    <img style="width:40px" src="<c:out value="img/${cartItem.livre.imageUrl}"/>"/>
                                </a>
                            </td>
                            <td>
                                <a target="_blank" href="${pageContext.request.contextPath }/livreC?idLivre=<c:out value="${cartItem.livre.id}"/>">
                                    <c:out value="${cartItem.livre.nom}"/></a>
                            </td>
                            <td style="width:120px">${cartItem.livre.prix }</td>
                            <td class="quantity" width="60" style="width:120px">


                                <a style="width:20px" type="button" class="countAdjust" href="${pageContext.request.contextPath }/ReduceCount?id=${cartItem.livre.id}&count=${cartItem.count-1}" >-</a>
                                <span class="countAdjust" href="" >${cartItem.count}</span>
                                <a style="width:20px" type="button" href="${pageContext.request.contextPath }/addCount?id=${cartItem.livre.id}&count=${cartItem.count+1}" >+</a>

                            </td>
                            <td width="140">
                                <span class="subtotal">$ <fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${cartItem.subtotal}" /></span>
                            </td>
                            <td><a class="link_button" href="${ pageContext.request.contextPath }/removeCart?pid=<c:out value="${cartItem.livre.id}"/>"><String>Delete</strong></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div >

                <div style="float:right;margin-left: 50px;">
                    <a href="${ pageContext.request.contextPath }/clearCart"
                       id="clear"  class="link_button">Clear Cart</a>
                </div>
                <div style="float:right;margin-left: 50px;">
                    <a href="${pageContext.request.contextPath}/saveOrder"  id="Submit"  class="link_button">submit</a>
                </div>
            </div>
        </div>
    </c:if>
</div>




<%@include file="inc/footer.jsp" %>