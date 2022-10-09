<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
	<div class="card-header">
		<div class="row">
			<div clas="col-md-6">
				<strong>HỖ TRỢ</strong>
				<br>
				${thongbao3}
			</div>

		</div>
	</div>
</div>
<div class="card-body">
	<table class="table table-bordered table-hover table-striped">
		<tr style="text-align: center">
			<th>Tên khách hàng</th>
			<th>E-mail</th>
			<th>Chi tiết</th>
			<th>Trạng thái</th>
			<th></th>
		</tr>

		<c:forEach items="${listHoTro}" var="item">

			<tr>
			<form action="adminDeleteHoTro" method="POST">
				<td>${item.TenKH}</td>
				<td>${item.Email}</td>
				<td>${item.ChiTiet}</td>
				<td>${item.status}</td>

				<td>
					<button type="submit" class="btn btn-sm btn-success" name="dele"
						value=${item.Email }>Delete</button>
				</td>
				</form>
			</tr>
		</c:forEach>
	</table>
</div>