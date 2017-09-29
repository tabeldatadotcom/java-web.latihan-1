package com.tabeldata.model;

import java.sql.Date;

public class Rawat {

    private Integer id;
    private Pasien pasien;
    private Dokter dokter;
    private Ruang ruang;
    private Date tanggalRegister;
    private Date tanggalCheckout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Ruang getRuang() {
        return ruang;
    }

    public void setRuang(Ruang ruang) {
        this.ruang = ruang;
    }

    public Date getTanggalRegister() {
        return tanggalRegister;
    }

    public void setTanggalRegister(Date tanggalRegister) {
        this.tanggalRegister = tanggalRegister;
    }

    public Date getTanggalCheckout() {
        return tanggalCheckout;
    }

    public void setTanggalCheckout(Date tanggalCheckout) {
        this.tanggalCheckout = tanggalCheckout;
    }
}
