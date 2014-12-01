<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.thuocdo.ma.Bean.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Thước Đo</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include>

<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Chi tiết khảo sát</h2>
<form action="#" id="form">
<ol>
	<li><label>Nội Dung: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="survey.title" /></label>
	<p class="clr" />
	</li>
	<li><label>Danh Mục: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="survey.category.categoryName" /></label>
	<p class="clr" />
	</li>
	<li><label>Tác Giả: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="survey.account.userName" /></label>
	<p class="clr" />
	</li>
	<li><label>Mô Tả: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="survey.description" /></label>
	<p class="clr" />
	</li>
	<li><label>Thời gian bắt đầu: </label> <label
		style="padding-left: 10px; text-align: left;"><s:date
		name="survey.beginTime" format="dd / MM / yyyy" /></label>
	<p class="clr" />
	</li>
	<li><label>Thời gian kết thúc: </label> <label
		style="padding-left: 10px; text-align: left;"><s:date
		name="survey.endTime" format="dd / MM / yyyy" /></label>
	<p class="clr" />
	</li>
	<li><label>Kích hoạt: </label> <label
		style="padding-left: 10px; text-align: left;"><s:if
		test="survey.isActive==true">Active</s:if><s:if
		test="survey.isActive==false">Non-active</s:if></label>
	<p class="clr" />
	</li>
	<li><label>Đối tượng: </label> <label
		style="padding-left: 10px; text-align: left;"><s:property
		value="survey.job.jobName" /> <s:property
		value="survey.ageRank.description" /></label>
	<p class="clr" />
	</li>
	<li><label>Vi phạm: </label> <label
		style="padding-left: 10px; text-align: left;"><s:if
		test="survey.isIllegal==true">Vi phạm</s:if><s:if
		test="survey.isIllegal==false">Hợp lệ</s:if></label>
	<p class="clr" />
	</li>
	<li><display:table id="mytable" name="survey.questions"
		pagesize="10" class="display" export="false" sort="list"
		requestURI="/Survey_detail"
		decorator="com.thuocdo.ma.Utils.QuestionDecorator">
		<display:column titleKey="" style="width:5%;">
			<input type="checkbox" name="questionIDList"
				value="${mytable.questionID}" />
		</display:column>
		<display:column property="questionContent" title="Question content"
			sortable="true" style="width:35%;" />
		<display:column property="typeOfQuestion.description"
			title="Type answer" sortable="true" style="width:20%;" />
		<display:column property="lstAnswer" title="Answer"
			style="text-align: left; padding:5px; width:" />
		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table></li>
	<li class="buttons" style="margin-left: 5px; padding: 20px;">
	<%
		Account account = (Account) session.getAttribute("account");
		if (account.getRole().getRoleName().equals("Admin")) {
	%> <a href="Survey_view" class="btnLink" style="margin-top: 5px;">Back</a>
	<%
		} else {
	%>
	<a href="Survey_managementForCustomer" class="btnLink" style="margin-top: 5px;">Back</a>
	
	<%
		}
	%>
</li>
</ol>


</form>


</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>