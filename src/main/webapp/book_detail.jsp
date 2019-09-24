<%@include file="inc/header.jsp" %>

<article class="project_detail">

    <form id="msform" action="${ pageContext.request.contextPath }/addCart" method="post">

        <input type="hidden" name="pid" value="<c:out value="${livreById.id }"/>" />

        <img src="img/${livreById.imageUrl}" alt="portfolio-1" />
        <h3>${livreById.nom}</h3>
        <p>Number of pages: ${livreById.page}</p>
        <p>Description: ${livreById.description}</p>
        <p>$ ${livreById.prix}</p>

        <tr class="quantity">
            <td>Quantity:</td>
            <td>
                <input id="count" name="count" value="1" maxlength="5"
                       type="number" min="0" onpaste="return false;" />
            </td>
        </tr>


        <input  value="Add to Cart" type="submit" />
    </form>
</artical>



<%@include file="inc/footer.jsp" %>
