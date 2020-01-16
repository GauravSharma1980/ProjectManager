<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<head>
<meta charset="utf-8"/>
<title>Product Manager</title>
</head>
<body>
<div align="center">
    <h1>Product List</h1>
            Edit Existing Product
    <br/><br/>
    
    <springForm:form action = "save" method = "post" modelAttribute = "Product" >
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Made In</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
               <tr>
               <td><input type = "text"  name = "id" value = ${product.id} readonly="readonly"></td>
               <td><input type = "text"  name = "name" value = ${product.name}></td>
               <td><input type = "text"  name = "brand" value = ${product.brand}></td>
               <td><input type = "text"  name = "model" value = ${product.model}></td>
               <td><input type = "text"  name = "madein" value = ${product.madein}></td>
               <td><input type = "text"  name = "price" value = ${product.price}></td>
               <td><input type = "Submit" value = "Update"/>
               </tr>
            </tbody>   
      </table>
      <div>
        ${modelError}
        <springForm:errors path ="brand" ></springForm:errors>
      </div>
    </springForm:form>
</div>   
</body>
</html>