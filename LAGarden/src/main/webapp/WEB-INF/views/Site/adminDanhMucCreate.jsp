<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Danh mục</h2>

<div class="mypadding-admin">



	<div class="form-horizontal">
		<h4>Thêm mới</h4>


		<div class="col-md-8">
			<form action="adminDashBoard" method="POST">
				<div class="form-group">
					<label><strong>Tên đăng nhập (*) :</strong></label><br> <input
						name="id">
				</div>
				
				<div class="form-group">
					<label><strong>Mật khẩu (*): </strong></label> <br> <input
						name="password" type="password" />
				</div>
				<button type="submit" class="btn btn-sm btn-success">Thêm</button>
				<a href="adminDanhMuc" class="btn btn-sm btn-success">Quay lại</a>
			</form>
			</div>
		</div>


</div>
