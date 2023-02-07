package tms.com.servlet;

import tms.com.service.UserCrudService;
import tms.com.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/user")
public class UserCrudServlet extends HttpServlet {

    UserCrudService userCrudService = new UserCrudService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestUserId = Integer.parseInt(request.getParameter("id"));
        User user = userCrudService.getUserById(requestUserId);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/singleUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
