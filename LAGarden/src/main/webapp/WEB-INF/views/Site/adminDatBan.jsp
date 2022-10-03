<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
    <div class="card-header">
        <div class="row">
            <div clas="col-md-6">
                <strong>ĐẶT BÀN</strong>
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
			<td>${item.username }</td>
			<td>${item.NgayBD }</td>
			<td>${item.GioBD }</td>
			<td>${item.Fullname }</td>
			<td>${item.Email }</td>
			<td>${item.Phone }</td>
			<td>${item.SLNguoiLon }</td>
			<td>${item.SLTreEm }</td>
			<td>${item.GhiChu }</td>
                
                <td>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Edit", "Edit", new { id = item.DatBanID })
                    </p>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Delete", "Delete", new { id = item.DatBanID })
                    </p>
                </td>
            </tr>
       </c:forEach>
    </table>
        <!-- @Html.PagedListPager(Model, page => Url.Action("Index", new { page }),
                                                 new PagedListRenderOptions
                                                 {
                                                     LiElementClasses = new string[] { "page-item" },
                                                 })  -->

</div>