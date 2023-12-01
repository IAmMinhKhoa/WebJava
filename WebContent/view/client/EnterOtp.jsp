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
	<div class="form-gap" ></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default" style="margin-top: 20px">
					<div class="panel-body">
						<div class="text-center">
							<h3>
								<i class="fa fa-lock fa-4x"></i>
							</h3>
							<h2 class="text-center">Nhập mã OTP</h2>
									<%
		  			if(request.getAttribute("message")!=null)
		  			{
		  				out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
		  			}
		  
		  %>
	
							<div class="panel-body">

								<form id="register-form" action="${pageContext.request.contextPath}/view/client/validateOTP" role="form" autocomplete="off"
									class="form" method="post">

									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope color-blue"></i></span> <input
												id="opt" name="otp" placeholder="Nhập mã OTP"
												class="form-control" type="text" required="required">
										</div>
									</div>
									<div class="form-group">
										<input name="recover-submit"
											class="btn aa-browse-btn btn-lg btn-primary btn-block"
											value="Reset Password" type="submit">
									</div>

									<input type="hidden" class="hide" name="token" id="token"
										value="">
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
