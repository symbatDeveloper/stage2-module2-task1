package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class GetUsersServlet {
    @WebServlet("/users")
    public class GetServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Set<User> users = Warehouse.getInstance()
                    .getUsers();
            req.setAttribute("users", users);
            RequestDispatcher rd = req.getRequestDispatcher("jsp/users.jsp");
            rd.forward(req, resp);
        }
    }
}
