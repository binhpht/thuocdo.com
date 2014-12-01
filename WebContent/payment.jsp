<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" pageEncoding="UTF-8" %>

<head>
<title>Thước Đo</title>
<script type="text/javascript" src="js/jquery.js"></script>
<jsp:include page="head.jsp"></jsp:include>

</head>
<body>
<div class="main"><jsp:include page="header.jsp"></jsp:include> <jsp:include
	page="blockHeader.jsp"></jsp:include>
<div class="header_panel"><jsp:include page="headerpanel.jsp"></jsp:include>
</div>
<div class="body"><!-- Right -->
<div class="body_right"><jsp:include page="bodyright.jsp"></jsp:include>
</div>
<div class="body_center">



<div style="float: left; width: 50%">
<h2>Thanh Toán</h2>
<form target="paypal" action="https://www.paypal.com/cgi-bin/webscr"
	method="post"><input type="hidden" name="cmd" value="_s-xclick" />
<input type="hidden" name="hosted_button_id" value="ASDDXB2DLH4XN" />
<table>
	<tr>
		<td><input type="hidden" name="on0" value="Prices" />Giá</td>
	</tr>
	<tr>
		<td><select name="os0">
			<option value="Standar">Gói Chuẩn $20.00</option>
			<option value="Vip">Gói Vip $40.00</option>
			<option value="Special">Đặc biệt $75.00</option>
		</select></td>
	</tr>
</table>
<input type="hidden" name="currency_code" value="USD" /> <input
	type="image" src="https://www.paypal.com/en_US/i/btn/btn_cart_LG.gif"
	name="submit" alt="PayPal - The safer, easier way to pay online!" /> <img
	alt="" border="0" src="https://www.paypal.com/en_US/i/scr/pixel.gif"
	width="1" height="1" /></form>




</div>
<div style="float: left; width: 45%">
<h2>We Accept</h2>
<!-- PayPal Logo -->
<table border="0" cellpadding="10" cellspacing="0" align="center">
	<tr>
		<td align="center"></td>
	</tr>

	<tr>
		<td align="center"><a href="#" onclick=javascript:
			window
			.open(
					'https://www.paypal.com/us/cgi-bin/webscr?cmd=xpt/Marketing/popup/OLCWhatIsPayPal-outside
			',
					'olcwhatispaypal',
					'toolbar=no, location=no,
			directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes,
			width=400, height=350');;
><img
			src="https://www.paypal.com/en_US/i/bnr/horizontal_solution_PPeCheck.gif"
			border="0" alt="Solution Graphics" /></a></td>
	</tr>
</table>
</div>

<div style="clear: both;"></div>

<!-- PayPal Logo --></div>
<div class="clr"></div>
</div>
<div class="footer"><jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>