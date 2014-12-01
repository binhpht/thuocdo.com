<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Thước Đo- Đo Lường Mọi Giá Trị</title>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>

<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>

</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="blockHeader.jsp"></jsp:include>
  <div class="header_panel">
    <jsp:include page="headerpanel.jsp"></jsp:include>
  </div>
  <div class="body">
  <!-- Right -->
    <div class="body_right">
   <jsp:include page="bodyright.jsp"></jsp:include>      
    </div>
    <div class="body_center">
      <jsp:include page="bodyleft.jsp"></jsp:include>
    </div>
    <div class="clr"></div>
  </div>
  <div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>

</body>
</html>