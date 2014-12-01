<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body">
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Job management</h2>
<% int i=0; %>
<sj:tabbedpanel id="jobTab" cssStyle="font-size:12px;width:100%;">
	<sj:tab id="frmInfortab" target="frmInfor" label="Job Information" />
	<sj:tab id="frmSearchtab" target="frmSearch" label="Search" />
	<div id="frmInfor"><s:actionerror /> <s:form
		action="Job_saveAndUpdate.action" method="post" cssClass="tabForm">
		<s:push value="job">
			<s:hidden name="jobID"></s:hidden>
			<s:textfield name="jobName" label="Job Name" cssClass="textfield"></s:textfield>
			<s:textarea name="description" label="Desciption"
				cssStyle="width:300px;height:100px;" cssClass="textfield"></s:textarea>
			<s:submit value="Save" cssClass="button"></s:submit>
		</s:push>
	</s:form></div>
	<div id="frmSearch"><s:actionerror />
	<form action="Job_search" method="post" class="tabForm">
	Keywords: <input name="keywords" class="textfield"
		style="margin-left: 20px; width: 390px;" /><input type="submit"
		value="Search" class="buttonSearch" /></form>
	</div>
</sj:tabbedpanel> <s:form action="Job_deleteAll" id="form">
	<ol>
		<li class="buttons"><input type="submit" class="btnSubmit"
			value="Delete" style="margin-left: 70%;" /></li>
		<li><display:table id="job" name="lstJob" pagesize="10"
			class="display" export="false" sort="list" requestURI="/Job_view">
			<display:column titleKey="" style="width:5px;">
				<input type="checkbox" name="LstjobID" value="${job.jobID}" />
			</display:column>
			<display:column title="No" sortable="true" style="width:5px;"><%
			i++;
					out.print(i);
		%></display:column>
			<display:column property="jobName" title="Job Name"
				url="/Job_edit" sortable="true" paramId="id"
				paramProperty="jobID" />
			<display:column property="description" title="Description"
				sortable="true" />
			<display:column url="/Job_delete" paramId="id"
				paramProperty="jobID" style="width:5px;"><img alt="Delete" src="images/33.png"/></display:column>

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