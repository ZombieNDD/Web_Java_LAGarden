<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="${pageContext.servletContext.contextPath}/resource/css/MenuBar CSS/MenubarCSS.css" rel="stylesheet" type="text/css" />
<title><tiles:getAsString name="title" /></title>
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
				<a class="navbar-brand" href="/LAGarden/"> <img
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
						active-color="DarkKhaki" id="hotro">Hỗ trợ</a> <a href="datban"
						class="nav-item my-bar-nav-item my-bar-a" active-color="DeepPink"
						id="datban">Đặt bàn</a> <a href="datmon"
						class="nav-item my-bar-nav-item my-bar-a" active-color="LimeGreen"
						id="datmon">Đặt món</a> 
						<%
						String tenTK = (String) session.getAttribute("Fullname");
						if (session.getAttribute("taikhoan") !=null){ %>
							<div class="dropdown nav my-bar-nav my-menu-nav-ver2">
                                <a class="nav-item my-bar-nav-item my-bar-a my-menu-nav-ver2-item" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="margin-left:20px">
                                    Xin chào: <% out.print(tenTK); %>
                                </a>
                                <div class="dropdown-menu my-drop-down" aria-labelledby="dropdownMenuButton">
                                    <div class="dropdown-item"><a href="giohang">Giỏ hàng</a></div>
                                    <div class="dropdown-item"><a href="logout">Đăng xuất</a></div>
                                </div>
                            </div>
						<%}else{ %>
						<a href="dangnhap"
						class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkSlateBlue" id="dangnhap">Đăng nhập</a> <a
						href="dangky" class="nav-item my-bar-nav-item my-bar-a"
						active-color="DarkKhaki" id="dangky">Đăng ký</a> 
						<%} %>  <span
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
