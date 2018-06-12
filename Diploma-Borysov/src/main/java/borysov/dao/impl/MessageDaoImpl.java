package borysov.dao.impl;

import borysov.dao.ConnectionPool;
import borysov.dao.MessageDao;
import borysov.entity.User;
import borysov.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDaoImpl implements MessageDao{
    private Connection connection = ConnectionPool.getConnection();
    private static final Logger LOGGER = Logger.getLogger(MessageDaoImpl.class);


    @Override
    public void addNewMessageToDB(User currentUser, String message) {
        String INSERT_NEW = "INSERT INTO messages (id_of_user, letter)  VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, currentUser.getId());
            preparedStatement.setString(2, message);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addNewMessageToDB error", e);
            throw new DAOException();
        }
    }
}
