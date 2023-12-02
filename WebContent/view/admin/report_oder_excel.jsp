<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "inline; filename=Oder.xls");
	%>

			<div class="card-body">
                <h5 class="card-title">Danh sách đơn hàng</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                       <th scope="col">Tài khoản User</th>
                        <th scope="col">Họ Tên</th>
                        <th scope="col">Email</th>
                        <th scope="col">SĐT</th>
                         <th scope="col">Địa chỉ</th>
                         <th scope="col">Ghi chú</th>
                         <th scope="col">Tổng tiền</th>
                         <th scope="col">Phương thức thanh toán</th>
                         <th scope="col">Trạng thái</th>
                          <th scope="col">Ngày tạo</th>
                      
                        
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${order}" var="order">
                      <tr>
                        <td scope="row">${order.id}</td>
                         <td>${order.user_session}</td>
                        <td>${order.user_name}</td>
                        <td>${order.user_mail}</td>
                        <td>${order.user_phone}</td>
                        <td>${order.address}</td>
                         <td>${order.message}</td>
                         <td>${order.amount} VNĐ</td>
                          <td>  <c:choose>
	                        <c:when test="${order.payment == 0}"> 
	                        	<c:out value="COD"/>
	                       	</c:when>
	                       	<c:otherwise>
						        <c:out value="Thẻ nội địa ATM"/>
						    </c:otherwise>
                       	</c:choose>
                          
                          </td>
                          <td>    
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
                          </td>
                           <td>${order.created}</td>
                           
        				
        				
                     </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
</body>
</html>