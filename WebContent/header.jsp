<%@ page language="java" pageEncoding="UTF-8" %>

<div class="header">
    <div class="search">
      <div id="cse" style="width: 100%;">Loading</div>
<script src="//www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript"> 
  google.load('search', '1', {language : 'vi', style : google.loader.themes.SHINY});
  google.setOnLoadCallback(function() {
    var customSearchControl = new google.search.CustomSearchControl('012826175445159319024:8lvzev_pgt0');
    customSearchControl.setResultSetSize(google.search.Search.FILTERED_CSE_RESULTSET);
    customSearchControl.draw('cse');
  }, true);
</script>

      
      </form>
    </div>
    <div class="logo"><a href="index.jsp"><img src="images/logo.png" width="277" height="100" border="0" alt="logo" /></a></div>
    <div class="contact_top">
      <ul>
        <li>Nhanh, Tiết Kiệm, Chính Xác</li>
    
      </ul>
    </div>
    <div class="clr"></div>
  </div>
  <div class="menu">
    <ul>
      <li><a href="index.action" class="active"><span>Trang Chủ</span></a></li>
      <li><a href="prices.jsp"><span>Chi Phí</span></a></li>
      <li><a href="FAQ_viewForCustomer.action"><span>FAQ</span></a></li>
      <li><a href="aboutus.jsp"><span>Về Chúng Tôi</span></a></li>
      <li><a href="contact.jsp"><span>Liên Hệ</span></a></li>
    </ul>
  </div>
  <div class="clr"></div>
  