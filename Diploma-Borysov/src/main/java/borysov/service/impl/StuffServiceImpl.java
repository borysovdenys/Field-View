package borysov.service.impl;

import borysov.dao.StuffDao;
import borysov.dao.impl.StuffDaoImpl;
import borysov.database.transaction.Performable;
import borysov.database.transaction.PerformableResult;
import borysov.database.transaction.TransactionManager;
import borysov.entity.Stuff;
import borysov.entity.User;
import borysov.service.StuffService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class StuffServiceImpl implements StuffService {
    private static final Logger LOGGER = Logger.getLogger(StuffServiceImpl.class);
    private StuffDao stuffDao = new StuffDaoImpl();
    private TransactionManager transactionManager;

    public StuffServiceImpl(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Stuff> getStuff(final int id) {
        return transactionManager.perform(new Performable<List<Stuff>>() {
            @Override
            public PerformableResult<List<Stuff>> perform(Connection connection) {
                LOGGER.info("getUserByLoginAndPass");
                final List<Stuff> listOfStuff = stuffDao.getStuffFromDB(id, connection);
                return new PerformableResult<List<Stuff>>() {
                    @Override
                    public List<Stuff> get() {
                        return listOfStuff;
                    }
                };
            }
        }).get();
    }

    @Override
    public void addStuff(final Stuff stuff) {
        transactionManager.perform(new Performable<Void>() {
            @Override
            public PerformableResult<Void> perform(Connection connection) {
                stuffDao.addNewStuffToDB(stuff, connection);
                return new PerformableResult<Void>() {
                    @Override
                    public Void get() {
                        return null;
                    }
                };
            }
        });
    }

}
