package borysov.dao.impl;

import borysov.dao.ConnectionPool;
import borysov.dao.StuffDao;
import borysov.database.transaction.TransactionManager;
import borysov.database.transaction.jdbc.JdbcTransactionManager;
import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.service.impl.StuffServiceImpl;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuffDaoImpl implements StuffDao {
    private static final Logger LOGGER = Logger.getLogger(StuffDaoImpl.class);

    @Override
    public List<Stuff> getStuffFromDB(int id,Connection connection) {
        List<Stuff> listOfStuff = new ArrayList<>();

        String SELECT = "SELECT * FROM stuff WHERE id_of_user=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Stuff stuff = new Stuff();
                stuff.setId(resultSet.getInt("id"));
                stuff.setIdOfUser(resultSet.getInt("id_of_user"));
                stuff.setName(resultSet.getString("name"));
                stuff.setLinkToMaterial(resultSet.getString("link_to_material"));
                stuff.setDateOfCreation(resultSet.getDate("date"));
                stuff.setCoordinates(resultSet.getString("coordinates"));
                stuff.setPrescription(resultSet.getString("prescription"));
                System.out.println(stuff);
                listOfStuff.add(stuff);

            }
        } catch (SQLException e) {
            throw new DAOException("DAOException while UserDaoImpl.getUserByLoginAndPass()");
        }
        return listOfStuff;
    }

    @Override
    public void addNewStuffToDB(Stuff stuff,Connection connection) {
        String INSERT_NEW = "INSERT INTO stuff (id_of_user, name, link_to_material, date, coordinates, prescription)  VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, stuff.getIdOfUser());
            preparedStatement.setString(2, stuff.getName());
            preparedStatement.setString(3, stuff.getLinkToMaterial());
            preparedStatement.setDate(4, stuff.getDateOfCreation());
            preparedStatement.setString(5, stuff.getCoordinates());
            preparedStatement.setString(6, stuff.getPrescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addNewStuffToDB error", e);
            throw new DAOException();
        }
    }

}
