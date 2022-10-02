<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="${pageContext.servletContext.contextPath}/resource/css/CangiuaCss.css" rel="stylesheet" />
</head>
<body>
	<div class="content">
<form action="/dangky" method="post"><input name="__RequestVerificationToken" type="hidden" value="TWd6NbHx2puqfFr-eHZE0y37L1tuallloRkqhGw_pxKxJzQQRHIsz0vkpyhA0ruXjWDnkXq8H8fJeRdQcc_E0qdFsD4_Xk8da1S8lsTKyBA1" />        <div class="my-swapper">
            <div class="form-horizontal">
                <h4 style="text-align:center; font-size:30px; font-weight:bold; margin-top:20px">Đăng ký thành viên</h4>
                <hr />
                <div class="form-group">
                    <div class="validation-summary-valid text-danger" data-valmsg-summary="true"><ul><li style="display:none"></li>
</ul></div>
                </div>
                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor" >Tên tài khoản (*): </div>
                        <input class="form-control boderText " 
                        	    
                        	   data-val="true" 
                        	   data-val-required="Yêu cầu nhập tên đăng nhập" 
                        	   id="UserName" 
                        	   name="UserName" 
                        	   type="text" 
                        	   value="" />

                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div  class="my-a-infor">Mật khẩu (*):</div>
                        <input class="form-control boderText " 
                        	   data-val="true" 
                        	   data-val-length="Độ dài mật khẩu ít nhất 6 ký tự." 
                        	   data-val-length-max="20" 
                        	   data-val-length-min="6" 
                        	   data-val-required="Yêu cầu nhập mật khẩu" 
                        	   id="Password" 
                        	   name="Password" 
                        	   type="password" />
                   
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div  class="my-a-infor">Nhập lại mật khẩu (*):</div>
                        <input class="form-control boderText" 
                        	   data-val="true"  
                        	   data-val-equalto="Xác nhận mật khẩu không đúng." 
                        	   data-val-equalto-other="*.Password" 
                        	   id="ConfirmPassword" 
                        	   name="ConfirmPassword" 
                        	   type="password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="my-a-infor">Họ và tên (*): </div>
                        <input class="form-control boderText " 
                        	   data-val="true" 
                        	   data-val-required="Yêu cầu nhập họ tên" 
                        	   id="Name" 
                        	   name="Name" 
                        	   type="text" 
                        	   value="" />
                        
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor">Địa chỉ (*): </div>
                        <input class="form-control boderText "
                        	   cols="20" 
                        	   data-val="true" 
                        	   data-val-required="Yêu cầu địa chỉ" 
                        	   id="Address" 
                        	   name="Address" 
                        	   rows="2" 
                        	   type="text" />
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor">E-mail (*): </div>
                        <input class="form-control boderText " 
                        	   data-val="true" 
                        	   data-val-required="Yêu cầu nhập email" 
                        	   id="Email" 
                        	   name="Email" 
                        	   type="email" 
                        	   value="" />
                        
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="my-a-infor">Số điện thoại (*): </div>
                        <input class="form-control boderText "
                        	   data-val="true" 
                        	   data-val-required="Yêu cầu số điện thoại" 
                        	   id="Phone" 
                        	   name="Phone" 
                        	   type="tel" 
                        	   value="" />
                        
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="control-label" style="margin:auto">
                            Vui lòng nhập Captcha (*): 
<script type="text/javascript">
$(function () {$('#5a42d1fc69ed41c1bd00d3edb53b5c2f').show();});
function ______40259592cb09457b8a8d5366fd036946________() { $('#5a42d1fc69ed41c1bd00d3edb53b5c2f').hide(); $.post("/DefaultCaptcha/Refresh", { t: $('#CaptchaDeText').val() }, function(){$('#5a42d1fc69ed41c1bd00d3edb53b5c2f').show();}); return false; }</script> 
<br/>
<img id="CaptchaImage" src="/DefaultCaptcha/Generate?t=72496aa0ee60416ba9d6fd1a0332729b"/><input id="CaptchaDeText" name="CaptchaDeText" type="hidden" value="72496aa0ee60416ba9d6fd1a0332729b" /> <br/><a href="#CaptchaImage" id="5a42d1fc69ed41c1bd00d3edb53b5c2f" onclick="______40259592cb09457b8a8d5366fd036946________()" style="display:none;">Refresh</a><br/>Input symbols<br/><input autocomplete="off" autocorrect="off" id="CaptchaInputText" name="CaptchaInputText" type="text" value="" /><br/>
                            <p>(*): Thông tin bắt buộc phải nhập</p>
                        </div>
                        
                    </div>
                    </div>
                    <div class="form-group">
                        
                        <div class="col-md-offset-2 col-md-10">
                            <input type="submit" value="Đăng ký" class="btn btn-sm btn-success" />
                            <a href="/dang-nhap/" class="btn btn-sm btn-success">Đăng nhập</a>
                        </div>
                    </div>

                </div>
            </div>
</form>        </div>

        <script>
            function addClass() {
                let ele = document.getElementById('dangky');
                /* thêm class*/
                ele.classList.add('is-active');
            }
            addClass();
        </script>
        
       
    <script src="/Public/MyJS/MenuBar JS/MenubarJS.js"></script>
</body>
</html>

