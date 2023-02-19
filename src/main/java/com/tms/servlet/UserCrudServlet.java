package com.tms.servlet;

import com.tms.service.UserCrudService;
import com.tms.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/user")
public class UserCrudServlet extends HttpServlet {

    UserCrudService userCrudService = new UserCrudService();
private static final Logger log = Logger.getLogger(UserCrudServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       log.info("doing/user Get method!");
        int requestUserId = Integer.parseInt(request.getParameter("id"));
        User user = userCrudService.getUserById(requestUserId);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/singleUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doing/user Post method!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doing/user Delete  method!");
        super.doDelete(req, resp);
    }
}