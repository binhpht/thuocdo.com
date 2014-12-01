<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
<div class="body_center" >

<h2>Age Rank Management</h2>
<%
		int i = 0;
	%>
<sj:tabbedpanel id="AgeRankTag" cssStyle="font-size:12px;width:100%;" >
	<sj:tab id="registertab"  target="frmRegister" label="AgeRank Information" />
	<sj:tab id="searchtab" target="frmSearch" label="Search" />
	<div id="frmRegister">	
	<s:actionerror /> 
	<s:form action="AgeRank_saveAndUpdate.action"
		method="post" cssClass="tabForm" >
		<s:push value="ageRank">
			<s:hidden name="ageRankID"></s:hidden>
			<s:textfield name="description" label="Description" cssClass="textfield"></s:textfield>
			<s:submit value="Save" cssClass="button"></s:submit>
		</s:push>
	</s:form></div>	 
	<div id="frmSearch">	
	<form action="AgeRank_search" method="post" class="tabForm">
		Keywords: <input name="keywords" class="textfield" style="margin-left:20px; width:390px;"/><input type="submit" value="Search" class="buttonSearch"/>
	</form></div>
</sj:tabbedpanel>

<form action="AgeRank_deleteMany.action" method="post" id="form">
<ol>
	<li class="buttons"><input type="submit" class="btnSubmit"
			value="Delete" style="margin-left: 70%;" /></li>
		<li><display:table id="age" name="lstAgeRank"
			pagesize="10" class="display" export="false" sort="list"
			requestURI="/AgeRank_view">
			<display:column titleKey="" style="width:5px;">
				<input type="checkbox" name="ageRankidList"
					value="${age.ageRankID}" />
			</display:column>
			<display:column title="No" sortable="true" style="width:5px;"><%
			i++;
					out.print(i);
		%></display:column>
			<display:column property="description" title="Age rank"
				url="/AgeRank_edit" paramId="id" paramProperty="ageRankID"
				sortable="true" />			
			<display:column title="" url="/AgeRank_delete" paramId="id"
				paramProperty="ageRankID" style="width:5px;"><img src="images/33.png" alt="Delete"/></display:column>
			<display:setProperty name="paging.banner.placement" value="bottom" />
		</display:table></li>
		
	<!--<table id="mytable" style="width: 100%;" class="management">
		<thead>
			<tr>
				<th><span style="color: #FFF;">&nbsp;</span></th>
				<th><span style="color: #FFF;">Description</span></th>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="lstAgeRank">
				<tr>
					<td style="width: 20; margin: auto"><input type="checkbox"
						value="<s:property value="ageRankID" />" name="ageRankidList" /></td>
					<td><s:property value="description" /></td>
					<td><a href="AgeRank_edit?id=<s:property value="ageRankID"/>">Edit</a></td>
					<td><a href="AgeRank_delete?id=<s:property value="ageRankID"/>">Delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	</li>
--></ol>
</form>
</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>