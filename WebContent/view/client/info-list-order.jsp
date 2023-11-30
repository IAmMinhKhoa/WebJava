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
						<div class="col-12 wrap_inforAccount" id="customer_orders">
							<p class="title-detail">Danh sách đơn hàng gần đây</p>						
							<div class="customer-table-wrapp">	
								<div class="customer_order customer-table-bg">		
									
									<p class="title-detail d-none">Danh sách đơn hàng mới nhất</p>
									<div class="table-responsive-overflow">
										<div class="table-responsive">
											<table class="table table-customers">
												<thead>
													<tr>
														<th class="order_number text-center" width="25%">Mã đơn hàng</th>
														<th class="date text-center" width="25%">Ngày đặt</th>
														<th class="total text-center" width="25%">Thành tiền</th>
														<th class="payment_status text-center" width="25%">Trạng thái thanh toán</th>
													</tr>
												</thead>
												<tbody>
													
													<c:forEach items="${orders}" var="order">
													<tr class="odd cancelled_order">
														<td class="text-center"><a href="/account/orders/1bfaa7a6b46f4f23b848e9fb5619838b" title="">${order.id}</a></td>
														<td class="text-center"><span>${order.created}</span></td>
														<td class="text-center"><span class="total money">${order.amount} VNĐ</span></td>
														<td class="text-center">
															<span class="status status_pending">
																<c:choose>
											                        <c:when test="${order.status == 1}">
											                        	<c:out value="Đang chờ xác nhận"/>
											                       	</c:when>
											                       	<c:when test="${order.status == 2}">
											                        	<c:out value="Đang chuẩn bị đơn hàng"/>
											                       	</c:when>
											                       	<c:when test="${order.status == 3}">
											                        	<c:out value="Đang giao hàng"/>
											                       	</c:when>
											                       	<c:otherwise>
																        <c:out value="Đã giao hàng"/>
																    </c:otherwise>
	                       										</c:choose>
															</span>
														</td>	 
													</tr>
													</c:forEach>
													
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
      