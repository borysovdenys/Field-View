package borysov.dao;

import borysov.entity.User;
import borysov.exception.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User getUserByLoginAndPass (String login, String password) throws SQLException;

    void addNewUserToDB(User newUser);

    List<User> getUsersAsAListFromDB(Connection connection);

    User getUserByIdFromDB(int id);
}
