<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<title>Đăng nhập hệ thống</title>
<style>
.swapper {
	max-width: 600px;
	min-height: 30px;
	border: 1px solid gray;
	padding: 15px;
	border-radius: 10px;
	margin: auto;
}

.boderText {
	width: 300px;
}
</style>
</head>
<body>
	<div class="swapper mt-md-5">
		<h3 class="text-center text-danger">ĐĂNG NHẬP HỆ THỐNG</h3>
		<div class="row">
			<div class="col-md-4">
				<img
					src="${pageContext.servletContext.contextPath}/resource/Img/chiakhoa.jpg"
					width="180" height="180">
			</div>

			<div class="col-md-8">
				<form action="adminedit" method="POST">
					<div class="form-group">
						<label><strong>Tên đăng nhập (*) :</strong></label><br> <input
							name="id">  
					</div>
					<div class="form-group">
						<label><strong>Mật khẩu (*): </strong></label> <br> <input
							name="password" type="password" />
					</div>
					<button type="submit" class="btn btn-success">ĐĂNG NHẬP</button>
				</form>
				
				<div class="form-group">
					<p>(*) Thông tin bắt buộc phải nhập</p>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
