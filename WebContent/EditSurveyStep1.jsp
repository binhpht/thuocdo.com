<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<script type="text/javascript" src="js/AddOrDeleteRowOfTable.js"></script>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="body">
  <!-- Right -->
    <div class="body_right">
   <jsp:include page="bodyright.jsp"></jsp:include>      
    </div>
    <div class="body_center">
    <s:form name="frmAddSurveyStep1" action="Survey_editSurveyStep1" method="post" cssClass="tabForm">
    <span style="color:red; font-size:15px; font-weight:bold; ">Step 1</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color:blue;font-size:15px; font-weight:bold;">Step 2</span> &nbsp;&nbsp;&nbsp; >&nbsp; >&nbsp;&nbsp;&nbsp;
      <span style="color:blue;font-size:15px; font-weight:bold;">Step 3</span>
      <hr style="width:100%; "/>
     
      <s:textfield id="title" name="survey.title" label="Title" size="60" cssClass="textfield"></s:textfield>
  
      <s:select name="survey.category.categoryID" 
      			list="categoryList" 
      			listKey="%{categoryID}" 
      			listValue="%{categoryName}" 
      			label="Category" cssClass="select"></s:select>
    
      <s:textarea name="survey.description" id="description"
      			label="Description" 
      			cols="50" rows="4" cssClass="textfield" cssStyle="height:150px;"></s:textarea>
   
      <s:select name="survey.ageRank.ageRankID" 
      			list="ageRankList" 
      			listKey="%{ageRankID}" 
      			listValue="%{description}" 
      			label="Object" cssClass="select"></s:select>
  
      <s:select name="survey.job.jobID" 
      			list="jobList" 
      			listKey="%{jobID}" 
      			listValue="%{jobName}" 
      			label="Job" cssClass="select"></s:select>
    	<s:submit value="Next" onclick="return checkFinishStep1()" cssClass="button" cssStyle="margin-right:10px;"></s:submit>
    	<!--<s:reset value="Reset"></s:reset>
    --></s:form>
    </div>
    <div class="clr"></div>
  </div>
  <div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>