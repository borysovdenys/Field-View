package borysov.controller;

import borysov.entity.Stuff;
import borysov.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowDataController")
public class ShowDataController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private final int idOfUser = 2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuffId = null;
        if(req.getParameter("stuff_id")!=null) {
            stuffId = req.getParameter("stuff_id");
            req.getSession().setAttribute("stuffId",stuffId);
        } else {
            stuffId = (String) req.getSession().getAttribute("stuffId");
        }
        LOGGER.info(stuffId);
        List<Stuff> stuffList = (List<Stuff>) req.getSession().getAttribute("stuffList");
        LOGGER.info(stuffList);
        Stuff stuffElement = null;
        for (Stuff s : stuffList) {
            if (s.getId() == Integer.valueOf(stuffId)) {
                stuffElement = s;
            }
        }
        req.getSession().setAttribute("stuffElement", stuffElement);

        User user = (User) req.getSession().getAttribute("currentUser");

        if (user.getIdOfRole() == idOfUser) {
            resp.sendRedirect("/view/showData.jsp");
           // req.getRequestDispatcher("/view/showData.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/adminPage.jsp").forward(req, resp);
        }
    }
}
