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
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">

<s:form action="EditSurvey_EditQuestion" name="frmQuestionManagement" id="form">
<span style="color: blue; font-size: 15px; font-weight: bold;">Step
	1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: red; font-size: 15px; font-weight: bold;">Step
	2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color: blue; font-size: 15px; font-weight: bold;">Step
	3</span>
	<hr style="width: 100%;" />
	<ol><li>
		<s:select name="question.typeOfQuestion.typeOfQuestionID" 
				id="typeOfQuestionID"
      			list="typeOfQuestionList" 
      			listKey="%{typeOfQuestionID}" 
      			listValue="%{description}" 
      			headerKey="question.typeOfQuestion.typeOfQuestionID"
      			label="Question's type"></s:select></li>
    	<li><s:hidden name="question.questionID" /></li>
    	<li>
      <s:textarea name="question.questionContent" 
      			id="questionContent"
      			label="Question" 
      			cols="50" rows="4"></s:textarea></li>
      	
      	<li><input type="button" value="Add new answer" onclick="addRow_edit('dataTable')" />
 
    	<input type="button" value="Delete answer" onclick="deleteRow('dataTable')" />
 		</li>
 		<li>
 		<%int i=0; %>
    	<table id="dataTable" width="400px" border="1">
        	<s:iterator value="question.answers">
        			<%i++; %>
					<tr>					
						<td><input type="checkbox" /></td>
						<td><%=i %></td>
						<td><input type="text" name="question.answers.answerContent" value="<s:property value="answerContent" />"/></td>
						<td><input type="hidden"  name="question.answers.answerID" value="<s:property value="answerID" />"/></td>
					</tr>
				</s:iterator>
    	</table></li>
     			
		<li class="buttons">
			<input type="submit" class="btnSubmit" value="Save" onclick="return checkFinishStep2()"/>
			<s:a action="EditSurvey_backStep2">Cancel</s:a>
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
