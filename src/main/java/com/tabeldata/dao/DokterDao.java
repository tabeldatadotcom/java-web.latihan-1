package com.tabeldata.dao;


import com.tabeldata.configs.DatabaseKonfigurasi;
import com.tabeldata.model.Dokter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DokterDao {

    public List<Dokter> semuaData() throws SQLException {
        List<Dokter> listData = new ArrayList<>();
        String sql = "SELECT id, nama, spesialis FROM latihan_1.dokter";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Dokter dokter = new Dokter();
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));

            listData.add(dokter);
        }

        resultSet.close();
        statement.close();
        connection.close();
        return listData;
    }

}
