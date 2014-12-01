<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
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

<h2>Quản Lý Tài Khoản</h2>
<%
		int i = 0;
	%>
<sj:tabbedpanel id="formTag" cssStyle="font-size:12px;width:100%;">
	<sj:tab id="frmInfortab" target="frmInfor" label="Thông Tin Tài Khoản" />
	<sj:tab id="searchtab" target="frmSearch" label="Tìm" />
	<div id="frmInfor"><s:actionerror /> <s:form
		action="Account_saveAndUpdate" method="post" cssClass="tabForm">
		<s:push value="account">
			<s:hidden name="accountID"></s:hidden>
			<s:textfield name="userName" label="Tên Đăng Nhập" cssClass="textfield"></s:textfield>
			<s:textfield name="fullName" label="Họ Tên" cssClass="textfield"></s:textfield>
			<s:radio label="Gender" list="#{'true':'Nam','false':'Nữ'}"
				name="gender" cssStyle="margin-left:50px;"></s:radio>
			<sj:datepicker label="Ngày Sinh" name="birthday" yearRange="1900" readonly="true"
				changeMonth="true" changeYear="true" cssClass="textfield"></sj:datepicker>
			<s:textfield name="email" label="Email" cssClass="textfield"></s:textfield>
			<s:textfield name="address" label="Địa Chỉ" cssClass="textfield"></s:textfield>
			<s:textfield name="phone" label="Điện Thoại" cssClass="textfield"></s:textfield>
			<s:select list="lstJob" listKey="jobID" listValue="jobName"
				label="Job" cssClass="select" name="job.jobID"></s:select>
			<s:select label="Kích Hoạt" name="isActive" cssClass="select"
				list="#{'true':'Có','false':'Không'}" />
			<s:select list="lstRole" listKey="roleID" listValue="roleName"
				label="Quyền" cssClass="select" name="role.roleID"></s:select>
			<s:submit value="Lưu" cssClass="button"></s:submit>
		</s:push>
	</s:form></div>
	<div id="frmSearch">
	
	<form action="Account_search" method="post" class="tabForm">
	Keywords: <input name="keywords" class="textfield"
		style="margin-left: 20px; width: 390px;" /><input type="submit"
		value="Search" class="buttonSearch" /></form>
	</div>
</sj:tabbedpanel>

<form action="Account_deleteMany.action" method="post" id="form">
<ol>
	<li class="buttons"><input type="submit" class="btnSubmit"
		value="Xóa" style="margin-left: 70%;" /></li>
	<li><display:table id="account" name="lstAccount" pagesize="10"
		class="display" export="false" sort="list" requestURI="/Account_view">
		<display:column titleKey="" style="width:5px;">
			<input type="checkbox" name="listAccountID"
				value="${account.accountID}" />
		</display:column>
		<display:column title="STT" sortable="true" style="width:5px;"><%
			i++;
					out.print(i);
		%></display:column>
		<display:column property="userName" title="Tên Đăng Nhập"
			url="/Account_edit" paramId="id" paramProperty="accountID"
			sortable="true" />
		<display:column property="fullName" title="Họ Tên" sortable="true" />
		<display:column property="role.roleName" title="Quyền" sortable="true" />
		<display:column url="/Account_delete" paramId="id"
			paramProperty="accountID" style="width:5px;" ><img src="images/33.png" alt="Delete"/></display:column>

		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table></li>
	<!--<li>
	<table id="mytable" style="width: 100%;" class="management">
		<thead>
			<tr>
				<th><span style="color: #FFF;">&nbsp;</span></th>
				<th><span style="color: #FFF;">Username</span></th>
				<th><span style="color: #FFF;">Fullname</span></th>
				<th><span style="color: #FFF;">Role</span></th>
				<th><span style="color: #FFF;">Delete</span></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="lstAccount">
				<tr>
					<td style="width: 10px; padding: 10px 2px;"><input
						type="checkbox" value="<s:property value="accountID" />"
						name="listAccountID" /></td>
					<td style="padding: 10px 2px;"><a
						href="Account_edit?id=<s:property value="accountID"/>"><s:property
						value="userName" /></a></td>
					<td style="padding: 10px 2px;"><s:property value="fullName" /></td>
					<td style="padding: 10px 2px;"><s:property
						value="role.roleName" /></td>
					<td style="margin: 0px;"><a
						href="Account_delete?id=<s:property value="accountID"/>"><img
						src="images/document_delete_16.png" style="border: none;"
						alt="Delete" /></a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	</li>
--></ol>
</form>

<!--<table id="tblFAQ" border="1">
	<tr>
		<th>Question</th>
		<th>Answer</th>
		<th>Active</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<s:iterator value="lstFAQ">
		<tr>
			<td><s:property value="questionContent" /></td>
			<td><s:property value="answerContent" /></td>
			<td><s:property value="isActive" /></td>
			<td><a href="FAQ_edit?id=<s:property value="faqid"/>">Edit</a></td>
			<td><a href="FAQ_delete?id=<s:property value="faqid"/>">Delete</a></td>
		</tr>
	</s:iterator>
</table>

--></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>