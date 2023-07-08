package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet {
    @WebServlet("/add")
    public class Addservlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            User user = new User(
                    req.getParameter("firstName"),
                    req.getParameter("lastName")
            );
            Warehouse.getInstance()
                    .addUser(user);
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("jsp/add.jsp");
            rd.forward(req, resp);
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            User user = new User(
                    req.getParameter("firstName"),
                    req.getParameter("lastName")
            );
            Warehouse.getInstance()
                    .addUser(user);
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("jsp/add.jsp");
            rd.forward(req, resp);
        }
    }
}

