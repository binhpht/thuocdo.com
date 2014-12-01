<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />

<title>Marketing Survey</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">



<s:form action="EditSurvey_deleteManyQuestion" name="frmQuestionManagement" id="form" cssClass="tabForm">
	<span style="color:blue; font-size:15px; font-weight:bold; ">Step 1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color:red;font-size:15px; font-weight:bold;">Step 2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color:blue;font-size:15px; font-weight:bold;">Step 3</span>
	<hr style="width: 100%;" />
	<h2>Question management</h2>
	<ol>
		<li class="buttons">
			<a href="EditSurvey_AddNewQuestion_View" class="buttonAdd" style="width:120px; margin-left:50%;">Add new question</a>
			<input type="submit" value="Delete" onclick="return checDeleteQuestion()" class="btnSubmit"/>
			
		</li>
		<li>
		<table id="mytable" style="width: 100%;" class="management">
			<thead>
				<tr>
					<th><span style="color: #FFF;">&nbsp;</span></th>
					<th><span style="color: #FFF;">No</span></th>
					<th><span style="color: #FFF;">Question content</span></th>
					<th><span style="color: #FFF;">Type answer</span></th>
				</tr>
			</thead>
			<%int i=0; %>
			<tbody>
				<s:iterator value="survey.questions">
				<%i++; %>
					<tr>
						<td><input type="checkbox" name="questionIDList"
							value="<s:property value="questionID"/>" /></td>
						<td><%=i %></td>
						<td><s:url action="EditSurvey_choiseQuestion.action" id="eUrl">
							<s:param name="question.questionID">
								<s:property value="questionID" />
							</s:param>
						</s:url> <s:a href="%{eUrl}">
							<s:property value="questionContent" />
						</s:a></td>
						<td><s:property value="typeOfQuestion.description" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		</li>
		<li style="height: 50px; margin:0px; margin-top: 15px;">
			<s:a action="EditSurvey_backStep1" cssClass="buttonAdd" cssStyle="padding: 5px 20px;">Back</s:a>
			<s:a href="EditSurvey_NextToStep3.action" cssClass="buttonAdd" cssStyle="padding:5px 20px; margin:0px; margin-left:73%; ">Next</s:a>
		</li>
	</ol>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>
