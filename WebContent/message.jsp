<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="Refresh" content="5; URL=index.action" />

<%@ page language="java" pageEncoding="UTF-8" %>
<title>Marketing Survey</title>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 

<div class="body">Welcome to survey marketing !!! ^^<br />

<s:actionerror/>
<s:actionmessage/>

<br />
He thong se chuyen toi trang chu trong 5s nua</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>