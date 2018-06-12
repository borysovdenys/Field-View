package borysov.extractor;

import borysov.entity.Stuff;
import borysov.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class AddDataExtractor implements Extractor<Stuff> {

    @Override
    public Stuff extract(HttpServletRequest request) {

        String idOfUser = request.getParameter("selected_user_field");
        String nameOfFile = request.getParameter("name_of_file_field");
        String link = request.getParameter("link_field");
        String date = request.getParameter("date_field");
        String coordinates = request.getParameter("coordinates_field");
        String prescription = request.getParameter("prescription_field");

        Stuff  stuff = new Stuff();
        stuff.setIdOfUser(Integer.parseInt(idOfUser));
        stuff.setName(nameOfFile);
        stuff.setLinkToMaterial(link);
        stuff.setDateOfCreation(Date.valueOf(date));
        stuff.setCoordinates(coordinates);
        stuff.setPrescription(prescription);

        return stuff;
    }
}
