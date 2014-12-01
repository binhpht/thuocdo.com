<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Thước Đo- Đo Lường Mọi GIá Trị</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
  
  <div class="body">
  <!-- Right -->
    <div class="body_right">
   <jsp:include page="bodyright.jsp"></jsp:include>      
    </div>
    <div class="body_center">
  <form action="JoinSurvey_saveJoinSurvey.action" method ="post" class="tabForm">
    <h2 style="text-align: center;">Welcome to <s:property value="survey.title"  /></h2>
    <h3 style="color:gray; font-size: 16px;"> You have <s:property value="survey.questions.size"  /> question </h3>
    <a href="Illegal_illegalReason.jsp" class="buttonAdd" style="margin-left: 85%; padding: 5px 20px;">Is illegal</a>
    <% int i =1 ;%>  
   <c:forEach var="question" items="${survey.questions}">
  <h3 style="border-bottom: solid 1px gray;"> Question <%= i++ %>  : <c:out value="${question.questionContent}"/> </h3>
  <%int j=0; %>
   <c:forEach var="answer" items="${question.answers}" >  
  <% 
  	if(j%2==0){
  %>
  <br/>
  <%
  	} 
  	j++;
  %>

 	<c:if test="${question.typeOfQuestion.typeOfQuestionID==1}">
	   <input type="radio" name="${question.questionID}"  value="${answer.answerID }"  /> 
	   <c:out  value="${answer.answerContent}"/><br/>
   </c:if>
   
   <c:if test="${question.typeOfQuestion.typeOfQuestionID==2}">
	   <input type="checkbox" name="${question.questionID}" value="${answer.answerID }" /> 
	   <c:out  value="${answer.answerContent}"/><br/>
   </c:if>
   
   <c:if test="${question.typeOfQuestion.typeOfQuestionID==3}">
   		<textarea style="width: 80%; height: 100px;" name="typeText.answer${answer.answerID}"></textarea><br/>
   </c:if>
 	 
  </c:forEach>    
  </c:forEach>
      <% i=1; %>
      <br/>
    <input  type="submit" value="Done" class="button" style="margin-left: 90%;" />
    </form>

	
    </div>
    <div class="clr"></div>
  </div>
  <div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>