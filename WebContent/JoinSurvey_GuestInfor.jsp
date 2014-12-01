<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>

<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<title>Home</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<sx:head debug="true" cache="false" compressed="false" />
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 

<div class="body">  
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Thông Tin</h2>

<s:form action="Account_saveGuestInfor" name="frmRegister" cssClass="tabForm">
	
	<span style="font-size: 14px; color: gray; width: auto; text-align: left">
	Nếu bạn có tài khoản thì có thể đăng nhập hoặc đăng kí ở <a href="Account_viewRegister.action">đây</a> 
    hoặc bạn có thể cung cấp cho chúng tôi một vài thông tin
	</span>
	
	<li><label for="accountInfor"
		style="font-size: 18px; color: #06F; width: auto; text-align: left; font-weight: bold; padding-top: 10px;">Thông Tin Khảo Sát:</label></li>
	
	<p class="clr" />

	<s:textfield name="account.fullName" label="Họ Tên" id="fullname" cssClass="textfield"/>

	<sj:datepicker changeMonth="true" changeYear="true" readonly="true"
		 label="Năm Sinh" name="birthday"  cssClass="textfield"></sj:datepicker>
		
	<s:radio label="Giới Tính" name="account.gender"  id ="account.gender"
		list="#{'0':'Nam','1':'Nữ'}" cssStyle="margin-left:40px;" />
		
	<s:textfield label="Địa Chỉ" name="account.address" id="address" cssClass="textfield"/>
	
	<s:textfield label="Email" name="account.email" id="email"  cssClass="textfield" />
	
	<s:select label="Nghề nghiệp" name="account.job.jobID" list="jobList" 
		listKey="%{jobID}" listValue="%{jobName}"  cssClass="select"/>
		<table></table>
	<s:submit value="Đăng kí" cssClass="button"></s:submit>
	<s:a href="" cssClass="buttonAdd" cssStyle="padding:5px 20px;">Hủy</s:a>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
<script language="JavaScript" type="text/javascript"
    xml:space="preserve">//<![CDATA[
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("frmRegister");

  //frmvalidator.EnableOnPageErrorDisplay();
  //frmvalidator.EnableMsgsTogether();
    frmvalidator.addValidation("fullname","req","Gõ họ tên");
    frmvalidator.addValidation("fullname","maxlen=50","Độ dài tối đa 50");
    frmvalidator.addValidation("fullname","minlen=6","Độ dài tối thiểu 6");
    frmvalidator.addValidation("birthday","req","Chọn ngày sinh nhật");
    frmvalidator.addValidation("account.gender","selone","Chọn giới tính");
    frmvalidator.addValidation("address","req","Gõ địa chỉ");
    frmvalidator.addValidation("address","maxlen=50","Địa chỉ độ dài tối đa là 50");
    frmvalidator.addValidation("email","req","Gõ email");
    frmvalidator.addValidation("email","email","Email không đúng");
    frmvalidator.addValidation("email","maxlen=50","Max length for email is 50");
    frmvalidator.addValidation("Terms","selone","Please select an option from 'Agree to Terms'");
    frmvalidator.addValidation("Terms","dontselectradio=1","Bạn không đủ điều kiẹn gia nhập thành viên vì không đòng ý  với quy dinh");
      
  
   
//]]></script>
</body>
</html>