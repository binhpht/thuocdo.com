<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

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
<div class="body_center">
<h2>Role management</h2>
<%
	int i = 0;
%> <sj:tabbedpanel id="roleTag"
	cssStyle="font-size:12px;width:100%;">
	<sj:tab id="frmInfortab" target="frmInfor" label="Category Information" />
	<sj:tab id="frmSearchtab" target="frmSearch" label="Search" />
	<div id="frmInfor"><s:actionerror /> <s:form
		action="Role_save.action" method="post" cssClass="tabForm">
		<s:hidden name="role.roleID"></s:hidden>
		<s:textfield name="role.roleName" cssClass="textfield"
			label="Role name" />
		<s:textarea name="role.description" label="Description"
			cssClass="textfield" cssStyle="width:300px;height:100px;">
			<s:property value="description" />
		</s:textarea>
		<s:submit value="Save" cssClass="button" />
	</s:form></div>
	<div id="frmSearch"><s:actionerror />
	<form action="Account_search" method="post" class="tabForm">
	Keywords: <input name="keywords" class="textfield"
		style="margin-left: 20px; width: 390px;" /><input type="submit"
		value="Search" class="buttonSearch" /></form>
	</div>
</sj:tabbedpanel> <s:form action="Role_deleteAll" name="frmRoleManagement" id="form">
	<ol>
		<li class="buttons"><input type="submit" class="btnSubmit"
			value="Delete" style="margin-left: 70%;" /></li>
		<li><display:table id="role" name="roleList" pagesize="10"
			class="display" export="false" sort="list" requestURI="/Role_view">
			<display:column titleKey="" style="width:5px;">
				<input type="checkbox" name="roleIDList" value="${role.roleID}" />
			</display:column>
			<display:column title="No" sortable="true" style="width:5px;">
				<%
					i++;
								out.print(i);
				%>
			</display:column>
			<display:column property="roleName" title="Role Name"
				url="/Role_choiseRole" paramId="id" sortable="true" paramId="roleID"
				paramProperty="roleID" />
			<display:column property="description" title="Description"
				sortable="true" />
			<display:column title="" url="/Role_delete" paramId="roleID"
				paramProperty="roleID" style="width:5px;">
				<img src="images/33.png" alt="Delete" />
			</display:column>

			<display:setProperty name="paging.banner.placement" value="bottom" />
		</display:table></li>
		<!--<li>
		<table id="mytable" style="width: 100%;" class="management">
			<thead>
				<tr>
					<th><span style="color: #FFF;">&nbsp;</span></th>
					<th><span style="color: #FFF;">Role name</span></th>
					<th><span style="color: #FFF;">Description</span></th>
					<th><span style="color: #FFF;">Delete</span></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="roleList">
					<tr>
						<td><input type="checkbox" name="roleIDList"
							value="<s:property value="roleID"/>" /></td>
						<td><s:url action="Role_choiseRole.action" id="eUrl">
							<s:param name="roleID">
								<s:property value="roleID" />
							</s:param>
						</s:url> <s:a href="%{eUrl}">
							<s:property value="roleName" />
						</s:a></td>
						<td><s:property value="description" /></td>
						<td><a
							href="Role_delete.action?roleID=<s:property value="roleID"/>">Delete</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		</li>
	
	-->
	</ol>
</s:form></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>
