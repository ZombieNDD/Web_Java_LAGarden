<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style>
        .my-a-thanh-toan{
            text-decoration:none;
        }
        .my-a-thanh-toan:hover{
            text-decoration:none !important;
    </style>
<div class="content">
    <div class="section group">
    <c:choose>
        <c:when test="${listGioHang.size()>0 }">
            <table class="table">
                <thead>
                    <tr>
                        <td>Mã SP</td>
                        <td>Tên SP</td>
                        <td>Ảnh SP</td>
                        <td>Số lượng</td>
                        <td>Đơn giá</td>
                        <td>Thành tiền</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listGioHang}" var="item">
                        <tr>
                            <td>${ item.ctMA.idMA}</td>
                            <td>${ item.ctMA.tenMonAn}</td>
                            <td><img src="${pageContext.servletContext.contextPath}/resource/Img${item.ctMA.imgMA}" width="100" /></td>
                            <td><input type="text" class="txtQuantity" data-id="${item.ctMA.idMA}" value="${item.quantity}" /> /phần</td>
                            <td>${item.ctMA.gia}</td>
                            <td>${ (item.ctMA.gia) * (item.quantity)}</td>
                            <td><a href="#" data-id="${item.ctMA.idMA}" class="btn-delete">Xoá</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

            <button id="btnContinue" class="btn btn-outline-primary">Tiếp tục mua hàng</button>
            <button id="btnUpdate" class="btn btn-outline-secondary" >Cập nhật giỏ hàng</button>
            <button id="btnDeleteAll" class="btn btn-outline-danger">Xoá giỏ hàng</button>
            <a class="btn btn-outline-primary" href="thanhtoan">Thanh toán</a>
        </c:when>
        <c:otherwise>
            <div class="mt-5">
                <span class="alert alert-danger">Chưa có sản phẩm nào trong giỏ hàng</span>
            </div>
        </c:otherwise>
</c:choose>
    </div>
</div>
<script src="${pageContext.servletContext.contextPath}/resource/MyJS/CartController.js"></script>