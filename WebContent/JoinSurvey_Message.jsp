<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="body">
  <!-- Right -->
    <div class="body_right">
   <jsp:include page="bodyright.jsp"></jsp:include>      
    </div>
    <div class="body_center">
    <span style="color:red; font-size:16px; margin-top:20px;"><s:property value="message"/></span>
    
    </div>
    <div class="clr"></div>
  </div>
  <div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>