package com.nick.jee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// import java.io.PrintWriter;

// @WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private UserValidationService service = new UserValidationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // PrintWriter writer = response.getWriter();
        // writer.println("Dummy");

        // request.setAttribute("name", request.getParameter("name"));
        // request.setAttribute("password", request.getParameter("password"));

        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        boolean isUserValid = service.isUserValid(name, password);

        if(isUserValid) {
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Name or Password");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
