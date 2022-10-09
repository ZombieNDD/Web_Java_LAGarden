<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
    <link href="${pageContext.servletContext.contextPath}/resource/css/HoTro.css" rel="stylesheet" />  

</head>
<body>
    <section>
        <div class="title_page" style="color:#ba000b ;
        font-size: 30pt;
        text-shadow: 5px 2px 4px grey;
        font-weight: bold;
        text-align: center;">Liên hệ</div>
        <div class="title-Ho-Tro">Liên hệ với chúng tôi</div>

        <div class="title-Information">Để liên hệ và nhận các thông tin khuyến mại sớm nhất, xin vui lòng điền đầy đủ thông tin của bạn vào form dưới đây. Chúng tôi sẽ liên lạc lại với bạn trong thời gian sớm nhất</div>
        <form>
            <div class="row">
                <fieldset class="col-md-6">
                    <input type="text" placeholder="Họ và tên" class="form-control form-control-lg" id="txtName" />
                </fieldset>
                <fieldset class="col-md-6">
                    <input type="text" placeholder="Email" class="form-control form-control-lg" id="txtEmail" />
                </fieldset>
            </div>
            <fieldset>
                <textarea placeholder="Nội dung" class="form-control form-control-lg content-area" rows="5" id="txtContent"></textarea>
            </fieldset>
            <button class="btn btn-success" id="btnSend" style="margin-top:20px">Gửi liên hệ</button>
        </form>
    </section>
    <script src="${pageContext.servletContext.contextPath}/resource/MyJS/HoTroController.js"></script>
    <script>
        function addClass() {
            let ele = document.getElementById('hotro');
            /* thêm class*/
            ele.classList.add('is-active');
        }
        addClass();
    </script>
</body>
