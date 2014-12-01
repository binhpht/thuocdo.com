<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />

<title>Khảo sát thông tin</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Quản lý danh mục</h2>
<%int i=0; %>
<sj:tabbedpanel id="categoryTag" cssStyle="font-size:12px;width:100%;">
	<sj:tab id="frmInfortab" target="frmInfor" label="Category Information" />
	<sj:tab id="frmSearchtab" target="frmSearch" label="Search" />
	<div id="frmInfor"><s:actionerror /> <s:form
		action="Category_save.action" cssClass="tabForm" method="post">
		<s:push value="category">
			<s:hidden name="categoryID"></s:hidden>
			<s:textfield name="categoryName" cssClass="textfield"
				label="Category Name" />
			<s:textarea name="description" cssClass="textfield"
				label="Description" cols="50" rows="4" />
			<s:submit value="Save" cssClass="button" />
		</s:push>
	</s:form></div>
	<div id="frmSearch"><s:actionerror /> <s:form action="#"
		method="post">
		<s:textfield name="questionContent" label="Keyword"></s:textfield>
		<s:submit value="Search" cssClass="button"></s:submit>
	</s:form></div>
</sj:tabbedpanel> <s:form action="Category_deleteMany" id="form">
	<ol>
		<li class="buttons"><input type="submit" class="btnSubmit"
			value="Delete" style="margin-left: 70%;" /></li>
		<li><display:table id="category" name="categoryList"
			pagesize="10" class="display" export="false" sort="list"
			requestURI="/FAQ_view">
			<display:column titleKey="" style="width:5px;">
				<input type="checkbox" name="categoryIDList"
					value="${category.categoryID}" />
			</display:column>
			<display:column title="No" sortable="true" style="width:5px;"><%
			i++;
					out.print(i);
		%></display:column>
			<display:column property="categoryName" title="Category name"
				url="/Category_edit" paramId="id" paramProperty="categoryID"
				sortable="true" />
			<display:column property="description" title="Description"
				sortable="true" />
			<display:column title="" url="/Category_delete" paramId="id"
				paramProperty="categoryID" style="width:5px;"><img src="images/33.png" alt="Delete"/></display:column>

			<display:setProperty name="paging.banner.placement" value="bottom" />
		</display:table></li>
		<!--<li>
		<table id="mytable" style="width: 100%;" class="management">
			<thead>
				<tr>
					<th><span style="color: #FFF;">&nbsp;</span></th>
					<th><span style="color: #FFF;">ID</span></th>
					<th><span style="color: #FFF;">Category</span></th>
					<th><span style="color: #FFF;">Description</span></th>
					<th><span style="color: #FFF;">Delete</span></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="categoryList">
					<tr>
						<td><input name="categoryIDList" type="checkbox"
							value="<s:property value="categoryID"/>" /></td>
						<td><s:property value="categoryID" /></td>
						<td><a
							href="Category_edit?id=<s:property value="categoryID"/>"> <s:property
							value="categoryName" /> </a></td>
						<td><s:property value="description" /></td>
						<td><a
							href="Category_delete?id=<s:property value="categoryID"/>">delete</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		</li>
	--></ol>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>
