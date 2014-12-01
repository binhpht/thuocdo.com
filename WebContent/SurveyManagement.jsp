<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" pageEncoding="UTF-8" %>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<head>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<title>Thước Do</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>

<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Quản Lý Khảo Sát</h2>
<%
	int i = 0;
%> <sj:tabbedpanel id="formTag"
	cssStyle="font-size:12px;width:100%;">
	<sj:tab id="searchtab" target="frmSearch" label="Search" />
	<div id="frmSearch"><s:actionerror /> <s:form
		action="Survey_search" method="post" cssClass="tabForm"
		cssStyle="width:100%;">
		<s:textfield name="keyword" label="Keywords" cssClass="textfield"></s:textfield>
		<sj:datepicker label="Begin Time" name="beginTime" yearRange="1900"
			changeMonth="true" changeYear="true" cssClass="textfield"></sj:datepicker>
		<sj:datepicker label="End Time" name="endTime" yearRange="1900"
			changeMonth="true" changeYear="true" cssClass="textfield"></sj:datepicker>
		<s:select label="Active" name="active" cssClass="select"
			list="#{'true':'Active','false':'Non Active'}" />
		<input type="submit" value="Search" class="buttonSearch"
			style="margin-left: 69%" />
		<s:a href="Survey_view" cssClass="buttonAdd"
			cssStyle="padding:3px 12px; padding-top:5px; margin-left:15px;">Refresh</s:a>
	</s:form></div>

</sj:tabbedpanel> <s:form action="Survey_deleteMany" id="form">
	<ol>
		<li class="buttons" style="float: right;"><a
			href="Survey_addSurvey" class="buttonAdd">Add survey</a> <input
			type="submit" class="btnSubmit" value="Delete"
			style="margin-left: 5px;" /></li>
		<li><display:table id="survey" name="lstSurvey" pagesize="10"
			decorator="com.thuocdo.ma.Utils.SurveyDecorator" class="display"
			export="false" sort="list" requestURI="/Survey_view">
			<display:column titleKey="" style="width:5px;">
				<input type="checkbox" name="surveyIDList"
					value="${survey.surveyID}" />
			</display:column>
			<display:column title="No" sortable="true" style="width:5px;">
				<%
					i++;
								out.print(i);
				%>
			</display:column>
			<display:column property="title" title="Title" url="/Survey_detail" 
				paramId="id" paramProperty="surveyID" sortable="true" />
				<display:column property="title" title="Report" url="/getResultbyID" 
				paramId="id" paramProperty="surveyID" sortable="true" />
			<display:column property="category.categoryName" title="Category"
				sortable="true" />
			<display:column property="account.userName" title="Username"
				sortable="true" />
			<display:column property="beginTime" title="Begin" sortable="true"
				format="{0,date,dd-MM-yyyy}" />
			<display:column property="endTime" title="End" sortable="true"
				format="{0,date,dd-MM-yyyy}" />
			<display:column property="active" title="Active" sortable="true" />
			<display:column title="" url="/Survey_editSurvey" paramId="survey.surveyID"
				paramProperty="surveyID" style="width:5px;">
				<img src="images/office3_24.png" alt="Edit" />
			</display:column>
			<display:column title="" url="/Survey_delete" paramId="id"
				paramProperty="surveyID" style="width:5px;">
				<img src="images/33.png" alt="Delete" />
			</display:column>
			<display:setProperty name="paging.banner.placement" value="bottom" />
		</display:table></li>
	</ol>


</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>