<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<div class="news">
<h2>Các cuộc khảo sát mới</h2>
<s:iterator value="lstNewOfSurvey">
	<div class="service"><img src="images/Survey_icon1.jpg"
		alt="picture" width="100" height="100" class="img" />
	<p class="title"><s:property value="title" /></p>
	<p><s:property value="description" /></p>
	<p><a href="JoinSurvey_getSurvey.action?survey.surveyID=<s:property value="surveyID" />" class="more"><img
		src="images/but_read_more_1.gif" alt="picture" width="81" height="24"
		border="0" /></a></p>
	<p class="clr" />
	</div>
</s:iterator> <br />
</div>
<div class="news">
<h2>Các cuộc khảo sát phổ biến</h2>

<s:iterator value="lstMostOfSurvey">
	<div class="service"><img src="images/Icon_Survey_1.gif"
		alt="picture" width="100" height="100" class="img" />
	<p class="title"><s:property value="title" /></p>
	<p><s:property value="description" /></p>
	<p><a href="JoinSurvey_getSurvey.action?survey.surveyID=<s:property value="surveyID" />" class="more"><img
		src="images/but_read_more_1.gif" alt="picture" width="81" height="24"
		border="0" /></a></p>
	<p class="clr" />
	</div>
</s:iterator>

<!--<div class="service"><img src="images/survey_pic_1.jpg"
	alt="picture" width="100" height="100" class="img" />
<p class="title">Survey 2</p>
<p>Lorem Ipsum has been the industry's standard dummy text ever
since thes, when an unknown printer.</p>
<p><a href="#" class="more"><img
	src="images/but_read_more_1.gif" alt="picture" width="81" height="24"
	border="0" /></a></p>
<p class="clr" />
</div>
<div class="service"><img
	src="images/survey_showcase_lifes_work.jpg" alt="picture" width="100"
	height="100" class="img" />
<p class="title">Survey 3</p>
<p>Lorem Ipsum has been the industry's standard dummy text ever
since thes, when an unknown printer.</p>
<p><a href="#" class="more"><img
	src="images/but_read_more_1.gif" alt="picture" width="81" height="24"
	border="0" /></a></p>
<p class="clr" />
</div>
--></div>