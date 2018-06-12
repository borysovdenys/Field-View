package borysov.controller;

import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.service.StuffService;
import borysov.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowUserStuffController")
public class ShowUserStuffController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    StuffService stuffService;
    UserService userService;

    @Override
    public void init() throws ServletException {
        stuffService = (StuffService) getServletContext().getAttribute("stuffService");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().removeAttribute("stuffElement");
        String userId = req.getParameter("user_id");
        User selectedUser = userService.getUserById(Integer.parseInt(userId));
        LOGGER.info(userId);
        List<Stuff> stuffList = stuffService.getStuff(Integer.valueOf(userId));
        req.getSession().setAttribute("selectedUser", selectedUser);
        req.getSession().setAttribute("stuffList", stuffList);
        req.getRequestDispatcher("/view/adminPage.jsp").forward(req, resp);
    }
}
