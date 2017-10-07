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
<form action="${pageContext.servletContext.contextPath}/rawat/proses" method="post">
    <div>
        <label for="pasientId">Pilih Pasien</label>
        <select name="selectPasientId" id="pasientId">
            <c:forEach items="${listPasien}" var="d">
                <option value="${d.id}">${d.nama}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="dokterId">Pilih Dokter</label>
        <select name="selectDokterId" id="dokterId">
            <c:forEach var="d" items="${listDokter}">
                <option value="${d.id}">${d.nama}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="ruangId">Pilih Ruangan</label>
        <select name="selectRuangId" id="ruangId">
            <c:forEach items="${listRuangan}" var="d">
                <option value="${d.id}">${d.noRuangan}</option>
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
