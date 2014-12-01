<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<head>
<title>Marketing Survey</title>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
		$(".active").removeClass("active");
		$("#faq").addClass("active");
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("a[name^='faq-']").each(function() {
			$(this).click(function() {
				$(".moveto").removeClass("moveto");
				$("#" + this.name).addClass("moveto");
			});
		});
	});
</script>
</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> 

<div class="body">
<h2>FAQs</h2>
<div id="contentFAQs">
<ul class="faq-top">
	<s:iterator value="lstFAQForCustomer">
		<li><a href="#faq-<s:property value='faqid'/>" name="faq-<s:property value='faqid'/>"><s:property
			value="questionContent" /> </a></li>
	</s:iterator>

	<!--<li><a href="#faq-b" name="faq-b"><span>How to participate in the survey?</span></a></li>
                <li><a href="#faq-c" name="faq-c"><span>How will I be intimated with the new survey?</span></a></li>
                <li><a href="#faq-d" name="faq-d"><span>What if it gives error, after participating
                    in the entire survey, and clicked on the submit button at the last for submitting
                    the survey?</span></a></li>
                <li><a href="#faq-e" name="faq-e"><span>Why I am unable to participate in the survey?</span></a></li>
                <li><a href="#faq-f" name="faq-f"><span>Why my registration request is not accepted?</span></a></li>
                <li><a href="#faq-g" name="faq-g"><span>Will there be any benefit if participated in
                    the survey?</span></a></li>
                <li><a href="#faq-h" name="faq-h"><span>How to participate in the competitions?</span></a></li>
                <li><a href="#faq-i" name="faq-i"><span>What if there are some arrears in participating
                    the survey?</span></a></li>
            -->
</ul>
<hr />
<ul>
	<s:iterator value="lstFAQForCustomer">
		<li id="faq-<s:property value='faqid'/>">
		<p class="question"><b><s:property value="questionContent"/></b></p>
		<p class="answer"><s:property value="answerContent"/> </p>
		</li>
	</s:iterator>
	<!--<li id="faq-b">
                    <p class="question">
                        <b>How to participate in the survey?</b></p>
                    <p class="answer">
                        - Your survey which u take part in hasn't been out of date.</p>
                </li>
                <li id="faq-c">
                    <p class="question">
                        <b>How will I be intimated with the new survey?</b></p>
                    <p class="answer">
                        - On the home page , we always display five new surveys and you can easily see it</p>
                </li>
                <li id="faq-d">
                    <p class="question">
                        <b>What if it gives error, after participating in the entire survey, and clicked on
                            the submit button at the last for submitting the survey?</b>
                    </p>
                    <p class="answer">
                        - IF u get errors , u could send them to admin , and we'll fix them .</p>
                </li>
                <li id="faq-e">
                    <p class="question">
                        <b>Why I am unable to participate in the survey?</b></p>
                    <p class="answer">
                        - There are two main reasons :<br />
                        1.Not the registered user and
                        <br />
                        2.Technical Problem</p>
                </li>
                <li id="faq-f">
                    <p class="question">
                        <b>Why my registration request is not accepted?</b></p>
                    <p class="answer">
                        - u have to be sure u type exactly and completely your information. When you register
                        into website that you must obey all our rules.</p>
                </li>
                <li id="faq-g">
                    <p class="question">
                        <b>Will there be any benefit if participated in the survey?</b></p>
                    <p class="answer">
                        -You have got knowledge about the environment and healthy , have a lot of experience
                        about surveys.</p>
                </li>
                <li id="faq-h">
                    <p class="question">
                        <b>How to participate in the competitions?</b></p>
                    <p class="answer">
                        - When U take part in that survey, you will have an exam to pass , and u have to
                        do exam on our website directly.</p>
                </li>
                <li id="faq-i">
                    <p class="question">
                        <b>What if there are some arrears in participating the survey?</b></p>
                </li>
            -->
</ul>
</div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>