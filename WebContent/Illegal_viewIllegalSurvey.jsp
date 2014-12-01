<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<form action="Illegal_ConfirmIllegal.action" method="post">
	<s:label name="title">Title:</s:label><s:property value="survey.title"/>
	<br/>
	<s:label name="categoryName">Category:</s:label><s:property value="survey.category.categoryName"/>
	<br/>
	<s:textarea name="survey.description" cols="50" rows="4" label="Description"></s:textarea>
	<br/>
	<s:label>The questions:</s:label>
<%
	int i = 1;
%> <c:forEach var="question" items="${survey.questions}">
	<h2>Question <%=i++%> : <c:out
		value="${question.questionContent}" /></h2>
	<%
		int j = 0;
	%>
	<c:forEach var="answer" items="${question.answers}">
		<%
			if (j % 2 == 0) {
		%>
		<br />
		<%
			}
					j++;
		%>

		<c:if test="${question.typeOfQuestion.typeOfQuestionID==1}">
			<input type="radio" name="${question.questionID}"
				value="${answer.answerID }" />
			<c:out value="${answer.answerContent}" />
		</c:if>

		<c:if test="${question.typeOfQuestion.typeOfQuestionID==2}">
			<input type="checkbox" name="${question.questionID}"
				value="${answer.answerID }" />
			<c:out value="${answer.answerContent}" />
		</c:if>

		<c:if test="${question.typeOfQuestion.typeOfQuestionID==3}">
			<textarea rows="4" cols="50" name="typeText.answer${answer.answerID}"></textarea>
		</c:if>

	</c:forEach>
</c:forEach>
<center><input type="submit" value="Confirm illegal" /></center>
<center><a href="Illegal_ConfirmLegal">Confirm legal</a></center>
</form>


</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>