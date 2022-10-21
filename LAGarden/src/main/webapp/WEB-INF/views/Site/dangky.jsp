<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.servletContext.contextPath}/resource/css/CangiuaCss.css"
	rel="stylesheet" />
</head>
<body>
	<div class="content">
		<form action="saveSignUpForm" method="post">
			<div class="my-swapper">
				<div class="form-horizontal">
					<h4
						style="text-align: center; font-size: 30px; font-weight: bold; margin-top: 20px">Đăng
						ký thành viên</h4>
						<c:forEach items="${message }" var="item"> 
							<div class="validation-summary-valid text-danger" 
							data-valmsg-summary="true">
							<ul>
								<li> ${item}</li>
							</ul>
						</div>
						</c:forEach>
					<hr />
					<div class="form-group">
						<div class="validation-summary-valid text-danger" 
							data-valmsg-summary="true">
							<ul>
								<li style="display: none"> </li>
							</ul>
						</div>
					</div>
					<div class="form-group">

						<div class="row">
							<div class="my-a-infor">Tên tài khoản (*):</div>
							<input path = "TenDangNhap" class="form-control boderText " data-val="true"
								data-val-required="Yêu cầu nhập tên đăng nhập" id="UserName"
								name="UserName" type="text" value="" />

						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="my-a-infor">Mật khẩu (*):</div>
							<input class="form-control boderText " data-val="true"
							
								data-val-length="Độ dài mật khẩu ít nhất 6 ký tự."
								data-val-length-max="20" data-val-length-min="6"
								data-val-required="Yêu cầu nhập mật khẩu" id="Password"
								name="Password" type="password" />

						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="my-a-infor">Nhập lại mật khẩu (*):</div>
							<input class="form-control boderText" data-val="true"
								data-val-equalto="Xác nhận mật khẩu không đúng."
								data-val-equalto-other="*.Password" id="ConfirmPassword"
								name="ConfirmPassword" type="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="my-a-infor">Họ và tên (*):</div>
							<input class="form-control boderText " data-val="true"
								data-val-required="Yêu cầu nhập họ tên" id="Name" name="Name"
								type="text" value="" />

						</div>
					</div>

					<div class="form-group">

						<div class="row">
							<div class="my-a-infor">Địa chỉ (*):</div>
							<input class="form-control boderText " cols="20" data-val="true"
								data-val-required="Yêu cầu địa chỉ" id="Address" name="Address"
								rows="2" type="text" />
						</div>
					</div>

					<div class="form-group">

						<div class="row">
							<div class="my-a-infor">E-mail (*):</div>
							<input class="form-control boderText " data-val="true"
								data-val-required="Yêu cầu nhập email" id="Email" name="Email"
								type="email" value="" />

						</div>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="my-a-infor">Số điện thoại (*):</div>
							<input class="form-control boderText " data-val="true"
								data-val-required="Yêu cầu số điện thoại" id="Phone"
								name="Phone" type="tel" value="" />

						</div>
					</div>
					<div class="form-group">
						<div class="row"></div>
					</div>
					<div class="form-group">

						<div class="col-md-offset-2 col-md-10">
							<input type="submit" value="Đăng ký"
								class="btn btn-sm btn-success" /> <a href="dangnhap"
								class="btn btn-sm btn-success">Đăng nhập</a>
						</div>
					</div>

				</div>
			</div>
		</form>
	</div>

	<script>
            function addClass() {
                let ele = document.getElementById('dangky');
                /* thêm class*/
                ele.classList.add('is-active');
            }
            addClass();
        </script>


	<script
		src="${pageContext.servletContext.contextPath}/resource/MyJS/MenuBar JS/MenubarJS.js"></script>
</body>
</html>

