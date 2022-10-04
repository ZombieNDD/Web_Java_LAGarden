<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Danh mục</h2>

<div class="mypadding-admin">



	<div class="form-horizontal">
		<h4>Thêm mới</h4>


		<div class="col-md-8">
			<form action="CreateDanhMucSuccess" method="POST">
				<div class="form-group">
					<label><strong>ID Danh Mục:</strong> </label> <input name="input1">
				</div>

				<div class="form-group">
					<label><strong>Tên danh mục: </strong></label> <input name="input2" />
				</div>

				<div class="form-group">
					<label><strong>Thứ tự: </strong></label> <input name="input3" />
				</div>

				<div class="form-group">
					<label><strong>Tags: </strong></label> <input name="input4" />
				</div>

				<button type="submit" class="btn btn-sm btn-success">Thêm</button>
				<a href="adminDanhMuc" class="btn btn-sm btn-success">Quay lại</a>
			</form>
		</div>
	</div>


</div>
