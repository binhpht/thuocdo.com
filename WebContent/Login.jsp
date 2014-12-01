<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Thuocdo.com</title>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>

</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body"><!-- Right -->
<h2>Login</h2>

<form action="Account_login" method="post" id="frmlogin">
<ol>
	<li style="margin-left: 35%; "><span  > <s:actionerror cssStyle=" color: red;"/> <s:actionmessage />
	</span></li>
	<li><label for="username" style="width: 40%;">Tên Đăng Nhập:<span
		class="red">*</span></label> <input id="username" name="txtUsername"
		class="text" style="width: 200px;" />
	<p class="clr" />
	</li>
	<li><label for="Password" style="width: 40%;">Mật khẩu: <span
		class="red">*</span></label> <input type="password" id="password"
		name="txtPassword" class="text" style="width: 200px;" />
	<p class="clr" />
	</li>

	<li class="buttons"><input type="submit" class="btnSubmit"
		value="Login" style="margin-left: 40%;" /> <input type="reset"
		class="btnSubmit" value="Reset" /></li>
	<li><a href="Account_viewRegister" style="margin-left: 50%;">Register</a> | <a href="#">Forget password</a></li>
	<li class="clr"></li>
</ol>
</form>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
<script language="JavaScript" type="text/javascript"
    xml:space="preserve">//<![CDATA[
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("frmlogin");

  //frmvalidator.EnableOnPageErrorDisplay();
  //frmvalidator.EnableMsgsTogether();
    frmvalidator.addValidation("username","req","Bạn phải nhập tên đăng nhập");
    frmvalidator.addValidation("password","req","Phải nhập mật khẩu");
   
   //]]></script>
</body>
</html>