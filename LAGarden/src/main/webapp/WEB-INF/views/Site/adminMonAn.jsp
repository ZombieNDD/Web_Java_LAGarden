<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
	<div class="card-header">
		<div class="row">
			<div clas="col-md-6">
				<strong>TẤT CẢ SẢN PHẨM</strong>
				<br>
				${thongbao3}
			</div>
			<div class="col-md-6 text-right">
				<a href="CreateMonAn" class="btn btn-sm btn-success">Thêm Mới</a>
			</div>
		</div>
	</div>
</div>
<div class="card-body">
	<table class="table table-bordered table-hover table-striped">
		<tr style="text-align: center">
			<th>Tên Món Ăn</th>
			<th>Giá</th>
			<th>Trạng Thái</th>
			<th>Hình Ảnh</th>
			<th>ID Danh Mục</th>
			<th></th>
		</tr>

		<c:forEach items="${listMonAn}" var="item">
			<tr>
				<form action="adminDeleteMonAn" method="POST">
				<td>${item.tenMonAn }</td>
				<td>${item.gia }</td>
				<td>${item.giaSale }</td>
				<td>${item.imgMA }</td>
				<td>${item.danhMucID }</td>

				<td><button type="submit" class="btn btn-sm btn-success"
						name="dele" value=${item.danhMucID }>Delete</button></td>
				</form>
			</tr>
		</c:forEach>

	</table>
</div>