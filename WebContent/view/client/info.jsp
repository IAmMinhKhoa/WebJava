<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <main class="wrapperMain_content">	<div class="layout-account">
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
				<div class="col-lg-9 col-md-12 col-12">		
					<div class="row wrap_content_account">
						<div class="col-12 wrap_inforAccount" id="customer_sidebar">
							<p class="title-detail">Thông tin tài khoản</p>
							<p class="name_account"><span>Họ và tên: </span>${name}</p>
							<p class="email "><span>Email: </span>${email}</p>
							<p><span>Ngày sinh: </span>21/07/2002</p>	
							<p><span>Điện thoại: </span>${phone}</p>
								
															

							<span class="btn btn-update">
								<a href="${pageContext.request.contextPath}/view/client/update-account">Cập nhật thông tin tài khoản</a>
							</span>
						</div>
						<div class="col-12 wrap_orderAccount" id="customer_orders">	
							<div class="customer-table-wrap">							
								<div class="customer_order customer-table-bg">		
									
									<p class="title-detail">Danh sách đơn hàng gần đây</p>
									<div class="table-responsive-overflow">
										<div class="table-responsive">
											<table class="table table-customers">
												<thead>
													<tr>
														<th class="order_number text-center">Mã đơn hàng</th>
														<th class="date text-center">Ngày đặt</th>
														<th class="total text-right">Thành tiền</th>
														<th class="payment_status text-center">Trạng thái thanh toán</th>
														<th class="fulfillment_status text-center">Vận chuyển</th>
													</tr>
												</thead>
												<tbody>
													
													<tr data-name="#487194" class="odd cancelled_order">
														<td class="text-center"><a href="/account/orders/1bfaa7a6b46f4f23b848e9fb5619838b" title="">#487194</a></td>
														<td class="text-center"><span>02/04/2023</span></td>
														<td class="text-right"><span class="total money">901,400 ₫</span></td>
														<td class="text-center"><span class="status status_pending">Chờ xử lý</span></td>
														
														<td class="text-center"><span class="delivery status_not fulfilled">Hủy đơn hàng</span></td>
														 
													</tr>
													
												</tbody>
											</table>
										</div>
									</div>
									
								</div>
							</div>
						</div>
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
      