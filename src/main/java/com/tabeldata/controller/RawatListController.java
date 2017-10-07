package com.tabeldata.controller;

import com.tabeldata.dao.RawatDao;
import com.tabeldata.model.Rawat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/rawat/list", "/rawat/"})
public class RawatListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RawatDao dao = new RawatDao();
            List<Rawat> listData = dao.semuaData();
            req.setAttribute("listRawat", listData);
            req.getRequestDispatcher("/pages/rawat/index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
