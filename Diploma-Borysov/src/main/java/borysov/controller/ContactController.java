package borysov.controller;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import borysov.entity.User;
import borysov.service.UserService;
import borysov.service.impl.MessageService;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ContactController.class);
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = (MessageService) getServletContext().getAttribute("messageService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageSent = (String) req.getSession().getAttribute("messageSent");

        if (messageSent != null) {
            req.setAttribute("messageSent", "messageSent");
            req.getSession().removeAttribute("messageSent");
        }

        req.getRequestDispatcher("view/contact.jsp").forward(req, resp);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                LOGGER.info("Contact us");

        String message = request.getParameter("contact_message_field");

        try {
            messageService.addNewMessage((User) request.getSession().getAttribute("currentUser"), message);
        } catch (Exception e) {
            response.sendRedirect("/view/errorPage.jsp");
            return;
        }

        request.getSession().setAttribute("messageSent", "messageSent");
        response.sendRedirect("/view/contact.jsp");
    }

}
