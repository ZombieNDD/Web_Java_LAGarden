<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link
	href="${pageContext.servletContext.contextPath}/resource/css/CangiuaCss.css"
	rel="stylesheet" />
</head>

<form action="loginuser" method="post">
    <div class="my-swapper">
        <div class="form-horizontal">
        
            <h4>Đăng nhập</h4>
            <hr />
			<h5 class = "text-danger">${message}</h5>
            <div class="form-group">
                <div class="row">
                    <div class="my-a-infor">Tài khoản: </div>
                    <input class="form-control boderText" id="username" name="username" type="text"/>        
                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="my-a-infor">Mật khẩu: </div>
                  <input class="form-control boderText" id="password" name="password" type="password"/>
                   
                </div>
            </div>

            <div class="form-group">
                <div class="row" style="padding-left:30%">
                    <input type="submit" value="Đăng nhập" class="btn btn-default btn-sm btn-success" />
                    <a style="padding: 5px 20px 0px 20px">
                        <b>Hoặc</b>
                    </a>
                    <div class="btn btn-primary"><a class="my-a-btn" href="dangky">Đăng ký thành viên</a></div>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    function addClass() {
        let ele = document.getElementById('dangnhap');
        /* thêm class*/
        ele.classList.add('is-active');
    }
    addClass();
</script>