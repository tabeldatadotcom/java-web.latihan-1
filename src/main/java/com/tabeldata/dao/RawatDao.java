package com.tabeldata.dao;

import com.tabeldata.configs.DatabaseKonfigurasi;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RawatDao {

    public List<Rawat> semuaData() throws SQLException {
        List<Rawat> listData = new ArrayList<>();
        String sql = "SELECT\n" +
                "  rwt.id         AS rawat_id,\n" +
                "  rwt.pasien_id     pasien_id,\n" +
                "  psn.nama       AS pasien_nama,\n" +
                "  rwt.dokter_id,\n" +
                "  dkr.nama       AS dokter_nama,\n" +
                "  rwt.ruang_id,\n" +
                "  rng.no_ruangan AS ruang_no,\n" +
                "  rng.kosong     AS ruang_kosong,\n" +
                "  rwt.waktu_register AS rawat_register,\n" +
                "  rwt.waktu_checkout AS rawat_checkout\n" +
                "FROM latihan_1.rawat rwt\n" +
                "  JOIN latihan_1.pasien psn ON rwt.pasien_id = psn.id\n" +
                "  JOIN latihan_1.dokter dkr ON rwt.dokter_id = dkr.id\n" +
                "  JOIN latihan_1.ruang rng ON rwt.ruang_id = rng.id";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
// tampung nilai dari database ke object java dengan tipe data Rawat
            Rawat rwt = new Rawat();
            rwt.setId(resultSet.getInt("rawat_id"));
            Dokter dokter = new Dokter();
            dokter.setId(resultSet.getInt("dokter_id"));
            dokter.setNama(resultSet.getString("dokter_nama"));
            rwt.setDokter(dokter);
//            dokter.setSpesialis(resultSet);

            Pasien pasien = new Pasien();
            pasien.setId(resultSet.getInt("pasien_id"));
            pasien.setNama(resultSet.getString("pasien_nama"));
//            pasien.set
            rwt.setPasien(pasien);

            Ruang ruang = new Ruang();
            ruang.setId(resultSet.getInt("ruang_id"));
            ruang.setNoRuangan(resultSet.getString("ruang_no"));
            rwt.setRuang(ruang);

            rwt.setTanggalRegister(resultSet.getDate("rawat_register"));
            rwt.setTanggalCheckout(resultSet.getDate("rawat_checkout"));
            listData.add(rwt);
        }

        System.out.println("jumlah data di list ada " + listData.size());
        resultSet.close();
        statement.clearBatch();
        connection.close();

        return listData;
    }

    public void save(Rawat rawat) throws SQLException {
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO latihan_1.rawat( pasien_id, dokter_id, ruang_id, waktu_register, waktu_checkout) VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, rawat.getPasien().getId());
        preparedStatement.setInt(2, rawat.getDokter().getId());
        preparedStatement.setInt(3, rawat.getRuang().getId());
        preparedStatement.setDate(4, rawat.getTanggalRegister());
        preparedStatement.setDate(5, rawat.getTanggalCheckout());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = "UPDATE latihan_1.ruang SET kosong = FALSE WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, rawat.getRuang().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
        connection.close();
    }

    public Rawat cariBerdasarkanId(Integer id) throws SQLException {
        String sql = "SELECT id, ruang_id, dokter_id, pasien_id, waktu_register, waktu_checkout FROM latihan_1.rawat WHERE id = ?";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Rawat rawat = new Rawat();
        if (resultSet.next()) {
            rawat.setId(resultSet.getInt("id"));

            Ruang ruang = new Ruang();
            ruang.setId(resultSet.getInt("ruang_id"));
            rawat.setRuang(ruang);

            Dokter dokter = new Dokter();
            dokter.setId(resultSet.getInt("dokter_id"));
            rawat.setDokter(dokter);

            Pasien pasien = new Pasien();
            pasien.setId(resultSet.getInt("pasien_id"));
            rawat.setPasien(pasien);

            rawat.setTanggalRegister(resultSet.getDate("waktu_register"));
            rawat.setTanggalCheckout(resultSet.getDate("waktu_checkout"));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return rawat;
    }

    public void update(Integer id, Integer dokterId, Integer ruangId) throws SQLException {
        String sql = "UPDATE latihan_1.rawat SET dokter_id = ?, ruang_id = ? WHERE id =? ";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, dokterId);
        preparedStatement.setInt(2, ruangId);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void delete(Integer value) throws SQLException {
        String sql = "DELETE FROM latihan_1.rawat WHERE id = ?";
        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, value);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
