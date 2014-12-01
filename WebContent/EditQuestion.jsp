<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>

<title>Marketing Survey</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp" />
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center"><s:form action="Question_EditQuestion"
	name="frmQuestionManagement" cssClass="tabForm" >
	<span style="color: blue; font-size: 15px; font-weight: bold;">Step
	1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: red; font-size: 15px; font-weight: bold;">Step
	2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	3</span>
	<hr style="width: 100%;" />
	
		<input type="button" value="Add new answer"
			onclick="addRow('dataTable')" class="button" style="width:120px; margin-left:60%;" /> <input type="button"
			value="Delete answer" onclick="deleteRow('dataTable')" class="button" style="width:120px;" />
		<s:select name="question.typeOfQuestion.typeOfQuestionID"
			list="typeOfQuestionList" listKey="%{typeOfQuestionID}"
			listValue="%{description}"
			headerKey="question.typeOfQuestion.typeOfQuestionID"
			label="Question's type" cssClass="select"></s:select>
		<s:hidden name="question.questionID" />
		<s:textarea name="question.questionContent" label="Question"
			 cssClass="textfield" cssStyle="height:150px;"></s:textarea>
		<%
			int i = 0;
		%>
		<table id="dataTable" width="400px" style="margin-left:130px;">
			<s:iterator value="question.answers">
				<%
					i++;
				%>
				<tr>
					<td><input type="checkbox" /></td>
					<td><%=i%></td>
					<td><input type="text" name="question.answers.answerContent"
						value="<s:property value="answerContent" />" class="textfield" /></td>
				</tr>
			</s:iterator>
		</table>
		<s:submit type="submit" cssClass="button"	value="Save" />

</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>
