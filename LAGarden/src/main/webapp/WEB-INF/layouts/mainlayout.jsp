<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link href="${pageContext.servletContext.contextPath}/resource/css/MenuBar CSS/MenubarCSS.css" rel="stylesheet" type="text/css" />
<tiles:insertAttribute name="head" />
<style>
body {
	background-image: url("resource/Img/AN1.jpg");
	background-size: cover;
	height: 100%;
}

footer {
	padding: 1em;
	color: black;
	clear: left;
	margin-top: 30px;
}
</style>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-lg navbar-dark bg-dark w-100 my-bar-margin-nav">
			<div class="container">
				<!-- Brand -->
				<a class="navbar-brand" href="~/Site/Home"> <img
					src="${pageContext.servletContext.contextPath}/resource/Img/logo2.png" width="220" height="50" alt="Logo" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<nav class="nav my-bar-nav">
					<a href="thongtin" class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkSlateBlue" id="thongtin">Thông tin</a> <a
						href="hotro" class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkKhaki" id="hotro">Hỗ trợ</a> <a href="/dat-ban"
						class="nav-item my-bar-nav-item my-bar-a" active-color="DeepPink"
						id="datban">Đặt bàn</a> <a href="/dat-mon"
						class="nav-item my-bar-nav-item my-bar-a" active-color="LimeGreen"
						id="datmon">Đặt món</a> <a href="/dang-nhap"
						class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkSlateBlue" id="dangnhap">Đăng nhập</a> <a
						href="/dang-ky" class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkKhaki" id="dangky">Đăng ký</a> <span
						class="nav-indicator my-bar-nav-indicator"></span>
				</nav>
			</div>
		</nav>
	</header>

	<tiles:insertAttribute name="body" />

	<footer style="background-color: black; opacity: 0.7;">
		<p style="color: white; text-align: right; text-decoration: none">
			Khu Biệt Thự Lan Anh, 2 Đường Số 45, P. Bình An, Quận 2, TP. HCM<br />Giờ
			mở cửa: 06:30 - 21:30 <br />©Copyright by
		</p>
	</footer>
	<tiles:insertAttribute name="thongtin" />
	<tiles:insertAttribute name="hotro" />
	<tiles:insertAttribute name="datban" />
	<tiles:insertAttribute name="datmon" />

	
	
	<script src="${pageContext.servletContext.contextPath}/resource/MyJS/MenuBar JS/MenubarJS.js"></script>
</body>
</html>
