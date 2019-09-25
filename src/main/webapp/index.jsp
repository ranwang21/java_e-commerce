<%@include file="inc/header.jsp" %>

<section>
    <h2 id="portfolio">BooksForSales</h2>
    <!--    iterate here to show corresponding articles-->
    <div class="flex-container">
        <c:forEach items="${listLivre}" var="livre">
            <article class="project clearfix"> <!--clearfix the alignment issue of articles-->

                <a href="${pageContext.request.contextPath}/livreC?idLivre=${livre.id}">


                    <img style="max-width:140px; max-height:200px" src="img/${livre.imageUrl}" alt="portfolio-1">
                    <h3>${livre.nom}</h3>
                    <quote>${livre.description}</quote>
                    <p>Price: $ ${livre.prix}</p>

                </a>
            </article>
        </c:forEach>
    </div>

</section>


<%@include file="inc/footer.jsp" %>

