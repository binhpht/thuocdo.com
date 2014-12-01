<%@ page import="com.thuocdo.ma.Bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" pageEncoding="UTF-8" %>

<%
	Account acc = null;
	if (session.getAttribute("account") != null) {
		acc = (Account) session.getAttribute("account");
	}
%>
<%
	if (acc == null || (acc != null && acc.getIsAccountTemp() == true)) {
%>

<!-- Login form -->
<h2>Đăng nhập</h2>
<form action="Account_login" method="post" id="frmlogin">
<ol>
	<li><label for="username">Đăng nhập:<span class="red">*</span></label>
	<input id="username" name="txtUsername" class="text" /></li>
	<li><label for="Password">Mật khẩu: <span class="red">*</span></label>
	<input type="password" id="password" name="txtPassword" class="text" /></li>

	<li class="buttons"><input type="submit" class="btnSubmit"
		value="Login" /> <input type="reset" class="btnSubmit" value="Reset" />
	</li>
	<li><a href="Account_viewRegister">Đăng kí</a> | <a href="#">Quên mật khẩu</a></li>
	<li class="clr"></li>
</ol>
</form>
<script language="JavaScript" type="text/javascript"
    xml:space="preserve">//<![CDATA[
//You should create the validator only after the definition of the HTML form
  
  var frmvalidator  = new Validator("frmlogin");

  //frmvalidator.EnableOnPageErrorDisplay();
  //frmvalidator.EnableMsgsTogether();
    frmvalidator.addValidation("username","req","Gõ tên đăng nhập");
    frmvalidator.addValidation("username","maxlen=50","Độ dài tối đa 50");
    frmvalidator.addValidation("username","minlen=5","Độ dài tối thiểu 6");
    frmvalidator.addValidation("password","req","Gõ mật khẩu");
    frmvalidator.addValidation("password","maxlen=50","Độ dài tối đa 50");
    frmvalidator.addValidation("password","minlen=5","Độ dài tối thiểu 6");
     
//]]></script>
<%
	}
%>
<%
	if (acc != null && acc.getIsAccountTemp() != true) {
%>


	<!-- Profile form -->
	<h2>Quản lý cá nhân</h2>
	<ul class="list">
		<li><a href="Account_viewProfile.action">Thông tin</a></li>
		<li><a href="changePassword.jsp">Đổi mật khẩu</a></li>
		<%
			if (acc != null && acc.getRole() != null
							&& !acc.getRole().getRoleName().equals("Admin")) {
		%>
		<li><a href="Survey_managementForCustomer">Quản Lý Khảo Sát</a></li>
		<%
			}
		%>

		<li><a href="payment.jsp">Thanh Toán</a></li>
		<li><a href="Account_logout.action">Thoát</a></li>
	</ul>
	<%
		if (acc != null && acc.getRole() != null
						&& acc.getRole().getRoleName().equals("Admin")) {
	%>
	<!-- Management  -->
	<h2>Quản Lý</h2>
	<ul class="list">
		<!--<li><a href="Role_view.action">Role management</a></li>
		<li><a href="Job_view.action">Job management</a></li>
		<li><a href="AgeRank_view.action">Age rank management</a></li>
		-->
		<li><a href="Account_view.action">Quản Lý Tài Khoản</a></li>
		<li><a href="Category_view.action">Quản Lý Danh Mục</a></li>
		<li><a href="Survey_view.action">Quản Lý Khảo Sát</a></li>
		<li><a href="Illegal_Management.action">Báo cáo vi phạm</a></li>
		<li><a href="FAQ_view.action">FAQs</a></li>
	</ul>
	<%
		}
			}
	%>


<!-- Category survey -->
<h2>Danh Mục Khảo Sát</h2>
<ul class="list">

	<s:iterator value="lstCategory">
		<li><a
			href="Survey_surveyByCategory?id=<s:property value="categoryID"/>" /><s:property
			value="categoryName" /></a></li>
	</s:iterator>
</ul>

<!-- Top member 
<h2>Statistic</h2>
<ul>
	<li>Member 1</li>
	<li>Member 2</li>
	<li>Member 3</li>
</ul>
-->
