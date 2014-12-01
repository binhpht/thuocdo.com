<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Marketing Survey</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">
<h2>IIlegal Manage</h2>

<form action="Illegal_DeleteIllegals" method="post" id="form">
<ol>
	<li class="buttons">
		<input type="submit" class="btnSubmit" value="Delete" style="margin-left: 85%;" />
	</li> 
	<li>
	<table id="mytable" style="width: 100%;" class="management">
		<thead>

			<tr>
				<th><span style="color: #FFF;">Check</span></th>
				<th><span style="color: #FFF;">No</span></th>
				<th><span style="color: #FFF;">Name</span></th>
				<th><span style="color: #FFF;">IsSolved</span></th>
				<th><span style="color: #FFF;">Content</span></th>

			</tr>
		</thead>
		<tbody>
		<%int i=0; %>
			<s:iterator value="illegalList">
			<%i++; %>
				<tr>
					<td><input type="checkbox" name="illegalIDList"
						value="<s:property value="illegalID"/>" /></td>
						
					<td><%=i %></td>
					
					<td><s:url action="Illegal_GetIllegalSurvey.action" id="eUrl">
							<s:param name="survey.surveyID">
								<s:property value="survey.surveyID" />
							</s:param>
						</s:url> 
						<s:a href="%{eUrl}">
							<s:property value="survey.title" />
						</s:a>
					</td>
					
					<td><s:if test="isSolved==true">Solved</s:if><s:if test="isSolved==false">Un-solved</s:if>
					<!--<s:property value="isSolved"/>-->
						</td>
					<td><s:property value="reason" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
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