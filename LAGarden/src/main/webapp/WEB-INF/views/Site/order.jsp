<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <link href="~/Public/MyCSS/Style.css" rel="stylesheet" />
    <script src="~/Public/MyJS/JavaScript.js"></script>
</head>
<body>
    <div class="text-center" style="margin-bottom:0">
        <div class="row" style="margin:unset">
            <div class=" col-sm-4">
                <div class="khungvien">
                    <img class=" container container-fluid container-lg container-md image-logo" src="~/Public/Img/Logo.jpg" style="" />
                </div>
            </div>
            <div class="col-sm-8" style="padding: unset;">
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner ">
                        <div class="carousel-item active" data-interval="10000">
                            <img src="/Public/Img/Hinh1.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
                        </div>
                        <div class="carousel-item" data-interval="2000">
                            <img src="/Public/Img/Hinh2.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
                        </div>
                        <div class="carousel-item">
                            <img src="/Public/Img/Hinh3.jpg" class="d-block w-100" alt="..." style="border-radius: 50px 50px 50px 50px">
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
            <div class="can-giua" style="padding-top:20px;">
                <ul class="mb-0 nav nav-food can-giua bo-goc my-list-menu">
                    <li>
                        <img src="~/Public/Img/LogoMenu.png" width="200">
                    </li>
                    
                </ul>
            </div>
        </div>

        <hr class="d-sm-none">

        <!-- Kết thúc cột trái -->
        <!-- Cột phải -->
        <div class="col-sm-8" href="#menu">
        </div>
        <!-- Kết thúc cột phải -->
    </div>


    <script>
        function addClass() {
            let ele = document.getElementById('datmon');
            /* thêm class*/
            ele.classList.add('is-active');
        }
        addClass();
    </script>

    <script>
        $(document).ready(function () {
            $('.page-item').find('[href="' + window.location.pathname + '"]').parent().addClass('my-active-page');
        });
    </script>
</body>