<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>
<script type="text/javascript" src="js/date.js"></script>
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<title>Chinh sua Khao Sat Buoc 3</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center"><s:form name="frmAddSurveyStep3"
	action="EditSurvey_editSurveyStep3" method="post" cssClass="tabForm">
	<span style="color: blue; font-size: 15px; font-weight: bold;">Step
	1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: red; font-size: 15px; font-weight: bold;">Step
	3</span>
	<hr style="width: 100%;" />

	<h2>Edit survey</h2>
	<sj:datepicker changeMonth="true" changeYear="true"
		cssClass="textfield" label="Begin time" name="survey.beginTime"
		id="beginTime"></sj:datepicker>
	<sj:datepicker changeMonth="true" changeYear="true" readonly="true"
		cssClass="textfield" label="End time" name="survey.endTime"
		id="endTime"></sj:datepicker>
	<s:select label="Active" headerKey="0"
		list="#{'0':'Active', '1':'Non-Active'}" name="survey.isActive"
		value="2" cssClass="select" />
	<table></table>
	<s:submit value="Finish" onclick="return checkFinishStep3()"
		cssClass="button" ></s:submit>
	<s:a href="EditSurvey_backStep2.action" cssClass="buttonAdd"
		cssStyle="padding: 5px 20px;" >Back</s:a>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>

</body>
</html>