package borysov.controller;

import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.extractor.AddDataExtractor;
import borysov.extractor.Extractor;
import borysov.extractor.UserRegistrationExtractor;
import borysov.service.StuffService;
import borysov.service.UserService;
import borysov.service.impl.MessageService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AddData.class);
    private Extractor<Stuff> addDataExtractor = new AddDataExtractor();
    StuffService stuffService;

    @Override
    public void init() throws ServletException {
        stuffService = (StuffService) getServletContext().getAttribute("stuffService");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.info("AddData");
        Stuff stuff = addDataExtractor.extract(request);

        stuffService.addStuff(stuff);

        response.sendRedirect("/view/adminPage.jsp");
    }

}
