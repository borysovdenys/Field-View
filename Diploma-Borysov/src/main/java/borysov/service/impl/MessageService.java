package borysov.service.impl;

import borysov.dao.MessageDao;
import borysov.dao.impl.MessageDaoImpl;
import borysov.database.transaction.Performable;
import borysov.database.transaction.PerformableResult;
import borysov.database.transaction.TransactionManager;
import borysov.entity.User;
import borysov.utility.Sender;
import org.apache.log4j.Logger;

import java.sql.Connection;

public class MessageService {
    private static final Logger LOGGER = Logger.getLogger(MessageService.class);
    private MessageDao messageDao = new MessageDaoImpl();
    private TransactionManager transactionManager ;

    public MessageService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public void addNewMessage(final User currentUser, final String message) {
        LOGGER.info("addNewMessage");
        transactionManager.perform(new Performable<Void>() {
            @Override
            public PerformableResult<Void> perform(Connection connection) {
                messageDao.addNewMessageToDB(currentUser, message);
                return new PerformableResult<Void>() {
                    @Override
                    public Void get() {
                        return null;
                    }
                };
            }
        });

        LOGGER.info("Sender");
        Sender tlsSender = new Sender("defan3171@gmail.com", "borisonfafa");
        String moldAnswer = "You have written message on our web-site! We will answer you soon.";
        tlsSender.send("Field-View", moldAnswer, "defan3171@gmail.com", currentUser.getEmail());
    }
}
