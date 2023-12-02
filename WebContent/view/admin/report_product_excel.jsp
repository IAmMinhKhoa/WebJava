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
	response.setHeader("Content-Disposition", "inline; filename=product.xls");
	%>
		<div class="card-body">
                <h5 class="card-title">Danh sách sản phẩm</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                    
                      <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên sản phẩm</th>
            
                        <th scope="col">ID danh mục</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Số Lượng</th>
                        <th scope="col">Giảm giá</th>
                        <th scope="col">Ngày tạo</th>
           
                      </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${productlist}" var="product">
                      <tr>
                        <th scope="row">${product.id }</th>
                        <td>${product.name }</td>
                        
                        <td>${product.catalog_id }</td>
                        <td>${product.price }</td>
                        
                      
                       	<td>${product.quantity }</td>
                       	
                        
                        <td>${product.discount }</td>
                        <td>${product.created }</td>
                       
                      </tr>
                      </c:forEach>
                     
                    </tbody>
                  </table>
                </div>
              </div>


</body>
</html>