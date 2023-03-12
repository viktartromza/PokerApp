package com.tms.servlet;

import com.tms.service.UserCrudService;
import com.tms.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/user")
public class UserCrudServlet extends HttpServlet {

    UserCrudService userCrudService = new UserCrudService();
private static final Logger log = LoggerFactory.getLogger(UserCrudServlet.class);
    //@Override
  // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //    log.info("doing/user Get method!");
  //     int requestUserId = Integer.parseInt(request.getParameter("id"));
  //     User user = userCrudService.getUserById(requestUserId);
  //     request.setAttribute("user", user);
  //     getServletContext().getRequestDispatcher("/singleUser.jsp").forward(request, response);
    //}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doing/user Post method!");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("e_mail");
        boolean result = userCrudService.createUser(login,password,email);

        if (result) {
            getServletContext().getRequestDispatcher("/successfully.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/unsuccessfully.jsp").forward(request, response);
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
