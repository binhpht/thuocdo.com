<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<style type="text/css">
.tdLabel{
	color:Gray;
	width: 25%;
}
</style>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center"><s:form name="frmSurveyIntroduction"
	action="JoinSurvey_joinSurvey" method="post" cssClass="tabForm">
	<span style="color: red; font-size: 15px; font-weight: bold;">Step
	1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	3</span>
	<hr style="width: 100%;" />
	<span style="font-size:30px; color:red; margin-left:35%;">Welcome to survey</span>
	<s:label id="title" name="survey.title" label="Title" cssStyle="margin:0px;padding-left:5px;color:blue; font-weight:bold;" />
	<s:label id="title" name="survey.description" label="Description" cssStyle="padding-left:5px;color:blue; font-weight:bold;" />
	<s:label id="title" name="survey.account.userName" label="Author" cssStyle="padding-left:5px;color:blue; font-weight:bold;" />
	<!--<s:textarea name="survey.description" id="description"
		label="Description" cols="50" rows="4"></s:textarea>
	--><table></table>
	<s:a href="JoinSurvey_Cancel.action" cssClass="buttonAdd">Cancel</s:a>
	<s:submit value="Join" cssClass="button"></s:submit>
	
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>