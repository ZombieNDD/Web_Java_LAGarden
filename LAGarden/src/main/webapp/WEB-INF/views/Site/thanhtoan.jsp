<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <link href="${pageContext.servletContext.contextPath}/resource/css/CangiuaCss.css" rel="stylesheet" />
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid black;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>

<div class="row" style="margin:auto">
    <div class="my-swapper col-sm-8" style="margin-left:100px">
<form action="thanhtoan" method="post">
           


            <div class="form-horizontal">
                <c:if test="${success!= null}"> 

                    <div class="alert alert-success">${success}</div>

                </c:if>
                <h4>Thanh toán</h4>
                <hr />
                ${error }
                <div class="form-group">
                    <div class="row">
                        <div class="my-a-infor">Tên người nhận: </div>
                        <input class = "form-control boderText" placeholder="Để trống nếu đặt mặc định" name="text1">
                        
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor">Số điện thoại: </div> <input class = "form-control boderText" placeholder="Để trống nếu đặt mặc định" name="text2">
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor">Địa chỉ: </div> <input class = "form-control boderText" placeholder="Để trống nếu đặt mặc định" name="text3">
                    </div>
                </div>

                <div class="form-group">

                    <div class="row">
                        <div class="my-a-infor">Email: </div> <input class = "form-control boderText" placeholder="Để trống nếu đặt mặc định" name="text4">
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <button  onclick="showAlert()" style="margin-left:20px" type="submit" class="btn btn-outline-success">Thanh toán</button>
                        <a class="btn btn-outline-danger" style="margin-left:20px" href="giohang">Quay lại</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="my-swapper col-sm-4">
        <h3>HOÁ ĐƠN</h3>
        <table>
            <tr>
                <th>Tên món ăn</th>
                <th>Số lượng</th>
                <th>Tổng tiền</th>
            </tr>
            
           <c:forEach items="${listThanhToan}" var="item">
                <tr>
                    <td>${item.ctMA.tenMonAn}</td>
                    <td>${item.quantity}</td>
                    <td>${item.ctMA.gia*item.quantity}</td>
                </tr>
            </c:forEach>

        </table>
        <div style="margin-top: 15px"><b class="text-danger">Tổng tiền thanh toán: ${tongtien }</b></div>
    </div>
    </div>
<script>
  function showAlert() {
    alert ("Chức năng hiện đang được phát triển!!");
  }
  </script>