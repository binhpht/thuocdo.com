<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<title>Home</title>
<jsp:include page="head.jsp"></jsp:include>

</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Edit Profile</h2>
<s:form action="Account_saveEditProfile" method="post" cssClass="tabForm">
	<s:push value="account">
		<s:hidden name="accountID"></s:hidden>
		<s:textfield name="userName" label="Username" cssClass="textfield"></s:textfield>
		<s:hidden name="password" ></s:hidden>
		<s:textfield name="fullName" label="Fullname" cssClass="textfield"></s:textfield>
		<s:radio label="Gender" list="#{'true':'Male','false':'Female'}"
			name="gender"></s:radio>
		<sj:datepicker label="Birthday" name="birthday" yearRange="1900" readonly="true"
			changeMonth="true" changeYear="true" cssClass="textfield"></sj:datepicker>
		<s:textfield name="email" label="Email" cssClass="textfield"></s:textfield>
		<s:textfield name="address" label="Address" cssClass="textfield"></s:textfield>
		<s:textfield name="phone" label="Phone" cssClass="textfield"></s:textfield>
		<s:select name="job.jobID" list="lstJob" listKey="jobID" listValue="jobName"
			label="Job" cssClass="textfield"></s:select>
			<s:hidden name="role.roleID"></s:hidden>
		<s:submit value="save" cssClass="button"></s:submit>
	</s:push>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>