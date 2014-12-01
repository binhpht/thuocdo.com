<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" pageEncoding="UTF-8" %>

<head>
<title>Marketing Survey</title>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<div class="main">
  <jsp:include page="header.jsp"></jsp:include>
 
  <div class="body">
  <!-- Right -->
    <div class="body_right">
   <h2>Map</h2>
      <p align="center"><img src="images/maps.gif" alt="picture" width="277" height="271"  style="margin-left: -20px;"/></p>
      <p><a href="#">Dummy text of the printing</a></p>
      <p>Been the industry's standard dummy text ever since thes, when rinter.Simply dummy text of thorem Ipsum has been.</p>
    </div>
    <div class="body_center">
      <h2>Contact </h2>
      <form action="#" method="post" id="form">
            <ol>
              <li>
                <label for="name">your name <span class="red">*</span></label>
                <input id="name" name="name" class="text" />
                <p class="clr"/>
              </li>
              <li>
                <label for="email">Your email <span class="red">*</span></label>
                <input id="email" name="email" class="text" />
                <p class="clr"/>
              </li>
              <li>
                <label for="company">Company Name</label>
                <input id="company" name="company" class="text" />
                <p class="clr"/>
              </li>
              <li>
                <label for="subject">Subject</label>
                <input id="subject" name="subject" class="text" />
                <p class="clr"/>
              </li>
              <li>
                <label for="message">message <span class="red">*</span></label>
                <textarea id="message" name="message" rows="6" cols="50"></textarea>
                <p class="clr"/>
              </li>
              <li class="buttons">
                <input type="submit" class="btnSubmit" value="Send"/>
              </li>
          </ol>
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