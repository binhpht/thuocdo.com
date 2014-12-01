<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center"><s:form name="frmAddSurveyStep2"
	action="EditSurvey_AddNewQuestion" method="post" cssClass="tabForm">

	<span style="color: blue; font-size: 15px; font-weight: bold;">Step
	1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: red; font-size: 15px; font-weight: bold;">Step
	2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	3</span>
	<hr style="width: 100%;" />
	<input type="button" value="Add new answer"
		onclick="addRow('dataTable')" class="button"
		style="width: 120px; margin-left: 62%;" />

	<input type="button" value="Delete answer"
		onclick="deleteRow('dataTable');" class="button" style="width: 100px;" />

	<s:select name="question.typeOfQuestion.typeOfQuestionID"
		id="typeOfQuestionID" list="typeOfQuestionList"
		listKey="%{typeOfQuestionID}" listValue="%{description}"
		label="Question's type" cssClass="select"></s:select>

	<s:textarea name="question.questionContent" id="questionContent"
		label="Question" cssClass="textfield" cssStyle="height:150px;"></s:textarea>


	<table id="dataTable" style="margin-left:130px;" width="400px">

	</table>

	<s:submit value="Save" onclick="return checkFinishStep2()" cssClass="button" />
	<s:a href="EditSurvey_backStep2.action" cssClass="buttonAdd" cssStyle="padding:6px 25px;">Cancel</s:a>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>