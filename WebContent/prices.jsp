<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
  
  <div class="body">
  <h2>Cost and remuneration</h2>
  	<div style="float: left;">
      	<div style="padding-bottom:3px;">
            <span style="font-size:20px;color:#06F">Create survey cost</span>
        </div>
  		<div style="padding-left:30px; padding-top:10px; ">
            <span style="color:#F00 ;border: 1px dashed red; padding: 5px;">Create survey cost = Number of answered people * Cost</span>
        </div>
        <div style="padding-top:20px;padding-left:10px;">
            <div style="padding-top:5px;">
                <b>Number of answered people</b>: number of people completed surveys.
            </div>
            <div style="padding-top:5px;">
                <b>Cost</b>: 2.500 vnd / one answered person.
            </div>
            <div style="padding-top: 5px;">

                <b>Example</b>: a survey has number of answered people are 200 people.
            </div>
            <div style="padding-top: 5px;">
                So create survey cost = 200 * 2.500 = 500.000 vnd.
            </div>
        </div>
		</div>
		<div style="float: left; margin-left: 30px;">        
        <div style="padding-bottom:3px;">
            <span style="font-size:20px;color:#06F">Remuneration for survey participants (RSP)</span>
        </div>
  		<div style="padding-left:30px; padding-top:10px;">
            <span style="color:#F00;border: 1px dashed red; padding: 5px;">RSP = Number of completed surveys * Remuneration level</span>
        </div>
        <div style="padding-top:20px;padding-left:10px;">
            <div style="padding-top:5px;">
                <b>Number of completed surveys</b>: number of surveys that a person has completed.
            </div>
            <div style="padding-top:5px;">
                <b>Remuneration level</b>: 1000 vnd / one survey.
            </div>
            <div style="padding-top: 5px;">
                <b>Example</b>: a person has completed 100 survey.
            </div>
            <div style="padding-top: 5px;">
                So RSP = 100 * 100 = 100.000 vnd.
            </div>
             <div style="padding-top: 5px;">
                <b>Note</b>: we pay only when you complete enough 20  surveys
            </div>
        </div>
        </div>
        <div style="clear: both;"></div>
  </div>
  <div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>