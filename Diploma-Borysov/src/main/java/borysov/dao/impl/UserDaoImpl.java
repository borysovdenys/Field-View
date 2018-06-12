package borysov.dao.impl;

import borysov.dao.ConnectionPool;
import borysov.dao.UserDao;
import borysov.entity.User;
import borysov.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final int idOfUser = 2;
    private Connection connection = ConnectionPool.getConnection();
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User getUserByIdFromDB(int id) {
        User user = null;

        String SELECT = "SELECT * FROM accounts WHERE id=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setIdOfRole(resultSet.getInt("id_of_role"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setCity(resultSet.getString("city"));

            }
        } catch (SQLException e) {
            LOGGER.error("getUserByLoginAndPass error");
            throw new DAOException("DAOException while UserDaoImpl.getUserByLoginAndPass()");
        }
        return user;
    }

    public User getUserByLoginAndPass(String login, String password) throws SQLException {
        User user = null;

        String SELECT = "SELECT * FROM accounts WHERE login=? AND password=?";

        PreparedStatement statement = connection.prepareStatement(SELECT);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setIdOfRole(resultSet.getInt("id_of_role"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setName(resultSet.getString("name"));
            user.setCity(resultSet.getString("city"));
            return user;
        } else {
            LOGGER.error("getUserByLoginAndPass error");
            throw new DAOException("DAOException while UserDaoImpl.getUserByLoginAndPass()");
        }
    }

    public void addNewUserToDB(User newUser) {
        String INSERT_NEW = "INSERT INTO accounts (id_of_role, login, password, email, name, city)  VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, idOfUser);
            preparedStatement.setString(2, newUser.getLogin());
            preparedStatement.setString(3, newUser.getPassword());
            preparedStatement.setString(4, newUser.getEmail());
            preparedStatement.setString(5, newUser.getName());
            preparedStatement.setString(6, newUser.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addNewUserToDB error", e);
            throw new DAOException();
        }

    }

    @Override
    public List<User> getUsersAsAListFromDB(Connection connection) {
        List<User> userList = new ArrayList<User>();
        User user = null;
        String SELECT = "SELECT * FROM accounts WHERE id_of_role=" + idOfUser;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setIdOfRole(resultSet.getInt("id_of_role"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setCity(resultSet.getString("city"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


}
