<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
    <div class="card-header">
        <div class="row">
            <div clas="col-md-6">
                <strong>ĐẶT BÀN</strong>
                <br>
				${thongbao3}
            </div>

        </div>
    </div>
</div>
<div class="card-body">
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <th>
                Tên TK
            </th>
            <th>
                Ngày bắt đầu
            </th>
            <th>
                Giờ bắt đầu
            </th>
            <th>
                Họ và tên
            </th>
            <th>
                E-mail
            </th>
            <th>
                Số điện thoại
            </th>
            <th>
                Người lớn
            </th>
            <th>
                Trẻ em
            </th>
            <th>
                Ghi chú
            </th>
            <th></th>
        </tr>

        <c:forEach items="${listTable}" var="item">		
		 <tr>
		 <form action="adminDeleteDatBan" method="POST">
			<td>${item.username }</td>
			<td>${item.ngayDB }</td>
			<td>${item.gioDB }</td>
			<td>${item.fullName }</td>
			<td>${item.email }</td>
			<td>${item.phone }</td>
			<td>${item.sLNguoiLon }</td>
			<td>${item.sLTreEm }</td>
			<td>${item.ghiChu }</td>
                
                <td>
                   <button type="submit" class="btn btn-sm btn-success" name="dele"
						value=${item.id }>Delete</button>
                </td>
                </form>
            </tr>
       </c:forEach>
    </table>
       

</div>