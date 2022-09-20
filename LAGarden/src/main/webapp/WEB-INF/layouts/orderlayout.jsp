<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
        <link href="${pageContext.servletContext.contextPath}/resource/css/Style.css" rel="stylesheet" />
        <script src="${pageContext.servletContext.contextPath}/resource/MyJS/JavaScript.js"></script>
</head>
<body>
    <div class="text-center" style="margin-bottom:0">
        <div class="row" style="margin:unset">
            <div class=" col-sm-4">
                <div class="khungvien">
                    <img class=" container container-fluid container-lg container-md image-logo" src="${pageContext.servletContext.contextPath}/resource/Img/Logo.jpg" style="" />
                </div>
            </div>
            <div class="col-sm-8" style="padding: unset;">
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner ">
                        <div class="carousel-item active" data-interval="10000">
                            <img src="${pageContext.servletContext.contextPath}/resource/Img/Hinh1.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
                        </div>
                        <div class="carousel-item" data-interval="2000">
                            <img src="${pageContext.servletContext.contextPath}/resource/Img/Hinh2.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.servletContext.contextPath}/resource/Img/Hinh3.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-target="#carouselExampleInterval" data-slide="prev" style="opacity:0">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Trước</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-target="#carouselExampleInterval" data-slide="next" style="opacity:0">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Sau</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin: unset; padding-top:40px">
        <!-- Cột trái -->
		<div class="col-sm-4">

		<tiles:insertAttribute name="menuleft" />
		</div>
        <!-- Kết thúc cột trái -->
        <!-- Cột phải -->
        <div class="col-sm-8">
	<tiles:insertAttribute name="body" />
          
    </div>
        </div>

    <script>
        function addClass() {
            let ele = document.getElementById('datmon');
            /* thêm class*/
            ele.classList.add('is-active');
        }
        addClass();
    </script>
</body>