package borysov.database.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents some entity that the transaction is performed on.
 */
public interface Performable<E> {
	PerformableResult<E> perform(Connection connection) throws SQLException;
}
