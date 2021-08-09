<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Edit</h2>
    <form action="/sanpham?action=edit" method="post">
        <table class="table">
            <tbody>
            <tr>
                <td>ID:</td>
                <td><input placeholder="nhập id" name="id" value="${add.id}"></td>
                <td>Name:</td>
                <td><input placeholder="nhập name" name="name" value="${add.name}"></td>
            <tr>
                <td>Price:</td>
                <td><input placeholder="nhập price" name="price" value="${add.price}"></td>
                <td>Quantity:</td>
                <td><input placeholder="nhập quantity" name="amount" value="${add.amount}"></td>
            </tr>
            <td>Color:</td>
            <td><input placeholder="nhập colour" name="color" value="${add.color}"></td>
            <td>Description:</td>
            <td><input placeholder="nhập description" name="description" value="${add.description}"></td>
            </tr>
            <tr>
                <td>Category</td>
                <td colspan="2">
                    <select name="id_cate">
                        <c:forEach items="${listCate}" var="cate">
                            <option value="${cate.id_cate}">
                                    ${cate.name_cate}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Edit</button>

    </form>
</div>

</body>
</html>

