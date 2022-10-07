<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card">
	<div class="card-header">
		<div class="row">
			<div clas="col-md-6">
				<strong>TÀI KHOẢN</strong>
				<br>
				${thongbao3}
			</div>
			<div class="col-md-6 text-right">
				<a href="CreateTaiKhoan" class="btn btn-sm btn-success">Thêm Mới</a>
			</div>
		</div>
	</div>
</div>
<div class="card-body">
	<table class="table table-bordered table-hover table-striped">
		<tr style="text-align: center">
			<th>Họ tên</th>
			<th>Tên tài khoản</th>
			<th>Mật khẩu</th>
			<th>E-mail</th>
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Roles</th>
			<th></th>
		</tr>

		<c:forEach items="${listUser}" var="item">

			<tr>
			<form action="adminDeleteTaiKhoan" method="POST">
				<td>${item.fullname}</td>
				<td>${item.username}</td>
				<td>${item.password}</td>
				<td>${item.email}</td>
				<td>${item.phone}</td>
				<td>${item.address}</td>
				<td>${item.roles}</td>

				<td><button type="submit" class="btn btn-sm btn-success"
						name="dele" value= ${item.username }>Delete</button></td>
				</form>
			</tr>
			
		</c:forEach>
	</table>
	
</div>