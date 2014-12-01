<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<head>
<title>Thước đo giá trị</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Đổi mật khẩu</h2>

<form action="Account_changePassword" method="post" id="form">
<ol>
	<li><label for="opass">Mật khẩu cũ: <span class="red"></span></label>
	<input type="password" name="oldPassword" class="textfield"
		style="width: 320px;" />
	<p class="clr" />
	</li>
	<li><label for="npass">Mật khẩu mới: <span class="red"></span></label>
	<input type="password" name="password" class="textfield"
		style="width: 320px;" />
	<p class="clr" />
	</li>
	<li><label for="rpass">Gõ lại: </label> <input
		id="company" type="password" name="vPassword" class="textfield"
		style="width: 320px;" />
	<p class="clr" />
	</li>
	<li class="buttons" style="clear: both;"><input type="submit" value="Đổi mật khẩu"
		style="width: 150px; clear: both;" class="btnSubmit"></input> <input
		type="reset"  style="clear: both;" value="Hủy" class="btnSubmit"></input>
		<p class="clr" />
		</li>
	<li class="clr"></li>
</ol>
</form>
</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>