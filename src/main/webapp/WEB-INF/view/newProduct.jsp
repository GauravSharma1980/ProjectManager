<!DOCTYPE html>
<html>  
<head>
<meta charset="utf-8"/>
<title>Product Manager</title>
</head>
<body>
<div align="center">
    <h1>Product List</h1>
    <a href="/new">Create New Product</a>
    <br/><br/>
    
     <form action="save" modelAttribute="Product" method="post">
    <table border="1" cellpadding="10">
        <tbody>
                <tr>
                 <td>Name</td>
               <td><input type="text" id = "name" name= "name" /></td>
               </tr>
                
                <tr>
                 <td>Brand</td>
               <td><input type="text"  id = "brand" name = "brand"  /></td>
               </tr>
                <tr>
                 <td>Model</td>
               <td><input type="text"  id = "model" name = "model"  /></td>
               </tr>
                <tr>
                <td>Made In</td>
               <td><input type="text"  id = "madein" name = "madein"  /></td>
               </tr>
                <tr>
                <td>Price</td>
               <td><input type="text" id = "price"  name = "price"  /></td>
               </tr>
               
               <tr>
                  <td><input type = "submit" value =  "Submit"/></td>
                  <td><input type = "button" value = "Cancel" onclick="clearAll();"/></td>
               </tr>
        </tbody>
    </table>
    </form>
</div> 

<script>

function clearAll()
{
    document.getElementById("name").value = '';
    document.getElementById("brand").value = '';
    document.getElementById("model").value = '';
    document.getElementById("madein").value = '';
    document.getElementById("price").value = '';
    
}
</script>
  
</body>
</html>