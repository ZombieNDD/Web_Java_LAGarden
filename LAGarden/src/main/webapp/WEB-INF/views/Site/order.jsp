<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${listMonAn}" var="item">
<div class="my-flex" style="padding-top: 20px">
	<div Class="card" style="width: 100%">
		<img src="${pageContext.servletContext.contextPath}/resource/Img${item.imgMA}" width="318" height="254" href="/sanpham-${item.tenMonAn }-${item.idMA } "
			Class="card-img-top" />
		<div Class="card-body">
			<h2 Class="card-title" href="/sanpham-${item.tenMonAn }-${item.idMA }">${item.tenMonAn}</h2>
			<h5>Giá tiền: ${item.gia}</h5>
			<a href="sanpham-${item.tenMonAn }-${item.idMA }" Class="btn btn-primary">Chi tiết</a>
		</div>
	</div>
</div>
</c:forEach>