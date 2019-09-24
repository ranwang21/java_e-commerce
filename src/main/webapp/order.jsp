<%@include file="inc/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="container cart">
    <div class="span24">
        <div class="step step1">
            <ul>
                <li class="current"></li>
                <li>order success</li>
            </ul>
        </div>
        <table>
            <tbody>
                <tr>
                    <th colspan="5">order No:<c:out value="${orderNo}" />&nbsp;&nbsp;&nbsp;&nbsp;
                    </th>
                </tr>
                <tr>
                    <th>image</th>
                    <th>name</th>
                    <th>price</th>
                    <th>count</th>
                    <th>subtotal</th>
                </tr>
                <c:forEach var="orderItem" items="${order.orderItems}">
                    <tr>
                        <td width="60">
                            <img style="width:40px;height:60px" src="<c:out value="img/${ orderItem.livre.imageUrl}"/>" />
                        </td>
                        <td><c:out value="${orderItem.livre.nom}" /></td>
                        <td>$ <c:out value="${orderItem.livre.prix}" /></td>
                        <td class="quantity" width="60"><c:out value="${orderItem.qty}" /></td>
                        <td width="140"><span class="subtotal">$<c:out	value="${orderItem.subtotal}" /></span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>total: <strong id="effectivePrice">$<c:out value="${order.total}" />
            </strong>
        </div>

        <form id="msform" action="${pageContext.request.contextPath }/pay" method="post">
            <input type="hidden" name="no" value="<c:out value="${orderNo}"/>" />

            <input type="hidden" name="orderId" value="<c:out value="${order.id}"/>" />


            <div class="span24" style="text-align: left">
                <label><strong>Address: </strong></label>
                <input style="display:block" name="addr" type="text" style="width: 250px" /><br>

                <lable><strong>Name: </strong></lable>
                <input style="display:block"  name="name" type="text" value="<c:out value="${sessionScope.user.prenom}"/>" style="width: 150px" /><br>
                <label><strong>Phone: </strong></label>
                <input style="display:block" name="phone" type="text"  style="width: 150px" /><br>

                <input style="display:block" name="total" type="hidden" value="${order.total}" />

                <hr />
                <p style="text-align: right; color:black">
                    <input  value="pay" type="submit" />
                </p>
            </div>
        </form>

    </div>
</div>


<%@include file="inc/footer.jsp" %>