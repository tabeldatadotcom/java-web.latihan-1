<%--
  Created by IntelliJ IDEA.
  User: dimmaryanto93
  Date: 29/09/17
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tambah Data Rawat</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/rawat/update-proses" method="post">
    <input type="hidden" name="hiddenRawatId" value="${rawat.id}">
    <div>
        <label for="pasientId">Pilih Pasien</label>
        <select name="selectPasientId" id="pasientId" disabled>
            <c:forEach items="${listPasien}" var="d">
                <option value="${d.id}">${d.nama}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="dokterId">Pilih Dokter</label>
        <select name="selectDokterId" id="dokterId">
            <option></option>
            <c:forEach var="d" items="${listDokter}">
                <c:if test="${rawat.dokter.id == d.id}" var="isTrue"/>
                <option value="${d.id}" ${isTrue == true ? 'selected="true"' : ''} >${d.nama}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="ruangId">Pilih Ruangan</label>
        <select name="selectRuangId" id="ruangId">
            <c:if test="${rawat.ruang.id == d.id}" var="isTrueRuangan"/>
            <c:forEach items="${listRuangan}" var="d">
                <option value="${d.id}" ${isTrueRuangan == true ? 'selected="true"' : ''} >${d.noRuangan}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button type="submit">Kirim</button>
        <button type="reset">Reset</button>
    </div>
</form>
</body>
</html>
