<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
	<div class="card-header">
		<div class="row">
			<div clas="col-md-6">
				<strong>HOÁ ĐƠN</strong>
				<br>
				${thongbao3}
			</div>

		</div>
	</div>
</div>

<div class="card-body">
	<table class="table table-bordered table-hover table-striped">
		<tr style="text-align: center">
			<th>Tên TK</th>
			<th>Tên nhận hàng</th>
			<th>Địa chỉ nhận</th>
			<th>Số điện thoại</th>
			<th>Email</th>
			<th>Tổng tiền</th>
			<th>Ngày lập</th>
			<th></th>
		</tr>

		<c:forEach items="${listHoaDon}" var="item">

			<tr>
			 <form action="adminDeleteHoaDon" method="POST">
				<td>${item.username}</td>
				<td>${item.NameRecieve}</td>
				<td>${item.AddressRecive}</td>
				<td>${item.Phone}</td>
				<td>${item.EmailRecieve}</td>
				<td>${item.TongTien}</td>
				<td>${item.NgayLap}</td>

				<td>
					<button type="submit" class="btn btn-sm btn-success" name="dele"
						value=${item.Phone }>Delete</button>
				</td>
				</form>
			</tr>
		</c:forEach>


	</table>
	
</div>