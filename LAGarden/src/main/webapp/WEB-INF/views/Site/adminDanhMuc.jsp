<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="card">
	<div class="card-header">
		<div class="row">
			<div clas="col-md-6">
				<strong>DANH MỤC</strong>
			</div>
			<div class="col-md-6 text-right">
				<a href="@Url.Action(("
					Create"),("DanhMuc"))" class="btn btn-sm btn-success">Thêm Mới</a>
			</div>
		</div>
	</div>
</div>

<div class="card-body">
	<table class="table table-bordered table-hover table-striped">
		<tr style="text-align: center">
			<th>ID danh mục</th>
			<th>Tên danh mục</th>
			<th>Thứ tự</th>
			<th>Tag</th>
			<th></th>
		</tr>
		
		
		
		
	<c:forEach items="${listDanhMuc}" var="item">
		
		<!-- <tr>
			<td>@Html.DisplayFor(modelItem => item.DanhMucID)</td>
			<td>@Html.DisplayFor(modelItem => item.DanhMucName)</td>
			<td>@Html.DisplayFor(modelItem => item.ThuTu)</td>
			<td>@Html.DisplayFor(modelItem => item.Tags)</td>
			<td>
				<p class="btn btn-sm btn-success"
					style="background: #ffffff; border: 2px solid #000000;">
					@Html.ActionLink("Edit", "Edit", new { id = item.DanhMucID })</p>
				<p class="btn btn-sm btn-success"
					style="background: #ffffff; border: 2px solid #000000;">
					@Html.ActionLink("Delete", "Delete", new { id = item.DanhMucID })</p>
			</td>
		</tr> -->
	</c:forEach>
	
		
	</table>
	
	<!-- @Html.PagedListPager(Model, page => Url.Action("Index", new { page }),
	new PagedListRenderOptions { LiElementClasses = new string[] {
	"page-item" }, }) -->


</div>