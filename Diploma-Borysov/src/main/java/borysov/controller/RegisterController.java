package borysov.controller;

import borysov.entity.User;
import borysov.extractor.Extractor;
import borysov.extractor.UserRegistrationExtractor;
import borysov.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
    private UserService userService;
    private Extractor<User> registrationExtractor = new UserRegistrationExtractor();


    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.info("Registration");

        //validation

        User user = registrationExtractor.extract(req);

        try {
            userService.registerUser(user);
        } catch (SQLException e) {
            LOGGER.error("reg error",e);
            resp.sendRedirect("view/errorPage.jsp");
            return;
        }

        resp.sendRedirect("index.jsp");

    }
}
