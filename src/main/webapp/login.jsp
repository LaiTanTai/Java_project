<%@ page import="model.Users"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
      <div class="p-4 border mt-4">
      <% String contextPath = request.getContextPath(); %>
      <h1>${kq}</h1>
      <c:out value="${kq}"/>
      <c:if test="${msg.getPassword() == '123'}">
          mật khẩu là ${msg.password}
      </c:if>
        <form action="<%=contextPath%>/login" method="post">
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="username">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
          </form>
      </div>
      </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%
    String kq = (String) request.getAttribute("kq");
    int count = 0 ;
    Users users = new Users();
%>
<%
    count++;
    if(count%2==0){
        users.setUsername("nguyenvana");
 %>
    <b style="padding:20px"> <%= users.getUsername() %> </b>
 <% } %>

 <c:forEach items="${list}" var="item" >
    <b>${item}</b>
 </c:forEach>
    <b style="padding : 10px"> <%= kq %> </b>
    <b style="padding : 10px"> <%= count %> </b>
</body>
</html>
