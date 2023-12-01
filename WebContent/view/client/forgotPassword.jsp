<%-- 
    Document   : index
    Created on : May 5, 2020, 10:57:00 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
<!--  content -->
 <!-- catg header banner section -->
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-login">
					<h2>Bạn quên mật khẩu?</h2>
                
                	<div class="forgot">
						<p>Thay đổi mật khẩu của bạn chỉ trong ba bước đơn giản. Điều này sẽ giúp bạn bảo mật mật khẩu của mình!</p>
						<ol class="list-unstyled">
							<li><span class="text-primary text-medium">1. </span>Nhập địa chỉ email bạn đã đăng kí vào bên dưới.</li>
							<li><span class="text-primary text-medium">2. </span>Hệ thống sẽ gửi cho bạn một mã OTP qua email.</li>
							<li><span class="text-primary text-medium">3. </span>Nhập mã OTP vào trang tiếp theo.</li>
						</ol>
					</div>
                 
                 	<form class="card mt-4" action="${pageContext.request.contextPath}/view/client/forgotPassword" method="POST">
						<div class="card-body">
							<div class="form-group" style="margin-top: 20px">
								<label for="email-for-pass">Nhập địa chỉ email của bạn</label> 
								<input class="form-control" autocomplete="off" required="" type="email" placeholder="Nhập email (*)" name="email" id="email" size="30">
								<small class="form-text text-muted">Vui lòng nhập địa chỉ email đã đăng ký. Chúng tôi sẽ gửi một mã OTP đến địa chỉ này qua email.</small>
							</div>
						</div>
						<div class="action_bottom action_link text-left">
								<input class="aa-browse-btn" type="submit" value="Gửi">
								<span class="" style="margin-left: 15px"><a href="${pageContext.request.contextPath}/view/client/login">Hủy</a></span>
						</div>
					</form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

<!--  end content-->
<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
