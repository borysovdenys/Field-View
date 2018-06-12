package borysov.database.transaction.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import borysov.database.transaction.Performable;
import borysov.database.transaction.PerformableResult;
import borysov.database.transaction.TransactionManager;
import borysov.exception.TransactionException;
import org.apache.log4j.Logger;

/**
 * JDBC transaction manager implementation.
 */
public class JdbcTransactionManager implements TransactionManager {

	private static final Logger LOG = Logger.getLogger(JdbcTransactionManager.class);

	/**
	 * A factory for connections to the database that this DataSource object
	 * represents.
	 */
	private DataSource dataSource;

	public JdbcTransactionManager() throws NamingException {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		// ST4DB - the name of data source
		dataSource = (DataSource) envContext.lookup("jdbc/diploma");
		this.dataSource = dataSource;
	}

	@Override
	public <E> PerformableResult<E> perform(Performable<E> performable) throws TransactionException {
		Connection connection = null;
		PerformableResult<E> result = null;
		try {
			connection = getConnection();
			result = performable.perform(connection);
			commit(connection);
		} catch (Exception e) {
			LOG.error("Transaction error.", e);
			rollBack(connection);
			throw new TransactionException("Transaction error", e);
		} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //DbUtil.close(connection);
		}
		LOG.trace("Successful operation performing.");
		return result;
	}

	private Connection getConnection() throws TransactionException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			LOG.warn("Cannot obtain connection", e);
			throw new TransactionException("Cannot obtain connection", e);
		}
		return connection;
	}

	private void commit(Connection connection) throws TransactionException {
		LOG.debug("Starting commit.");
		try {
			connection.commit();
		} catch (SQLException e) {

			/*
			 * if a database access error occurs, this method is called while participating
			 * in a distributed transaction, this method is called on a closed connection or
			 * this Connection object is in auto-commit mode
			 */
			LOG.warn("Error during commit", e);
			throw new TransactionException("Error during commit", e);
		}
		LOG.debug("Commit done.");
	}

	private void rollBack(Connection connection) {
		LOG.debug("Starting rollback.");
		try {
			connection.rollback();
		} catch (SQLException e) {

			/*
			 * if a database access error occurs, this method is called while participating
			 * in a distributed transaction, this method is called on a closed connection or
			 * this Connection object is in auto-commit mode
			 */
			LOG.warn("Cannot rollback connection", e);
		}
		LOG.debug("Rollback done.");
	}

}
