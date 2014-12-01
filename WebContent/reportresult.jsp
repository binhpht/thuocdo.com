<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Enumeration"%>
<%@page import="javax.servlet.jsp.tagext.PageData"%>
<%@ page import="com.thuocdo.ma.Bean.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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


<h2>Report : <s:property value="survey.title"  /> </h2>
<c:set var="count" value="${countNumber}"/>  
<c:set var="percent" value="${percentResult}"/>  
  <table border="1">    
  <thead align="center">
  	<td>Question</td>
  	  	<td>Answer</td>
  	
  	  	<td>Number Choise</td>
  	
  	  	<td>Percent</td>
  	
  </thead>
<% double[][] percentResult = (double[][])pageContext.getAttribute("percent"); %>
<% long [] countNumber = (long[])pageContext.getAttribute("count"); %>
<% int i = 0; int k = 0;%>
<c:forEach var="question" items="${survey.questions}">
<c:if test="${question.typeOfQuestion.typeOfQuestionID!=3}">
<% i++; int j = 0; %> 
<% int aaa =0; %>
<c:set var="aaa" value="0"/>
     <c:set var="bbb" value = "0"/>

 <c:forEach var="answer" items="${question.answers}"  >  
 	<c:set value="${bbb+1 }" var="bbb"/>
   </c:forEach>
<!--  <c:out value="${bbb}"></c:out>-->
 <c:forEach var="answer" items="${question.answers}"  >  
 <tr>
<% j++; k++; %> 
 <c:if test="${aaa==0}"><td rowspan="${bbb}">
 <%=i %>. <c:out  value="${question.questionContent } "/> 
</td></c:if>


<td> <c:out  value="${answer.answerContent}"/>  </td>


  <td><%= countNumber[k]%></td>


 <td><%= String.format("%2.2f",percentResult[i][j]*100)%>   %</td>


<c:set var="aaa" value="4"/>
</tr>
</c:forEach>

</c:if>

</c:forEach>

<br></br>
   </table >
   
      <table border='1'>
      <thead align="center">
       <td> Question</td> 
      <td> Answer</td>
            <td> Name Person</td>
      
            <td> Address</td>
            <td> Birth year</td>
                        <td> Job name</td>
            
      
      </thead>
 <s:iterator value="%{lstReport}" id="row" >
        <tr>
         <s:iterator value="%{#row}" id="cell"    >
                <td><s:property value="%{#cell}"/></td>
            </s:iterator>
        </tr>
    </s:iterator>
</table>
   


</div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>