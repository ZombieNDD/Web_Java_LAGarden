<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="can-giua">
        <ul class="mb-0 nav nav-food can-giua bo-goc my-list-menu">
            <li>
                <img src="${pageContext.servletContext.contextPath}/resource/Img/LogoMenu.png" width="200">
            </li>
            <c:forEach items="${listDanhMuc}" var="i">
            	<li class="nav-item link-3" id="${i.danhMucID}"><a class="nav-link my-a" href="danhmuc-${i.danhMucName}-${i.danhMucID}-1">${i.danhMucName}</a></li>
            </c:forEach>
        </ul>
    </div>