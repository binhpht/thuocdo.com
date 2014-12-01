<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>


<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Tài khoản </h2>
<form action="#" id="form">
<ol>
	<li><label>Tài Khoản: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.userName" /></label>
	<p class="clr" />
	</li>
	<li><label>Họ Tên: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.fullName" /></label>
	<p class="clr" />
	</li>
	<li><label>Sinh Nhật: </label> <label
		style="padding-left: 10px; text-align: left;"><s:date
		name="account.birthday" format="dd/MM/yyyy" /></label>
	<p class="clr" />
	</li>
	<li><label>Giới Tính: </label> <label
		style="padding-left: 10px; text-align: left;"><s:if
		test="account.gender==true">Nam</s:if><s:if
		test="account.gender==false">Nữ</s:if></label>
	<p class="clr" />
	</li>
	<li><label>Địa Chỉ: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.address" /></label>
	<p class="clr" />
	</li>
	<li><label>Số Điện Thoại: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.phone" /></label>
	<p class="clr" />
	</li>
	<li><label>Email: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.email" /></label>
	<p class="clr" />
	</li>
	<li><label>Nghề Nghiệp: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="account.job.jobName" /></label>
	<p class="clr" />
	</li>
	<li class="buttons"><a href="Account_editProfile" class="btnLink">Sửa đổi thông tin</a><a href="Account_changePassword" class="btnLink"
		style="margin-left: 7px;">Đổi mật khẩu</a></li>
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