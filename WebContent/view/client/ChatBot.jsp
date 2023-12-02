<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
      <!-- CHATBOT MKHOA -->
      <link href="${url}/css/style_chatbot.css" rel="stylesheet"> 

  <title>Chatbot</title>



<!-- 
	<section id="wrap_chatbot">
	
		<div id="chat-window">
	      <div class="main-title">CHAT BOT CỬA HÀNG</div>
	      <div id="chat-messages"></div>
	      <form id="chat-form">
	        <input
	          type="text"
	          id="chat-input"
	          autocomplete="off"
	          placeholder="Type your message here"
	          required
	        />
	        <button type="submit">Send</button>
	      </form>
	    </div>
	
	</section> -->
	
	
	<section id="wrap_chatbot">
    <div id="chat-window">
        <div class="main-title">CHAT BOT CỬA HÀNG</div>
        <div id="chat-messages"></div>
        <form id="chat-form">
            <input type="text" id="chat-input" autocomplete="off" placeholder="Type your message here" required />
            <select id="chat-options">
                <option value="">Biểu mẫu thông dụng</option>
                <option value="Hôm nay sinh nhật con trai tôi, tôi nên mua đồ chơi gì tặng nó đây? ">Hôm nay sinh nhật con trai tôi, tôi nên mua đồ chơi gì tặng nó đây? </option>
                <option value="Liệu bé gái có thích món đồ chơi công chúa Barie không">Liệu bé gái có thích món đồ chơi công chúa Barie không</option>
                <option value="Cách tặng quà bất ngờ cho con">Cách tặng quà bất ngờ cho con</option>
                <!-- Add more options as needed -->
            </select>
            <button type="submit">Send</button>
        </form>
    </div>
</section>
	    
	    
	    <script>
    // Lắng nghe sự kiện khi combobox thay đổi
    document.getElementById("chat-options").addEventListener("change", function() {
        // Lấy giá trị đã chọn từ combobox
        var selectedOption = this.value;

        // Gán giá trị của combobox vào trường nhập liệu
        document.getElementById("chat-input").value = selectedOption;
    });
</script>
	    

	  
	  
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.3/axios.min.js"></script> -->
	
	<script src="https://cdn.jsdelivr.net/npm/axios@latest/dist/axios.min.js"></script>
	<script src="app.js"></script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      