<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card">
    <div class="card-header">
        <div class="row">
            <div clas="col-md-6">
                <strong>Hình ảnh</strong>
                <br>
				${thongbao3}
            </div>
            <div class="col-md-6 text-right">
                <a href="@Url.Action(("Create"),("ImageDatBan"))" class="btn btn-sm btn-success">Thêm Mới</a>
            </div>
        </div>
    </div>
</div>

<div class="card-body">
    <table class="card-body table-bordered table-hover table-striped">
        <tr style="text-align:center">
            <th>
                Hình ảnh
            </th>
            <th>
                Source
            </th>
        </tr>

        @foreach (var item in Model)
        {
            <tr style="text-align:center">
                <td>
                    <img src="@Html.DisplayFor(modelItem => item.imgsource)" width="100" height="100" />
                </td>
                <td>
                    @Html.DisplayFor(modelItem => item.imgsource)
                </td>
                <td>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Edit", "Edit", new { id = item.ID }) |
                    </p>
                    <p class="btn btn-sm btn-success" style="background: #ffffff; border: 2px solid #000000;">
                        @Html.ActionLink("Delete", "Delete", new { id = item.ID })
                    </p>
                </td>
            </tr>
        }

    </table>
    <!-- @Html.PagedListPager(Model, page => Url.Action("Index", new { page }),
                                        new PagedListRenderOptions
                                        {
                                            LiElementClasses = new string[] { "page-item" },
                                        }) -->


</div>