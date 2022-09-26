<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
    <link href="${pageContext.servletContext.contextPath}/resource/css/CTSP.css" rel="stylesheet" />
</head>
<body>
    <div class="row">
        <div class="col-md-6">
            <p class="ImageCenter"><img class="my-image-size"  src="${pageContext.servletContext.contextPath}/resource/Img${monAn.imgMA}" /></p>
            <div class="bg-primary"></div>
        </div>
        <div class="col-md-6">
            <h1 class="text-primary">Món ăn</h1>
            <h1>${ monAn.tenMonAn}</h1>
            <h3>Giá: ${ monAn.gia}</h3>
            
            <p>${monAn.chiTietMA }</p>
            <a class="btn btn-outline-primary" href="/them-gio-hang?idma=@Model.IDMA&quantity=1">Đặt món</a>
        </div>
    </div>
</body>
