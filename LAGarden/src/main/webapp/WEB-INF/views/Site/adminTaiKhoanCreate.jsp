<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Tài khoản</h2>

<div class="mypadding-admin">
   
        

        <div class="form-horizontal">
		<h4>Thêm mới</h4>

		
		<div class="col-md-8">
			<form action="CreateTaiKhoanSuccess" method="POST">
				<div class="form-group">
					<label><strong>Họ và Tên:</strong> </label> <input name="input1">
				</div>

				<div class="form-group">
					<label><strong>Tên Tài Khoản: </strong></label> <input name="input2" />
				</div>

				<div class="form-group">
					<label><strong>Mật Khẩu: </strong></label> <input name="input3" />
				</div>

				<div class="form-group">
					<label><strong>Email: </strong></label> <input
						name="input4" />
				</div>

				<div class="form-group">
					<label><strong>Số Điện Thoại: </strong></label> <input name="input5" />
				</div>

				<div class="form-group">
					<label><strong>Địa Chỉ: </strong></label> <input name="input6" />
				</div>

				<div class="form-group">
					<label><strong>Roles: </strong></label> <input name="input7" />
				</div>


				<button type="submit" class="btn btn-sm btn-success">Thêm</button>
				<a href="adminTaiKhoan" class="btn btn-sm btn-success">Quay lại</a>
				
				<br>
				${thongbao}
				${thongbao2}
			</form>
		</div>
	</div>
    
</div>