<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
    <title>
        Thông tin nhà hàng
    </title>
</head>
<body>
    <section>
        <div class="title_page" style="color:#2a9f08 ;
        font-size: 30pt;
        text-shadow: 5px 2px 4px grey;
        font-weight: bold;
        text-align: center;">Lan Anh Garden</div>
        <div class="infor_page" style=" text-align:center;">
            <div style="text-align:center; font-size:27px ; font-weight:bold;color: #16920d;">
                <p>🔎 Bạn đang tìm nơi tổ chức tiệc ngoài trời yên tĩnh và riêng tư?</p>
                <p>🔎 Bạn đang suy nghĩ tổ chức tiệc ở ven sông hay có hồ bơi?</p>
                <p>🔎 Bạn đang mong muốn tìm một nơi sang trọng để tổ chức tiệc?</p>
            </div>
            <p style="font-size:21px; font-weight: bold;">LAgarden Restaurant nổi bật với không gian gần gũi thiên nhiên, bao phủ bởi nhiều tán cây xanh mát ven nhánh sông Sài Gòn. Nơi đây, tạo nên một bầu không khí trong lành mà mỗi vị khách khi đặt chân đến đều cảm nhận được ngay từ lần đầu tiên.</p>
            <p style="font-size:21px; font-weight: bold;">LA Garden – một mảng xanh ngay sát trung tâm. Chỉ qua khỏi một cây cầu bạn sẽ đến được khu vườn xinh đẹp ấy, nơi sẽ giúp bạn cảm nhận đủ sự bình dị, yên ả.</p>
            <p style="font-size:21px; font-weight: bold;">Để mang lại cho khách hàng mội trãi nghiệm thoải mái, chúng tôi luôn nâng cao phục vụ, mong muốn nhận được phản hồi, góp ý từ khách hàng, sự hài lòng của khách hàng là niềm hạnh phúc đối với chúng tôi.</p>

        </div>
    </section>
    <section class="section_sevice">
        <div class="row" style="margin:auto">
            <div class="col-md-4" style="left:50px;">
                <span class="anhicon"><img src="${pageContext.servletContext.contextPath}/resource/Img/icon1.png" /></span>
                <div class="contain-right">
                    <p class="title">Miễn phí giao hàng</p>
                    <p>Miễn phí vận chuyển nội thành</p>
                </div>
            </div>
            <div class="col-md-4">
                <span class="anhicon"><img src="${pageContext.servletContext.contextPath}/resource/Img/icon3.png" /></span>
                <div class="contain-right">
                    <p class="title">Tiết kiệm thời gian</p>
                    <p>Mua sắm dễ hơn khi online</p>
                </div>
            </div>
            <div class="col-md-4">
                <span class="anhicon"><img src="${pageContext.servletContext.contextPath}/resource/Img/icon4.png" /></span>
                <div class="contain-right">
                    <p class="title">Tư vấn trực tiếp</p>
                    <p>Đội ngũ tư vấn nhiệt tình</p>
                </div>
            </div>
        </div>
    </section>
    <script>
        function addClass() {
            let ele = document.getElementById('thongtin');
            /* thêm class*/
            ele.classList.add('is-active');
        }
        addClass();
    </script>
</body>
