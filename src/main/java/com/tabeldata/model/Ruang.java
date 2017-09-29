package com.tabeldata.model;

public class Ruang {
    private Integer id;
    private String noRuangan;
    private Boolean kosong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoRuangan() {
        return noRuangan;
    }

    public void setNoRuangan(String noRuangang) {
        this.noRuangan = noRuangang;
    }

    public Boolean getKosong() {
        return kosong;
    }

    public void setKosong(Boolean kosong) {
        this.kosong = kosong;
    }

    public void setKosong(boolean kosong) {
        this.kosong = kosong;
    }
}
