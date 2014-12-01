<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript" src="js/gen_validatorv4.js"></script>
<!--Css for validation-->
<style type="text/css" xml:space="preserve">
BODY, P,TD{ font-family: Arial,Verdana,Helvetica, sans-serif; font-size: 10pt }
A{font-family: Arial,Verdana,Helvetica, sans-serif;}
B {	font-family : Arial, Helvetica, sans-serif;	font-size : 12px;	font-weight : bold;}
.error_strings{ font-family:Verdana; font-size:14px; color:#f00000; background-color:#fff;}
</style>

<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<title>Thước Đo</title>
<jsp:include page="head.jsp"></jsp:include>
</head>

<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 

<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Đăng kí thành viên</h2>
<s:actionerror/>
<s:actionmessage/>
 <div id='frmRegister_account.userName_errorloc' class="error_strings"></div>
  <div id='frmRegister_account.password_errorloc' class="error_strings"></div>
  <div id='frmRegister_verifyPassword_errorloc' class="error_strings"></div>
  	  <div id='frmRegister_account.fullName_errorloc' class="error_strings"></div>
  	    <div id='frmRegister_birthday_errorloc' class="error_strings"></div>
  	    <div id='frmRegister_account.gender_errorloc' class="error_strings"></div>
  	     <div id='frmRegister_account.address_errorloc' class="error_strings"></div>
  	      <div id='frmRegister_account.phone_errorloc' class="error_strings"></div>
  	      <div id='frmRegister_account.email_errorloc' class="error_strings"></div>
  	      <div id='frmRegister_Terms_errorloc' class="error_strings"></div>
  	      
  	 
  
<s:form action="Account_saveRegister" 
	name="frmRegister" cssClass="tabForm">
	<s:textfield name="account.userName" label="Tên đăng nhập" cssClass="textfield"
		id="username" />
		 
	<s:password name="account.password" id="password" label="Mật khẩu"  cssClass="textfield"/>
	<s:password name="verifyPassword" label="Xác nhận mật khẩu" cssClass="textfield" />
	
	<s:textfield name="account.fullName" label="Họ Tên" id="fullname"  cssClass="textfield"/>

	<sj:datepicker changeMonth="true" changeYear="true" yearRange="1900" readonly="true"
		 label="Năm Sinh" name="birthday" cssClass="textfield"></sj:datepicker>
	<s:radio label="Giới Tính" name="account.gender" id="gender"
		list="#{'0':'Nam','1':'Nữ'}"cssStyle="margin-left:50px;" />
		
	<s:textfield label="Địa Chỉ" name="account.address" id="address" cssClass="textfield"/>
	
	<s:textfield label="Số Điện Thoại" name="account.phone" id="phonenumber" cssClass="textfield" />
	
	<s:textfield label="Email" name="account.email" id="email" cssClass="textfield" />
		<s:select label="Nghề nghiệp" name="account.job.jobID" list="lstJob"
		listKey="%{jobID}" listValue="%{jobName}" cssClass="select"/>
	<s:textarea value="Bạn có đồng ý với nội quy của website" readonly="true" cssClass="textfield" cssStyle="height:150px;"></s:textarea>
<s:radio name="Terms" id="Terms" list="#{'0':'Đồng Ý','1':'Không Đồng ý'}" cssStyle="margin-left:50px;"></s:radio>
 <table></table>

	<input type="submit" value="Đăng kí" class="button" style="margin-left:70%;"/>
	<input type="reset" value="Làm Lại" class="button" style="margin-left: 10px;"/>
</s:form></div>
<script language="JavaScript" type="text/javascript"
    xml:space="preserve">//<![CDATA[
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("frmRegister");

  //frmvalidator.EnableOnPageErrorDisplay();
  //frmvalidator.EnableMsgsTogether();
    frmvalidator.addValidation("username","req","Yêu cầu tên đăng nhập");
    frmvalidator.addValidation("username","alnum","Bạn không được phép nhập ký tự đặc biệt");
    frmvalidator.addValidation("username","maxlen=30","Độ dài tối đa là 30");
    frmvalidator.addValidation("username","minlen=6","Độ dài tối thiểu là  6");
    frmvalidator.addValidation("password","req","Yêu cầu mật khẩu");
    frmvalidator.addValidation("password","alnum","Không được gõ ký tự đặc biệt");
    frmvalidator.addValidation("password","maxlen=30","Độ dài tối đa là 30");
    frmvalidator.addValidation("password","minlen=5","Độ dài tối thiểu là 5");
    frmvalidator.addValidation("verifyPassword","req","Xác nhận mật khẩu");
    frmvalidator.addValidation("verifyPassword","eqelmnt=password","Mật khẩu không trùng");
    frmvalidator.addValidation("fullname","req","Gõ họ tên");
    frmvalidator.addValidation("fullname","maxlen=50","Độ dài tối đa 50");
    frmvalidator.addValidation("fullname","minlen=6","Độ dài tối thiểu 6");
    frmvalidator.addValidation("birthday","req","Chọn ngày sinh nhật");
    frmvalidator.addValidation("account.gender","selone","Chọn giới tính");
    frmvalidator.addValidation("address","req","Gõ địa chỉ");
    frmvalidator.addValidation("address","maxlen=50","Địa chỉ độ dài tối đa là 50");
    frmvalidator.addValidation("phonenumber","req","Gõ số điện thoại");
    frmvalidator.addValidation("phonenumber","numeric","Số điện thoại không đúng");
    frmvalidator.addValidation("phonenumber","alnum","Số điẹn thoại không được dùng ký tự đặc biệt");
    frmvalidator.addValidation("phonenumber","maxlen=20","Độ dài tối đa 20");
    frmvalidator.addValidation("email","req","Gõ email");
    frmvalidator.addValidation("email","email","Email không đúng");
    frmvalidator.addValidation("email","maxlen=50","Max length for email is 50");
    frmvalidator.addValidation("Terms","selone","Please select an option from 'Agree to Terms'");
    frmvalidator.addValidation("Terms","dontselectradio=1","Bạn không đủ điều kiẹn gia nhập thành viên vì không đòng ý  với quy dinh");
      
  
   
//]]></script>
	
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>