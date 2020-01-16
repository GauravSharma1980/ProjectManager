<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="pagedListHolder" scope="request" class="org.springframework.beans.support.PagedListHolder"/>
<html>
<head>
<meta charset="utf-8"/>
<%-- <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" /> --%>
	<link ref = "stylesheet" href = "/public/lib/css/style.css">
<title>Product Manager</title>
</head>
<body>
<form:form action="sortHomePage" method = "post" modelAttribute="Product">
<div class = "container">
    <h1>Product List</h1>
    <a href="/new">Create New Product</a>
    <br/><br/>
    <table class ="table" border="1" cellpadding="10">
        <thead>
            <tr>
               <c:choose>
                 <c:when test="${sortById == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByProductIdAsc" title = "Product ID">Product ID</button>
                 </th>
                 </c:when>
                 <c:when test="${sortById == 'desc' }">
                <th class="thead" width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByProductIdDesc" title = "Product ID">Product ID</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByProductIdAsc" title = "Product ID">Product ID</button>
                 </th>
                </c:otherwise>
                </c:choose> 
                <c:choose>
                 <c:when test="${sortByName == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByNameAsc" title = "Name">Name</button>
                 </th>
                 </c:when>
                 <c:when test="${sortByName == 'desc' }">
                <th class="thead"  width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByNameDesc" title = "Name">Name</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByNameAsc" title = "Name">Name</button>
                 </th>
                </c:otherwise>
                </c:choose> 
               <c:choose>
                 <c:when test="${sortByBrand == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByBrandAsc" title = "Name">Brand</button>
                 </th>
                 </c:when>
                 <c:when test="${sortByBrand == 'desc' }">
                <th class="thead" width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByBrandDesc" title = "Name">Brand</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByBrandAsc" title = "Name">Brand</button>
                 </th>
                </c:otherwise>
                </c:choose> 
                <c:choose>
                 <c:when test="${sortByModel == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByModelAsc" title = "Model">Model</button>
                 </th>
                 </c:when>
                 <c:when test="${sortByModel == 'desc' }">
                <th class="thead" width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByModelDesc" title = "Model">Model</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByModelAsc" title = "Model">Model</button>
                 </th>
                </c:otherwise>
                </c:choose> 
                <c:choose>
                 <c:when test="${sortByModel == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByMadeInAsc" title = "Made In">Made In</button>
                 </th>
                 </c:when>
                 <c:when test="${sortByModel == 'desc' }">
                <th class="thead"  width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByMadeInDesc" title = "Made In">Made In</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByMadeInAsc" title = "Made In">Made In</button>
                 </th>
                </c:otherwise>
                </c:choose> 
                 <c:choose>
                 <c:when test="${sortByPrice == 'asc' }">
                <th class="thead" width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByPriceAsc" title = "Price">Price</button>
                 </th>
                 </c:when>
                 <c:when test="${sortByPrice == 'desc' }">
                <th class="thead" width= "16%" class= "sorting_asc">
                  <button type = "submit" name = "eventName" value = "sortByPriceDesc" title = "Price">Price</button>
                 </th>
                </c:when> 
                <c:otherwise>
                <th class="thead"  width= "16%" class= "sorting_desc">
                  <button type = "submit" name = "eventName" value = "sortByPriceAsc" title = "Price">Price</button>
                 </th>
                </c:otherwise>
                </c:choose> 
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
       <c:url value="/" var="pagedLink">
<c:param name="action" value="list"/>
<c:param name="p" value="~"/>
	</c:url>  
              <c:forEach items="${pagedListHolder.pageList}" varStatus="status" var="prodList">
              <tr>
               <td class ="centerAlign">${prodList.id}</td>
               <td class ="centerAlign">${prodList.name}</td>
               <td class ="centerAlign">${prodList.brand}</td>
               <td class ="centerAlign">${prodList.model}</td>
               <td class ="centerAlign">${prodList.madein}</td>
               <td class ="centerAlign">${prodList.price}</td>
               <td><a href = "/delete?id=${prodList.id}">Delete</a>&nbsp;<a href = "/edit?id=${prodList.id}">Edit</a></td>
               </tr>
                </c:forEach>
            </tbody>
             <tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/> 
    </table>
</div>
</form:form>  
</body>
</html>