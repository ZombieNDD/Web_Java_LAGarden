<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/1147679ae7.js" crossorigin="anonymous"></script>
    <style><%@include file="/resource/css/trangchu.css"%></style>

    <link href="https://fonts.googleapis.com/css2?family=Baloo+Chettan+2:wght@600;700;800&display=swap" rel="stylesheet">
    <title>LA Restaurant</title>
</head>
<body style="background-image:url(${pageContext.servletContext.contextPath}/resource/Img/MonAn/mon6.jpg); background-size: cover; height: 100%;">
    <header>
        <input type="checkbox" />
        <div class="menu-icon">
            <div class="menu-line">
            </div>
        </div>
        <div class="menu-item">
            <ul>
                <li><a href="/">Trang chủ</a></li>
                <li><a href="thongtin">Về chúng tôi</a></li>
                <li><a href="tinTuc">Tin tức</a></li>
                <li><a href="hotro">Liên hệ</a></li>
                <li><a href="dangnhap">Đăng nhập</a></li>
                <li><a href="dangky">Đăng ký</a></li>
                <li><a>Xin chào: </a></li>
                <li><a href="admin">Admin</a></li>
            </ul>
        </div>
        <div class="header-text">
            <div style="display:block; color:#ffffff">
                <img src="${pageContext.servletContext.contextPath}/resource/Img/ChuLogo.png" />
            </div>
            <a href="datban">Đặt bàn</a>
            <a href="datmon">Đặt món</a>
        </div>
    </header>
    <footer style="background-color:black;opacity:0.7; margin-top:0px;">

        <p style="color:white;text-align:right;text-decoration:none;font-size:13px">Khu Biệt Thự Lan Anh, 2 Đường Số 45, P. Bình An,  Quận 2, TP. HCM<br />Giờ mở cửa: 06:30 - 21:30 <br />©Copyright by </p>

        <script language="JavaScript">window.onload = DatMonTable();</script>
    </footer>
</body>
</html>

