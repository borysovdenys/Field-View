package borysov.dao;

import borysov.entity.Stuff;

import java.sql.Connection;
import java.util.List;

public interface StuffDao {
    List<Stuff> getStuffFromDB(int id,Connection connection);

    void addNewStuffToDB(Stuff stuff, Connection connection);
}
