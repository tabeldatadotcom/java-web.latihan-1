package com.tabeldata.controller;

import com.tabeldata.dao.RawatDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/rawat/delete")
public class RawatDeleteControll extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String kodeRawat = req.getParameter("kode");
        try {
            RawatDao rawatDao = new RawatDao();
            rawatDao.delete(Integer.valueOf(kodeRawat));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/");
    }
}
