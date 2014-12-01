<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Marketing Survey</title>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>

</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> <jsp:include
	page="blockHeader.jsp"></jsp:include>
<div class="header_panel"><jsp:include page="headerpanel.jsp"></jsp:include>
</div>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>Surveys</h2>
<s:if test="lstSurveyByCategory.size()==0">No survey for category.</s:if> <s:if
	test="lstSurveyByCategory.size()!=0">
	<s:iterator value="lstSurveyByCategory">
		<div class="service"><img src="images/Survey_icon1.jpg"
			alt="picture" width="100" height="100" class="img" />
		<p class="title"><s:property value="title" /></p>
		<p><s:property value="description" /></p>
		<p><a href="JoinSurvey_getSurvey.action?survey.surveyID=<s:property value="surveyID" />" class="more"><img
			src="images/but_read_more_1.gif" alt="picture" width="81" height="24"
			border="0" /></a></p>
		<p class="clr" />
		</div>
	</s:iterator>
</s:if></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>