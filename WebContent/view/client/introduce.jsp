<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <section id="aa-catg-head-banner">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
         <a href="${pageContext.request.contextPath}/">Trang chủ</a>	 
         <strong>/ Giới thiệu</strong>
      </div>
     </div>
   </div>
  </section>
    <div class="container">
      <div class="row">
      	<div>
      		<h1 style ="text-align: center; color: red;">Cửa hàng đồ chơi</h1>
      		<p>Chào mừng quý khách đến với cửa hàng chúng tôi <strong>Toy Store</strong> - nơi tuyệt vời dành cho trẻ em và 
      		những khoảnh khắc đáng nhớ của tuổi thơ! Chúng tôi tự hào là địa chỉ đáng tin cậy để bạn khám phá và chọn lựa những món đồ chơi tuyệt vời nhất cho các bé yêu của mình.</p>
      		<p>Trong thế giới ngập tràn đồ chơi, chúng tôi đã chọn lọc những sản phẩm chất lượng cao từ các nhãn hiệu uy tín trên thị trường. 
      		Tại cửa hàng của chúng tôi, bạn sẽ khám phá ra những đồ chơi phản ánh sự sáng tạo, khám phá và học hỏi, tất cả được thiết kế để kích thích trí tưởng tượng và phát triển kỹ năng của trẻ em.
			<img src="${url}/images/banner_product.png" alt="" width="100%" style="margin:30px 0 30px 0 ">
			<p>Không chỉ là nơi mua sắm, cửa hàng của chúng tôi còn là không gian thân thiện và am hiểu với trẻ em. 
			Với các khu vực chuyên biệt theo độ tuổi, bạn sẽ dễ dàng tìm thấy những sản phẩm phù hợp nhất cho từng giai đoạn phát triển của bé yêu.</p>
			<p>Đội ngũ nhân viên nhiệt tình và giàu kinh nghiệm của chúng tôi luôn sẵn lòng hỗ trợ bạn trong quá trình chọn lựa. Chúng tôi cam kết mang đến trải nghiệm mua sắm trực tuyến dễ dàng, an toàn và thú vị nhất, 
			giúp gia đình bạn xây dựng những ký ức đáng nhớ từ những khoảnh khắc vui chơi của con trẻ. Hãy đồng hành cùng chúng tôi để làm cho thế giới của trẻ em trở nên phong phú và đầy thú vị!</p>
      	</div>
      </div>
     </div>
    </section>
    
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      