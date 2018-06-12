package borysov.controller;

import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.exception.TransactionException;
import borysov.utility.Dispatcher;
import org.apache.log4j.Logger;
import borysov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    Dispatcher dispatcher = new Dispatcher();
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginError = (String) req.getSession().getAttribute("errorLogIn");

        if (loginError != null) {
            req.setAttribute("errorLogIn", "errorLogIn");
            req.getSession().removeAttribute("errorLogIn");
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Log in");

        String login = request.getParameter("login_field");
        String password = request.getParameter("password_field");


        try {
            User currentUser = null;
            currentUser = userService.getUserByLoginAndPass(login, password);
            request.getSession().setAttribute("currentUser", currentUser);
            dispatcher.goByRole(currentUser, request, response);
        } catch (TransactionException | DAOException e) {
            LOGGER.error("Login or password entered incorrectly!", e);
            request.getSession().setAttribute("errorLogIn", "errorLogIn");
            response.sendRedirect("/LoginController");
        }

    }

}
