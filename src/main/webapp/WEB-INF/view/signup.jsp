<html>
<%@include file = "header.jsp" %>
<div class = "container">
<h1 class = "jumbotron">

    New User Sign up form 

</h1>
<form:form modelAttribute="signupForm">
  <div class="form-row">
    <form:errors/>
    <div class="form-group col-md-6">
      <form:label path= "userName">User Name </form:label>
      <form:input path= "userName" class="form-control" id="form:inputEmail4" placeholder = "Enter User Name"/>
      <form:errors cssClass="error" path="userName"></form:errors>
    </div>
    <div class="form-group col-md-6">
      <form:label path="password">Password</form:label>
      <form:password path="password" class="form-control" id="form:inputPassword4" placeholder = "Enter your password"/>
      <form:errors cssClass="error" path="password" ></form:errors>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <form:label path="email">Email</form:label>
      <form:input path="email" class="form-control" id="form:inputEmail4" placeholder = "Enter Email Address"/>
      <form:errors cssClass="error" path="email"></form:errors>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
   <button type="submit" class="btn btn-primary">Cancel</button>
</form:form>
</div>
<%@include file = "footer.jsp" %>
</html>
