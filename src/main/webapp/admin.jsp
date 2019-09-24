<%@include file="inc/header.jsp" %>

<form id="msform" onsubmit="return validate_form()">
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Create a category</h2>
        <!--<h3 class="fs-subtitle">This error message</h3>-->
        <input id="description" type="text" name="description" placeholder="Description" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>

<form id="msform" onsubmit="return validate_form()">

    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Add a book</h2>
        <!--<h3 class="fs-subtitle">This error message</h3>-->
        <input id="nom" type="text" name="nom" placeholder="Name" />
        <input id="page" type="number" name="page" placeholder="page" />
        <label>Category: </label>
        <select name="category" >
            <--! to be finished by backend data -->
            <option value="1">category1</option>
            <option value="2">category2</option>
        </select>
        <input id="imageUrl" type="file" name="imageUrl" title="choose an image" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>

<%@include file="inc/footer.jsp" %>