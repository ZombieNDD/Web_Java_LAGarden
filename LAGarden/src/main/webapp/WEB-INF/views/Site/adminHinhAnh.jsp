<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>
    @Html.ActionLink("Create New", "Create")
</p>
<table class="table">
    <tr>
        <th>
            @Html.DisplayNameFor(model => model.Slug)
        </th>
        <th>
            @Html.DisplayNameFor(model => model.TypeLink)
        </th>
        <th>
            @Html.DisplayNameFor(model => model.TableId)
        </th>
        <th></th>
    </tr>

@foreach (var item in Model) {
    <tr>
        <td>
            @Html.DisplayFor(modelItem => item.Slug)
        </td>
        <td>
            @Html.DisplayFor(modelItem => item.TypeLink)
        </td>
        <td>
            @Html.DisplayFor(modelItem => item.TableId)
        </td>
        <td>
            @Html.ActionLink("Edit", "Edit", new { id=item.IDMA }) |
            @Html.ActionLink("Details", "Details", new { id=item.IDMA }) |
            @Html.ActionLink("Delete", "Delete", new { id=item.IDMA })
        </td>
    </tr>
}

</table>