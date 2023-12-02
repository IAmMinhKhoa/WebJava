<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin-username") == null){
	  response.sendRedirect(request.getContextPath() + "/admin/login"); 
  }
  %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="card mt-3">
          <div class="card-content">
            <div class="row row-group m-0">
            
            
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body"   items="${transactions_ToDay}" var="transactions_ToDay">
                  <h5 class="text-white mb-0">${transactions_ToDay } <span class="float-right">VNĐ	</i></span>
                  </h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:100%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Lợi Nhuận(Hôm Nay)<span class="float-right"> <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              
              
             
             
             <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body"   items="${transactions_Yesterday}" var="transactions_ToDay">
                  <h5 class="text-white mb-0">${transactions_Yesterday } <span class="float-right">VNĐ	</i></span>
                  </h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:100%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Lợi Nhuận(Hôm Qua)<span class="float-right"> <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              
              
              
              
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body"   items="${transactions_ThatMonth}" var="transactions_ToDay">
                  <h5 class="text-white mb-0">${transactions_ThatMonth } <span class="float-right">VNĐ	</i></span>
                  </h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:100%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Lợi Nhuận(Tháng Này)<span class="float-right"> <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              
              
              
              
              <div class="col-12 col-lg-6 col-xl-3 border-light">
                <div class="card-body"   items="${transactions_LastMonth}" var="transactions_ToDay">
                  <h5 class="text-white mb-0">${transactions_LastMonth } <span class="float-right">VNĐ	</i></span>
                  </h5>
                  <div class="progress my-3" style="height:3px;">
                    <div class="progress-bar" style="width:100%"></div>
                  </div>
                  <p class="mb-0 text-white small-font">Lợi Nhuận(Tháng Rồi)<span class="float-right"> <i
                        class="zmdi zmdi-long-arrow-up"></i></span></p>
                </div>
              </div>
              
             
            </div>
          </div>
        </div>
        <div class="row">
        
        <!-- TOP 5 PRODUCT -->
          <div class="col-12 col-lg-4 col-xl-4">
            <div class="card">
              <div class="card-header">Sản Phẩm Bán Chạy
              </div>
              <div class="card-body">
                <div class="chart-container-2">
                  <canvas id="chart1"></canvas>
                </div>
              </div>
              <div class="table-responsive">
                <table class="table align-items-center">
                  <tbody>
                  	
                   	<c:forEach items="${productlistTOP5}" var="product">
			          	<tr>
	                      <td><i class="fa fa-circle text-white mr-2"></i>${product.name }</td>
	                      <td>${product.quantity} Cái</td>
	                      
	                    </tr>
			        </c:forEach>
                  
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- TOP 5 PRODUCT -->
          
          
          
          
          <!-- TOP 5 USER -->
          <div class="col-12 col-lg-4 col-xl-4">
            <div class="card">
              <div class="card-header">Top 5 Khách Hàng Thành Viên
              </div>
              <div class="card-body">
                <div class="chart-container-2">
                  <canvas id="chart2"></canvas>
                </div>
              </div>
              <div class="table-responsive">
                <table class="table align-items-center">
                  <tbody>
                  	
                   	<c:forEach items="${userlistTOP5}" var="user">
			          	<tr>
	                      <td><i class="fa fa-circle text-white mr-2"></i>${user.name }</td>
	                      <td>${user.amount} VNĐ</td>
	                      
	                    </tr>
			        </c:forEach>
                  
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- TOP 5 PRODUCT -->
          
          
          
          
          <!-- TOP 5 PRODUCT HIGT QUANTITY -->
          <div class="col-12 col-lg-4 col-xl-4">
            <div class="card">
              <div class="card-header">Top 5 Sản Phẩm Số Lượng
              </div>
              <div class="card-body">
                <div class="chart-container-2">
                  <canvas id="chart3"></canvas>
                </div>
              </div>
              <div class="table-responsive">
                <table class="table align-items-center">
                  <tbody>
                  	
                   	<c:forEach items="${prodcutHighestQuantity}" var="product_hight_quantity">
			          	<tr>
	                      <td><i class="fa fa-circle text-white mr-2"></i>${product_hight_quantity.name }</td>
	                      <td>${product_hight_quantity.quantity} cái</td>
	                      
	                    </tr>
			        </c:forEach>
                  
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- TOP 5 PRODUCT HIGT QUANTITY -->
          
          
          
        </div>
      </div>
    </div>
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <div class="right-sidebar">
      <div class="switcher-icon">
        <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
      </div>
      <div class="right-sidebar-content">
        <p class="mb-0">Màu nền admin</p>
        <hr>
        <ul class="switcher">
          <li id="theme1"></li>
          <li id="theme2"></li>
          <li id="theme3"></li>
          <li id="theme4"></li>
          <li id="theme5"></li>
          <li id="theme6"></li>
        </ul>
        <p class="mb-0">Màu nền gradient</p>
        <hr>
        <ul class="switcher">
          <li id="theme7"></li>
          <li id="theme8"></li>
          <li id="theme9"></li>
          <li id="theme10"></li>
          <li id="theme11"></li>
          <li id="theme12"></li>
          <li id="theme13"></li>
          <li id="theme14"></li>
          <li id="theme15"></li>
        </ul>
      </div>
    </div>

  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />
    
    
    
    <script>
   
    function CharTop5Product() {
    "use strict";
    var ctx = document.getElementById("chart1").getContext('2d');
    var productData = []; // Array to store product data
    var productLabels = []; // Array to store product names

    // Iterate over the productlistTOP5 list and extract the necessary data
    <c:forEach items="${productlistTOP5}" var="product">
        productLabels.push("${product.name}");
        productData.push(${product.quantity});
    </c:forEach>

    var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: productLabels,
            datasets: [{
                backgroundColor: [
                    "#ffffff",
                    "rgba(255, 255, 255, 0.70)",
                    "rgba(255, 255, 255, 0.50)",
                    "rgba(255, 255, 255, 0.20)",
                    "rgba(1, 255, 255, 0.20)"
                ],
                data: productData,
                borderWidth: [0, 0, 0, 0]
            }]
        },
        options: {
            maintainAspectRatio: false,
            legend: {
                position: "bottom",
                display: false,
                labels: {
                    fontColor: '#ddd',
                    boxWidth: 15
                }
            },
            tooltips: {
                displayColors: false
            }
        }
    });
}

    function CharTop5ProductHightQuantitt() {
        "use strict";
        var ctx = document.getElementById("chart3").getContext('2d');
        var productData = []; // Array to store product data
        var productLabels = []; // Array to store product names

        // Iterate over the productlistTOP5 list and extract the necessary data
        <c:forEach items="${prodcutHighestQuantity}" var="prodcutHighestQuantity">
            productLabels.push("${prodcutHighestQuantity.name}");
            productData.push(${prodcutHighestQuantity.quantity});
        </c:forEach>

        var myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: productLabels,
                datasets: [{
                    backgroundColor: [
                        "#ffffff",
                        "rgba(255, 255, 255, 0.70)",
                        "rgba(255, 255, 255, 0.50)",
                        "rgba(255, 255, 255, 0.20)",
                        "rgba(1, 255, 255, 0.20)"
                    ],
                    data: productData,
                    borderWidth: [0, 0, 0, 0]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    position: "bottom",
                    display: false,
                    labels: {
                        fontColor: '#ddd',
                        boxWidth: 15
                    }
                },
                tooltips: {
                    displayColors: false
                }
            }
        });
    }
    
    
    
    function CharTop5User() {
        "use strict";
        var ctx = document.getElementById("chart2").getContext('2d');
        var productData = []; // Array to store product data
        var productLabels = []; // Array to store product names

        // Iterate over the productlistTOP5 list and extract the necessary data
        <c:forEach items="${userlistTOP5}" var="user">
            productLabels.push("${user.name}");
            productData.push(${user.amount});
            console.log("${user.name}");
        </c:forEach>

        var myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: productLabels,
                datasets: [{
                    backgroundColor: [
                        "#ffffff",
                        "rgba(255, 255, 255, 0.70)",
                        "rgba(255, 255, 255, 0.50)",
                        "rgba(255, 255, 255, 0.20)",
                        "rgba(1, 255, 255, 0.20)"
                    ],
                    data: productData,
                    borderWidth: [0, 0, 0, 0]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    position: "bottom",
                    display: false,
                    labels: {
                        fontColor: '#ddd',
                        boxWidth: 15
                    }
                },
                tooltips: {
                    displayColors: false
                }
            }
        });
    }

    
    $(function() {
       
    	CharTop5Product();
    	CharTop5ProductHightQuantitt();
    	CharTop5User();
    });
  
</script>