<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show Personal</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


    <h2>Search Product</h2>

    <form method="post" action="/sanpham?action=find">
        <input placeholder="Nhập tên sản phẩm cần tìm" name="nameFind">
        <button type="submit" class="btn btn-success">Find</button>
    </form>
    <a href="/sanpham" class="btn btn-success">Back home</a>
    <br>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listProduct}" var="product" varStatus="loop">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td>${product.color}</td>
                <td>${product.name_cate}</td>
                <td><a href="/sanpham?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a href="/sanpham?action=delete&index=${loop.index}" class="btn btn-danger" onclick=" return confirm('Bạn có muốn xóa???')">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
