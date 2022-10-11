<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${listMonAn}" var="item">
	<div class="my-flex" style="padding-top: 20px">
		<div Class="card" style="width: 100%">
			<img
				src="${pageContext.servletContext.contextPath}/resource/Img${item.imgMA}"
				width="318" height="254"
				href="/sanpham-${item.tenMonAn }-${item.idMA } "
				Class="card-img-top" />
			<div Class="card-body">
				<h2 Class="card-title"
					href="/sanpham-${item.tenMonAn }-${item.idMA }">${item.tenMonAn}</h2>
				<h5>Giá tiền: ${item.gia}</h5>
				<a href="sanpham-${item.tenMonAn }-${item.idMA }"
					Class="btn btn-primary">Chi tiết</a>
			</div>
		</div>
	</div>
</c:forEach>
<!-- =========================================PHÂN TRANG========================================= -->
<nav aria-label="...">
  <ul class="pagination">
  <c:if test = "${page> first}">
    <li class="page-item">
      <a class="page-link" href="${url}-${prev}" tabindex="-1">Previous</a>
    </li>
    </c:if>
    <%
    int currentPage = (Integer)(request.getAttribute("page"));
    int pageDisplay = (Integer)(request.getAttribute("maxPage"));
    int totalPage = (Integer)(request.getAttribute("last"));
    int startPageIndex = Math.max(1, currentPage - pageDisplay / 2);
    int endPageIndex = Math.min(totalPage, currentPage + pageDisplay / 2);
    for (int i = startPageIndex; i <= endPageIndex; i++) { %>
    <li class="page-item"><a class="page-link" href="${url}-<%=i%>"><%=i%></a></li>
     <% } %>
    <c:if test = "${page < totalPage}">
    <li class="page-item">
      <a class="page-link" href="${url}-${next}">Next</a>
    </li>
    </c:if>
  </ul>
</nav>
