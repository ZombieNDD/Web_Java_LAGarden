<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Món ăn</h2>

<div class="mypadding-admin">



	<div class="form-horizontal">
		<h4>Thêm mới</h4>

		<div class="col-md-8">
			<form action="CreateMonAnSuccess" method="POST">
				<div class="form-group">
					<label><strong>ID Danh Mục:</strong> </label> <input name="input1">
				</div>

				<div class="form-group">
					<label><strong>Tên Món Ăn: </strong></label> <input name="input2" />
				</div>

				<div class="form-group">
					<label><strong>Số Lượng: </strong></label> <input name="input3" />
				</div>

				<div class="form-group">
					<label><strong>Chi Tiết Món Ăn: </strong></label> <input
						name="input4" />
				</div>

				<div class="form-group">
					<label><strong>Giá: </strong></label> <input name="input5" />
				</div>

				<div class="form-group">
					<label><strong>Khuyến Mãi: </strong></label> <input name="input6" />
				</div>

				<div class="form-group">
					<label><strong>Hình Ảnh: </strong></label> <input name="input7" />
				</div>

				<div class="form-group">
					<label><strong>Slug: </strong></label> <input name="input8" />
				</div>

				<div class="form-group">
					<label><strong>Tiêu đề: </strong></label> <input name="input9" />
				</div>

				<button type="submit" class="btn btn-sm btn-success">Thêm</button>
				<a href="adminMonAn" class="btn btn-sm btn-success">Quay lại</a> 
				<br>
				${thongbao} 
				${thongbao2}
			</form>
		</div>
	</div>

</div>
