package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = {"/rawat/new", "/rawat/proses"})
public class RawatAddController extends HttpServlet {

    private final Logger console = LoggerFactory.getLogger(RawatAddController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        PasienDao pasienDao = new PasienDao();
        RuangDao ruangDao = new RuangDao();
        DokterDao dokterDao = new DokterDao();

        try {
            List<Dokter> listDokter = dokterDao.semuaData();
            List<Pasien> listPasien = pasienDao.semuaData();
            List<Ruang> listRuangan = ruangDao.semuaDataKamarKosong(true);

            req.setAttribute("listDokter", listDokter);
            req.setAttribute("listPasien", listPasien);
            req.setAttribute("listRuangan", listRuangan);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Rawat rawat = new Rawat();
        String pasientId = req.getParameter("selectPasientId");
        Pasien pasien = new Pasien();
        pasien.setId(Integer.valueOf(pasientId));
        rawat.setPasien(pasien);

        String selectDokterId = req.getParameter("selectDokterId");
        Dokter dokter = new Dokter();
        dokter.setId(Integer.valueOf(selectDokterId));
        rawat.setDokter(dokter);

        String selectRuangId = req.getParameter("selectRuangId");
        Ruang ruang = new Ruang();
        ruang.setId(Integer.valueOf(selectRuangId));
        rawat.setRuang(ruang);

        rawat.setTanggalRegister(Date.valueOf(LocalDate.now()));
        rawat.setTanggalCheckout(Date.valueOf(LocalDate.now()));


        RawatDao rawatDao = new RawatDao();
        try {
            rawatDao.save(rawat);
            console.info("pasienId: {}, dokterId: {}, ruangId: {}, tanggalRegister: {} ",
                    rawat.getPasien().getId(),
                    rawat.getDokter().getId(),
                    rawat.getRuang().getId(),
                    rawat.getTanggalRegister());
        } catch (SQLException e) {
            console.error("tidak dapat menyimpan data rawat", e);
//            e.printStackTrace();
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/");
    }
}
