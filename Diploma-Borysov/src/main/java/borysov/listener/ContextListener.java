package borysov.listener;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import borysov.dao.UserDao;
import borysov.dao.impl.UserDaoImpl;
import borysov.database.transaction.TransactionManager;
import borysov.database.transaction.jdbc.JdbcTransactionManager;
import borysov.service.StuffService;
import borysov.service.UserService;
import borysov.service.impl.MessageService;
import borysov.service.impl.StuffServiceImpl;
import borysov.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

/**
 *
 * 
 * releasing ConnectionPool when context is being destroyed
 */
public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ContextListener.class);
	private UserService userService;
	private MessageService messageService;
	private StuffService stuffService;
	private UserDao userDao;
	private TransactionManager transactionManager;
	//extractor



    @Override
    public void contextInitialized(ServletContextEvent sce) {
		ServletContext applicationContext = sce.getServletContext();
		try {
			transactionManager = new JdbcTransactionManager();
		} catch (NamingException e) {
			LOGGER.error("transactionManager wasn't initialized",e);
		}
		userDao = new UserDaoImpl();
		userService = new UserServiceImpl(userDao,transactionManager);
		applicationContext.setAttribute("userService",userService);
		messageService = new MessageService(transactionManager);
		applicationContext.setAttribute("messageService",messageService);
		stuffService = new StuffServiceImpl(transactionManager);
		applicationContext.setAttribute("stuffService",stuffService);
		//ConnectionPool.getConnection();
		LOGGER.info("ConnectionPool is released");
    }
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}