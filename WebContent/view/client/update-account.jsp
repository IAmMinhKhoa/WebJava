<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <main class="wrapperMain_content">	<div class="layout-account update">
	<div class="container">
		<div class="wrapbox-heading-account">
			<div class="header-page clearfix">
				<h1 class="d-none">Tài khoản của bạn </h1>
			</div>
		</div>
		<div class="wrapbox-content-account">
			<div class="row">
			 <div class="col-lg-3 col-md-12 col-12 sidebar-account">
				<div class="AccountSidebar">
				  <div class="AccountAvatar">
							TN
				  </div>
					 <p class="AccountTitle titleSidebar">Xin chào 
					 <c:if test="${sessionScope.username != null}">
					 	<span>${name}</span></p> 
					 </c:if>
						
					 <div class="AccountContent">
						<div class="AccountList">
							<ul class="list-unstyled">			
								<li><i class="fa-solid fa-circle-user" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/view/client/account">Thông tin tài khoản</a></li>
							    <li><i class="fa fa-list-alt" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/view/client/account?view=list-order">Quản lý đơn hàng</a></li>
							    <li><i class="fa fa-sign-out" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/view/client/logout">Đăng xuất</a></li>
							</ul>
						</div>
					 </div>
				 </div>
			 </div>
			 <div class="col-lg-6 col-md-12 col-12">
					<div class="wrapbox-heading-account">
						<h1>Thông tin tài khoản</h1>
					</div>
					<div class="update_accout user_box">
						<form id="extraInfo" name="formUpdateAccount" method="post" action="${pageContext.request.contextPath}/view/client/update-account" >
							<div class="mb-3">
								<label>Họ Tên:</label>
								<input class="form-control" autocomplete="off" required="" data-errormessage-value-missing="Bạn chưa nhập Họ Tên" type="text" value="${name }" name="fullname" placeholder="Nhập họ tên(*)" id="fullname" size="30">
							</div>
							<div class="mb-3">
								<label>Email:</label>
								<input class="form-control" autocomplete="off" required="" data-errormessage-value-missing="Bạn chưa nhập email" data-errormessage-type-mismatch="Email chưa đúng định dạng!" type="email" value="${email }" placeholder="Nhập email (*)" name="email" id="email" size="30">
							</div>
							<div class="mb-3">
								<label>Số điện thoại:</label>
								<input class="form-control" autocomplete="off" pattern="[0-9]{10}" required="" data-errormessage-value-missing="Bạn chưa nhập số điện thoại" data-errormessage-type-mismatch="Số điện thoại chưa đúng định dạng!" type="tel" value="${phone }" placeholder="Số điện thoại (*)" name="phone" id="phone_ac" size="30">
							</div>
							<div class="mb-3">
								<label>Ngày sinh:</label>
								<input class="form-control" autocomplete="off" required="" data-errormessage-value-missing="Bạn chưa nhập ngày sinh" data-errormessage-type-mismatch="Ngày sinh chưa đúng định dạng!" type="date" placeholder="Ngày sinh (*)" name="birthday" size="30">
							</div>
							<div id="error" class="alert alert-warning text-center d-none" style="color: #f00;"></div>
							<div id="info" class="alert alert-warning text-center d-none"></div>
							<p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>  
							<div class="action_bottom action_link text-center">
								<input class="btn button m-b-10" type="submit" value="Cập nhật thông tin">
								<span class="d-none">hoặc <a href="/account">Hủy</a></span>
							</div>
							<input type="hidden" id="province" name="province" value="Hồ Chí Minh">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

		</main>
    
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      