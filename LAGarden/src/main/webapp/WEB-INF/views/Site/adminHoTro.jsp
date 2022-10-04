<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
    <div class="card-header">
        <div class="row">
            <div clas="col-md-6">
                <strong>HỖ TRỢ</strong>
            </div>

        </div>
    </div>
</div>
<div class="card-body">
    <table class="table table-bordered table-hover table-striped">
        <tr style="text-align:center">
            <th>
                Tên khách hàng
            </th>
            <th>
                E-mail
            </th>
            <th>
                Chi tiết
            </th>
            <th>
                Trạng thái
            </th>
            <th></th>
        </tr>

       <c:forEach items="${listHoTro}" var="item">
		
		 <tr>
			<td>${item.TenKH}</td>
			<td>${item.Email}</td>
			<td>${item.ChiTiet}</td>
			<td>${item.status}</td>
               
                <td>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Edit", "Edit", new { id = item.id })
                    </p>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Delete", "Delete", new { id = item.id })
                    </p>
                </td>
            </tr>
</c:forEach>
    </table>
   <!--  @Html.PagedListPager(Model, page => Url.Action("Index", new { page }),
                                            new PagedListRenderOptions
                                            {
                                                LiElementClasses = new string[] { "page-item" },
                                            }) -->

</div>