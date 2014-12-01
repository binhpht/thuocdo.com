<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>
<sj:head compressed="false" />
<sj:head jqueryui="true" jquerytheme="redmond" />
<style type="text/css" media="all">
@import url("css/displaytag.css");

@import url("css/screen_table.css");
</style>

<title>Thước Đo</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<s:property value="#a" />
<div class="main"><jsp:include page="header.jsp"></jsp:include>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">

<h2>Quản Lý Hỏi Đáp Thường Gặp</h2>
<% int i=0; %>
<sj:tabbedpanel id="faqTag" cssStyle="font-size:12px;width:100%;">
	<sj:tab id="registertab" target="frmRegister" label="FQA Information" />
	
	<div id="frmRegister"><s:actionerror /> <s:form
		action="FAQ_saveAndUpdate.action" method="post" cssClass="tabForm" id="faqForm">
		<s:push value="faq">
			<s:hidden name="faqid"></s:hidden>
			<s:textfield name="questionContent" label="Câu Hỏi" id="content"
				cssClass="textfield"></s:textfield>
			<s:textfield name="answerContent" label="Trả Lời" id="answer" cssClass="textfield"></s:textfield>
			<s:select label="Kích Hoạt" name="isActive" cssClass="select"
				list="#{'true':'Kích Hoạt','false':'Vô Hiệu'}" />
			<s:submit value="Lưu" cssClass="button"></s:submit>
		</s:push>
	</s:form></div>

</sj:tabbedpanel>

<form action="FAQ_deleteMany.action" method="post" id="form">
<ol>
	<li class="buttons"><input type="submit" class="btnSubmit"
		value="Xóa" style="margin-left: 70%;" /></li>
	<li><display:table id="faq" name="lstFAQ" pagesize="10"
		decorator="com.thuocdo.ma.Utils.FAQDecorator" class="display"
		export="false" sort="list" requestURI="/FAQ_view">
		<display:column titleKey="" style="width:5px;">
			<input type="checkbox" name="faqidList" value="${faq.faqid}" />
		</display:column>
		<display:column title="STT" sortable="true" style="width:5px;"><%
			i++;
					out.print(i);
		%></display:column>
		<display:column property="questionContent" title="Câu Hỏi"
			url="/FAQ_edit" paramId="id" paramProperty="faqid" sortable="true" />
		<display:column property="answerContent" title="Câu Trả Lời"
			sortable="true" />
		<display:column property="active" title="Kích Hoạt" sortable="true" />		
		<display:column title="" url="/FAQ_delete" paramId="id"
			paramProperty="faqid" style="width:5px;"><img src="images/33.png" alt="Delete"/></display:column>
		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table></li>

	<!--<li>
	<table id="mytable" style="width: 100%;" class="management">
		<thead>
			<tr>
				<th><span style="color: #FFF;">&nbsp;</span></th>
				<th><span style="color: #FFF;">Question</span></th>
				<th><span style="color: #FFF;">Answer</span></th>
				<th><span style="color: #FFF;">Active</span></th>
				<th><span style="color: #FFF;">Delete</span></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="lstFAQ">
				<tr>
					<td style="width: 10px; margin: auto; padding: 10px 2px;"><input
						type="checkbox" value="<s:property value="faqid" />"
						name="faqidList" /></td>
					<td style="padding: 10px 2px;"><a
						href="FAQ_edit?id=<s:property value="faqid"/>"><s:property
						value="questionContent" /></a></td>
					<td style="padding: 10px 2px;"><s:property
						value="answerContent" /></td>
					<td style="padding: 10px 2px;"><s:if test="isActive ==true">Active</s:if>
					<s:if test="isActive ==false">Non-Active</s:if></td>
					<td style="margin: 0px;"><a
						href="FAQ_delete?id=<s:property value="faqid"/>"><img
						src="images/document_delete_16.png" style="border: none;"
						alt="Delte" /></a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	</li>
-->
</ol>
</form>
</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
<script language="JavaScript" type="text/javascript"
    xml:space="preserve">//<![CDATA[
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("faqForm");

  //frmvalidator.EnableOnPageErrorDisplay();
  //frmvalidator.EnableMsgsTogether();
    frmvalidator.addValidation("content","req","Yêu cầu nội dung");
    frmvalidator.addValidation("content","maxlen=100","Độ dài tối đa là 100");
    frmvalidator.addValidation("answer","req","Yêu cầu nội dung câu trả lời");
    frmvalidator.addValidation("content","maxlen=200","Độ dài tối đa là 200");      
     
  
   
//]]></script>
</html>