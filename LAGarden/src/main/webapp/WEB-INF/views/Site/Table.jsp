<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
        <script src="${pageContext.servletContext.contextPath}/resource/MyJS/Table.js"></script>
        <link href="${pageContext.servletContext.contextPath}/resource/css/Table.css" rel="stylesheet" />
        <script src="${pageContext.servletContext.contextPath}/resource/MyJS/jquery.cycle.all.js"></script>
        
</head>
<body>

    <section>
        <div class="row">
            <div class="col-md-3" style="
                 border:1px solid white;
                 height:320px;
                 padding-left:10px;
                 padding-right:10px;
                 background-color:gray;">
                 
                <p>
                   <c:forEach items="${list}" var="i">
                        <img src="${pageContext.servletContext.contextPath}/resource/Img/${i.imgsource}" width="100" height="100" />
                    </c:forEach>
                </p>
                
            </div>
            <div class="col-md-6 pl-0 "><img class="my-padding" src="${pageContext.servletContext.contextPath}/resource/Img/MonAn/mon5.jpg" width="674" height="500" id="main-Img" /></div>
            <div class="col-md-3">
                <div class="DatBan">
                    <h2 class="fontDatBan">Đặt chỗ LAGarden</h2>
                    <form>
                        <div class="form-row">
                            <input type="text" class="form-control" cols="70" id="txtten" placeholder="Họ và tên" rows="1" width="287" />
                        </div>
                        <div class="form-row">
                            <input type="text" class="form-control" cols="70" id="txtsdt" placeholder="Số điện thoại" rows="1" width="287" />
                        </div>
                        <div class="form-row">
                            <input type="text" class="form-control" cols="70" id="txtemail" placeholder="E-mail" rows="1" width="287" />
                        </div>
                        <div class="form-row">
                            <div class="col">
                                <input type="date" class="form-control" id="myDate">
                            </div>
                            <div class="col">
                                <input type="time" class="form-control" id="myTime">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col">
                                <select class="form-control" id="myOptionNL"></select>
                            </div>
                            <div class="col">
                                <select class="form-control" id="myOptionTE"></select>
                            </div>
                        </div>
                        <div class="form-row">
                            <input type="text" class="form-control" cols="70" id="txtGhichu" placeholder="Điền  ghi chú  tại đây..." rows="1" width="287" />
                        </div>
                        <center style="margin-top:20px"><button id="btnsend" type="button" class="btn btn-outline-primary">ĐẶT CHỖ NGAY</button></center>
                    </form>
                    <p>Hoặc gọi tới:</p>
                    <p style="color:red;font-size:20px;font-weight:bold">012360759</p>
                    <p>Để đặt chỗ và được tư vấn.</p>
                </div>
            </div>
        </div>
    </section>

    <script>

        $('p img').click(function () {
            let imgPath = $(this).attr('src');
            $("#main-Img").fadeTo(1000, 0.30, function () {
                $("#main-Img").attr("src", imgPath);
            }).fadeTo(300, 1);
            return false;
        });

       
    </script>

    <script language="JavaScript">window.onload = addOptionTreEm()</script>
    <script language="JavaScript">window.onload = NgayGio()</script>
    <script language="JavaScript">window.onload = addOptionNguoiLon();</script>
    <script src="${pageContext.servletContext.contextPath}/resource/MyJS/FormTable.js"></script>
    <script>
        function addClass() {
            let ele = document.getElementById('datban');
            /* thêm class*/
            ele.classList.add('is-active');
        }
        addClass();
    </script>
</body>

<img src="${pageContext.servletContext.contextPath}/resource/Img/MonAn/B1.png" width="70" height="70" style="position: absolute; right:300px;top:45px;" />

<img src="${pageContext.servletContext.contextPath}/resource/Img/MonAn/B2.png" width="110" height="110" style="position: absolute; left:260px;top:535px;" />