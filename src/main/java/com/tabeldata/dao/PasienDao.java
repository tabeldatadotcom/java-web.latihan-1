package com.tabeldata.dao;

import com.tabeldata.configs.DatabaseKonfigurasi;
import com.tabeldata.model.Pasien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PasienDao {

    public List<Pasien> semuaData() throws SQLException {
        List<Pasien> listData = new ArrayList<>();
        String sql = "SELECT nama, id,  alamat, tanggal_lahir FROM latihan_1.pasien";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Pasien pasien = new Pasien();
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
//            not recomended
            pasien.setAlamat(resultSet.getString(3));
            pasien.setTanggalLahir(resultSet.getDate("tanggal_lahir"));
            listData.add(pasien);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listData;
    }
}
