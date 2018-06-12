package borysov.service;

import borysov.entity.User;
import borysov.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User getUserById(int id);

    User getUserByLoginAndPass(String login, String password);

    void registerUser(User user) throws SQLException;

    List<User> getListOfUsers();
}
