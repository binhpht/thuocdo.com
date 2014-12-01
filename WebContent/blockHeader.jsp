<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<div class="block_header">
<div class="slider">
<div id="slider">
<ul>
	<s:iterator value="lstNewOfSurvey">
		<li>
		<div class="img"><img src="images/screen_1.jpg" alt="picture"
			width="174" height="252" /></div>
		<h2><s:property value="title" /><a href="#"><img
			src="images/but_read_more_2.gif" alt="picture" width="81" height="24"
			border="0" /></a></h2>
		<p><s:property value="description" /></p>
		</li>

	</s:iterator>

	<s:iterator value="lstMostOfSurvey">
		<li>
		<div class="img"><img src="images/screen_1.jpg" alt="picture"
			width="174" height="252" /></div>
		<h2><s:property value="title" /><a href="#"><img
			src="images/but_read_more_2.gif" alt="picture" width="81" height="24"
			border="0" /></a></h2>
		<p><s:property value="description" /></p>
		</li>
	</s:iterator>
	<!--<li>
	<div class="img"><img src="images/screen_1.jpg" alt="picture"
		width="174" height="252" /></div>
	<h2>Cuoc khao sat moi nhat<a href="#"><img
		src="images/but_read_more_2.gif" alt="picture" width="81" height="24"
		border="0" /></a></h2>
	<p>Mo ta noi dung</p>
	</li>
	<li>
	<div class="img"><img src="images/screen_1.jpg" alt="picture"
		width="174" height="252" /></div>
	<h2>Cuoc khao sat duoc nhieu nguoi tham gia<a href="#"><img
		src="images/but_read_more_2.gif" alt="picture" width="81" height="24"
		border="0" /></a></h2>
	<p>Noi dung cuoc khao sat</p>
	</li>
--></ul>
</div>
</div>
</div>
<div class="clr"></div>
