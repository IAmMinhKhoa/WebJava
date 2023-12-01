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
 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-login">
                <h4>Nhập mật khẩu mới</h4>
                  <form class="aa-login-form" action="${pageContext.request.contextPath}/view/client/newPassword" method="POST">
								<div class="card-body">
							<label for="email-for-pass">Nhập mật khẩu mới</label> 
							<input class="form-control" autocomplete="off" required="" type="password" placeholder="Nhập mật khẩu mới" name="password" id="email" size="30">
							<label for="email-for-pass">Nhập lại mật khẩu</label> 
							<input class="form-control" autocomplete="off" required="" type="password" placeholder="Xác nhận mật khẩu" name="confPassword" id="email" size="30">
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
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
