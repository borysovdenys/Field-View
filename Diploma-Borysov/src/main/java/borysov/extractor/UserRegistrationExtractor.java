package borysov.extractor;

import borysov.entity.User;

import javax.servlet.http.HttpServletRequest;

public class UserRegistrationExtractor implements Extractor<User> {

    @Override
    public User extract(HttpServletRequest request) {

        String login = request.getParameter("login_field");
        String password = request.getParameter("password_field");
        String email = request.getParameter("email_field");
        String name = request.getParameter("name_field");
        String city = request.getParameter("city_field");

        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setCity(city);

        return newUser;
    }
}
