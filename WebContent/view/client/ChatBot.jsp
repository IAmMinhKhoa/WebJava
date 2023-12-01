<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
      <!-- CHATBOT MKHOA -->
      <link href="${url}/css/style_chatbot.css" rel="stylesheet"> 

  <title>Chatbot</title>




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
	
	</section>
	    
	    
	    
	    

	  
	  
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.3/axios.min.js"></script> -->
	
	<script src="https://cdn.jsdelivr.net/npm/axios@latest/dist/axios.min.js"></script>
	<script src="app.js"></script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      