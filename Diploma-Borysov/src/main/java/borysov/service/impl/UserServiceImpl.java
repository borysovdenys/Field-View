package borysov.service.impl;

import borysov.dao.UserDao;
import borysov.database.transaction.Performable;
import borysov.database.transaction.PerformableResult;
import borysov.database.transaction.TransactionManager;
import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.service.UserService;
import borysov.utility.PasswordHashing;
import borysov.utility.Sender;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private UserDao userDao;
    private TransactionManager transactionManager;

    public UserServiceImpl(UserDao userDao, TransactionManager transactionManager) {
        this.userDao = userDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public User getUserById(final int id) {
        return transactionManager.perform(new Performable<User>() {
            @Override
            public PerformableResult<User> perform(Connection connection) throws SQLException {
                LOGGER.info("getUserByLoginAndPass");
                final User user = userDao.getUserByIdFromDB(id);
                return new PerformableResult<User>() {
                    @Override
                    public User get() {
                        return user;
                    }
                };
            }
        }).get();
    }

    public User getUserByLoginAndPass(final String login, final String password) {
        final String hashPassword = PasswordHashing.MD5Hashing(password);
        return transactionManager.perform(new Performable<User>() {
            @Override
            public PerformableResult<User> perform(Connection connection) throws SQLException {
                LOGGER.info("getUserByLoginAndPass");
                final User user = userDao.getUserByLoginAndPass(login,hashPassword);
                return new PerformableResult<User>() {
                    @Override
                    public User get() {
                        return user;
                    }
                };
            }
        }).get();
    }

    public void registerUser(final User newUser) {
        String hashPassword = PasswordHashing.MD5Hashing(newUser.getPassword());
        newUser.setPassword(hashPassword);
        transactionManager.perform(new Performable<Void>() {
            @Override
            public PerformableResult<Void> perform(Connection connection) {
                userDao.addNewUserToDB(newUser);
                return new PerformableResult<Void>() {
                    @Override
                    public Void get() {
                        return null;
                    }
                };
            }
        });


        String moldAnswer = " Thank you for register on our web-site!\n That's your login: " + newUser.getLogin() + ", and password: "+ newUser.getPassword() + ".\n Use it for sign in.\n Have a good day!";
        Sender tlsSender = new Sender("defan3171@gmail.com", "password");
        LOGGER.info("Sender");

        tlsSender.send("Field-View", moldAnswer, "defan3171@gmail.com", newUser.getEmail());
    }

    @Override
    public List<User> getListOfUsers() {
        return transactionManager.perform(new Performable<List<User>>() {
            @Override
            public PerformableResult<List<User>> perform(Connection connection) {
                LOGGER.info("getListOfUsers");
                final List<User> listOfUsers = userDao.getUsersAsAListFromDB(connection);
                return new PerformableResult<List<User>>() {
                    @Override
                    public List<User> get() {
                        return listOfUsers;
                    }
                };
            }
        }).get();
    }
}
