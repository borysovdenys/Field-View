package borysov.utility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import borysov.entity.User;
import borysov.filter.AuthorizationUserFilter;
import org.apache.log4j.Logger;

public class Dispatcher {
    private final int idOfAdmin = 3;
    private final int idOfUser = 2;
    private static final Logger LOGGER = Logger.getLogger(AuthorizationUserFilter.class);


    public boolean isAccountUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        User user = (User) request.getSession().getAttribute("currentUser");
        System.out.println(user);
        if (user==null) {

            LOGGER.debug("attempt to achieve inaccessible page 1\tnull");
            response.sendRedirect("/index.jsp");
            return false;
        } else if (user.getIdOfRole() != idOfUser) {
            LOGGER.debug("attempt to achieve inaccessible page 2\tid");
            response.sendRedirect("/index.jsp");
            return false;
        }
        return true;
    }

    public boolean isAccountAdmin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        User user = (User) request.getSession().getAttribute("currentUser");
        System.out.println(user);
        if (user==null) {

            LOGGER.debug("attempt to achieve inaccessible page 1\tnull");
            response.sendRedirect("/index.jsp");
            return false;
        } else if (user.getIdOfRole() != idOfAdmin) {
            LOGGER.debug("attempt to achieve inaccessible page 2\tid");
            response.sendRedirect("/index.jsp");
            return false;
        }
        return true;
    }

    public void goByRole(User user, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (user == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (user.getIdOfRole() == idOfAdmin) {
            response.sendRedirect("/view/adminPage.jsp");
        } else if (user.getIdOfRole() == idOfUser) {
            response.sendRedirect("/view/mainPage.jsp");
        } else {
            System.out.println("loginError");
            response.sendRedirect("index.jsp");
        }
    }
}
