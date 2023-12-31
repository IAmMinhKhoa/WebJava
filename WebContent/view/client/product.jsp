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
  <section id="aa-catg-head-banner">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
         <a href="${pageContext.request.contextPath}/">Trang chủ</a>	 
         <strong>/ Sản phẩm</strong>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- product category -->
  <section id="aa-product-category">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
          <div class="aa-product-catg-content">
           
            <div class="aa-product-catg-body">
              <ul class="aa-product-catg">
                <!-- start single product item -->
                <c:if test="${empty productlist}">
                 	<p style="margin-left: 30px">Chưa có sản phẩm!</p>
                 </c:if>
                <c:forEach items="${productlist}" var="product">
	                
	                	<c:choose>
						    <c:when test="${product.status==1}">
						        <li>
	                  <figure>
	                    <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}" alt="${product.name}"></a>
	                    
	                    <c:choose>
						    <c:when test="${product.quantity>0}">
						        <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/view/client/add-cart?product-id=${product.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
						    </c:when>
						   
						    <c:otherwise>
						        <a class="aa-add-card-btn"><span></span>Đã Hết Hàng !!!</a>
						    </c:otherwise>
						</c:choose>
	                    
	                    
	                    
	                    <figcaption>
	                      <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name}</a></h4>

						<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} VNĐ</span><span class="aa-product-price"></span>
	                     
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">${product1.price} VNĐ</span>
		                      <span class="aa-product-price"><del>${product.price} VNĐ</del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
	                    </figcaption>
	                  </figure>
	                  
	                  <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
	                  
	                </li>
						    </c:when>
						   
						    <c:otherwise>
						       
						    </c:otherwise>
						</c:choose>
	                
	                
	                
                </c:forEach>                                       
              </ul>

              <!-- / quick view modal -->   
            </div>
            
            
            
            <!-- HTML PHÂN TRANG -->
				 <div id="pagination">
				    <button id="prevPage">Prev</button>
				    <span id="currentPage"></span>
				    <button id="nextPage">Next</button>
				</div>
				
				
				
          </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
          <aside class="aa-sidebar">
          
         
          
          
            <!-- single sidebar -->
            <div class="aa-sidebar-widget">
              <h3>Danh mục</h3>
              <ul class="aa-catg-nav">
              <c:forEach items="${catelist}" var="cate">
              	<li><a href="${pageContext.request.contextPath}/view/client/product-id?id=${cate.id}">${cate.name}</a></li>
              </c:forEach>                
              </ul>
            </div>
            <!-- single sidebar -->
			<div class="aa-sidebar-widget">
              <h3>Lọc giá</h3>
	          <form action="${pageContext.request.contextPath}/view/client/product/search-price" method="GET">
	              <div id="range-price">
							<span class="range-left">
								<input id="input-with-keypress-0" type="number" value="${param.pricemin}"  name="pricemin">
							</span>
							<span class="range-right">
								<input id="input-with-keypress-1" type="number" value="${param.pricemax}"  name="pricemax">
							</span>
					</div>
					<div class="btn-container">
						<button class="btn-filter-price">Xem kết quả</button>
					</div>	
				</form>
            </div>
            <!-- single sidebar -->
            <div class="aa-sidebar-widget">
              <h3>Sản phẩm gần đây</h3>
              <div class="aa-recently-views">
                <ul>
                 <c:forEach items="${productlist}" var="product" end="2">
                  <li>
                    <a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}" class="aa-cartbox-img"><img alt="img" src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${product.image_link}"></a>
                    <div class="aa-cartbox-info">
                      <h4><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                      <c:choose>
						<c:when test="${product.discount == 0}">
	                        <p>${product.price} VNĐ</p>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                       <p>${product1.price} VNĐ</p>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                    
                    </div>                    
                  </li>
                  </c:forEach>
                </ul>
              </div>                                 
            </div>
            <!-- single sidebar -->
           
          </aside>
        </div>
       
      </div>
    </div>
  </section>
  
  
  
  
  <!-- JS CONTROLLER PHÂN TRANG  -->
  
  <script>
    var currentPage = 1; // Trang hiện tại
    var productsPerPage = 8; // Số sản phẩm hiển thị trên mỗi trang
    var totalProducts = ${productlist.size()}; // Tổng số sản phẩm

    var prevPageBtn = document.getElementById("prevPage");
    var nextPageBtn = document.getElementById("nextPage");
    var currentPageSpan = document.getElementById("currentPage");

    // Xử lý sự kiện nhấn nút "Prev"
    prevPageBtn.addEventListener("click", function() {
        if (currentPage > 1) {
            currentPage--;
            showProducts();
        }
    });

    // Xử lý sự kiện nhấn nút "Next"
    nextPageBtn.addEventListener("click", function() {
        var maxPage = Math.ceil(totalProducts / productsPerPage);
        if (currentPage < maxPage) {
            currentPage++;
            showProducts();
        }
    });

    // Hiển thị danh sách sản phẩm cho trang hiện tại
    function showProducts() {
        var productList = document.getElementsByClassName("aa-product-catg")[0];
        var products = productList.getElementsByTagName("li");

        var startIndex = (currentPage - 1) * productsPerPage;
        var endIndex = startIndex + productsPerPage;

        // Ẩn tất cả các sản phẩm
        for (var i = 0; i < products.length; i++) {
            products[i].style.display = "none";
        }

        // Hiển thị sản phẩm cho trang hiện tại
        for (var j = startIndex; j < endIndex+1; j++) {
            if (j < products.length) {
                products[j].style.display = "block";
            }
        }

        // Cập nhật trạng thái phân trang
        currentPageSpan.textContent = currentPage;

        // Kiểm tra và ẩn/hiện các nút phân trang
        prevPageBtn.disabled = (currentPage === 1);
        nextPageBtn.disabled = (currentPage === Math.ceil(totalProducts / productsPerPage));
    }

    // Hiển thị sản phẩm cho trang ban đầu
    showProducts();
</script>
  
  
  
  
  
  
  
  
  
  
  
  
<!-- / product category -->
<!--  end content-->
  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
 

  