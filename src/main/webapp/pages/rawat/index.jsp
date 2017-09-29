<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Daftar Rawat Pasient</title>
</head>
<body>
<a style="border: 2px solid blue;" href="${pageContext.servletContext.contextPath}/rawat/new"
   class="btn btn-primary">Tambah</a>
<table>
    <thead>
    <tr>
        <td>Kode</td>
        <td>Nama Pasien</td>
        <td>Kode Dokter</td>
        <td>Nama Dokter</td>
        <td>No Ruangan</td>
        <td>Tanggal Register</td>
        <td>Tanggal Checkout</td>
        <td>Aksi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listRawat}" var="rawat">
        <tr>
            <td>${rawat.id}</td>
            <td>${rawat.pasien.nama}</td>
            <td>${rawat.dokter.id}</td>
            <td>${rawat.dokter.nama}</td>
            <td>${rawat.ruang.noRuangan}</td>
            <td><f:formatDate value="${rawat.tanggalRegister}" pattern="dd MMMM yy hh:mm:ss"></f:formatDate></td>
            <td><f:formatDate value="${rawat.tanggalCheckout}" pattern="dd MMM yyyy"></f:formatDate></td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/rawat/update?kode=${rawat.id}">Update</a>
                &nbsp
                <form action="${pageContext.servletContext.contextPath}/rawat/delete" method="post">
                    <input type="hidden" name="kode" value="${rawat.id}">
                    <button style="border: #ff141a" type="submit">Kirim</button>
                </form>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
