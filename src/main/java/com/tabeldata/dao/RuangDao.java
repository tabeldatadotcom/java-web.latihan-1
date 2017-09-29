package com.tabeldata.dao;

import com.tabeldata.configs.DatabaseKonfigurasi;
import com.tabeldata.model.Ruang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuangDao {

    public List<Ruang> semuaDataKamarKosong(Boolean statusKamarIsi) throws SQLException {
        List<Ruang> listData = new ArrayList<>();
        String sql = "SELECT id, no_ruangan, kosong FROM latihan_1.ruang WHERE kosong = ? ";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setBoolean(1, statusKamarIsi);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Ruang ruang = new Ruang();
            ruang.setId(resultSet.getInt("id"));
            ruang.setNoRuangan(resultSet.getString("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));
            listData.add(ruang);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return listData;
    }
}
